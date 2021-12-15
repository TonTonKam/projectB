package vue;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class AcceuilArticles extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	
	public AcceuilArticles(JPanel contentPane) {
		setLayout(null);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(160, 82, 45));
		panel.setBounds(6, 6, 438, 288);
		add(panel);
		panel.setLayout(null);
		
	
		
		JButton btnNewButton = new JButton("Connexion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcceuilAdministrateur acc = new AcceuilAdministrateur(contentPane);
				contentPane.removeAll();
				contentPane.add(acc);
				contentPane.repaint();
				contentPane.revalidate();
				
			}
		});
		btnNewButton.setBounds(122, 182, 175, 29);
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(251, 121, 130, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(251, 73, 130, 26);
		panel.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("Identifiant");
		lblNewLabel.setBounds(52, 78, 105, 16);
		panel.add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("Mot de Passe");
		lblMotDePasse.setBounds(52, 126, 130, 16);
		panel.add(lblMotDePasse);
		
		JButton btnInscription = new JButton("Inscription");
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inscription formulaire = new Inscription();
				contentPane.removeAll();
				contentPane.add(formulaire);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		btnInscription.setBounds(122, 233, 175, 29);
		panel.add(btnInscription);

	// BorderLayout 
		// setPreferredSize(new Dimension(200,0));
		//contentPane.add(objet, BorderLayout.LEFT);
	}
}
