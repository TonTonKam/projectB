package vue;

import javax.swing.*;

import controller.ControllerClientMenu;
import model.ColorPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelClientMenu extends JPanel {

	//label temporaire a definir
	private JButton btnCategorie;
	private ControllerClientMenu controlMC;
	private int index;
	
	/**
	 * Create the panel.
	 */
	public PanelClientMenu(PanelClientAccueil panelGeneral, PanelClientArticleSelect panelExpedition, int longueurM) {
		controlMC = new ControllerClientMenu();
		setBackground(ColorPanel.vertFoncer());
		setBounds(0, 120, longueurM, 80);
		
		//ajout du generateur de bouton
		for(index = 0; index < controlMC.listCategorie().size() + 1; index ++) {
			btnCategorie = new JButton();
			add(controlMC.genererBoutonCategorie(panelGeneral, panelExpedition, longueurM, btnCategorie, index));
		}
		
	}
}
