package vue;

import javax.swing.*;

import controller.ControllerClientMenuGeneral;
import model.ColorPanel;
import model.VarStatic;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelClientGeneralMenu extends JPanel {

	//attributs
	private JLabel labelLogo, labelAssistance, labelTelephone, labelJoindre, labelBienvenue, labelNomClient;
	private JButton btnDeconnexion;
	private ControllerClientMenuGeneral controlMenuG;
	/**
	 * Create the panel.
	 */
	public PanelClientGeneralMenu(int longueurM) {
		setBackground(ColorPanel.vertClair());
		setBackground(new Color(0, 234, 117));
		setBounds(0, 0, longueurM, 120);
		//setLayout(new SpringLayout());
		
		controlMenuG = new ControllerClientMenuGeneral();
		
		labelLogo = new JLabel("IMG");
		add(labelLogo);
		
		labelAssistance = new JLabel("Assistance téléphonique");
		add(labelAssistance);
		
		labelTelephone = new JLabel("01.58.79.63.53");
		add(labelTelephone);
		
		labelJoindre = new JLabel("7h - 23h Tous les jours");
		add(labelJoindre);
		
		labelBienvenue = new JLabel("Bienvenue");
		add(labelBienvenue);
		
		//modifie la valeur
		labelNomClient = new JLabel("Utilisateur");
		controlMenuG.afficheUser(this);
		add(labelNomClient);
		
		btnDeconnexion = new JButton("Quitter");
		btnDeconnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//ferme L'application
				System.exit(0);
			}
		});
		add(btnDeconnexion);
	}
	
	public void setLabelNomClient(String labelNomClient) {
		this.labelNomClient.setText(labelNomClient);
	}

	
}
