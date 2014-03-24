package processing;

import java.io.File;
import java.util.ArrayList;

import processing.core.PApplet;
import sound.Fourier;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.BeatDetect;
import design.*;

public class MyProcessingSketch extends PApplet{
	
	private String path;
	
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
	
	public MyProcessingSketch(String path){
		super();
		this.path=path;
	}

	public void setup() {
		size(600,600);

		minim = new Minim(this);
		File f = new File(path);
		//File f = new File("./Music/Flute.mp3");
		File root = new File("./");
		System.out.println(root.getAbsolutePath());
		System.out.println(f.isFile());
		
		song = minim.loadFile("./Music/Flute.mp3");
		
		System.out.println(song.bufferSize());

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
		
		
		
		
		sg.maj(fourier.getFreqgauche());
		sd.maj(fourier.getFreqdroite());
		
		sg.display();
		sd.display();
		
		rg.maj(fourier.getFreqgauche());
		rd.maj(fourier.getFreqdroite());
		rg.display();
		rd.display();
			
		
	}


	

}
