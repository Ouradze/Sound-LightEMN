package design;

import processing.core.PApplet;
import sound.CalculFourier;
import sound.Lissage;
import utils.MatriceFreq;

/**
 * @author guillaume
 * 
 */
public class Hypercube extends Design {
	public static final int n = 20;
	public int cote;
	public int coteElem;
	public int profondeur;
	public MatriceFreq mat;

	public Hypercube(PApplet p, int x, int y, int z) {
		super(p, x, y, z);
		cote = 400;
		coteElem = (int) (cote / (float) (n));
		profondeur = coteElem;
		this.coefs = new double[] { 0.58, 0.58, 0.57, 0.57, 0.58, 0.58, 0.6,
				0.61, 0.62, 0.62, 0.62, 0.62, 0.63, 0.67, 0.7, 0.73, 0.77,
				0.82, 0.86, 0.9, 0.93, 0.96, 0.96, 0.96, 0.96, 0.93, 0.9, 0.86,
				0.83, 0.8, 0.77, 0.74, 0.7, 0.67, 0.64, 0.6, 0.56, 0.54, 0.51,
				0.48, 0.46, 0.46, 0.46, 0.46, 0.44, 0.44, 0.42, 0.4, 0.4, 0.39,
				0.39, 0.39, 0.39, 0.39, 0.39, 0.39, 0.39, 0.41, 0.42, 0.43,
				0.44, 0.45, 0.47, 0.49, 0.5, 0.5, 0.51, 0.51, 0.54, 0.55, 0.56,
				0.59, 0.6, 0.63, 0.66, 0.68, 0.7, 0.75, 0.77, 0.81, 0.81, 0.84,
				0.86, 0.88, 0.89, 0.92, 0.93, 0.96, 0.98, 0.99 };

	}

	public void display() {
		this.majMatrice();
		parent.pushMatrix();
		parent.translate(this.positionX, this.positionY, this.positionZ - 300);

		parent.rotateY(PApplet.radians(360 * parent.mouseX / parent.width));

		for (int j = 0; j < n; j++) {
			parent.pushMatrix();
			parent.translate(0, 0, -j * profondeur);
			this.bas(j);
			this.haut(j);
			this.gauche(j);
			this.droite(j);
			parent.popMatrix();
		}
		this.fond();
		parent.popMatrix();

		parent.noStroke();

	}

	public void fond() {
		parent.pushMatrix();
		parent.translate(coteElem / 2, coteElem / 2, 0);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				parent.pushMatrix();

				parent.translate(i * coteElem - cote / 2, j * coteElem - cote
						/ 2, -n * profondeur);
				parent.noStroke();
				parent.fill(255);

				parent.box(coteElem, coteElem, profondeur + this.mat.get(i, j)
						* 2);

				parent.fill(255);

				parent.popMatrix();
			}
		}
		parent.popMatrix();
	}

	public void haut(int j) {
		parent.pushMatrix();
		parent.translate(coteElem / 2, -cote / 2, 0);
		this.cote(j);

		parent.popMatrix();
	}

	public void cote(int j) {

		for (int i = 0; i < n; i++) {
			parent.pushMatrix();

			parent.translate(i * coteElem - cote / 2, 0, 0);
			parent.noStroke();

			parent.box(coteElem, coteElem + this.mat.get(i, j) * 2, profondeur);

			parent.popMatrix();
		}

	}

	public void bas(int j) {
		parent.pushMatrix();

		parent.translate(coteElem / 2, cote / 2, 0);
		this.cote(j);

		parent.popMatrix();
	}

	public void gauche(int j) {
		parent.pushMatrix();

		parent.translate(-cote / 2, coteElem / 2, 0);

		parent.rotateZ(PApplet.radians(90));
		this.cote(j);
		parent.popMatrix();
	}

	public void droite(int j) {
		parent.pushMatrix();

		parent.translate(cote / 2, coteElem / 2, 0);

		parent.rotateZ(PApplet.radians(90));
		this.cote(j);
		parent.popMatrix();
	}

	@Override
	public void scale() {
		this.freqcentre = CalculFourier.QuadScaling(Lissage
				.Lissercubique(this.freqcentre));
		this.freqgauche = CalculFourier.QuadScaling(Lissage
				.Lissercubique(this.freqgauche));
		this.freqdroite = CalculFourier.QuadScaling(Lissage
				.Lissercubique(this.freqdroite));

	}

	public void majMatrice() {
		this.mat = new MatriceFreq(this.freqcentre, n);
	}

}
