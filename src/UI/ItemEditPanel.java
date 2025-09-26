package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import PD.Item;
import PD.Store;
import PD.TaxCategory;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemEditPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	
	/**
	 * Create the panel.
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ItemEditPanel(JFrame currentFrame, JPanel currentPanel, Store store, Item item, Boolean isAdd) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Item");
		lblNewLabel.setBounds(127, 11, 57, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Number");
		lblNewLabel_1.setBounds(43, 47, 49, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Description");
		lblNewLabel_2.setBounds(21, 82, 71, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tax Category");
		lblNewLabel_3.setBounds(10, 122, 82, 14);
		add(lblNewLabel_3);
		
		textField = new JTextField(item.getNumber());
		textField.setBounds(102, 44, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(item.getDescription());
		textField_1.setBounds(102, 79, 122, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		DefaultComboBoxModel<TaxCategory> tcList = new DefaultComboBoxModel(store.getTaxCategories().values().toArray());
		JComboBox<TaxCategory> comboBox = new JComboBox<TaxCategory>(tcList);
	
		comboBox.setBounds(102, 118, 96, 22);
		add(comboBox);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isAdd == false) {
					item.setNumber(textField.getText());
					item.setDescription(textField_1.getText());
					item.setTaxCategory((TaxCategory) comboBox.getSelectedItem());
				}
				else if (isAdd == true) {
					item.setNumber(textField.getText());
					item.setDescription(textField_1.getText());
					item.setTaxCategory((TaxCategory) comboBox.getSelectedItem());
					store.addItem(item);
				}
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemListPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(36, 235, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemListPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(135, 235, 89, 23);
		add(btnNewButton_1);
		
		JPanel panel = new PriceListPanel(currentFrame, currentPanel, store, item, isAdd);
		panel.setBounds(239, 11, 182, 125);
		add(panel);
		
		JPanel panel_1 = new UPCListPanel(currentFrame, currentPanel, store, item, isAdd);
		panel_1.setBounds(239, 147, 182, 125);
		add(panel_1);

	}
}
