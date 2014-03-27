package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.MusicFile;
import processing.MyProcessingSketch;
import processing.core.PApplet;

public class MainWindow extends JFrame{

	private MusicFile file;
	private PApplet test;
	
	public MainWindow(MusicFile file, PApplet test){
		super("Sound & Light");

		this.setSize(900, 900);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.file = file;
		this.test = test;

		JPanel panel = new JPanel();

		panel.add(test);
		this.add(panel);
		test.init();
	}

}
