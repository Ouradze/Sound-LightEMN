package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import processing.MainProcessing;

public class RetroView extends JFrame {

	private MainProcessing test;

	public RetroView(MainProcessing test) {
		super("Sound & Light");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.test = test;

		JPanel panel = new JPanel();

		panel.add(test);
		this.add(panel);
		test.init();
	}

	public MainProcessing getApplet() {
		return this.test;
	}
}
