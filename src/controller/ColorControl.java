package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.CustomDesign;

public class ColorControl implements Observer, ActionListener {

	private CustomDesign shape;

	public ColorControl(CustomDesign shape) {
		this.shape = shape;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JTextField text = (JTextField) arg0.getSource();
		this.shape.setColor(Integer.parseInt(text.getText()));
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

}
