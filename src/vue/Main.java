package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private final int longueurMax = 1000;
	private final int hauteurMax = 500;
	public Main() {
		super("Pepon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(longueurMax,hauteurMax);
		this.setLocationRelativeTo(null);
		//contentPane.setBounds(100,100,1000,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		
		PanelLogin login = new PanelLogin(contentPane,longueurMax,hauteurMax);
		contentPane.add(login);
		login.setVisible(true);
		
		
		
	}

}
