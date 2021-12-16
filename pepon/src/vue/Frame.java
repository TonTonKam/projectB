package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.PanelModelGeneral;

public class Frame extends JFrame {

	private JPanel contentPane;
	private final int LONGUEURMAX = 1000;
	private final int HAUTEURMAX = 800;

	PanelMenuClient pmc;
	PanelMenuGeneral pmg;
	PanelMenuPanier pmp;
	PanelGeneralClient pgc;

	/**
	 * Create the frame.
	 */
	public Frame() {
		//instanciantion des panels
		pmc = new PanelMenuClient(LONGUEURMAX);
		pmg = new PanelMenuGeneral(LONGUEURMAX);
		pmp = new PanelMenuPanier(LONGUEURMAX, HAUTEURMAX);
		pgc = new PanelGeneralClient(LONGUEURMAX, HAUTEURMAX);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, LONGUEURMAX, HAUTEURMAX);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(pla);
		contentPane.add(pmc);
		contentPane.add(pmg);
		contentPane.add(pmp);
		pmc.setVisible(true);
		pmg.setVisible(true);
		pmp.setVisible(true);
		pla.setVisible(true);
	}

}
