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

import model.User;
import model.VarStatic;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.regex.Pattern;

import vue.Frame;
import vue.PanelClientAccueil;
import vue.PanelAdminArticle;
import vue.PanelArticleSelectClient;
import vue.PanelClientCommande;
import vue.PanelInscription;
import vue.PanelLogin;
import vue.PanelClientMenu;
import vue.PanelClientGeneralMenu;
import vue.PanelClientPanierMenu;
import vue.PanelAdminUser;

public class ControllerLogin {
	//private JPasswordField password;
	
	private JTextField identifiant;
	private JTextField password;
	private JPanel contentPane;
	private JPanel PanelAdminArticle;
	private JPanel PanelAccueilClient;
	private JPanel login;
	private PanelClientMenu pmc;
	private PanelClientGeneralMenu pmg;
	private PanelClientPanierMenu pmp;
	private PanelClientAccueil pac;
	private PanelArticleSelectClient pasc;
	private PanelClientCommande pcc;
	private PanelAdminUser pau;
	
	public void connecter(JTextField identifiant,JTextField password,JPanel contentPane,int longueurMax, int hauteurMax) {
	
		pcc = new PanelClientCommande(longueurMax, hauteurMax);
		pasc = new PanelArticleSelectClient(pmp, longueurMax, hauteurMax);
		pac = new PanelClientAccueil(pasc, longueurMax, hauteurMax);
		pmc = new PanelClientMenu(pac, pasc, longueurMax);
		pmg = new PanelClientGeneralMenu(longueurMax);
		pmp = new PanelClientPanierMenu(pcc, pasc, pac, longueurMax, hauteurMax);
		pau = new PanelAdminUser();
		
		
		login = new PanelLogin(contentPane,longueurMax, hauteurMax);
		String identifiant_saisi = identifiant.getText();
		String pwd_saisie = password.getText();
		//String pwd_saisie = String.valueOf(password.getPassword());
		
		
		UserDao usDao = new UserDao();
		
		usDao.login(identifiant_saisi,pwd_saisie);
		
		
		if(!(Pattern.matches("^[a-zA-Z0-9_.-]+[@][a-zA-Z0-9-]+[.]+[a-zA-Z0-9]+$", identifiant_saisi) )) {
			JOptionPane.showMessageDialog(null, "Veuillez verifier le format de votre identifiant","Error",JOptionPane.ERROR_MESSAGE);}
		else if(usDao.mailExist(identifiant_saisi)) {
			JOptionPane.showMessageDialog(null, "Vos identifiants semblent incorrects, si vous êtes un nouveau client, veuillez vous inscrire");
		}
		else if(usDao.login(identifiant_saisi, pwd_saisie)) {
			JOptionPane.showMessageDialog(null, "Felicitation");
			login.setVisible(false);
			if(!usDao.isAdmin(identifiant_saisi, pwd_saisie)) {
				
			//debut accueil
				contentPane.removeAll();
				contentPane.add(pac);
				contentPane.add(pmc);
				contentPane.add(pmg);
				contentPane.add(pmp);
				contentPane.add(pasc);
				contentPane.add(pcc);
				contentPane.repaint();
				contentPane.revalidate();
			
			}
			else {
				
				contentPane.removeAll();
				contentPane.add(pau);
				contentPane.repaint();
				contentPane.revalidate();
			
		}
			}
		else {
			JOptionPane.showMessageDialog(null, "Identifiant ou Mot de Passe incorrect");
			
		}
	}
	
}
	
