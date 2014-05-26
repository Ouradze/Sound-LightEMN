package processing;

import java.awt.Container;

import sound.Fourier;
import utils.Equalizer;
import design.Barre;
import design.Cercles;
import design.Design;
import design.Hypercube;
import design.Lumieres;
import design.Rond;
import design.Shape;
import design.Spectre;
import design.Stripe;
import design.StripeAnal;
import design.Stripes3D;
import design.Surface;

/**
 * 
 * @author Guillaume Facchini
 * 
 */
public class MainProcessing extends AbstractProcessing {

	public MainProcessing(Container parent) {
		super(parent);
	}

	private static final long serialVersionUID = 1L;
	Design form;
	Equalizer eq;
	Lumieres l;
	int i;
	Barre b;
	long timer;

	public void majSong(String path) {
		audio.majSong(path);
		audio.switchToSong();
		System.out.println(audio.toString());
	}

	public void majInput() {
		audio.switchToInput();
		System.out.println(audio.toString());
	}

	public void majForme(String s, String path) {

		switch (s) {
		case "1":

			form = new Surface(this, this.width / 2, this.height / 2, 0);

			break;
		case "2":

			form = new Stripes3D(this, this.width / 2, this.height / 2, 0);
			break;
		case "3":

			form = new Hypercube(this, this.width / 2, this.height / 2, 0);

			break;

		case "4":
			form = new Rond(this, this.width / 2, this.height / 2);
			break;
		case "5":
			form = new Stripe(this, this.width / 2, this.height / 2);

			break;

		case "6":
			form = new Cercles(this, this.width / 2, this.height / 2);

			break;

		case "7":
			form = new StripeAnal(this, this.width / 2, this.height / 2);
			break;

		case "8":
			form = new Spectre(this, this.width / 2, this.height / 2, 0);
			break;
		case "Import":
			form = new Shape(this, this.width / 2, this.height / 2, 0, path);
			break;
		}
	}

	public void setup() {

		System.out.println(parent.getWidth());

		size(parent.getWidth(), parent.getHeight() - 50, P3D);

		// size(1500, 900, P3D);

		fourier = new Fourier(audio);
		fourier.maj();
		l = new Lumieres(this);

		i = 0;
		timer = 0;

	}

	public void draw() {
		i++;

		size(this.parent.getWidth(), this.parent.getHeight(), P3D);

		l.alterne(i);
		background(0);
		fourier.maj();
		if (form != null) {
			fourier.setCoefs(form.getCoefs());
			form.maj(fourier, this.width / 2, this.height / 2, 0);
			form.display();
		}
	}

}
