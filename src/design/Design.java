package design;

import processing.core.PApplet;
import sound.Fourier;

public abstract class Design {

	public float[] freqgauche; // valeurs des amplitudes correpondant à chaque
	public float[] freqdroite; // fréquence
	public float[] freqcentre;
	public PApplet parent;
	// permet de définir la sortie stéréo gauche (-1) ou
	// droite (1), utile en cas de symétrie
	public int positionX; // position du centre du graphique
	public int positionY; // position du centre du graphique
	public int positionZ;
	public double[] coefs;

	public Design(PApplet p, int x, int y, int z) {

		this.parent = p;
		this.positionX = x;
		this.positionY = y;
		this.positionZ = z;

	}

	public abstract void scale();

	public void maj(Fourier f, int x, int y, int z) {
		this.freqcentre = f.getCentre();
		this.freqgauche = f.getGauche();
		this.freqdroite = f.getDroite();
		this.positionX = x;
		this.positionY = y;
		this.positionZ = z;

		this.scale();
	}

	public abstract void display();

	public double[] getCoefs() {
		if (this.coefs != null) {
			return this.coefs;
		} else {
			return null;
		}
	}

}
