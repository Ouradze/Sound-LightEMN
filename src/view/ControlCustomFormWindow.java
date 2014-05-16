package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.CustomDesign;
import controller.ColorControl;

public class ControlCustomFormWindow extends JFrame {

	private CustomDesign shape;

	public ControlCustomFormWindow(CustomDesign shape) {
		super("Couleur");

		this.shape = shape;

		JPanel panel = new JPanel();

		panel.add(new JLabel("Choisissez votre couleur"));

		JTextField text = new JTextField(20);
		text.addActionListener(new ColorControl(this.shape));

		panel.add(text);

		this.add(panel);

		this.setSize(400, 400);

	}
}
