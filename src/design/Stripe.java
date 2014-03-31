package design;

import processing.core.PApplet;
import sound.Fourier;

public class Stripe {

	public float[] freq;

	public PApplet parent;
	public float largeur;
	public float espace;
	public int sens;
	public int positionX;
	public int positionY;

	public Stripe(PApplet p, int s, int x, int y) {
		this.sens = s;
		this.parent = p;
		this.positionX = x;
		this.positionY = y;

	}

	public void maj(float[] freq) {

		this.freq = Fourier.QuadScaling(Fourier.scaling(freq, 1.9, 0.1));

	}

	public void display() {

		espace = (float) 0.5;
		float[] freq2 = Fourier.CutScaling(this.freq, (float) 1.5);

		largeur = (float) (parent.width / (2 * freq.length)) + espace;

		for (int i = 1; i < freq.length; i++) {

			parent.pushMatrix();
			parent.translate(positionX, positionY);

			parent.fill(255, 0, 0);
			parent.stroke(0);
			parent.rect(sens * i * (largeur + espace), -freq[i], largeur,
					2 * freq[i] + 2);

			parent.fill(240, 0, 0);
			parent.stroke(0);
			parent.rect(sens * i * (largeur + espace), -freq2[i], largeur,
					2 * freq2[i] + 2);

			parent.popMatrix();
		}

	}

}
