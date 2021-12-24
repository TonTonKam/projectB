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
import vue.PanelArticleSelectClient;
import vue.PanelCommandeClient;
import vue.PanelInscription;
import vue.PanelLogin;
import vue.PanelMenuClient;
import vue.PanelMenuGeneral;
import vue.PanelMenuPanier;
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
	
	public void connecter(JTextField identifiant,JTextField password,JPanel contentPane,int longueurMax, int hauteurMax) {
	
		
		
		
		login = new PanelLogin(contentPane,longueurMax, hauteurMax);
		String identifiantSaisi = identifiant.getText();
		String pwdSaisie = password.getText();
		//String pwd_saisie = String.valueOf(password.getPassword());
		
		
		UserDao usDao = new UserDao();
		
		//usDao.login(identifiant_saisi,pwd_saisie);
		
		
		if(!(Pattern.matches("^[a-zA-Z0-9_.-]+[@][a-zA-Z0-9-]+[.]+[a-zA-Z0-9]+$", identifiantSaisi) )) {
			JOptionPane.showMessageDialog(null, "Veuillez vérifier le format de votre identifiant","Error",JOptionPane.ERROR_MESSAGE);}
		else if(usDao.mailExist(identifiantSaisi)||usDao.incorectPassword(identifiantSaisi,pwdSaisie)) {
			JOptionPane.showMessageDialog(null, "Vos identifiants semblent incorrects, si vous êtes un nouveau client, veuillez vous inscrire");
		}
		else if(usDao.isAdmin(identifiantSaisi, pwdSaisie)) {
				JOptionPane.showMessageDialog(null, "F�licitation");
				login.setVisible(false);
				pcc = new PanelCommandeClient(longueurMax, hauteurMax);
				pasc = new PanelArticleSelectClient(pmp, longueurMax, hauteurMax);
				pac = new PanelAccueilClient(pasc, longueurMax, hauteurMax);
				pmc = new PanelMenuClient(pac, pasc, longueurMax);
				pmg = new PanelMenuGeneral(contentPane,longueurMax);
				pmp = new PanelMenuPanier(pcc, pasc, pac, longueurMax, hauteurMax);
				pau = new PanelAdminUser();
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
				JOptionPane.showMessageDialog(null, "F�licitation");
				login.setVisible(false);
				contentPane.removeAll();
				contentPane.add(pau);
				contentPane.repaint();
				contentPane.revalidate();
				
			
		}}
		
	}
	

	
