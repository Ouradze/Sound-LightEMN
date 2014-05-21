package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import processing.CustomProcessing;

/**
 * 
 * @author Mehdi Raddadi
 * 
 *         JFrame to draw custom forms
 * 
 */
public class CustomWindow extends JFrame {

	public CustomWindow() {
		super("Sound & Light-Custom");

		this.setSize(900, 900);

		CustomProcessing test = new CustomProcessing(this);

		JPanel panel = new JPanel();

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		panel.add(test);
		this.add(panel);
		test.init();
	}
}
