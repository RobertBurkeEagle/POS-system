package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import PD.Cashier;
import PD.Price;
import PD.Register;
import PD.Sale;
import PD.Session;
import PD.Store;

import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class POSLoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	private JLabel lblNewLabel_5;
	public POSLoginPanel(JFrame currentFrame, Store store) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("POS Login");
		lblNewLabel.setBounds(200, 11, 69, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cashier");
		lblNewLabel_1.setBounds(55, 38, 49, 14);
		add(lblNewLabel_1);
		
		DefaultComboBoxModel<Cashier> cashierList = new DefaultComboBoxModel<Cashier>();
		cashierList.addAll(store.getCashiers().values());
		
		JComboBox comboBox = new JComboBox(cashierList);
		comboBox.setBounds(157, 34, 135, 22);
		add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Register");
		lblNewLabel_2.setBounds(55, 77, 49, 14);
		add(lblNewLabel_2);
		
		DefaultComboBoxModel<Register> registerList = new DefaultComboBoxModel<Register>();
		registerList.addAll(store.getRegisters().values());
		
		JComboBox comboBox_1 = new JComboBox(registerList);
		comboBox_1.setBounds(157, 74, 135, 22);
		add(comboBox_1);
		
		JLabel lblNewLabel_3 = new JLabel("Starting Cash");
		lblNewLabel_3.setBounds(55, 116, 92, 14);
		add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(157, 114, 135, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setBounds(55, 155, 69, 14);
		add(lblNewLabel_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(157, 152, 135, 20);
		add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
				Cashier cashier = (Cashier) comboBox.getSelectedItem();
				if(cashier.isAuthorized(password)) {
					Session session = new Session(store, (Cashier) comboBox.getSelectedItem(), (Register) comboBox_1.getSelectedItem());
					BigDecimal startCash = new BigDecimal(textField.getText());
					session.setStartCash(startCash);
					
					currentFrame.getContentPane().removeAll();
					currentFrame.getContentPane().add(new POSSalePanel(currentFrame, store, session, new Sale()));
					currentFrame.getContentPane().revalidate();
				}
				else {
					lblNewLabel_5.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(130, 206, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSHomePanel(store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(229, 206, 89, 23);
		add(btnNewButton_1);
		
		lblNewLabel_5 = new JLabel("Incorrect Pasword");
		lblNewLabel_5.setBounds(179, 183, 113, 14);
		add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);

	}
}
