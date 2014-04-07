package design;

import processing.core.PApplet;
import sound.*;

public class Stripes3D extends Design {
	public FileFreq fileDroite;
	public FileFreq fileGauche;
	public int taille;
	public int sizeFile;

	public Stripes3D(PApplet p, int s, int x, int y, int z) {
		super(p, s, x, y, z);
		this.fileDroite = new FileFreq(50);
		this.fileGauche = new FileFreq(50);
	}

	public void display() {

		parent.pushMatrix();

		parent.translate(this.positionX, (float) (positionY * 1.5),
				this.positionZ - 50);
		parent.pushMatrix();
		parent.rotateY(PApplet.radians(-20));
		for (int k = 0; k < sizeFile; k++) {
			parent.pushMatrix();
			parent.translate(500, 0, -30 * k);
			
			this.creerRangeeDroite(k);
			parent.popMatrix();
		}
		parent.popMatrix();
		parent.pushMatrix();
		parent.rotateY(PApplet.radians(20));
		for (int k = 0; k < sizeFile; k++) {
			parent.pushMatrix();
			parent.translate(-500, 0, -30 * k);
			
			this.creerRangeeGauche(k);
			parent.popMatrix();
		}
		parent.popMatrix();

		parent.popMatrix();

		parent.noStroke();

	}

	public void creerRangeeDroite(int k) {
		float[] f = this.fileDroite.getIndex(k);
		for (int i = 0; i < this.taille; i++) {
			if (f[i] > 5) {
				parent.pushMatrix();

				parent.translate((i - this.taille / 2) * 10, 0, 0);

				parent.stroke(0);
				parent.fill(255);

				parent.box(10, 2 * f[i], 30);

				parent.stroke(0);
				parent.fill(255);

				parent.popMatrix();
			}
		}
	}

	public void creerRangeeGauche(int k) {
		float[] f = this.fileGauche.getIndex(k);
		for (int i = 0; i < this.taille; i++) {
			if (f[i] > 5) {
				parent.pushMatrix();

				parent.translate(-(i - this.taille / 2) * 10, 0, 0);

				parent.stroke(0);
				parent.fill(255);

				parent.box(10, 2 * f[i], 30);

				parent.stroke(0);
				parent.fill(255);

				parent.popMatrix();
			}
		}
	}

	public void maj(float[] freq, int x, int y, int z) {
		float[] f = Lissage.Lissercubique(freq);
		this.freq = f;
		this.fileDroite.maj(f);
		this.positionX = x;
		this.positionY = y;
		this.positionZ = z;
		this.taille = freq.length;
	}

	@Override
	public void maj(float[] freqg, float[] freqd, int x, int y, int z) {
		float[] fg = Lissage.Lissercubique(freqg);
		float[] fd = Lissage.Lissercubique(freqd);
		this.freq = fg;
		this.fileGauche.maj(fg);
		this.fileDroite.maj(fd);
		this.sizeFile = this.fileDroite.getsize();
		this.positionX = x;
		this.positionY = y;
		this.positionZ = z;
		this.taille = fg.length;
	}

}
