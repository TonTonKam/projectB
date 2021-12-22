package vue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Frame extends JFrame {

	private JPanel contentPane;
	private final int LONGUEURMAX = 1000;
	private final int HAUTEURMAX = 800;

	private PanelLogin login;
	private PanelMenuClient pmc;
	private PanelMenuGeneral pmg;
	private PanelMenuPanier pmp;
	private PanelAccueilClient pac;
	private PanelArticleSelectClient pasc;
	private PanelCommandeClient pcc;
	
	private PanelAdminMenu pam;

	private PanelAdminUser pau;
	


	/**
	 * Create the frame.
	 */
	public Frame() {
		
		//instanciantion des panels
		pmg = new PanelMenuGeneral(LONGUEURMAX);
		pcc = new PanelCommandeClient(LONGUEURMAX, HAUTEURMAX);
		pasc = new PanelArticleSelectClient(pmp, LONGUEURMAX, HAUTEURMAX);
		pac = new PanelAccueilClient(pasc, LONGUEURMAX, HAUTEURMAX);
		pmc = new PanelMenuClient(pac, pasc, LONGUEURMAX);
		pmp = new PanelMenuPanier(pcc, pasc, pac, LONGUEURMAX, HAUTEURMAX);
		
		pam = new PanelAdminMenu();

		//Admin
		pau = new PanelAdminUser();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		login = new PanelLogin(contentPane,LONGUEURMAX,HAUTEURMAX);
		
		contentPane.add(pac);
		contentPane.add(pmc);
		contentPane.add(pmg);
		contentPane.add(pmp);
		pmp.setLayout(null);
		contentPane.add(pasc);
		contentPane.add(pcc);
	
		
		//Admin
		contentPane.add(pau);
		
		
		contentPane.add(pam);
		
		contentPane.add(login);
		login.setVisible(false);
	//debut accueil
		pmc.setVisible(false);
		pmg.setVisible(false);
		pmp.setVisible(false);
		pac.setVisible(false);
	//fin accueil
		pasc.setVisible(false);
		pcc.setVisible(false);

		pam.setVisible(false);

	// Debut admin	
		pau.setVisible(true);
		
	}

}
