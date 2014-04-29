package design;

import processing.core.PApplet;
import sound.*;
import utils.FileFreq;

public class Stripes3D extends Design {
	public FileFreq file;
	public final int taille = 100;
	public int sizeFile;

	public Stripes3D(PApplet p, int x, int y, int z) {
		super(p, x, y, z);

		this.file = new FileFreq(50);
		this.coefs = new double[] { 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5,
				0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5,
				0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5,
				0.5, 0.5, 0.54, 0.59, 0.64, 0.7, 0.74, 0.79, 0.83, 0.86, 0.87,
				0.9, 0.93, 0.94, 0.94, 0.95, 0.97, 0.97, 0.97, 0.97, 0.97,
				0.97, 0.97, 0.97, 0.97, 0.97, 0.97, 0.97, 0.97, 0.97, 0.97,
				0.97, 0.95, 0.95, 0.95, 0.95, 0.95, 0.95, 0.95, 0.95, 0.95,
				0.95, 0.95, 0.95, 0.95, 0.95, 0.95, 0.95, 0.95, 0.95, 0.95,
				0.95, 0.95, 0.95, 0.95, 0.95, 0.95, 0.95 };

	}

	public void display() {
		this.majFile();
		parent.pushMatrix();

		parent.translate(this.positionX, (float) (positionY * 1.5),
				this.positionZ);

		parent.rotateY(PApplet.radians(0));
		for (int k = 0; k < sizeFile; k++) {
			parent.pushMatrix();
			parent.translate(0, 0, -30 * k);

			this.creerRangee(k);
			parent.popMatrix();
		}
		parent.popMatrix();

	}

	public void creerRangee(int k) {
		float[] f = this.file.getIndex(k);
		for (int i = 0; i < this.taille; i++) {
			if (f[i] > 5) {
				parent.pushMatrix();

				parent.translate((i - this.taille / 2) * 10, 0, 0);

				parent.stroke(0);
				parent.fill(255);

				parent.box(10, 3 * f[i], 30);

				parent.popMatrix();
			}
		}
	}

	public void scale() {
		this.freqcentre = CalculFourier.CutScaling(
				Lissage.Lissercubique(CalculFourier.moyennelocale(
						this.freqcentre, 3)), (float) 0.6);
		this.freqgauche = CalculFourier.CutScaling(
				Lissage.Lissercubique(CalculFourier.moyennelocale(
						this.freqgauche, 5)), (float) 0.9);
		this.freqdroite = CalculFourier.CutScaling(
				Lissage.Lissercubique(CalculFourier.moyennelocale(
						this.freqdroite, 5)), (float) 0.9);

	}

	public void majFile() {
		this.file.maj(this.freqcentre);
		this.sizeFile = this.file.getsize();
	}

}
