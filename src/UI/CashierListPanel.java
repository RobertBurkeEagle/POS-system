package UI;

import javax.swing.JPanel;

import PD.Cashier;
import PD.Register;
import PD.Store;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierListPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	DefaultListModel<Cashier> listModel;
	/**
	 * Create the panel.
	 */
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	public CashierListPanel(JFrame currentFrame, Store store) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cashiers");
		lblNewLabel.setBounds(201, 11, 68, 14);
		add(lblNewLabel);
		
		listModel = new DefaultListModel<Cashier>();
		listModel.addAll(store.getCashiers().values());
		
		JList<Cashier> list = new JList<Cashier>(listModel);
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
				currentFrame.getContentPane().add(new CashierEditPanel(currentFrame, store, new Cashier(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(81, 202, 89, 23);
		add(btnNewButton);
		
		btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierEditPanel(currentFrame, store, list.getSelectedValue(), false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(180, 202, 89, 23);
		add(btnNewButton_1);
		btnNewButton_1.setEnabled(false);
		
		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				store.deleteCashier(list.getSelectedValue());
				listModel.removeElement(list.getSelectedValue());
			}
		});
		btnNewButton_2.setBounds(279, 202, 89, 23);
		add(btnNewButton_2);
		btnNewButton_2.setEnabled(false);

	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
