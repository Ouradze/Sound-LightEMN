package processing;

import java.io.File;
import java.nio.file.attribute.DosFileAttributes;
import java.util.ArrayList;

import processing.core.PApplet;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.BeatDetect;

public class MyProcessingSketch extends PApplet{
	
	private String path;
	
	Minim minim;
	AudioPlayer song;
	BeatDetect beat;

	ArrayList<Stripe> slist = new ArrayList<Stripe>(); 
	
	public MyProcessingSketch(String path){
		this.path = path;
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
		
		//System.out.println(slist.size());

	}


	public void moveBis(){
		Stripe s = new Stripe(this);
		s.move();
		s.display();
	}

}
