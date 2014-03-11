package SoundAndLight;

import processing.MyProcessingSketch;
import processing.core.PApplet;
import model.MusicFile;
import view.ControlWindow;
import view.MainWindow;

public class Main {

	public static void main(String[] args){
		
		MusicFile file = new MusicFile("./Music/Flute.mp3");
		PApplet test = new MyProcessingSketch(file.getPath());

		MainWindow window = new MainWindow(file, test);
		window.setVisible(true);
		
		ControlWindow controlWin = new ControlWindow(window);
		controlWin.setVisible(true);
	}
}
