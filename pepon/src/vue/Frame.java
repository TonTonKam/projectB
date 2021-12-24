package vue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControllerClientMenuGeneral;
import model.ColorPanel;

import javax.swing.JLabel;

public class Frame extends JFrame {

	private JPanel contentPane;
	private final int LONGUEURMAX = 1000;
	private final int HAUTEURMAX = 800;

	private PanelLogin login;

	private PanelAdminUser pau;
	
	/**
	 * Create the frame.
	 */
	public Frame() {
		
		//Admin
		pau = new PanelAdminUser();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, LONGUEURMAX, HAUTEURMAX);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setBackground(ColorPanel.vertClair());
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		login = new PanelLogin(contentPane,LONGUEURMAX,HAUTEURMAX);
		//instanciantion des panels client dans controllerLogin
		
		//Admin
		contentPane.add(pau);
		contentPane.add(login);
		
		login.setVisible(false);

	// Debut admin	
		pau.setVisible(true);
		
	}

}
