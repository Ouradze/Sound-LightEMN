package sound;

import processing.core.PApplet;
import ddf.minim.*;

public class AudioHandler {
	PApplet parent;
	Minim minim;
	AudioPlayer song;
	AudioInput input;
	AudioSource audio;
	
	
	public AudioHandler(PApplet parent){
		
		this.minim = new Minim(parent);
		this.input = minim.getLineIn();
		this.audio = this.input;
	}
	
	public void majSong(String path) {
		song = minim.loadFile(path);
		
	}

	
	
	public AudioSource getAudio(){
		return this.audio;
	}
	
	public void switchToSong(){
		this.audio = this.song;
		song.play();
	}
	public void switchToInput(){
		if(song!=null){
			song.close();
		}
		audio = input;
	}
	
	public void pauseSong(){
		if(song!=null){
		song.pause();
		}
	}
	public void playSong(){
		if(song!=null){
			song.play();
		}
	}
	public float getPosition(){
		if(song!=null){
			return song.position();
		}
		else{
			return (float) 0.0;
		}
	}

}
