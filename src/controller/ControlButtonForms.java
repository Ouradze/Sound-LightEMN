package controller;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFileChooser;

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
			case "1": p.majForme("1");
				break;
			case "2": p.majForme("2");
				break;
			case "3": p.majForme("3");
				break;
			case "4": p.majForme("4");
				break;
			case "5": p.majForme("5");
				break;
		} 
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
