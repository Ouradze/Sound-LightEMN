package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import processing.AbstractProcessing;

public class RetroView extends JFrame {

	private AbstractProcessing test;

	public RetroView(AbstractProcessing test2) {
		super("Sound & Light");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.test = test2;

		JPanel panel = new JPanel();

		panel.add(test2);
		this.add(panel);
		test2.init();
	}

	public AbstractProcessing getApplet() {
		return this.test;
	}
}
