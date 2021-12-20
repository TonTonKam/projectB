package controller;

import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.User;
import vue.Frame;
import vue.PanelInscription;
import vue.PanelLogin;

public class ControllerInscription {
	private JTextField nom;
	private JTextField prenom;
	private JTextField email;
	private JPasswordField password;
	private JPanel contentPane;
	private JButton btnNewButton;

	public void activer(JTextField nom,JTextField prenom,JTextField email,JPasswordField password,JButton btnNewButton) {
		String nomSaisie = nom.getText();
		String prenomSaisie = prenom.getText();
		String emailSaisie = email.getText();
		String passwordSaisie = String.valueOf(password.getPassword());
		
		if((!nomSaisie.isEmpty())&&(!prenomSaisie.isEmpty())&&(!emailSaisie.isEmpty())&&(!passwordSaisie.isEmpty())) {
			btnNewButton.setEnabled(true);
		}
		else {
			btnNewButton.setEnabled(false);
		}
	}
		
			
	
	public void inscrire(JTextField nom,JTextField prenom,JTextField email,JPasswordField password,JPanel contentPane,int longueurMax,int hauteurMax) {
		String nomSaisie = nom.getText();
		String prenomSaisie = prenom.getText();
		String emailSaisie = email.getText();
		String passwordSaisie = String.valueOf(password.getPassword());
		
		User marc = new User(nomSaisie,prenomSaisie,emailSaisie,passwordSaisie);
		UserDao marco = new UserDao();
		
		
		if(!(Pattern.matches("^[a-zA-Z0-9_.-]+[@][a-zA-Z0-9-]+[.]+[a-zA-Z0-9]+$", emailSaisie) )) {
			JOptionPane.showMessageDialog(null, "Mail invalide","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(!marco.mailExist(emailSaisie)) {
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
