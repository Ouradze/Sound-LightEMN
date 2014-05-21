package controller;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import processing.AbstractProcessing;

/**
 * 
 * @author Mehdi Raddadi
 * 
 */
public class ControlChooseSvg implements Observer, ActionListener {

	private Frame parent;
	public AbstractProcessing p;

	final JFileChooser fc = new JFileChooser();

	public ControlChooseSvg(Frame parent, AbstractProcessing p) {
		this.parent = parent;
		this.p = p;
		File dir = new File("./Music/");
		fc.setCurrentDirectory(dir);
		fc.setFileFilter(new FileNameExtensionFilter("Vector Image", "svg",
				"obj"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (true) {
			int returnVal = fc.showOpenDialog(this.parent);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();

				p.majForme("Import", file.getPath());
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
