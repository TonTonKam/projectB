package vue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Frame extends JFrame {

	private JPanel contentPane;
	private final int LONGUEURMAX = 1000;
	private final int HAUTEURMAX = 800;

	private PanelMenuClient pmc;
	private PanelMenuGeneral pmg;
	private PanelMenuPanier pmp;
	private PanelAccueilClient pac;
	private PanelArticleSelectClient pasc;
	private PanelCommandeClient pcc;

	/**
	 * Create the frame.
	 */
	public Frame() {
		//instanciantion des panels
		pcc = new PanelCommandeClient(LONGUEURMAX, HAUTEURMAX);
		pasc = new PanelArticleSelectClient(LONGUEURMAX, HAUTEURMAX);
		pac = new PanelAccueilClient(pasc, LONGUEURMAX, HAUTEURMAX);
		pmc = new PanelMenuClient(pac, pasc, LONGUEURMAX);
		pmg = new PanelMenuGeneral(LONGUEURMAX);
		pmp = new PanelMenuPanier(LONGUEURMAX, HAUTEURMAX);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, LONGUEURMAX, HAUTEURMAX);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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
	}

}
