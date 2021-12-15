package vue;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SpringLayout;

public class PanelMenuClient extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelMenuClient(int longueurM) {
		setBackground(Color.ORANGE);
		setBounds(0, 120, longueurM, 80);
		setLayout(new SpringLayout());
	}

}
