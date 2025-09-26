package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import PD.Store;
import PD.TaxCategory;
import PD.TaxRate;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class TaxRateEditPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public TaxRateEditPanel(JFrame currentFrame, JPanel currentPanel, Store store, TaxCategory taxCategory, TaxRate taxRate, Boolean isAdd, Boolean tcIsAdd) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Rate");
		lblNewLabel.setBounds(174, 23, 83, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Rate");
		lblNewLabel_1.setBounds(67, 58, 51, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField(taxRate.getTaxRate().toString());
		textField.setBounds(100, 55, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Effective Date");
		lblNewLabel_2.setBounds(10, 97, 96, 14);
		add(lblNewLabel_2);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yy");
		textField_1 = new JTextField(taxRate.getEffectiveDate().format(formatter));
		textField_1.setBounds(100, 94, 96, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				taxRate.setTaxRate(new BigDecimal(textField.getText()));
				taxRate.setEffectiveDate(textField_1.getText());
				if(isAdd == true)
					taxCategory.addTaxRate(taxRate);
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryEditPanel(currentFrame, currentPanel, store, taxCategory, tcIsAdd));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(97, 217, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryEditPanel(currentFrame, currentPanel, store, taxCategory, tcIsAdd));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(241, 217, 89, 23);
		add(btnNewButton_1);

	}

}
