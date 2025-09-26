package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import PD.Item;
import PD.Store;
import PD.UPC;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UPCEditPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public UPCEditPanel(JFrame currentFrame, JPanel currentPanel, Store store, Item item, UPC upc, Boolean isAdd, Boolean uIsAdd) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit UPC");
		lblNewLabel.setBounds(200, 11, 49, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UPC Code:");
		lblNewLabel_1.setBounds(139, 59, 58, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField(upc.getUpc());
		textField.setBounds(207, 56, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upc.setUpc(textField.getText());
				
				if(!uIsAdd)
					item.removeUPC(upc);
				else
					item.addUPC(upc);
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame, currentPanel, store, item, isAdd));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(126, 150, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame, currentPanel, store, item, isAdd));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(225, 150, 89, 23);
		add(btnNewButton_1);

	}
}
