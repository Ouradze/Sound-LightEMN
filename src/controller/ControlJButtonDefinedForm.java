package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import processing.AbstractProcessing;
import view.FormsWindow;

/**
 * 
 * @author Mehdi Raddadi
 * 
 */
public class ControlJButtonDefinedForm implements Observer, ActionListener {

	public AbstractProcessing p;

	public ControlJButtonDefinedForm(AbstractProcessing p) {
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
