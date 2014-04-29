package processing;

import java.awt.*;

import processing.core.PApplet;
import processing.core.PShape;
import sound.*;
import utils.Equalizer;
import ddf.minim.*;
import design.*;
@Deprecated
public class MainProcessing extends PApplet {

	private static final long serialVersionUID = 1L;
	private Container parent;

	AudioHandler audio;

	protected boolean troisD;
	Fourier fourier;
	Design form;
	Equalizer eq;
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
		System.out.println(audio.toString());
	}

	public void majInput() {
		// System.out.println("SONG : " + song.bufferSize());
		audio.switchToInput();
		System.out.println(audio.toString());

	}

	public void majForme(String s) {

		switch (s) {
		case "1":

			
			form = new Surface(this, this.width / 2, this.height / 2, 0);

			break;
		case "2":
			
			form = new Stripes3D(this, this.width / 2, this.height / 2, 0);
			break;
		case "3":
			
			form = new Hypercube(this, this.width / 2, this.height / 2, 0);

			this.troisD = true;
			
			break;
		
		case "4":
			
			break;
		case "5":
			form = new Stripe(this, this.width / 2, this.height / 2);
			
			break;

		}

	}

	public void setup() {
	
		size(this.parent.getWidth(), this.parent.getHeight()-50, P3D);

		audio = new AudioHandler(this);
		//System.out.println(audio.toString());

		fourier = new Fourier(audio);
		fourier.maj();
		l = new Lumieres(this);
		

		i = 0;
		timer = 0;
		//eq =  new Equalizer(this, 10, 100, 0, fourier);

	}

	public void draw() {
		i++;

//		long tps = System.currentTimeMillis() - this.timer;
//		System.out.println((float) 1000 / (float) tps);

		size(this.parent.getWidth(), this.parent.getHeight(), P3D);
		
		
		
		l.alterne(i);
		background(0);
		fourier.maj();
		//eq.display();
		//fourier.appliCoefs();
		//System.out.println(eq.toString());
		if (form != null) {
			fourier.setCoefs(form.getCoefs());
			form.maj(fourier, this.width / 2, this.height / 2, 0);
			form.display();
		}

//		this.timer = System.currentTimeMillis();

	}

}
