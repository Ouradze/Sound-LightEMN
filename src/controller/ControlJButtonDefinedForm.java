package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import processing.MainProcessing;
import view.FormsWindow;

public class ControlJButtonDefinedForm implements Observer, ActionListener {

	public MainProcessing p;

	public ControlJButtonDefinedForm(MainProcessing p) {
		this.p = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		FormsWindow window = new FormsWindow(this.p);
		window.setVisible(true);

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

}
