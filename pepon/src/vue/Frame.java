package vue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

<<<<<<< HEAD
import controller.ControllerClientMenuGeneral;
import model.ColorPanel;

import javax.swing.JLabel;

=======
>>>>>>> origin/yannK
public class Frame extends JFrame {

	private JPanel contentPane;
	private final int LONGUEURMAX = 1000;
	private final int HAUTEURMAX = 800;

<<<<<<< HEAD
	private PanelLogin login;

	private PanelAdminUser pau;
	
=======
	private PanelMenuClient pmc;
	private PanelMenuGeneral pmg;
	private PanelMenuPanier pmp;
	private PanelAccueilClient pac;
	private PanelArticleSelectClient pasc;
	private PanelCommandeClient pcc;
	

>>>>>>> origin/yannK
	/**
	 * Create the frame.
	 */
	public Frame() {
<<<<<<< HEAD
		
		//Admin
		pau = new PanelAdminUser();
		
=======
		//instanciantion des panels
		pcc = new PanelCommandeClient(LONGUEURMAX, HAUTEURMAX);
		pasc = new PanelArticleSelectClient(LONGUEURMAX, HAUTEURMAX);
		pac = new PanelAccueilClient(pasc, LONGUEURMAX, HAUTEURMAX);
		pmc = new PanelMenuClient(pac, pasc, LONGUEURMAX);
		pmg = new PanelMenuGeneral(LONGUEURMAX);
		pmp = new PanelMenuPanier(pcc, pasc, pac, LONGUEURMAX, HAUTEURMAX);

>>>>>>> origin/yannK
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, LONGUEURMAX, HAUTEURMAX);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
<<<<<<< HEAD
		
		contentPane.setBackground(ColorPanel.vertClair());
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		login = new PanelLogin(contentPane,LONGUEURMAX,HAUTEURMAX);
		//instanciantion des panels client dans controllerLogin
		
		//Admin
		contentPane.add(pau);
		contentPane.add(login);
		
		login.setVisible(true);

	// Debut admin	
		pau.setVisible(false);
		
=======
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(pac);
		contentPane.add(pmc);
		contentPane.add(pmg);
		contentPane.add(pmp);
		contentPane.add(pasc);
		contentPane.add(pcc);
		
		pmc.setVisible(true);
		pmg.setVisible(true);
		pmp.setVisible(true);
		pac.setVisible(true);
		pasc.setVisible(false);
		pcc.setVisible(false);
>>>>>>> origin/yannK
	}

}
