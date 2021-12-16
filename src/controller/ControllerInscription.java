package controller;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.User;
import vue.PanelAcceuilAdministrateur;
import vue.Main;
import vue.PanelInscription;
import vue.PanelLogin;

public class ControllerInscription {
	private JTextField nom;
	private JTextField prenom;
	private JTextField email;
	private JPasswordField password;
	private JPanel contentPane;

	public void inscrire(JTextField nom,JTextField prenom,JTextField email,JPasswordField password,JPanel contentPane,int longueurMax,int hauteurMax) {
		String nom_saisie = nom.getText();
		String prenom_saisie = prenom.getText();
		String email_saisie = email.getText();
		String password_saisie = String.valueOf(password.getPassword());
		
		User marc = new User(nom_saisie,prenom_saisie,email_saisie,password_saisie);
		UserDao marco = new UserDao();
		if(!(Pattern.matches("^[a-zA-Z0-9_.-]+[@][a-zA-Z0-9-]+[.]+[a-zA-Z0-9]+$", email_saisie) )) {
			JOptionPane.showMessageDialog(null, "Mail invalide","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(!marco.mailExist(email_saisie)) {
			JOptionPane.showMessageDialog(null, "Cette adresse est associée à un compte","Error",JOptionPane.ERROR_MESSAGE);
			PanelLogin bienvenue = new PanelLogin(contentPane, longueurMax, hauteurMax);
			contentPane.removeAll();
			contentPane.add(bienvenue);
			contentPane.repaint();
			contentPane.revalidate();	
		}
		else {
			
			marco.inscription(marc);
			
		}
		
		
	
	}
	
}
