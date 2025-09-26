package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import PD.Item;
import PD.Price;
import PD.Store;
import PD.UPC;

public class UPCListPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	JButton btnNewButton;
	JButton btnNewButton_2;
	public UPCListPanel(JFrame currentFrame, JPanel currentPanel, Store store, Item item, Boolean isAdd) {
		setLayout(null);
		
		DefaultListModel<UPC> listModel = new DefaultListModel<UPC>();
		listModel.addAll(item.getUpcs().values());
		
		JList<UPC> list = new JList<UPC>(listModel);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(list.getSelectedValue() != null) {
					btnNewButton.setEnabled(true);
					btnNewButton_2.setEnabled(true);
				}
				else {
					btnNewButton.setEnabled(false);
					btnNewButton_2.setEnabled(false);
				}
			}
		});
		list.setBounds(10, 11, 145, 73);
		add(list);
		
		btnNewButton = new JButton("Edit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new UPCEditPanel(currentFrame, currentPanel, store, item, list.getSelectedValue(), isAdd, false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(10, 88, 65, 17);
		add(btnNewButton);
		btnNewButton.setEnabled(false);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new UPCEditPanel(currentFrame, currentPanel, store, item, new UPC(), isAdd, true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(85, 88, 70, 17);
		add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item.removeUPC(list.getSelectedValue());
				listModel.removeElement(list.getSelectedValue());
			}
		});
		btnNewButton_2.setBounds(38, 106, 85, 17);
		add(btnNewButton_2);
		btnNewButton_2.setEnabled(false);
	}

}
