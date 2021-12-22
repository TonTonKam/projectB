package vue;

import model.ColorPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;

	public class PanelAdminCommande extends JPanel {
	/**
	 * Create the panel.
	 */
	public PanelAdminCommande() {
		
		setBackground(Color.ORANGE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Commandes");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel.setBounds(235, 150, 268, 62);
		add(lblNewLabel);
	}

}
