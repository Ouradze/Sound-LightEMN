package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import processing.MainProcessing;

public class ControlButtonForms implements Observer, ActionListener{

	public MainProcessing p;

	public ControlButtonForms(MainProcessing p) {
		this.p = p;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = ((JButton) e.getSource()).getActionCommand();
		
		switch(command){
			case "Surface": p.majForme("1");
				break;
			case "Stripes3D": p.majForme("2");
				break;
			case "Hypercube": p.majForme("3");
				break;
			case "Cercle": p.majForme("4");
				break;
			case "Stripe": p.majForme("5");
				break;
			case "Cercles" : p.majForme("6");
				break;
			case "StripeAnal" : p.majForme("7");
			break;
			case "Spectre" : p.majForme("8");
		} 
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
