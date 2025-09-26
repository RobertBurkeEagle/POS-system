package UI;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;

import PD.Item;
import PD.Price;
import PD.Store;

import javax.swing.event.ListSelectionEvent;

public class PriceListPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	JButton btnNewButton;
	JButton btnNewButton_2;
	public PriceListPanel(JFrame currentFrame, JPanel currentPanel, Store store, Item item, Boolean isAdd) {
		setLayout(null);
		
		DefaultListModel<Price> listModel = new DefaultListModel<Price>();
		listModel.addAll(item.getPrices());
		
		JList<Price> list = new JList<Price>(listModel);
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
				currentFrame.getContentPane().add(new PriceEditPanel(currentFrame, currentPanel, store, item, list.getSelectedValue(), isAdd, false));
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
				currentFrame.getContentPane().add(new PriceEditPanel(currentFrame, currentPanel, store, item, new Price(), isAdd, true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(85, 88, 70, 17);
		add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item.removePrice(list.getSelectedValue());
				listModel.removeElement(list.getSelectedValue());
			}
		});
		btnNewButton_2.setBounds(38, 106, 85, 17);
		add(btnNewButton_2);
		btnNewButton_2.setEnabled(false);

	}

}
