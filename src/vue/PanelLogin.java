package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ControllerLogin;


public class PanelLogin extends JPanel {
	private JTextField password;
	private JTextField identifiant;
	private ControllerLogin controllerLogin;

	/**
	 * Create the panel.
	 */
	
	public PanelLogin(JPanel contentPane,int longueurMax,int hauteurMax) {
		controllerLogin = new ControllerLogin();
		setLayout(null);
		System.out.println("login");
		
		
		//JPanel panel = new JPanel();
		this.setBackground(new Color(160, 82, 45));
		
		this.setBounds(0,0,1000,800);
		
		//add(panel);
		this.setLayout(null);
		
		JButton connexion = new JButton("Connexion");
		connexion.setBounds(278, 217, 175, 29);
		this.add(connexion);
		
		password = new JTextField();
		password.setBounds(251, 121, 130, 26);
		this.add(password);
		password.setColumns(10);
		
		identifiant = new JTextField();
		identifiant.setColumns(10);
		identifiant.setBounds(251, 73, 130, 26);
		this.add(identifiant);
		
		
		connexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controllerLogin.connecter(identifiant,password,contentPane,longueurMax,hauteurMax);
				
			}
		});
		
		
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("Identifiant");
		lblNewLabel.setBounds(52, 78, 105, 16);
		this.add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("Mot de Passe");
		lblMotDePasse.setBounds(52, 126, 130, 16);
		this.add(lblMotDePasse);
		
		JButton inscription = new JButton("Inscription");
		
			
		inscription.setBounds(278, 258, 175, 29);
		this.add(inscription);

	// BorderLayout 
		// setPreferredSize(new Dimension(200,0));
		//contentPane.add(objet, BorderLayout.LEFT);
	}


}
	
