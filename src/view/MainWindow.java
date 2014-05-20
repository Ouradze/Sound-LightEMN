package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import processing.AbstractProcessing;
import processing.MainProcessing;

public class MainWindow extends JFrame {

	private AbstractProcessing test;

	public MainWindow() {
		super("Sound & Light");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// setBounds(0, 0, screenSize.width, screenSize.height);
		this.setSize(screenSize);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		test = new MainProcessing(this);
		this.test = test;

		JPanel panel = new JPanel();

		panel.add(test);
		this.add(panel);
		test.init();
	}

	public AbstractProcessing getApplet() {
		return this.test;
	}

}
