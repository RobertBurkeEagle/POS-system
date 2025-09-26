package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import PD.Item;
import PD.Sale;
import PD.SaleLineItem;
import PD.Session;
import PD.Store;

import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class POSSalePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 */
	
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton;
	private Item item;
	
	
	public POSSalePanel(JFrame currentFrame, Store store, Session session, Sale sale) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("POS Sale");
		lblNewLabel.setBounds(192, 11, 76, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Item Number");
		lblNewLabel_1.setBounds(33, 40, 89, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(117, 37, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		
		DefaultListModel<SaleLineItem> sliList = new DefaultListModel<SaleLineItem>();
		sliList.addAll(sale.getSaleLineItems());
		JList<SaleLineItem> list = new JList<SaleLineItem>(sliList);
		list.setBounds(74, 65, 194, 76);
		add(list);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Tax Free");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_2_1.setEnabled(!chckbxNewCheckBox.isSelected());
				textField_2.setEnabled(!chckbxNewCheckBox.isSelected());
				sale.setTaxFree(chckbxNewCheckBox.isSelected());
				textField_2.setText(sale.calcTax().toString());
				textField_3.setText(sale.calcTotal().toString());
				textField_5.setText(sale.calcChange().toString());
			}
		});
		chckbxNewCheckBox.setBounds(329, 36, 99, 23);
		add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_2 = new JLabel("Subtotal");
		lblNewLabel_2.setBounds(278, 68, 76, 14);
		add(lblNewLabel_2);
		
		textField_1 = new JTextField(sale.calcSubTotal().toString());
		textField_1.setBounds(339, 65, 96, 20);
		add(textField_1);
		textField_1.setColumns(10);
		textField_1.setFocusable(false);
		
		lblNewLabel_2_1 = new JLabel("Tax");
		lblNewLabel_2_1.setBounds(278, 96, 76, 14);
		add(lblNewLabel_2_1);
		
		textField_2 = new JTextField(sale.calcTax().toString());
		textField_2.setColumns(10);
		textField_2.setBounds(339, 93, 96, 20);
		add(textField_2);
		textField_2.setFocusable(false);
		
		JLabel lblNewLabel_2_2 = new JLabel("Total");
		lblNewLabel_2_2.setBounds(278, 124, 76, 14);
		add(lblNewLabel_2_2);
		
		textField_3 = new JTextField(sale.calcTotal().toString());
		textField_3.setColumns(10);
		textField_3.setBounds(339, 121, 96, 20);
		add(textField_3);
		textField_3.setFocusable(false);
		
		JLabel lblNewLabel_2_3 = new JLabel("Tendered");
		lblNewLabel_2_3.setBounds(278, 152, 76, 14);
		add(lblNewLabel_2_3);
		
		textField_4 = new JTextField(sale.calcAmtTendered().toString());
		textField_4.setColumns(10);
		textField_4.setBounds(339, 149, 96, 20);
		add(textField_4);
		textField_4.setFocusable(false);
		
		JLabel lblNewLabel_2_4 = new JLabel("change");
		lblNewLabel_2_4.setBounds(278, 186, 76, 14);
		add(lblNewLabel_2_4);
		
		textField_5 = new JTextField(sale.calcChange().toString());
		textField_5.setColumns(10);
		textField_5.setBounds(339, 183, 96, 20);
		add(textField_5);
		textField_5.setFocusable(false);
		
		btnNewButton = new JButton("Complete Sale");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				session.addSale(sale);
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSSalePanel(currentFrame, store, session, new Sale()));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(146, 162, 122, 23);
		add(btnNewButton);
		btnNewButton.setEnabled(sale.isPaymentEnough());
		
		JButton btnNewButton_1 = new JButton("Payment");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new PaymentEntryPanel(currentFrame, store, session, sale, null));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(33, 162, 89, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancel");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSSalePanel(currentFrame, store, session, new Sale()));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_2.setBounds(33, 196, 89, 23);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("End Session");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSEndSessionPanel(currentFrame, store, session));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_3.setBounds(146, 196, 122, 23);
		add(btnNewButton_3);
		btnNewButton_3.setEnabled(!session.getSales().isEmpty());
		
		textField_6 = new JTextField();
		textField_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (store.findItemByUPC(textField.getText()) != null) {
					item = store.findItemByUPC(textField.getText());
					lblNewLabel_5.setVisible(false);
				}
				else {
					lblNewLabel_5.setVisible(true);
					item = null;
				}
				if(item != null && textField_6.getText() != null) {
					
					if(!textField_6.getText().isBlank()) {
						SaleLineItem sli = new SaleLineItem(sale, item, textField_6.getText());
						lblNewLabel_4.setVisible(false);
						
						if(sale.getSLIForItem(item) != null) {
							sliList.removeElement(sale.getSLIForItem(item));
							sale.getSLIForItem(item).setQuantity(Integer.parseInt(textField_6.getText()) + sale.getSLIForItem(item).getQuantity());
							sliList.addElement(sale.getSLIForItem(item));
						}
						else {
							sale.addSaleLineItem(sli);
							sliList.addElement(sli);
						}
					}
					else {
						lblNewLabel_4.setVisible(true);
					}
					textField_1.setText(sale.calcSubTotal().toString());
					textField_2.setText(sale.calcTax().toString());
					textField_3.setText(sale.calcTotal().toString());
				}
			}
		});
		textField_6.setColumns(10);
		textField_6.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                 char c = e.getKeyChar();
                 if ( ((c < '0') || (c > '9')) && (c != '-') && (c != KeyEvent.VK_BACK_SPACE) || textField_6.getText().length() > 3) {
                 e.consume();
            }
        }
		});
		textField_6.setBounds(254, 37, 36, 20);
		add(textField_6);
		
		JLabel lblNewLabel_3 = new JLabel("QTY");
		lblNewLabel_3.setBounds(223, 40, 29, 14);
		add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Invalid Num");
		lblNewLabel_4.setBounds(241, 25, 82, 14);
		add(lblNewLabel_4);
		lblNewLabel_4.setVisible(false);
		
		lblNewLabel_5 = new JLabel("Invalid UPC");
		lblNewLabel_5.setBounds(129, 25, 82, 14);
		add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);

	}
}
