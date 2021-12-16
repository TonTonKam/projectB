package vue;

import javax.swing.*;

import model.ColorPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelMenuClient extends JPanel {

	//label temporaire a definir
	private JButton btnBoisson, btnLegume, btnFruit, btnConverve, btnCharcuterie;
	
	/**
	 * Create the panel.
	 */
	public PanelMenuClient(int longueurM) {
		ColorPanel color = new ColorPanel();
		setBackground(color.vertFoncer());
		setBounds(0, 120, longueurM, 80);
		
		btnBoisson = new JButton("Boissons");
		btnBoisson.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		add(btnBoisson);
		
		btnLegume = new JButton("Legumes");
		btnLegume.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		add(btnLegume);
		
		btnFruit = new JButton("Fruits");
		btnFruit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		add(btnFruit);
		
		btnConverve = new JButton("Concerve");
		btnConverve.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		add(btnConverve);
		
		btnCharcuterie = new JButton("Charcuterie");
		btnCharcuterie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		add(btnCharcuterie);
	}

}
