package vue;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;

import controler.UserDao;
import model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class PanelInscription extends JPanel {
	private JTextField nom;
	private JTextField prenom;
	private JTextField email;
	private JTextField password;

	/**
	 * Create the panel.
	 */
	public PanelInscription() {
		setLayout(null);
		
		
		this.setBackground(new Color(152, 251, 152));
		this.setBounds(6, 6, 559, 338);
		this.setLayout(null);
		
		nom = new JTextField();
		nom.setText("");
		nom.setBounds(303, 63, 130, 26);
		this.add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setText("");
		prenom.setColumns(10);
		prenom.setBounds(303, 107, 130, 26);
		this.add(prenom);
		
		email = new JTextField();
		email.setText("");
		email.setColumns(10);
		email.setBounds(303, 145, 130, 26);
		this.add(email);
		
		password = new JTextField();
		password.setText("");
		password.setColumns(10);
		password.setBounds(303, 195, 130, 26);
		this.add(password);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(92, 68, 61, 16);
		this.add(lblNewLabel);
		
		JLabel lblPrnom = new JLabel("Prénom");
		lblPrnom.setBounds(92, 112, 61, 16);
		this.add(lblPrnom);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(92, 150, 61, 16);
		this.add(lblEmail);
		
		JLabel lblPasseword = new JLabel("Passeword");
		lblPasseword.setBounds(91, 200, 98, 16);
		this.add(lblPasseword);
		
		JButton btnNewButton = new JButton("S'inscrire");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom_saisie = nom.getText();
				String prenom_saisie = prenom.getText();
				String email_saisie = email.getText();
				String password_saisie = password.getText();
				
				User marc = new User(nom_saisie,prenom_saisie,email_saisie,password_saisie);
				
				UserDao marco = new UserDao();
				marco.inscription(marc);
				
				
				
			}
		});
		
		btnNewButton.setBounds(200, 247, 117, 29);
		this.add(btnNewButton);

		
	}

}
