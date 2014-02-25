package processing;

import java.util.ArrayList;

import processing.core.*;
import ddf.minim.*;
import ddf.minim.analysis.*;

public class MyProcessingSketch extends PApplet{
	
	Minim minim;
	AudioPlayer song;
	BeatDetect beat;

	ArrayList<Stripe> slist = new ArrayList<Stripe>();  
	
	/*public void setup() {
	    size(600, 600);
	    background(0);
	  }
	  public void draw() {
	    background(0);
	    fill(200);
	    ellipseMode(CENTER);
	    ellipse(mouseX,mouseY,40,40);
	  }*/

	public void setup() {
		size(600,600);

		minim = new Minim(this);
		

		song = minim.loadFile("../Music/Flute.mp3");
		song.play();
		beat = new BeatDetect();
	}

	public void draw() {
		background(100);
		beat.detect(song.mix);

		// Move and display all "stripes"
		if(beat.isOnset()){
			Stripe s = new Stripe(this);
			slist.add(s);
		}
		for(int i=0;i<slist.size();i++){
			slist.get(i).move();
			slist.get(i).display();
			
			if(slist.get(i).x> this.size().getWidth()){
				slist.remove(i);
			}
		}
		
		System.out.println(slist.size());

	}


	public void moveBis(){
		Stripe s = new Stripe(this);
		s.move();
		s.display();
	}

}
