package controller;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;



public class ControllerPanelMenuAdmin {
	public void switchPanels(JPanel panel,JLayeredPane layeredPane) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
}
