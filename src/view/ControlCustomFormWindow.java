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

		panel.add(new JLabel("R"));
		panel.add(new JLabel("G"));
		panel.add(new JLabel("B"));

		JTextField red = new JTextField(20);
		red.addActionListener(new ColorControl(this.shape));
		red.setName("Red");

		JTextField green = new JTextField(20);
		green.setName("Green");
		green.addActionListener(new ColorControl(this.shape));

		JTextField blue = new JTextField(20);
		blue.addActionListener(new ColorControl(this.shape));
		blue.setName("Blue");

		panel.add(red);
		panel.add(green);
		panel.add(blue);

		this.add(panel);

		this.setSize(400, 400);

	}
}
