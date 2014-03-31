package design;

import processing.core.PApplet;
import sound.FileFreq;
import sound.Lissage;
import sound.Matrice;

public class Hypercube extends Design {
	public static final int n = 20;
	public int largeur;
	public int hauteur;
	public int profondeur;
	public Matrice mat;

	public Hypercube(PApplet p, int s, int x, int y) {
		super(p, s, x, y);
		largeur = (int) ((float) (parent.width) / (float) (n));
		hauteur = (int) ((float) (parent.height) / (float) (n));
		profondeur = largeur;
		;

	}

	public void maj(float[] freq) {
		float[] f = Lissage.Lissercubique(freq);
		this.freq = f;
		this.mat = new Matrice(f, n);

	}

	@Override
	public void display() {

		parent.pushMatrix();
		parent.translate(parent.width / 2 + largeur / 2, -hauteur / 2,
				-profondeur / 2 - 1000);

		parent.pushMatrix();
		parent.rotateY(PApplet.radians(360 * parent.mouseX / parent.width));

		for (int j = 0; j < n; j++) {
			parent.pushMatrix();
			parent.translate(0, 0, -j * profondeur);
			this.bas(j);
			this.cote(j);
			this.gauche(j);
			this.droite(j);
			parent.popMatrix();
		}
		this.fond();
		parent.popMatrix();
		parent.popMatrix();
		parent.noStroke();

	}

	public void fond() {
		parent.pushMatrix();
		parent.translate(0, hauteur, 0);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				parent.pushMatrix();
				parent.translate((i - ((float) (n) / (float) (2))) * largeur,
						parent.width / 2 + (j - ((float) (n) / (float) (2)))
								* hauteur, -n * profondeur);
				parent.noStroke();
				int v1 = (int) (Math.random() * 255);
				int v2 = (int) (Math.random() * 255);
				int v3 = (int) (Math.random() * 255);
				parent.fill(v1, v2, v3);

				parent.box(largeur, hauteur, profondeur + this.mat.get(i, j)
						* 2);

				parent.fill(255);

				parent.popMatrix();
			}
		}
		parent.popMatrix();
	}

	public void cote(int j) {
		parent.pushMatrix();
		parent.translate(0, 0, 0);
		for (int i = 0; i < n; i++) {
			parent.pushMatrix();

			parent.translate((i - ((float) (n) / (float) (2))) * largeur, 0, 0);
			parent.noStroke();

			parent.box(largeur, hauteur + this.mat.get(i, j) * 2, profondeur);

			parent.popMatrix();
		}
		parent.popMatrix();
	}

	public void bas(int j) {
		parent.pushMatrix();
		parent.translate(0, parent.height + hauteur, 0);
		this.cote(j);

		parent.popMatrix();
	}

	public void gauche(int j) {
		parent.pushMatrix();
		parent.translate(-largeur - parent.width / 2, hauteur + parent.height
				/ 2, 0);
		parent.rotateZ(PApplet.radians(90));
		this.cote(j);
		parent.popMatrix();
	}

	public void droite(int j) {
		parent.pushMatrix();
		parent.translate(parent.width / 2, hauteur + parent.height / 2, 0);
		parent.rotateZ(PApplet.radians(90));
		this.cote(j);
		parent.popMatrix();
	}

}
