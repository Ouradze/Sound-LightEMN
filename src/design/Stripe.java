package design;

import processing.core.PApplet;
import sound.CalculFourier;
import sound.Lissage;

public class Stripe extends Design {

	public float largeur;
	public float espace;
	public int sens;

	public Stripe(PApplet p, int x, int y) {
		super(p, x, y, 0);
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

	public void display() {

		espace = (float) 0.5;

		largeur = (float) (parent.getWidth() / (2 * this.freqcentre.length))
				+ espace;
		parent.pushMatrix();
		parent.translate(positionX, positionY);
		for (int i = 1; i < this.freqcentre.length; i++) {

			parent.fill(0);
			parent.stroke(255);
			parent.rect(i * (largeur + espace), -freqcentre[i], largeur,
					2 * freqcentre[i] + 2);

			parent.fill(255);
			parent.stroke(255);
			parent.rect(-i * (largeur + espace), -freqcentre[i], largeur,
					2 * freqcentre[i] + 2);

		}
		parent.popMatrix();

	}

	@Override
	public void scale() {
		this.freqcentre = CalculFourier.CutScaling(
				Lissage.Lissercubique(this.freqcentre), (float) 0.8);
		this.freqgauche = CalculFourier.CutScaling(
				Lissage.Lissercubique(this.freqgauche), (float) 0.8);
		this.freqdroite = CalculFourier.CutScaling(
				Lissage.Lissercubique(this.freqdroite), (float) 0.8);

	}

}
