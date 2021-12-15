package vue;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class PanelLogin extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	
	public PanelLogin(JPanel contentPane,int longueurMax,int hauteurMax) {
		setLayout(null);
		System.out.println("login");
		
		
		//JPanel panel = new JPanel();
		this.setBackground(new Color(160, 82, 45));
		
		this.setBounds(0,0,longueurMax,hauteurMax);
		
		//add(panel);
		this.setLayout(null);
		
	
		
		JButton btnNewButton = new JButton("Connexion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelAcceuilAdministrateur acc = new PanelAcceuilAdministrateur(contentPane, longueurMax, hauteurMax);
				contentPane.removeAll();
				contentPane.add(acc);
				contentPane.repaint();
				contentPane.revalidate();
				
			}
		});
		btnNewButton.setBounds(longueurMax/5, hauteurMax/2, 175, 29);
		this.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(251, 121, 130, 26);
		this.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(251, 73, 130, 26);
		this.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("Identifiant");
		lblNewLabel.setBounds(52, 78, 105, 16);
		this.add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("Mot de Passe");
		lblMotDePasse.setBounds(52, 126, 130, 16);
		this.add(lblMotDePasse);
		
		JButton btnInscription = new JButton("Inscription");
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelInscription formulaire = new PanelInscription();
				contentPane.removeAll();
				contentPane.add(formulaire);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		btnInscription.setBounds(122, 233, 175, 29);
		this.add(btnInscription);

	// BorderLayout 
		// setPreferredSize(new Dimension(200,0));
		//contentPane.add(objet, BorderLayout.LEFT);
	}


}
	
