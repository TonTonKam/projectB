package vue;

import javax.swing.*;

import model.ColorPanel;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelMenuGeneral extends JPanel {

	//attributs
	private JLabel labelLogo, labelAssistance, labelTelephone, labelJoindre, labelBienvenue, labelNomClient;
	private JButton btnDeconnexion;
	private JPanel PanelLogin;
	private JPanel contentPane;
	private int longueurMax, hauteurMax;
	
	/**
	 * Create the panel.
	 */
	public PanelMenuGeneral(JPanel contentPane, int longueurM) {
		setBackground(ColorPanel.vertClair());
		setBackground(new Color(0, 234, 117));
		setBounds(0, 0, longueurM, 120);
		//setLayout(new SpringLayout());
		
		labelLogo = new JLabel("IMG");
		add(labelLogo);
		
		labelAssistance = new JLabel("Assistance t�l�phonique");
		add(labelAssistance);
		
		labelTelephone = new JLabel("01.58.79.63.53");
		add(labelTelephone);
		
		labelJoindre = new JLabel("7h - 23h Tous les jours");
		add(labelJoindre);
		
		labelBienvenue = new JLabel("Bienvenue");
		add(labelBienvenue);
		
		labelNomClient = new JLabel("NomClient");
		add(labelNomClient);
		
		btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PanelLogin deconect = new PanelLogin(contentPane, longueurM, longueurM);
				contentPane.removeAll();
				contentPane.add(deconect);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		add(btnDeconnexion);
	}

}
