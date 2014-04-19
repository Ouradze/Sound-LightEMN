package design;

import processing.core.PApplet;
import sound.*;

public class Stripes3D extends Design {
	public FileFreq file;
	public final int taille = 75;
	public int sizeFile;

	public Stripes3D(PApplet p, int x, int y, int z) {
		super(p, x, y, z);

		this.file = new FileFreq(50);
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
			if (f[i] > 0) {
				parent.pushMatrix();

				parent.translate((i - this.taille / 2) * 10, 0, 0);

				parent.stroke(0);
				parent.fill(255);

				parent.box(10, 2 * f[i], 30);

				parent.popMatrix();
			}
		}
	}

	public void scale() {
		this.freqcentre = Lissage.Lissercubique(this.freqcentre);
		this.freqgauche = Lissage.Lissercubique(this.freqgauche);
		this.freqdroite = Lissage.Lissercubique(this.freqdroite);

	}

	public void majFile() {
		this.file.maj(this.freqcentre);
		this.sizeFile = this.file.getsize();
	}

}
