package UI;

import javax.swing.JPanel;

import PD.Store;
import PD.TaxCategory;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JLabel;

public class TaxCategoriesListPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	DefaultListModel<TaxCategory> listModel;
	JPanel currentPanel = this;
	/**
	 * Create the panel.
	 */
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	public TaxCategoriesListPanel(JFrame currentFrame, Store store) {
		setLayout(null);
		
		
		listModel = new DefaultListModel<TaxCategory>();
		listModel.addAll(store.getTaxCategories().values());
		
		JList<TaxCategory> list = new JList<TaxCategory>(listModel);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(list.getSelectedValue() != null) {
					btnNewButton_1.setEnabled(true);
					if(list.getSelectedValue().isUsed() == false)
						btnNewButton_2.setEnabled(true);
					else
						btnNewButton_2.setEnabled(false);
				}
				else {
					btnNewButton_1.setEnabled(false);
					btnNewButton_2.setEnabled(false);
				}
			}
		});
		list.setBounds(110, 42, 230, 149);
		add(list);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryEditPanel(currentFrame, currentPanel, store, new TaxCategory(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(81, 202, 89, 23);
		add(btnNewButton);
		
		btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryEditPanel(currentFrame, currentPanel, store, list.getSelectedValue(), false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(180, 202, 89, 23);
		add(btnNewButton_1);
		btnNewButton_1.setEnabled(false);
		
		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				store.deleteTaxCategory(list.getSelectedValue());
				listModel.removeElement(list.getSelectedValue());
			}
		});
		btnNewButton_2.setBounds(279, 202, 89, 23);
		add(btnNewButton_2);
		btnNewButton_2.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("Tax Categories");
		lblNewLabel.setBounds(180, 11, 89, 14);
		add(lblNewLabel);
		
	}

}
