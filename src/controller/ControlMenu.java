package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JMenuItem;

import processing.AbstractProcessing;
import view.RetroView;

/**
 * 
 * @author Mehdi Raddadi
 * 
 */
public class ControlMenu implements ActionListener, ItemListener {

	private AbstractProcessing test;

	public ControlMenu(AbstractProcessing test2) {
		this.test = test2;
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JMenuItem menuItem = (JMenuItem) arg0.getSource();

		String command = menuItem.getText();

		System.out.println(command);

		switch (command) {
		case "Show Retro":

			RetroView retro = new RetroView(test);
			retro.setVisible(true);
			break;

		}

	}

}
