package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import processing.MainProcessing;

public class ControlButtonForms implements Observer, ActionListener {

	public MainProcessing p;

	public ControlButtonForms(MainProcessing p) {
		this.p = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String command = ((JButton) e.getSource()).getActionCommand();

		switch (command) {
		case "Surface":
			p.majForme("1", null);
			break;
		case "Stripes3D":
			p.majForme("2", null);
			break;
		case "Hypercube":
			p.majForme("3", null);
			break;
		case "Cercle":
			p.majForme("4", null);
			break;
		case "Stripe":
			p.majForme("5", null);
			break;
		case "Cercles":
			p.majForme("6", null);
			break;
		case "StripeAnal":
			p.majForme("7", null);
			break;
		case "Spectre":
			p.majForme("8", null);
			break;
		}

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

}
