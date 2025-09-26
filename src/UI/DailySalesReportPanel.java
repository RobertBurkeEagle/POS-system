package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.github.lgooddatepicker.components.DatePicker;

import PD.Sale;
import PD.SaleLineItem;
import PD.Session;
import PD.Store;

public class DailySalesReportPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	private DatePicker datePicker;
	public DailySalesReportPanel(JFrame currentFrame, Store store) {
	setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sales Report");
		lblNewLabel.setBounds(168, 11, 96, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date:");
		lblNewLabel_1.setBounds(119, 35, 49, 14);
		add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 70, 396, 179);
		add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFocusable(false);
		
		JButton btnNewButton = new JButton("Generate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDate reportDate = datePicker.getDate();
				String text = genSalesReport(reportDate, store);
				textArea.setText(text);
			}
		});
		btnNewButton.setBounds(119, 266, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSHomePanel(store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(248, 266, 89, 23);
		add(btnNewButton_1);
		
		datePicker = new DatePicker();
		datePicker.getComponentDateTextField().setFocusable(false);
		datePicker.getComponentDateTextField().setText("January 01, 2000");
		datePicker.setBounds(155, 33, 168, 20);
		add(datePicker);
		
	}
	String genSalesReport(LocalDate date, Store store) {
		String generation = "Sales Report For: " + date.toString() + "\n\n";
		generation += "Time\tItems Sold\tPayment\n\n";
		
		for(Session s : store.getSessionsForDate(date)) {
			for(Sale sale : s.getSales()) {
				generation += sale.getDateTime().format(DateTimeFormatter.ofPattern("H:mm")).toString() + "\t" + sale.getSaleLineItems().size() + "\t" + sale.getTotalPayments()  + "\n";
			}
		}
		
		
		return generation;	
		
	}

}
