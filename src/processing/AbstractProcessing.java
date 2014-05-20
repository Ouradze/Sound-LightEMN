package processing;

import java.awt.Container;

import processing.core.PApplet;
import sound.AudioHandler;
import sound.Fourier;
import design.Barre;
import design.Design;
import design.Lumieres;

public abstract class AbstractProcessing extends PApplet {

	private static final long serialVersionUID = 1L;
	private Container parent;

	AudioHandler audio;

	protected boolean troisD;
	Fourier fourier;
	Design form;
	Lumieres l;
	int i;
	Barre b;
	long timer;

	public AbstractProcessing(Container parent) {
		super();
		this.parent = parent;
	}

	public abstract void majSong(String path);

	public abstract void majInput();

	public abstract void setup();

	public abstract void draw();

}
