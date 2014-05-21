package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.CustomDesign;

/**
 * 
 * @author Mehdi Raddadi
 * 
 */
public class ColorControl implements Observer, ActionListener {

	private CustomDesign shape;

	public ColorControl(CustomDesign shape) {
		this.shape = shape;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//
		JTextField text = (JTextField) arg0.getSource();

		String command = text.getName();

		int red = this.shape.getColor().getRed();
		int green = this.shape.getColor().getGreen();
		int blue = this.shape.getColor().getBlue();
		Color c;

		switch (command) {
		case "Red":

			c = new Color(Integer.parseInt(text.getText()), green, blue);
			this.shape.setColor(c);
			break;

		case "Green":

			c = new Color(red, Integer.parseInt(text.getText()), blue);
			this.shape.setColor(c);
			break;
		case "Blue":

			c = new Color(red, green, Integer.parseInt(text.getText()));
			this.shape.setColor(c);
			break;
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

}
