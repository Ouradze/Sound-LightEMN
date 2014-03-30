package processing;

import java.util.ArrayList;

import design.*;
import sound.*;
import processing.core.*;
import ddf.minim.*;
import ddf.minim.analysis.BeatDetect;

public class MainProcessing extends PApplet {

	private static final long serialVersionUID = 1L;
	Minim minim;
	AudioPlayer song;

	Fourier fourier;
	Surface3D cube;
	Lumieres l;
	int i;
	Barre b;

	public void setup() {
		size(900, 900, P3D);

		minim = new Minim(this);

		song = minim.loadFile("./Music/rise.mp3");

		fourier = new Fourier(song, this);
		cube = new Surface3D(this, 1, this.width / 2, this.height / 2);
		l =  new Lumieres(this);
		song.rewind();
		song.play();
		i = 0;

	}

	public void draw() {
		i++;
		
		
		l.alterne(i);
		background(0);
		fourier.majBuff(song);
		cube.maj(fourier.getFreq(Fourier.CENTRE));
		cube.display();
		
		
		
		
		

	}

}
