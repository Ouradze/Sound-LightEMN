package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import processing.MainProcessing;
import controller.ControlButtonForms;

public class FormsWindow extends JFrame{
	
	private MainProcessing window;
	JPanel mainPanel = new JPanel(new GridLayout(4, 1));

	public FormsWindow(MainProcessing window) {
		super("Sound & Light-Control");

		this.window = window;
		this.setSize(100, 400);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.createForm();

		this.add(mainPanel);
	}

	public void createForm() {
		JPanel panelForm = new JPanel();

		ControlButtonForms controlFormButtons = new ControlButtonForms(this.window);
		JButton FormButton1 = new JButton("1");
		FormButton1.addActionListener(controlFormButtons);
		panelForm.add(FormButton1);
		
		JButton FormButton2 = new JButton("2");
		FormButton2.addActionListener(controlFormButtons);
		panelForm.add(FormButton2);
		
		JButton FormButton3 = new JButton("3");
		FormButton3.addActionListener(controlFormButtons);
		panelForm.add(FormButton3);
		
		JButton FormButton4 = new JButton("4");
		FormButton4.addActionListener(controlFormButtons);
		panelForm.add(FormButton4);
		
		JButton FormButton5 = new JButton("5");
		FormButton5.addActionListener(controlFormButtons);
		panelForm.add(FormButton5);

		mainPanel.add(panelForm);
	}
}
