package processing;

import java.awt.Container;

import processing.core.PApplet;
import processing.core.PImage;
import sound.AudioHandler;
import sound.Fourier;

/**
 * 
 * @author Guillaume Facchini & Mehdi Raddadi
 * 
 *         Abstract class which enable us to inject either a predefined
 *         processing sketch or one created by the user
 */
public abstract class AbstractProcessing extends PApplet {

	private static final long serialVersionUID = 1L;
	protected PImage mFrame;
	protected Container parent;

	AudioHandler audio;

	Fourier fourier;

	int i;

	long timer;

	public AbstractProcessing(Container parent) {
		super();
		this.parent = parent;

		audio = new AudioHandler(this);

	}

	/**
	 * 
	 * @param path
	 */
	public void majSong(String path) {

		audio.majSong(path);
		audio.switchToSong();
		System.out.println(audio.toString());
	}

	/**
	 * 
	 */
	public void majInput() {
		audio.switchToInput();
		System.out.println(audio.toString());
	}

	/**
	 * 
	 * @param s
	 * @param path
	 */
	public abstract void majForme(String s, String path);

	/**
	 * 
	 */
	public abstract void setup();

	/**
	 * 
	 */
	public abstract void draw();

	protected void setFrame(PImage frame) {
		mFrame = frame;
	}

	public PImage getFrame() {
		return mFrame;
	}

	/**
	 * 
	 * @return
	 */
	public Container getPar() {
		return this.parent;
	}

}
