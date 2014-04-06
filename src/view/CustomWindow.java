package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.CustomShape;
import processing.CustomProcessing;
import controller.ControlCustomWindow;

public class CustomWindow extends JFrame{
	
	public CustomWindow() {
		super("Sound & Light-Custom");

		this.setSize(900,900);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBackground( Color.BLACK );
		
		CustomProcessing test = new CustomProcessing(this);
		
		JPanel panel = new JPanel();
		
		ControlCustomWindow control = new ControlCustomWindow((CustomShape)test.getShape());
		
		test.addMouseListener(control);
		test.addMouseMotionListener(control);

		panel.add(test);
		this.add(panel);
		test.init();
	}
}
