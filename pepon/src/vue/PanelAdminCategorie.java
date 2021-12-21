package vue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import controller.ControllerCategorieAdmin;
import controller.ControllerUserAdmin;
import model.Categorie;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelAdminCategorie extends JPanel {
	private JTextField textCategorie;
	private JTable table;
	private JTextField textIdCategorie;

	/**
	 * Create the panel.
	 */
	
	//Instanciation d'un objet user 
		ControllerCategorieAdmin cat = new ControllerCategorieAdmin();
	public PanelAdminCategorie() {
		setBackground(Color.LIGHT_GRAY);
		setBounds(43, 90, 900, 450);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion de Cat\u00E9gorie");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(339, 21, 225, 56);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Libell\u00E9 de la categorie");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(71, 125, 159, 35);
		add(lblNewLabel_1);
		
		textCategorie = new JTextField();
		textCategorie.setBounds(243, 127, 251, 35);
		add(textCategorie);
		textCategorie.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(544, 125, 311, 284);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setEnabled(false);
		
		textCategorie.addCaretListener(new CaretListener(){
			@Override
			public void caretUpdate(CaretEvent e) {
				cat.activerBtnAjouter(textCategorie, btnAjouter);

			}
		});	
		
		// ***************************Ajouter une catégorie********************************************
		
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cat_saisie = textCategorie.getText();
				Categorie category = new Categorie(cat_saisie);
				
				if(cat_saisie.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Remplissez le champs svp!","Error",JOptionPane.ERROR_MESSAGE);
				}else {
						if(cat.catExist(cat_saisie)) {
							cat.ajouter(category);
							JOptionPane.showMessageDialog(null,  "la catégorie " + category +" a bien été ajoutée");
							
						}else {
							JOptionPane.showMessageDialog(null, "Cette catégorie existe deja !","Error",JOptionPane.ERROR_MESSAGE);		
						}		
				}
				
				cat.afficherTable(table);
				textCategorie.setText("");
			}
		});
		
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAjouter.setForeground(Color.BLACK);
		btnAjouter.setBounds(71, 195, 102, 50);
		add(btnAjouter);
		
		// ***************************Modifier une catégorie********************************************
		
		JButton btnModofier = new JButton("Modifier");
		btnModofier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id, label;
				
				label =textCategorie.getText();
				id = textIdCategorie.getText();	
				//Appel de la méthode modifier
				if(!label.isEmpty()) {
				cat.modifier(label, id);
				//afficher la table modifiée
				cat.afficherTable(table);
				textCategorie.setText("");
				textIdCategorie.setText("");
				}
			}
		});
		btnModofier.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModofier.setBounds(236, 195, 102, 50);
		add(btnModofier);
		
		// ***************************Supprimer une catégorie********************************************
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String label =textCategorie.getText();
				if(!label.isEmpty()) {
					String id = textIdCategorie.getText();
					cat.supprimer(id);
					cat.afficherTable(table);
					textCategorie.setText("");
					textIdCategorie.setText("");
				}
			}
		});
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSupprimer.setBounds(392, 195, 102, 50);
		add(btnSupprimer);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBorder(new TitledBorder(null, "Chercher", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(70, 262, 425, 70);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("ID Cat\u00E9corie");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 31, 106, 28);
		panel.add(lblNewLabel_2);
		// Chercher une catégorie par id
		textIdCategorie = new JTextField();
		textIdCategorie.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String id = textIdCategorie.getText();				
				cat.findById(id,textCategorie);
			}
		});
		textIdCategorie.setBounds(114, 31, 125, 25);
		panel.add(textIdCategorie);
		textIdCategorie.setColumns(10);
		
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCategorie.setText("");
				textIdCategorie.setText("");
			}
		});
		btnEffacer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEffacer.setBounds(71, 359, 180, 50);
		add(btnEffacer);
		
		//Quitter l'appli
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnQuitter.setBounds(314, 359, 180, 50);
		add(btnQuitter);
		//Afficher la table categorie
		cat.afficherTable(table);

	}

}
