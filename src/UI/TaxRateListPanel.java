package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import PD.Store;
import PD.TaxCategory;
import PD.TaxRate;

public class TaxRateListPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	DefaultListModel<TaxRate> listModel;
	/**
	 * Create the panel.
	 */
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	public TaxRateListPanel(JFrame currentFrame, JPanel currentPanel, Store store, TaxCategory taxCategory, Boolean tcIsAdd) {
		setLayout(null);
		
		listModel = new DefaultListModel<TaxRate>();
		for(TaxRate tr : taxCategory.getTaxRates())
		listModel.addElement(tr);
		
		JList<TaxRate> list = new JList<TaxRate>(listModel);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(list.getSelectedValue() != null) {
					btnNewButton_1.setEnabled(true);
					if(list.getSelectedValue().isEffective(LocalDate.now()) == false)
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
		list.setBounds(0, 11, 215, 92);
		add(list);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxRateEditPanel(currentFrame, currentPanel, store, taxCategory, new TaxRate(), true, tcIsAdd));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(0, 114, 65, 23);
		add(btnNewButton);
		
		btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxRateEditPanel(currentFrame, currentPanel, store, taxCategory, list.getSelectedValue(), false, tcIsAdd));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(75, 114, 65, 23);
		add(btnNewButton_1);
		btnNewButton_1.setEnabled(false);
		
		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taxCategory.removeTaxRate(list.getSelectedValue());
				listModel.removeElement(list.getSelectedValue());
				
			}
		});
		btnNewButton_2.setBounds(150, 114, 65, 23);
		add(btnNewButton_2);
		btnNewButton_2.setEnabled(false);
	}

}
