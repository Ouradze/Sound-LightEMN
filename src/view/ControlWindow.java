package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import processing.core.PApplet;
import controller.ControlJButtonDefinedForm;
import controller.ControlJButtonFile;

public class ControlWindow extends JFrame {

	private MainWindow window;

	JPanel mainPanel = new JPanel(new GridLayout(4, 1));

	public ControlWindow(MainWindow window) {
		super("Sound & Light-Control");

		this.window = window;

		this.setSize(100, 400);
		// this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.createForm();
		this.createSound();

		this.add(mainPanel);
	}

	public void createForm() {
		JPanel panelForm = new JPanel();

		JButton definedForm = new JButton("Defined");
		ControlJButtonDefinedForm controlDefinedForm = new ControlJButtonDefinedForm();
		definedForm.addActionListener(controlDefinedForm);
		panelForm.add(definedForm);

		mainPanel.add(panelForm);
	}

	public void createSound() {
		JPanel panelSound = new JPanel();

		JCheckBox file = new JCheckBox("File");
		ControlJButtonFile controlFile = new ControlJButtonFile(this);
		file.addActionListener(controlFile);

		JCheckBox stream = new JCheckBox("Stream");

		panelSound.add(file);
		panelSound.add(stream);

		mainPanel.add(panelSound);
	}

	public MainWindow getWindow() {
		return this.window;
	}

}
