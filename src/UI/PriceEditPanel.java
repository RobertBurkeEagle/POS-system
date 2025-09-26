package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import PD.Item;
import PD.Price;
import PD.PromoPrice;
import PD.Store;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class PriceEditPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;
	private PromoPrice promo;

	/**
	 * Create the panel.
	 */
	private JCheckBox chckbxNewCheckBox;
	private JTextField textField_2;
	public PriceEditPanel(JFrame currentFrame, JPanel currentPanel, Store store, Item item, Price price, Boolean isAdd, Boolean pIsAdd) {
		setLayout(null);
		
		if(price.isPromo())
			promo = (PromoPrice) price;
		else
			promo = new PromoPrice();
		
		JLabel lblNewLabel = new JLabel("Edit Price");
		lblNewLabel.setBounds(200, 11, 49, 14);
		add(lblNewLabel);
		
		chckbxNewCheckBox = new JCheckBox("Promo Price");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					textField_2.setVisible(true);
					lblNewLabel_3.setVisible(true);
				}
				else {
					textField_2.setVisible(false);
					lblNewLabel_3.setVisible(false);
				}
			}
		});
		chckbxNewCheckBox.setBounds(173, 42, 99, 23);
		add(chckbxNewCheckBox);
		if(pIsAdd)
			chckbxNewCheckBox.setEnabled(true);
		else
			chckbxNewCheckBox.setEnabled(false);
		if(price.isPromo())
			chckbxNewCheckBox.setSelected(true);
		
		
		
		textField = new JTextField(price.getPrice().toString());
		textField.setBounds(173, 73, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(price.getEffectiveDate().format(DateTimeFormatter.ofPattern("M/d/yy")));
		textField_1.setBounds(173, 104, 96, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Price:");
		lblNewLabel_1.setBounds(135, 76, 28, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Effective Date:");
		lblNewLabel_2.setBounds(89, 107, 74, 14);
		add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("End Effective:");
		lblNewLabel_3.setBounds(94, 138, 69, 14);
		add(lblNewLabel_3);
		if(price.isPromo())
			lblNewLabel_3.setVisible(true);
		else
			lblNewLabel_3.setVisible(false);
		
		textField_2 = new JTextField(promo.getEndDate().format(DateTimeFormatter.ofPattern("M/d/yy")));
		textField_2.setBounds(173, 135, 96, 20);
		add(textField_2);
		textField_2.setColumns(10);
		if(price.isPromo())
			textField_2.setVisible(true);
		else
			textField_2.setVisible(false);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(pIsAdd) {
					if(chckbxNewCheckBox.isSelected()) {
						promo.setEndDate(LocalDate.parse(textField_2.getText(), DateTimeFormatter.ofPattern("M/d/yy")));
						promo.setPrice(textField.getText());
						promo.setEffectiveDate(LocalDate.parse(textField_1.getText(), DateTimeFormatter.ofPattern("M/d/yy")));
						promo.setItem(item);
						item.addPrice(promo);
						
						currentFrame.getContentPane().removeAll();
						currentFrame.getContentPane().add(new ItemEditPanel(currentFrame, currentPanel, store, item, isAdd));
						currentFrame.getContentPane().revalidate();
					}
					price.setPrice(textField.getText());
					price.setEffectiveDate(LocalDate.parse(textField_1.getText(), DateTimeFormatter.ofPattern("M/d/yy")));
					price.setItem(item);
					item.addPrice(price);
					
					currentFrame.getContentPane().removeAll();
					currentFrame.getContentPane().add(new ItemEditPanel(currentFrame, currentPanel, store, item, isAdd));
					currentFrame.getContentPane().revalidate();
				}
				else {
					
					item.removePrice(price);
					
					if(price.isPromo()) {
						promo.setEndDate(LocalDate.parse(textField_2.getText(), DateTimeFormatter.ofPattern("M/d/yy")));
						promo.setPrice(textField.getText());
						promo.setEffectiveDate(LocalDate.parse(textField_1.getText(), DateTimeFormatter.ofPattern("M/d/yy")));
						promo.setItem(item);
						item.addPrice(promo);
						
						currentFrame.getContentPane().removeAll();
						currentFrame.getContentPane().add(new ItemEditPanel(currentFrame, currentPanel, store, item, isAdd));
						currentFrame.getContentPane().revalidate();
					}
					price.setPrice(textField.getText());
					price.setEffectiveDate(LocalDate.parse(textField_1.getText(), DateTimeFormatter.ofPattern("M/d/yy")));
					price.setItem(item);
					item.addPrice(price);
					
					currentFrame.getContentPane().removeAll();
					currentFrame.getContentPane().add(new ItemEditPanel(currentFrame, currentPanel, store, item, isAdd));
					currentFrame.getContentPane().revalidate();
				}
				
			}
		});
		btnNewButton.setBounds(114, 172, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame, currentPanel, store, item, isAdd));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(225, 172, 89, 23);
		add(btnNewButton_1);

	}
}
