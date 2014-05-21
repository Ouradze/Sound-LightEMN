package design;

import processing.core.PApplet;
import sound.Fourier;

/**
 * 
 * @author guillaume
 * 
 *         Design abstract class, every forms inherit from this class Enable to
 *         inject whatever we want into the window
 */
public abstract class Design {

	public float[] freqgauche;
	public float[] freqdroite;
	public float[] freqcentre;
	public Fourier f;
	public PApplet parent;

	public int positionX; // position du centre du graphique
	public int positionY; // position du centre du graphique
	public int positionZ;
	public double[] coefs;

	/**
	 * 
	 * @param p
	 * @param x
	 * @param y
	 * @param z
	 */
	public Design(PApplet p, int x, int y, int z) {

		this.parent = p;
		this.positionX = x;
		this.positionY = y;
		this.positionZ = z;
		this.coefs = new double[] { 0.2, 0.23, 0.23, 0.24, 0.24, 0.24, 0.24,
				0.24, 0.24, 0.25, 0.25, 0.25, 0.25, 0.27, 0.28, 0.28, 0.28,
				0.28, 0.28, 0.28, 0.28, 0.28, 0.28, 0.29, 0.31, 0.31, 0.33,
				0.36, 0.38, 0.41, 0.41, 0.41, 0.41, 0.41, 0.44, 0.46, 0.5,
				0.54, 0.59, 0.66, 0.71, 0.77, 0.82, 0.85, 0.9, 0.93, 0.96,
				0.95, 0.98, 0.99, 0.99, 0.99, 0.98, 0.99, 0.99, 0.99, 0.99,
				0.99, 0.99, 0.99, 0.99, 0.99, 0.99, 0.99, 0.99, 0.99, 0.99,
				0.99, 0.99, 0.99, 0.99, 0.99, 0.99, 0.99, 0.99, 0.99, 0.99,
				0.99, 0.99, 0.99, 0.99, 0.99, 0.99, 0.99, 0.99, 0.99, 0.99,
				0.99, 0.99, 0.99 };
	}

	public abstract void scale();

	/**
	 * 
	 * @param f
	 * @param x
	 * @param y
	 * @param z
	 */
	public void maj(Fourier f, int x, int y, int z) {
		this.freqcentre = f.getCentre();
		this.freqgauche = f.getGauche();
		this.freqdroite = f.getDroite();
		this.f = f;
		this.positionX = x;
		this.positionY = y;
		this.positionZ = z;

		this.scale();
	}

	public abstract void display();

	/**
	 * 
	 * @return
	 */
	public double[] getCoefs() {
		if (this.coefs != null) {
			return this.coefs;
		} else {
			return null;
		}
	}

}
