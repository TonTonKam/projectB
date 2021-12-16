package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	private JPanel contentPane;
	private final int hauteur = 400;
	private final int longueur = 800;
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		PanelMenuAdmin menuAdmin = new PanelMenuAdmin(contentPane);
		PanelUserAdmin userAdmin = new PanelUserAdmin(contentPane);
		PanelArticleAdmin articleAdmin = new PanelArticleAdmin(contentPane);
		contentPane.add(menuAdmin);
		contentPane.add(userAdmin);
		contentPane.add(articleAdmin);
		userAdmin.setVisible(false);
		menuAdmin.setVisible(true);
		articleAdmin.setVisible(false);
	}

}
