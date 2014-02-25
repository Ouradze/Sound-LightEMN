package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import processing.MyProcessingSketch;
import processing.core.PApplet;

public class MainWindow extends JFrame{

public MainWindow(){
	super("Sound & Light");
	
	this.setSize(600, 600);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	JPanel panel = new JPanel();
	
	PApplet test = new MyProcessingSketch();
	
	panel.add(test);
	this.add(panel);
	test.init();
}
	
}
