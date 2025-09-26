package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import PD.Check;
import PD.Sale;
import PD.Session;
import PD.Store;

public class CheckEntryPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	private JLabel lblNewLabel_5;
	public CheckEntryPanel(JFrame currentFrame, Store store, Session session, Sale sale, Check check) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Check Payment");
		lblNewLabel.setBounds(72, 11, 110, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Amount");
		lblNewLabel_1.setBounds(0, 39, 93, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField(check.getAmount().toString());
		textField.setBounds(113, 36, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Check Number");
		lblNewLabel_2.setBounds(0, 70, 93, 14);
		add(lblNewLabel_2);
		
		textField_1 = new JTextField(check.getRoutingNumber());
		textField_1.setBounds(113, 67, 96, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		
		JLabel lblNewLabel_3 = new JLabel("Acct Number");
		lblNewLabel_3.setBounds(0, 100, 93, 14);
		add(lblNewLabel_3);
		
		textField_2 = new JTextField(check.getAccountNumber());
		textField_2.setBounds(113, 97, 96, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Routing Number");
		lblNewLabel_4.setBounds(0, 131, 110, 14);
		add(lblNewLabel_4);
		
		textField_3 = new JTextField(check.getRoutingNumber());
		textField_3.setBounds(113, 128, 96, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check.setAmount(new BigDecimal(textField.getText()));
				check.setCheckNumber(textField_1.getText());
				check.setAccountNumber(textField_2.getText());
				check.setRoutingNumber(textField_3.getText());
				
				if(check.isAuthorized()) {
					sale.addPayment(check);
					currentFrame.getContentPane().removeAll();
					currentFrame.getContentPane().add(new PaymentEntryPanel(currentFrame, store, session, sale, null));
					currentFrame.getContentPane().revalidate();
				}
				else
					lblNewLabel_5.setVisible(true);
			}
		});
		btnNewButton.setBounds(0, 154, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new PaymentEntryPanel(currentFrame, store, session, sale, null));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(120, 154, 89, 23);
		add(btnNewButton_1);
		
		lblNewLabel_5 = new JLabel("Unauthorized");
		lblNewLabel_5.setBounds(67, 181, 116, 14);
		add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
	
		
	}

}
