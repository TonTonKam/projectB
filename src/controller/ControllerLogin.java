package controller;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.regex.Pattern;

import vue.Main;
import vue.PanelAcceuilAdministrateur;
import vue.PanelInscription;

public class ControllerLogin {
	//private JPasswordField password;
	
	private JTextField identifiant;
	private JTextField password;
	
	public void connecter(JTextField identifiant,JTextField password,JPanel contentPane,int longueurMax, int hauteurMax) {
	
	String identifiant_saisi = identifiant.getText();
	String pwd_saisie = password.getText();
	//String pwd_saisie = String.valueOf(password.getPassword());
	
	UserDao usDao = new UserDao();
	
	usDao.login(identifiant_saisi,pwd_saisie);
	
	
	if(!(Pattern.matches("^[a-zA-Z0-9_.-]+[@][a-zA-Z0-9-]+[.]+[a-zA-Z0-9]+$", identifiant_saisi) )) {
		JOptionPane.showMessageDialog(null, "Veuillez vérifier le format de votre identifiant","Error",JOptionPane.ERROR_MESSAGE);}
	else if(usDao.mailExist(identifiant_saisi)) {
		JOptionPane.showMessageDialog(null, "Identifiant inconnu");
	}
	else if(usDao.login(identifiant_saisi, pwd_saisie)) {
		JOptionPane.showMessageDialog(null, "F�licitation");
		PanelAcceuilAdministrateur acc = new PanelAcceuilAdministrateur(contentPane,longueurMax, hauteurMax);
		contentPane.removeAll();
		contentPane.add(acc);
		contentPane.repaint();
		contentPane.revalidate();
		}
	else {
		JOptionPane.showMessageDialog(null, "Mot de Passe incorrect");
		
	}
	}
	
}
	
