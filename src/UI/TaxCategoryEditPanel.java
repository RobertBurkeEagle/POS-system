package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import PD.Store;
import PD.TaxCategory;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TaxCategoryEditPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	//private TreeSet<TaxRate> taxRatesDupe = new TreeSet<TaxRate>();
	

	/**
	 * Create the panel.
	 */
	public TaxCategoryEditPanel(JFrame currentFrame, JPanel currentPanel, Store store, TaxCategory taxCategory, Boolean tcIsAdd) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit TaxCategory");
		lblNewLabel.setBounds(193, 31, 49, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Category");
		lblNewLabel_1.setBounds(10, 68, 80, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField(taxCategory.getCategory());
		textField.setBounds(95, 65, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Save");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taxCategory.setCategory(textField.getText());
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoriesListPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_3.setBounds(95, 237, 75, 23);
		add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Cancel");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoriesListPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_4.setBounds(259, 237, 89, 23);
		add(btnNewButton_4);
		
		JPanel panel = new TaxRateListPanel(currentFrame, currentPanel, store, taxCategory, tcIsAdd);
		panel.setBounds(203, 56, 237, 170);
		add(panel);

	}
}
