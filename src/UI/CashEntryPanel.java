package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import PD.Cash;
import PD.Sale;
import PD.Session;
import PD.Store;

public class CashEntryPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public CashEntryPanel(JFrame currentFrame, Store store, Session session, Sale sale, Cash cash) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cash Payment");
		lblNewLabel.setBounds(72, 11, 97, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Amount");
		lblNewLabel_1.setBounds(0, 39, 49, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField(cash.getAmount().toString());
		textField.setBounds(113, 36, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cash.setAmount(new BigDecimal(textField.getText()));
				
				sale.addPayment(cash);
				session.getRegister().getCashDrawer().addCash(cash.getAmount().subtract(sale.calcChange()));
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new PaymentEntryPanel(currentFrame, store, session, sale, null));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(0, 64, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new PaymentEntryPanel(currentFrame, store, session, sale, null));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(120, 64, 89, 23);
		add(btnNewButton_1);
	}

}
