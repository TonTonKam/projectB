package vue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Canvas;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Article;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class PanelAcceuilAdministrateur extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelAcceuilAdministrateur(JPanel contentPane,int longueurMax, int hauteurMax) {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(6, 6, 438, 288);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(6, 6, 64, 64);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelLogin bout = new PanelLogin(contentPane,longueurMax, hauteurMax);
				contentPane.removeAll();
				contentPane.add(bout);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		btnNewButton.setBounds(6, 253, 117, 29);
		panel.add(btnNewButton);
		noir noire = new noir();
		JButton btnNewButton_1 = new JButton("Rouge");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				panel.add(noire);
				panel.repaint();
				panel.revalidate();
			}
		});
		btnNewButton_1.setBounds(229, 24, 117, 29);
		panel.add(btnNewButton_1);
		JButton btnNewButton_2 = new JButton("Rouge");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				panel.remove(noire);
				panel.repaint();
				panel.revalidate();
			}
		});
		btnNewButton_2.setBounds(229, 84, 217, 109);
		panel.add(btnNewButton_2);
	}
	}

