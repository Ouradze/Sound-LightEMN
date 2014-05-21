package design;

import processing.core.PApplet;
import ddf.minim.AudioPlayer;

/**
 * @author guillaume
 * 
 */
public class Barre {

	AudioPlayer song;
	PApplet parent;
	float h;
	float x;

	/**
	 * @param p
	 * @param song
	 */
	public Barre(PApplet p, AudioPlayer song) {
		this.song = song;
		this.parent = p;
		this.x = 0;
	}

	/**
	 * 
	 */
	public void display() {
		h = 30;
		int l = song.length();
		parent.stroke(0);
		parent.rect(song.position() * parent.width / l, parent.height - h,
				(float) (parent.width * 0.01), h);
		parent.fill(150);
		parent.rect(0, parent.height - h / 2, parent.width, 5);

		if (parent.mouseY >= parent.height - h) {
			parent.stroke(150);
			parent.rect(song.position() * parent.width / l, parent.height - h,
					(float) (parent.width * 0.01), h);
			if (parent.mousePressed) {
				x = parent.mouseX;
				parent.stroke(255);
				parent.rect(x, parent.height - h,
						(float) (parent.width * 0.01), h);
				song.cue((int) (x * l / parent.width));
			}
		} else {
			parent.stroke(0);
			parent.rect(song.position() * parent.width / l, parent.height - h,
					(float) (parent.width * 0.01), h);
			parent.noStroke();

		}

		parent.noStroke();
	}

}
