package vue;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;

import controller.ControllerInscription;
import controller.UserDao;
import model.ColorPanel;
import model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class PanelInscription extends JPanel {
	private JTextField nom;
	private JTextField prenom;
	private JTextField email;
	private JPasswordField password;
	private JPanel contentPane;
	private int longueurMax;
	private int hauteurMax;
	private ControllerInscription controllerInscription;

	/**
	 * Create the panel.
	 */
	public PanelInscription(JPanel contentPane, int longueurMax, int hauteurMax) {
		controllerInscription = new ControllerInscription();
		setLayout(null);
		
		this.setBackground(ColorPanel.vertClair());
		this.setBounds(6, 6, longueurMax-6, hauteurMax-6);
		this.setLayout(null);
		
		nom = new JTextField();
		
		nom.setText("");
		nom.setBounds(4*longueurMax/8, 2*hauteurMax/8, 130, 26);
		this.add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setText("");
		prenom.setColumns(10);
		prenom.setBounds(4*longueurMax/8, 3*hauteurMax/8, 130, 26);
		this.add(prenom);
		
		email = new JTextField();
		email.setText("");
		email.setColumns(10);
		email.setBounds(4*longueurMax/8, 4*hauteurMax/8, 130, 26);
		this.add(email);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(2*longueurMax/8, 2*hauteurMax/8, 61, 16);
		this.add(lblNewLabel);
		
		JLabel lblPrnom = new JLabel("Prénom");
		lblPrnom.setBounds(2*longueurMax/8, 3*hauteurMax/8, 61, 16);
		this.add(lblPrnom);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(2*longueurMax/8, 4*hauteurMax/8, 61, 16);
		this.add(lblEmail);
		
		JLabel lblPasseword = new JLabel("Passeword");
		lblPasseword.setBounds(2*longueurMax/8, 5*hauteurMax/8, 98, 16);
		this.add(lblPasseword);
		
		
		JButton btnNewButton = new JButton("S'inscrire");
		btnNewButton.setEnabled(false);
		
		nom.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				controllerInscription.activer(nom,prenom,email,password,btnNewButton);
			}
		});
		prenom.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				controllerInscription.activer(nom,prenom,email,password,btnNewButton);
			}
		});
		email.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				controllerInscription.activer(nom,prenom,email,password,btnNewButton);
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerInscription.inscrire(nom,prenom,email,password,contentPane, longueurMax, hauteurMax);
			}
		});
		
		btnNewButton.setBounds(3*longueurMax/8, 6*hauteurMax/8, 117, 29);
		this.add(btnNewButton);
		
		
		
		password = new JPasswordField();
		password.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				controllerInscription.activer(nom, prenom, email, password, btnNewButton);
			}
		});
		password.setBounds(4*longueurMax/8, 5*hauteurMax/8, 127, 26);
		add(password);
		
		JLabel lblNewLabel_1 = new JLabel("Bienvenue sur Pepon");
		lblNewLabel_1.setFont(new Font("Lao MN", Font.PLAIN, 29));
		lblNewLabel_1.setBounds(2*longueurMax/8, 1*hauteurMax/8, 312, 36);
		add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelLogin back = new PanelLogin(contentPane,longueurMax,hauteurMax);
				contentPane.removeAll();
				contentPane.add(back);
				contentPane.repaint();
				contentPane.revalidate();
				
			}
		});
		
		btnNewButton_1.setBounds(longueurMax/8, 6*hauteurMax/8, 117, 29);
		this.add(btnNewButton_1);
		
	}
}
