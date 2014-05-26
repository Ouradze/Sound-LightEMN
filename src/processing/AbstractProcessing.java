package processing;

import java.awt.Container;

import com.sun.istack.internal.logging.Logger;

import processing.core.PApplet;
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
	protected Container parent;

	AudioHandler audio;

	Fourier fourier;

	int i;

	long timer;
	boolean debug;

	public AbstractProcessing(Container parent) {
		super();
		this.parent = parent;
		debug = false;
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

	/**
	 * 
	 * @return
	 */
	public Container getPar() {
		return this.parent;
	}
	
	public void debug(){
		if(debug){
			if(this.frameRate>61 || this.frameRate<59 ){
			System.out.println();
			System.out.println("FPS : "+this.frameRate +" /s");
			
		
			}
		}
	}

}
