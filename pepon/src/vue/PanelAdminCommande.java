package vue;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class PanelAdminCommande extends JPanel {

	//attributs
	private JPanel panelCommande;
	/**
	 * Create the panel.
	 */
	public PanelAdminCommande() {
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 64, 964, 486);
		add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		panelCommande = new JPanel();
		panelCommande.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(panelCommande, "name_727945092020900");
		
		JLabel lblGestionDeCommandes = new JLabel("Gestion de commandes");
		lblGestionDeCommandes.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelCommande.add(lblGestionDeCommandes);
	}

}
