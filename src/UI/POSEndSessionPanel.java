package UI;

import javax.swing.JPanel;

import java.math.BigDecimal;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import PD.Sale;
import PD.Session;
import PD.Store;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class POSEndSessionPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public POSEndSessionPanel(JFrame currentFrame, Store store, Session session) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Session summary");
		lblNewLabel.setBounds(159, 24, 109, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cashier");
		lblNewLabel_1.setBounds(63, 54, 49, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel(session.getCashier().toString());
		lblNewLabel_1_1.setBounds(159, 54, 96, 14);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Register");
		lblNewLabel_1_2.setBounds(63, 79, 49, 14);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel(session.getRegister().toString());
		lblNewLabel_1_1_1.setBounds(159, 79, 96, 14);
		add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Number Sales");
		lblNewLabel_2.setBounds(63, 104, 88, 14);
		add(lblNewLabel_2);
		
		textField = new JTextField(String.valueOf(session.getSales().size()));
		textField.setBounds(159, 101, 96, 20);
		add(textField);
		textField.setColumns(10);
		textField.setFocusable(false);
		
		JLabel lblNewLabel_2_1 = new JLabel("Total Sales");
		lblNewLabel_2_1.setBounds(63, 132, 88, 14);
		add(lblNewLabel_2_1);
		
		textField_1 = new JTextField(session.calcTotal().toString());
		textField_1.setColumns(10);
		textField_1.setBounds(159, 129, 96, 20);
		add(textField_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Enter Cash");
		lblNewLabel_2_2.setBounds(63, 160, 88, 14);
		add(lblNewLabel_2_2);
		
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setText(session.calcCashCountDiff(textField_2.getText()).toString());
				
			}
		});
		textField_2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                 char c = e.getKeyChar();
                 if ( ((c < '0') || (c > '9')) && (c != '.') && (c != KeyEvent.VK_BACK_SPACE)) {
                 e.consume();
            }
        }
		});
		textField_2.setColumns(10);
		textField_2.setBounds(159, 157, 96, 20);
		add(textField_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Cash Count Diff");
		lblNewLabel_2_3.setBounds(63, 188, 102, 14);
		add(lblNewLabel_2_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(159, 185, 96, 20);
		add(textField_3);
		textField_3.setFocusable(false);
		
		JButton btnNewButton = new JButton("End Session");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSHomePanel(store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(144, 221, 124, 23);
		add(btnNewButton);

	}

}
