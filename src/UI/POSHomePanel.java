package UI;

import javax.swing.JPanel;

import PD.Store;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class POSHomePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public POSHomePanel(Store store) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel(store.getName());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(161, 100, 136, 33);
		add(lblNewLabel);

	}
}
