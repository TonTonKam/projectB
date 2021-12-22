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
	private PanelClientMenu pmc;
	private PanelClientGeneralMenu pmg;
	private PanelClientPanierMenu pmp;
	private PanelClientAccueil pac;
	private PanelArticleSelectClient pasc;
	private PanelClientCommande pcc;

	private PanelAdminUser pau;
	
	/**
	 * Create the frame.
	 */
	public Frame() {
		
		//instanciantion des panels
		pmg = new PanelClientGeneralMenu(LONGUEURMAX);
		pcc = new PanelClientCommande(LONGUEURMAX, HAUTEURMAX);
		pasc = new PanelArticleSelectClient(pmp, LONGUEURMAX, HAUTEURMAX);
		pac = new PanelClientAccueil(pasc, LONGUEURMAX, HAUTEURMAX);
		pmc = new PanelClientMenu(pac, pasc, LONGUEURMAX);
		//pmp = new PanelMenuPanier(pcc, pasc, pac, LONGUEURMAX, HAUTEURMAX);

		//Admin
		pau = new PanelAdminUser();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, LONGUEURMAX, HAUTEURMAX);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		login = new PanelLogin(contentPane,LONGUEURMAX,HAUTEURMAX);
		
		contentPane.add(pac);
		contentPane.add(pmc);
		contentPane.add(pmg);
		//contentPane.add(pmp);
		//pmp.setLayout(null);
		contentPane.add(pasc);
		contentPane.add(pcc);
	
		//Admin
		contentPane.add(pau);
		
		contentPane.add(login);
		login.setVisible(false);
	//debut accueil
		pmc.setVisible(false);
		pmg.setVisible(false);
		//pmp.setVisible(false);
		pac.setVisible(false);
	//fin accueil
		pasc.setVisible(false);
		pcc.setVisible(false);

	// Debut admin	
		pau.setVisible(true);
		
	}

}
