package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import PD.Credit;
import PD.Sale;
import PD.Session;
import PD.Store;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class CreditEntryPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	private JLabel lblNewLabel_5;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yy");
	public CreditEntryPanel(JFrame currentFrame, Store store, Session session, Sale sale, Credit credit) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Credit Payment");
		lblNewLabel.setBounds(72, 11, 97, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Amount");
		lblNewLabel_1.setBounds(0, 39, 103, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField(credit.getAmount().toString());
		textField.setBounds(113, 36, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Card Type");
		lblNewLabel_2.setBounds(0, 71, 103, 14);
		add(lblNewLabel_2);
		
		String[] cardTypesArr = {"MC", "Visa", "Discover", "CashApp", "Venmo"};
		DefaultComboBoxModel<String> cardTypes = new DefaultComboBoxModel<String>();
		for(String i : cardTypesArr)
			cardTypes.addElement(i);
		
		JComboBox<String> comboBox = new JComboBox<String>(cardTypes);
		comboBox.setBounds(113, 67, 96, 22);
		add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Acct Number");
		lblNewLabel_3.setBounds(0, 100, 103, 14);
		add(lblNewLabel_3);
		
		textField_2 = new JTextField(credit.getAcctNumber());
		textField_2.setBounds(113, 97, 96, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Exp Date");
		lblNewLabel_4.setBounds(0, 131, 103, 14);
		add(lblNewLabel_4);
		
		textField_3 = new JTextField(credit.getExpireDate().format(formatter));
		textField_3.setBounds(113, 128, 96, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				credit.setAmount(new BigDecimal(textField.getText()));
				credit.setCardType(comboBox.getSelectedItem().toString());
				credit.setAcctNumber(textField_2.getText());
				credit.setExpireDate(LocalDate.parse(textField_3.getText(), formatter));
				
				if(credit.isAuthorized()) {
					sale.addPayment(credit);
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
		lblNewLabel_5.setBounds(73, 178, 116, 14);
		add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
	}

}
