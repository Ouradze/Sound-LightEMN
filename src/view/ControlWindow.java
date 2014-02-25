package view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ControlWindow extends JFrame{

	JPanel mainPanel = new JPanel(new GridLayout(4, 1));
	
	public ControlWindow(){
		super("Sound & Light-Control");
		
		this.setSize(100, 400);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.createForm();
		this.createSound();
		
		this.add(mainPanel);
	}
	
	public void createForm(){
		JPanel panelForm = new JPanel();
		
		JButton definedForm = new JButton("Defined");
		//ControlJButtonDefinedForm controlDefinedForm = new ControlJButtonDefinedForm();
		//definedForm.addActionListener(controlDefinedForm);
		panelForm.add(definedForm);
		
		mainPanel.add(panelForm);
	}

	public void createSound(){
		JPanel panelSound = new JPanel();
		
		JCheckBox file = new JCheckBox("File");
		JCheckBox stream = new JCheckBox("Stream");
		
		panelSound.add(file);
		panelSound.add(stream);
		
		mainPanel.add(panelSound);
	}
	
}
