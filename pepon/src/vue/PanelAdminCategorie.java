package vue;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class PanelAdminCategorie extends JPanel {

	//attributs
	private JPanel panelCategorie;
	public PanelAdminCategorie() {

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 64, 964, 486);
		add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panelCategorie = new JPanel();
		panelCategorie.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(panelCategorie, "name_727948124011100");
		
		JLabel lblGestionDeCatgories = new JLabel("Gestion de cat\u00E9gories");
		lblGestionDeCatgories.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelCategorie.add(lblGestionDeCatgories);
	}

}
