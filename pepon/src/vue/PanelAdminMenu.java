package vue;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import controller.ControllerPanelMenuAdmin;
import model.ColorPanel;

import javax.swing.*;

public class PanelAdminMenu extends JPanel {

	//attributs
	ControllerPanelMenuAdmin us;

	//constructor
	public PanelAdminMenu() {
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 964, 486);
		add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		setBounds(10, 64, 964, 486);
		setBackground(ColorPanel.vertFoncer());
		
		JButton btnNewButton = new JButton("Utilistaeurs");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//us = new ControllerPanelMenuAdmin()
				//us.switchPanels(panelUser,layeredPane);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(23, 11, 147, 42);
		add(btnNewButton);
		
		JButton btnArticles = new JButton("Articles");
		btnArticles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//us = new ControllerPanelMenuAdmin()
				//us.switchPanels(panelArticle,layeredPane);
			}
		});
		btnArticles.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnArticles.setBounds(212, 11, 147, 42);
		add(btnArticles);
		
		JButton btnCommandes_1 = new JButton("Commandes");
		btnCommandes_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//us = new ControllerPanelMenuAdmin()
				//us.switchPanels(panelCommande,layeredPane);
			}
		});
		btnCommandes_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCommandes_1.setBounds(408, 11, 147, 42);
		add(btnCommandes_1);
		
		
		
		JButton btnCommandes = new JButton("Cat\u00E9gories");
		btnCommandes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//us = new ControllerPanelMenuAdmin()
				//us.switchPanels(panelCategorie,layeredPane);
			}
		});
		btnCommandes.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCommandes.setBounds(611, 11, 157, 42);
		add(btnCommandes);
	}

}
