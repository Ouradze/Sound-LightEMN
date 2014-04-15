package processing;

import java.awt.*;

import processing.core.PApplet;
import sound.*;
import ddf.minim.*;
import design.*;

public class MainProcessing extends PApplet {

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

	public MainProcessing(Container parent) {
		super();
		this.parent = parent;
	}

	public void majSong(String path) {
		// System.out.println("AUDIO : " + audio.bufferSize());
		audio.majSong(path);
		audio.switchToSong();
	}

	public void majInput() {
		// System.out.println("SONG : " + song.bufferSize());
		audio.switchToInput();

	}

	public void majForme(String s) {

		switch (s) {
		case "1":
			this.troisD = true;
			form = new Surface3D(this, this.width / 2, this.height / 2, 0);

			break;
		case "2":
			this.troisD = true;
			form = new Stripes3D(this, this.width / 2, this.height / 2, 0);
			break;
		case "3":
			this.troisD = true;
			form = new Hypercube(this, this.width / 2, this.height / 2, -1000);
			break;
		case "4":
			this.troisD = false;
			form = new Rond(this, this.width / 2, this.height / 2);
			break;
		case "5":
			form = new Stripe(this, this.width / 2, this.height / 2);
			this.troisD = false;
			break;

		}

	}

	public void setup() {
		this.troisD = true;
		size(this.parent.getWidth(), this.parent.getHeight()-50, P3D);

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
