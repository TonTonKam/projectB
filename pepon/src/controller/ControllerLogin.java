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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.regex.Pattern;

import vue.Frame;
import vue.PanelAccueilClient;
import vue.PanelAdminArticle;
import vue.PanelAdminMenu;
import vue.PanelArticleSelectClient;
import vue.PanelCommandeClient;
import vue.PanelInscription;
import vue.PanelLogin;
import vue.PanelMenuClient;
import vue.PanelMenuGeneral;
import vue.PanelMenuPanier;
import vue.test;
import vue.PanelAdminUser;

public class ControllerLogin {
	//private JPasswordField password;
	
	private JTextField identifiant;
	private JTextField password;
	private JPanel contentPane;
	private JPanel PanelAdminArticle;
	private JPanel PanelAccueilClient;
	private JPanel login;
	private PanelMenuClient pmc;
	private PanelMenuGeneral pmg;
	private PanelMenuPanier pmp;
	private PanelAccueilClient pac;
	private PanelArticleSelectClient pasc;
	private PanelCommandeClient pcc;
	private PanelAdminUser pau;
	private PanelAdminMenu pam;
	private test teste;
	
	public void connecter(JTextField identifiant,JTextField password,JPanel contentPane,int longueurMax, int hauteurMax) {
	
		pcc = new PanelCommandeClient(longueurMax, hauteurMax);
		pasc = new PanelArticleSelectClient(longueurMax, hauteurMax);
		pac = new PanelAccueilClient(pasc, longueurMax, hauteurMax);
		pmc = new PanelMenuClient(pac, pasc, longueurMax);
		pmg = new PanelMenuGeneral(longueurMax);
		pmp = new PanelMenuPanier(pcc, pasc, pac, longueurMax, hauteurMax);
		pau = new PanelAdminUser();
		pam = new PanelAdminMenu();
		teste = new test(longueurMax, hauteurMax);
		login = new PanelLogin(contentPane,longueurMax, hauteurMax);
		String identifiant_saisi = identifiant.getText();
		String pwd_saisie = password.getText();
		//String pwd_saisie = String.valueOf(password.getPassword());
		
		
		UserDao usDao = new UserDao();
		
		usDao.login(identifiant_saisi,pwd_saisie);
		
		
		if(!(Pattern.matches("^[a-zA-Z0-9_.-]+[@][a-zA-Z0-9-]+[.]+[a-zA-Z0-9]+$", identifiant_saisi) )) {
			JOptionPane.showMessageDialog(null, "Veuillez vérifier le format de votre identifiant","Error",JOptionPane.ERROR_MESSAGE);}
		else if(usDao.mailExist(identifiant_saisi)) {
			JOptionPane.showMessageDialog(null, "Vos identifiants semblent incorrects, si vous êtes un nouveau client, veuillez vous inscrire");
		}
		else if(usDao.login(identifiant_saisi, pwd_saisie)) {
			JOptionPane.showMessageDialog(null, "F�licitation");
			login.setVisible(false);
			if(usDao.isAdmin(identifiant_saisi, pwd_saisie)) {
				
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
				contentPane.add(teste);
				contentPane.repaint();
				contentPane.revalidate();
				
			
		}}
		else {
			JOptionPane.showMessageDialog(null, "Identifiant ou Mot de Passe incorrect");
			
		}
	}
	
}
	
