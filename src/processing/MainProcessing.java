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
	AudioInput input;

	Fourier fourier;
	Hypercube cube;
	
	Barre b;

	public void setup() {
		size(600,600, P3D);

		minim = new Minim(this);

		song = minim.loadFile("./Music/House.mp3");
		input =  minim.getLineIn();
		fourier = new Fourier(song, this);
		cube = new Hypercube(this, 1, this.width / 2, this.height / 2);
		//b = new Barre(this, song);
		song.rewind();
		song.play();
	    

	}

	public void draw() {
		
		pointLight(255, 0, 0, width/2, height/2, 400);
		background(100);
		fourier.majBuff(song);
		cube.display();
		
		
		
		
		
	}

}
