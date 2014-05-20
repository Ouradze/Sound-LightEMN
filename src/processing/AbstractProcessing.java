package processing;

import java.awt.Container;

import processing.core.PApplet;
import sound.AudioHandler;
import sound.Fourier;

public abstract class AbstractProcessing extends PApplet {

	private static final long serialVersionUID = 1L;
	protected Container parent;

	AudioHandler audio;

	Fourier fourier;

	int i;

	long timer;

	public AbstractProcessing(Container parent) {
		super();
		this.parent = parent;

		audio = new AudioHandler(this);

	}

	public void majSong(String path) {

		audio.majSong(path);
		audio.switchToSong();
		System.out.println(audio.toString());
	}

	public void majInput() {
		audio.switchToInput();
		System.out.println(audio.toString());
	}

	public abstract void majForme(String s, String path);

	public abstract void setup();

	public abstract void draw();

	public Container getPar() {
		return this.parent;
	}

}
