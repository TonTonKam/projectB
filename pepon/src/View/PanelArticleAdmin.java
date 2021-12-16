package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelArticleAdmin extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelArticleAdmin(JPanel contentPane) {
		setBackground(Color.GREEN);
		setBounds(0, 300, 800, 300);
		setLayout(null);
		JLabel lblNewLabel = new JLabel("Gestion d'article");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(245, 11, 207, 40);
		add(lblNewLabel);
		System.out.println("admin_article");
	}

}
