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

	public abstract void majForme(String s);

	public void setup() {
		this.troisD = true;
		size(this.parent.getWidth(), this.parent.getHeight() - 50, P3D);

		audio = new AudioHandler(this);

		fourier = new Fourier(audio);

		l = new Lumieres(this);

		i = 0;
		timer = 0;

	}

	public void draw() {
		i++;

		long tps = System.currentTimeMillis() - this.timer;
		System.out.println((float) 1000 / (float) tps);

		size(this.parent.getWidth(), this.parent.getHeight(), P3D);

		l.alterne(i);
		background(0);
		fourier.maj();

		if (form != null) {
			form.maj(fourier, this.width / 2, this.height / 2, -500);
			form.display();
		}

		this.timer = System.currentTimeMillis();

	}

}
