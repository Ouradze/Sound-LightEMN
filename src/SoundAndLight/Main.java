package SoundAndLight;

import javax.swing.JFrame;

import processing.MainProcessing;
import processing.core.PApplet;
import model.MusicFile;
import view.ControlWindow;
import view.MainWindow;

public class Main {

	public static void main(String[] args) {
		
		MainWindow window = new MainWindow();
		window.setVisible(true);

		ControlWindow controlWin = new ControlWindow(window);
		controlWin.setVisible(true);
	}
}
