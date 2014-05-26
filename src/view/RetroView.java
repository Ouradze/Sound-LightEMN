package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import processing.AbstractProcessing;
import processing.RecorderProcessing;

/**
 * 
 * @author Mehdi Raddadi
 * 
 *         Class which display on the retroprojector screen. Fonctionnal but not
 *         yet implemented in the rest of the project
 * 
 */
public class RetroView extends JFrame {

	/**
	 * ProcessingSketch to be displayed
	 */
	private AbstractProcessing test;

	public RetroView(AbstractProcessing test2) {
		super("Sound & Light");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.test = test2;

		this.setSize(test2.displayWidth, test2.displayHeight);
		System.out.println("Jframe : " + this.getWidth());

		JPanel panel = new JPanel();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		panel.setSize(screenSize);
		panel.setSize(test2.displayWidth, test2.displayHeight);

		System.out.println("Retro : " + panel.getWidth());

		RecorderProcessing recorder = new RecorderProcessing(panel);

		recorder.setModel(this.test);

		recorder.init();

		panel.add(recorder);

		this.add(panel);

		panel.repaint();
		this.repaint();
	}

	public AbstractProcessing getApplet() {
		return this.test;
	}
}
