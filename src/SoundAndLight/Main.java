package SoundAndLight;

import view.ControlWindow;
import view.MainWindow;

public class Main {

	public static void main(final String[] args) {

		MainWindow window = new MainWindow();
		window.setVisible(true);

		ControlWindow controlWin = new ControlWindow(window);
		controlWin.setVisible(true);

		// FullWindow mainWindow = new FullWindow();
		// mainWindow.setVisible(true);

	}
}
