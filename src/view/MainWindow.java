package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

<<<<<<< HEAD
import model.MusicFile;
import processing.MyProcessingSketch;
=======
import processing.MainProcessing;
>>>>>>> b1afe9b50c60777deb9c73328311f997eead4456
import processing.core.PApplet;

public class MainWindow extends JFrame{

	private MusicFile file;
	private PApplet test;
	
	public MainWindow(MusicFile file, PApplet test){
		super("Sound & Light");

		this.setSize(600, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.file = file;
		this.test = test;

		JPanel panel = new JPanel();

		panel.add(test);
		this.add(panel);
		test.init();
	}

<<<<<<< HEAD
=======
	JPanel panel = new JPanel();
	
	PApplet test = new MainProcessing();
	
	panel.add(test);
	this.add(panel);
	test.init();
}
	
>>>>>>> b1afe9b50c60777deb9c73328311f997eead4456
}
