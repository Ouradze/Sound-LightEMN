package sound;

import processing.core.PApplet;
import sound.*;

public class Equalizer {

	public PApplet parent;

	public int positionX;
	public int positionY;
	public int positionZ;

	public double[] coefs;
	public Fourier fourier;

	public int longtotale;
	public int largeurunit;
	public int hauteur;

	// For developpment use ONLY
	public Equalizer(PApplet p, int x, int y, int z, Fourier f) {
		this.parent = p;
		this.positionX = x;
		this.positionY = y;
		this.positionZ = z;
		this.fourier = f;
		this.longtotale = this.parent.width;

		this.hauteur = 100;
		coefs = new double[f.getCentre().length];
		for (int i = 0; i < coefs.length; i++) {
			coefs[i] = (float) 0.5;
		}
		this.largeurunit = longtotale / coefs.length;

		f.setCoefs(coefs);
	}

	public void display() {

		parent.pushMatrix();
		parent.translate(this.positionX, this.positionY, this.positionZ);
		for (int i = 0; i < coefs.length; i++) {
			parent.pushMatrix();

			this.creerBarre(i);

			parent.popMatrix();
		}

		parent.popMatrix();
		this.sourisDetect();
	}

	public void creerBarre(int i) {

		parent.stroke(255);
		parent.rect(i * (float)largeurunit, hauteur * (1 - (float)coefs[i]), (float)largeurunit,
				hauteur * (float)coefs[i]);

	}

	public void majFourier() {
		fourier.setCoefs(coefs);

	}

	public void sourisDetect() {
		int sourisX = parent.mouseX;
		int sourisY = parent.mouseY;
		parent.stroke(255);
		parent.rect(this.positionX, this.positionY, this.longtotale,
				1 * hauteur);
		boolean zonelargeur = (sourisX > this.positionX)
				&& (sourisX < (this.positionX + this.longtotale));
		boolean zonehauteur = (sourisY > this.positionY)
				&& (sourisY < this.positionY + 1 * hauteur);

		if (zonelargeur && zonehauteur) {
			sourisX = sourisX - this.positionX;
			sourisY = sourisY - this.positionY;
			if (parent.mousePressed) {
				this.modifCoef(sourisX, sourisY);
			}
		}
	}

	public void modifCoef(int sourisX, int sourisY) {
		int i = (int) ((float) sourisX * coefs.length / (float) longtotale);
		float val = (float) (1 * hauteur - sourisY) / (float) (1 * hauteur);

		this.coefs[i] = val;
		this.majFourier();
	}

	public String toString() {

		String s = "{";
		if (this.coefs != null) {
			s += "" + this.coefs[0];
			for (int i = 1; i < this.coefs.length; i++) {
				s += "," + this.coefs[i];
			}
			s += "}";
		}
		return s;
	}
}
