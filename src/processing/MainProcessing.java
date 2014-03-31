package processing;

import java.awt.Container;
import java.awt.Frame;

import processing.core.PApplet;
import sound.Fourier;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.AudioSource;
import ddf.minim.Minim;
import design.*;

public class MainProcessing extends PApplet {

	private static final long serialVersionUID = 1L;
	private Container parent;
	Minim minim;
	AudioPlayer song;
	AudioInput input;
	private String path;
	AudioSource audio;

	Fourier fourier;
	Design form;
	Lumieres l;
	int i;
	Barre b;

	public MainProcessing(Container parent) {
		super();
		this.parent = parent;
	}

	public void majSong(String path) {
		// System.out.println("AUDIO : " + audio.bufferSize());
		song = minim.loadFile(path);
		audio = song;
		song.play();
	}

	public void majInput() {
		// System.out.println("SONG : " + song.bufferSize());
		song.close();

		audio = input;

	}

	public void majForme(String s) {

		switch (s) {
		case "1" :
			form  = new Surface3D(this, 1, this.width / 2, this.height / 2);
			
			break;
		case "2" :
			form  = new Stripes3D(this, 1, this.width / 2, this.height / 2);
			break;
		case "3" :
			break;
		case "4" :
			break;
		case "5" :
			break;
			
		}

	}

	public void setup() {
		size(this.parent.getWidth(), this.parent.getHeight(), P3D);

		minim = new Minim(this);

		input = minim.getLineIn();
		audio = input;

		fourier = new Fourier(audio, this);
		//this.majForme("1");
		// b = new Barre(this, song);
		l = new Lumieres(this);
		
		i = 0;

	}

	public void draw() {
		i++;

		size(this.parent.getWidth(), this.parent.getHeight(), P3D);
		l.alterne(i);
		background(0);
		fourier.majBuff(audio);
		
		if (form != null) {
			form.maj(fourier.getFreq(Fourier.CENTRE),this.width/2,this.height/2-50);
			form.display();
		}

	}

}
