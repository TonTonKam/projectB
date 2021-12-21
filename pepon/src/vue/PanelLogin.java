package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ControllerLogin;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;


public class PanelLogin extends JPanel {
	private JTextField identifiant;
	private ControllerLogin controllerLogin;
	private JPasswordField password;

	/**
	 * Create the panel.
	 */
	
	public PanelLogin(JPanel contentPane,int longueurMax,int hauteurMax) {
		controllerLogin = new ControllerLogin();
		setLayout(null);
		this.setBackground(new Color(0, 128, 0));
		
		this.setBounds(0,0,longueurMax,hauteurMax);
		this.setLayout(null);
		
		JButton connexion = new JButton("Connexion");
		connexion.setBounds(3*longueurMax/8, 4*hauteurMax/8, 175, 29);
		this.add(connexion);
		
		identifiant = new JTextField();
		identifiant.setColumns(10);
		identifiant.setBounds(4*longueurMax/8, 2*hauteurMax/8, 130, 26);
		this.add(identifiant);
		
		
		connexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controllerLogin.connecter(identifiant,password,contentPane,longueurMax,hauteurMax);
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("Identifiant");
		lblNewLabel.setBounds(2*longueurMax/8, 2*hauteurMax/8, 105, 16);
		this.add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("Mot de Passe");
		lblMotDePasse.setBounds(2*longueurMax/8, 3*hauteurMax/8, 130, 16);
		this.add(lblMotDePasse);
		
		JButton inscription = new JButton("Inscription");
		inscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelInscription philippe = new PanelInscription(contentPane, longueurMax, hauteurMax);
				contentPane.removeAll();
				contentPane.add(philippe);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		
		inscription.setBounds(3*longueurMax/8, 5*hauteurMax/8, 175, 29);
		this.add(inscription);
		
		password = new JPasswordField();
		password.setBounds(4*longueurMax/8, 3*hauteurMax/8, 130, 26);
		add(password);

	}
}
	
