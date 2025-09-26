package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import PD.Cashier;
import PD.Store;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierEditPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Create the panel.
	 */
	public CashierEditPanel(JFrame currentFrame, Store store, Cashier cashier, Boolean isAdd) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add/Edit Cashier");
		lblNewLabel.setBounds(177, 25, 83, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Number : ");
		lblNewLabel_1.setBounds(28, 60, 73, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name : ");
		lblNewLabel_2.setBounds(28, 85, 73, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address : ");
		lblNewLabel_3.setBounds(28, 110, 83, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("City : ");
		lblNewLabel_4.setBounds(28, 135, 73, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Phone : ");
		lblNewLabel_5.setBounds(28, 160, 73, 14);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Password :");
		lblNewLabel_6.setBounds(28, 185, 83, 14);
		add(lblNewLabel_6);
		
		textField = new JTextField(cashier.getNumber());
		textField.setBounds(111, 57, 49, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(cashier.getPerson().getName());
		textField_1.setBounds(111, 82, 96, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField(cashier.getPerson().getAddress());
		textField_2.setBounds(111, 107, 96, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField(cashier.getPerson().getCity());
		textField_3.setBounds(111, 132, 96, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField(cashier.getPerson().getPhone());
		textField_4.setBounds(111, 157, 96, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		passwordField = new JPasswordField(cashier.getPassword());
		passwordField.setBounds(111, 182, 96, 20);
		add(passwordField);
		
		JLabel lblNewLabel_7 = new JLabel("SSN :");
		lblNewLabel_7.setBounds(177, 60, 37, 14);
		add(lblNewLabel_7);
		
		textField_5 = new JTextField(cashier.getPerson().getSsn());
		textField_5.setBounds(216, 57, 96, 20);
		add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("State :");
		lblNewLabel_8.setBounds(217, 135, 43, 14);
		add(lblNewLabel_8);
		
		textField_6 = new JTextField(cashier.getPerson().getState());
		textField_6.setBounds(254, 132, 27, 20);
		add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Zip :");
		lblNewLabel_9.setBounds(291, 135, 49, 14);
		add(lblNewLabel_9);
		
		textField_7 = new JTextField(cashier.getPerson().getZip());
		textField_7.setBounds(321, 132, 49, 20);
		add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isAdd == false) {
					cashier.setNumber(store, textField.getText());
					cashier.getPerson().setName(textField_1.getText());
					cashier.getPerson().setAddress(textField_2.getText());
					cashier.getPerson().setCity(textField_3.getText());
					cashier.getPerson().setPhone(textField_4.getText());
					cashier.setPassword(passwordField.getText());
					cashier.getPerson().setSsn(textField_5.getText());
					cashier.getPerson().setState(textField_6.getText());
					cashier.getPerson().setZip(textField_7.getText());
				}
				else if (isAdd == true) {
					cashier.setNumber(store, textField.getText());
					cashier.getPerson().setName(textField_1.getText());
					cashier.getPerson().setAddress(textField_2.getText());
					cashier.getPerson().setCity(textField_3.getText());
					cashier.getPerson().setPhone(textField_4.getText());
					cashier.setPassword(passwordField.getText());
					cashier.getPerson().setSsn(textField_5.getText());
					cashier.getPerson().setState(textField_6.getText());
					cashier.getPerson().setZip(textField_7.getText());
					store.addCashier(cashier);
				}
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierListPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(118, 213, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierListPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(223, 213, 89, 23);
		add(btnNewButton_1);

	}
}
