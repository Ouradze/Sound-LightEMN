package controller;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFileChooser;

import processing.AbstractProcessing;

/**
 * 
 * @author Mehdi Raddadi
 * 
 */
public class ControlJButtonStream implements Observer, ActionListener {

	private Frame parent;
	public AbstractProcessing p;

	final JFileChooser fc = new JFileChooser();

	public ControlJButtonStream(Frame parent, AbstractProcessing p) {
		this.parent = parent;
		this.p = p;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		p.majInput();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

}
