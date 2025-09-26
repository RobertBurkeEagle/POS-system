package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import PD.Sale;
import PD.Session;
import PD.Store;
import PD.Cash;
import PD.Check;
import PD.Credit;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaymentEntryPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	private JPanel panel;
	public PaymentEntryPanel(JFrame currentFrame, Store store, Session session, Sale sale, String type) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Payment");
		lblNewLabel.setBounds(190, 11, 77, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Payment Due");
		lblNewLabel_1.setBounds(23, 32, 96, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tendered");
		lblNewLabel_1_1.setBounds(23, 84, 96, 14);
		add(lblNewLabel_1_1);
		
		textField = new JTextField(sale.calcAmountForPayment().toString());
		textField.setBounds(23, 53, 96, 20);
		add(textField);
		textField.setColumns(10);
		textField.setFocusable(false);
		
		textField_1 = new JTextField(sale.calcAmtTendered().toString());
		textField_1.setBounds(23, 109, 96, 20);
		add(textField_1);
		textField_1.setColumns(10);
		textField_1.setFocusable(false);
		
		JButton btnNewButton = new JButton("Cash");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new PaymentEntryPanel(currentFrame, store, session, sale, "Cash"));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(23, 151, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Check");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new PaymentEntryPanel(currentFrame, store, session, sale, "Check"));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(23, 185, 89, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Credit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new PaymentEntryPanel(currentFrame, store, session, sale, "Credit"));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_2.setBounds(23, 219, 89, 23);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Payment Complete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sale.isPaymentEnough()) {
					currentFrame.getContentPane().removeAll();
					currentFrame.getContentPane().add(new POSSalePanel(currentFrame, store, session, sale));
					currentFrame.getContentPane().revalidate();
				}
			}
		});
		btnNewButton_3.setBounds(149, 248, 151, 23);
		add(btnNewButton_3);
		btnNewButton_3.setEnabled(sale.isPaymentEnough());
		
		if(type != null) {
			if(type == "Credit")
				panel = new CreditEntryPanel(currentFrame, store, session, sale, new Credit());
			else if(type == "Check") 
				panel = new CheckEntryPanel(currentFrame, store, session, sale, new Check());
			else if(type == "Cash")
				panel = new CashEntryPanel(currentFrame, store, session, sale, new Cash());
		}
		else
			panel = new JPanel();
		panel.setBounds(149, 36, 250, 206);
		add(panel);
		
		
	}
}
