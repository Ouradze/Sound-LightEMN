package processing;

import java.util.ArrayList;

import design.*;
import sound.*;

import processing.core.*;
import ddf.minim.*;
import ddf.minim.analysis.*;

public class MyProcessingSketch extends PApplet{
	
	Minim minim;
	AudioPlayer song;
	BeatDetect beat;

	int nbr = 200; // nombre de barres

	ArrayList<Stripe> slistcercle = new ArrayList<Stripe>();
	Fourier fourier;
	Barre b;
	Rond rg;
	Rond rd;
	Stripe sg;
	Stripe sd;
	Stripe sg1;
	Stripe sd1;
	Stripe sg2;
	Stripe sd2;

	public void setup() {
		size(600,600);

		minim = new Minim(this);
		

		song = minim.loadFile("./Music/Flute.mp3");
		fourier = new Fourier(song, this);
		rg = new Rond(this, 1, this.width/2,(int) (2.5*this.height/4));
		rd = new Rond(this,-1, this.width/2,(int) (2.5*this.height/4));
		sd = new Stripe(this, 1, this.width/2,this.height/4);
		sg = new Stripe(this,-1, this.width/2,this.height/4);
		
		song.rewind();
		song.play();
		b = new Barre(this, song);
		
	}

	public void draw() {
		background(100);
		fourier.majBuff(song);
		b.display();
		
		
		
		
		sg.maj(fourier.getFreqg());
		sd.maj(fourier.getFreqd());
		
		sg.display();
		sd.display();
		
		rg.maj(fourier.getFreqg());
		rd.maj(fourier.getFreqd());
		rg.display();
		rd.display();
		

		
		
	}


	

}
