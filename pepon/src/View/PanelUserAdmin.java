package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PanelUserAdmin extends JPanel {
	
	/**
	 * Create the panel.
	 */
	public PanelUserAdmin(JPanel contentPane) {
		setBackground(Color.GRAY);
		setBounds(0, 300, 800, 300);
		setLayout(null);
		JLabel lblNewLabel = new JLabel("Gestion d'utilisateur");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(245, 11, 207, 40);
		add(lblNewLabel);
		System.out.println("admin_user");

	}
}
