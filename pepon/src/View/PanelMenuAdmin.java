package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelMenuAdmin extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelMenuAdmin(JPanel contentPane) {
		setBackground(Color.ORANGE);
		setBounds(0, 0, 800, 60);
		setLayout(null);
		
		JButton user = new JButton("Utilisateur");
		user.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelUserAdmin user = new PanelUserAdmin(contentPane);
				contentPane.add(user);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		user.setBounds(10, 11, 113, 33);
		add(user);
		
		JButton article = new JButton("Articles");
		article.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelArticleAdmin article = new PanelArticleAdmin(contentPane);
				
				contentPane.add(article);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		article.setBounds(171, 11, 113, 33);
		add(article);
		
		JButton commande = new JButton("Commandes");
		commande.setBounds(334, 11, 113, 33);
		add(commande);
		
		JButton btnCatgories = new JButton("Cat\u00E9gories");
		btnCatgories.setBounds(486, 11, 113, 33);
		add(btnCatgories);
		
		JButton btnStatuts = new JButton("Statuts");
		btnStatuts.setBounds(645, 11, 113, 33);
		add(btnStatuts);

	}

}
