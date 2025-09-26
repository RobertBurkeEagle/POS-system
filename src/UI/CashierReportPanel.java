package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import PD.Cashier;
import PD.Store;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import com.github.lgooddatepicker.components.DatePicker;

public class CashierReportPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	private DatePicker datePicker;
	public CashierReportPanel(JFrame currentFrame, Store store) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cashier Report");
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
				String text = genCashierReport(reportDate, store);
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
	String genCashierReport(LocalDate date, Store store) {
		
		String generation = "Cashier Report For: " + date.toString() + "\n\n";
			   generation += "Number\tName\t\tCount\tAmount\tDiff\n";
		int tSales = 0;
		BigDecimal total = new BigDecimal("0.00");
		total.setScale(2, RoundingMode.HALF_UP);
		BigDecimal diff = new BigDecimal("0.00");
		diff.setScale(2, RoundingMode.HALF_UP);
		for (Cashier c : store.getCashiers().values()) {
			generation += c.getNumber() + "\t" + c.getPerson().getName() + "\t\t" + c.salesForDate(date) + "\t" + c.TotalForDate(date) + "\t" + c.diffForDate(date) + "\n";
			tSales += c.salesForDate(date);
			diff = diff.add(c.diffForDate(date));
			total = c.TotalForDate(date);
		}
		generation += "\nTotal : \t\t\t\t\t";
		return generation;
		
	}
}
