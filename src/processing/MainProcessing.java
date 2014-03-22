package processing;

import java.util.ArrayList;

import design.*;
import sound.*;
import processing.core.*;
import processing.core.PApplet;

import ddf.minim.*;
import ddf.minim.analysis.BeatDetect;
public class MainProcessing extends PApplet{
	
	
	private static final long serialVersionUID = 1L;
	Minim minim;
	AudioPlayer song;



	Fourier fourier;
	Stripes3D barres;
	

	public void setup() {
		size(600,600,P3D);

		minim = new Minim(this);
		

		song = minim.loadFile("./Music/Flute.mp3");
		fourier = new Fourier(song, this);
		barres = new Stripes3D(this, 1, this.width/2, this.height/2);
		
		song.rewind();
		song.play();
		
		
		
	}

	public void draw() {
		background(100);
		fourier.majBuff(song);
		barres.maj(fourier.getFreqcentre());
		barres.display();
		
		
		
		
		
		
		

		
		
	}


	

}
