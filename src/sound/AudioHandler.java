package sound;

import processing.core.PApplet;
import ddf.minim.*;

public class AudioHandler {
	PApplet parent;
	Minim minim;
	AudioPlayer song;
	AudioInput input;
	AudioSource audio;
	AudioMetaData meta;

	public AudioHandler(PApplet parent) {

		this.minim = new Minim(parent);
		this.input = minim.getLineIn();
		this.audio = this.input;
	}

	public void majSong(String path) {
		if (song != null) {
			song.close();
		}
		song = minim.loadFile(path);
		meta = song.getMetaData();
	}

	public AudioSource getAudio() {
		return this.audio;
	}

	public void switchToSong() {
		this.audio = this.song;
		song.play();
	}

	public void switchToInput() {
		if (song != null) {
			song.close();
		}
		audio = input;
	}

	public void pauseSong() {
		if (song != null) {
			song.pause();
		}
	}

	public void playSong() {
		if (song != null) {
			song.play();
		}
	}

	public float getPosition() {
		if (song != null) {
			return song.position();
		} else {
			return (float) 0.0;
		}
	}

	public void setPosition(int position) {
		if (song != null) {
			song.cue(position);
		}
	}

	public String getMetaData() {

		String s = "";
		if (song != null) {
			if (!meta.fileName().isEmpty()) {
				s += "File Name: " + meta.fileName() + '\n';
			}
			if (meta.length() != 0) {
				s += "Length (in milliseconds): " + meta.length() + '\n';
			}
			if (!meta.title().isEmpty()) {
				s += "Title: " + meta.title() + '\n';
			}
			if (!meta.author().isEmpty()) {
				s += "Author: " + meta.author() + '\n';
			}
			if (!meta.album().isEmpty()) {
				s += "Album: " + meta.album() + '\n';
			}
			if (!meta.date().isEmpty()) {
				s += "Date: " + meta.date() + '\n';
			}
			if (!meta.comment().isEmpty()) {
				s += "Comment: " + meta.comment() + '\n';
			}
			if (!meta.track().isEmpty()) {
				s += "Track: " + meta.track() + '\n';
			}
			if (!meta.genre().isEmpty()) {
				s += "Genre: " + meta.genre() + '\n';
			}
			if (!meta.copyright().isEmpty()) {
				s += "Copyright: " + meta.copyright() + '\n';
			}
			if (!meta.disc().isEmpty()) {
				s += "Disc: " + meta.disc() + '\n';
			}
			if (!meta.composer().isEmpty()) {
				s += "Composer: " + meta.composer() + '\n';
			}
			if (!meta.orchestra().isEmpty()) {
				s += "Orchestra: " + meta.orchestra() + '\n';
			}
			if (!meta.publisher().isEmpty()) {
				s += "Publisher: " + meta.publisher() + '\n';
			}
			if (!meta.encoded().isEmpty()) {
				s += "Encoded: " + meta.encoded() + '\n';
			}

		}
		return s;

	}

	public String toString() {
		String s = "Audio Mode : ";
		if (song == null) {
			s += "Micro";
		} else {
			s += "Fichier Son" + '\n';
			s += this.getMetaData();
		}
		return s;
	}

}
