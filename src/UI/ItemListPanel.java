package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;

import PD.Item;
import PD.Store;

import javax.swing.event.ListSelectionEvent;

public class ItemListPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	JPanel currentPanel = this;
	/**
	 * Create the panel.
	 */
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	public ItemListPanel(JFrame currentFrame, Store store) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Item List");
		lblNewLabel.setBounds(195, 11, 59, 14);
		add(lblNewLabel);
		
		DefaultListModel<Item> listModel = new DefaultListModel<Item>();
		listModel.addAll(store.getItems().values());
		
		JList<Item> list = new JList<Item>(listModel);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(list.getSelectedValue() != null) {
					btnNewButton_1.setEnabled(true);
					btnNewButton_2.setEnabled(true);
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
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame, currentPanel, store, new Item(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(81, 202, 89, 23);
		add(btnNewButton);
		
		btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame, currentPanel, store, list.getSelectedValue(), false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(180, 202, 89, 23);
		add(btnNewButton_1);
		btnNewButton_1.setEnabled(false);
		
		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				store.deleteItem(list.getSelectedValue());
				listModel.removeElement(list.getSelectedValue());
			}
		});
		btnNewButton_2.setBounds(279, 202, 89, 23);
		add(btnNewButton_2);
		btnNewButton_2.setEnabled(false);

	}

}
