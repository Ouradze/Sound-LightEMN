package SoundAndLight;

import view.ControlWindow;
import view.MainWindow;

public class Main {

	public static void main(final String[] args) {

		//CustomWindow custom = new CustomWindow();
		//custom.setVisible(true);

		
		
		 MainWindow window = new MainWindow(); window.setVisible(true);
		 
		 ControlWindow controlWin = new ControlWindow(window);
		 controlWin.setVisible(true);
		 
	}
}
