package vue;

import javax.swing.*;

import model.ColorPanel;

import java.awt.Color;

public class PanelMenuGeneral extends JPanel {

	//attributs
	private JLabel labelLogo, labelAssistance, labelTelephone, labelJoindre, labelBienvenue, labelNomClient;
	private JButton btnDeconnexion;
	
	/**
	 * Create the panel.
	 */
	public PanelMenuGeneral(int longueurM) {
		ColorPanel color = new ColorPanel();
		setBackground(color.vertClair());
		setBackground(new Color(0, 234, 117));
		setBounds(0, 0, longueurM, 120);
		setLayout(new SpringLayout());
	}

}
