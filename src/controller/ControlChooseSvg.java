package controller;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import processing.MainProcessing;

public class ControlChooseSvg implements Observer, ActionListener {

	private Frame parent;
	public MainProcessing p;

	final JFileChooser fc = new JFileChooser();

	public ControlChooseSvg(Frame parent, MainProcessing p) {
		this.parent = parent;
		this.p = p;
		File dir = new File("./Music/");
		fc.setCurrentDirectory(dir);
		fc.setFileFilter(new FileNameExtensionFilter("Vector Image", "svg"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (true) {
			int returnVal = fc.showOpenDialog(this.parent);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();

				p.majForme(file.getPath(), file.getName());
			} else {
				// log.append("Open command cancelled by user." + newline);
			}
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
