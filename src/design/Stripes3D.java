package design;

import processing.core.PApplet;
import sound.*;

public class Stripes3D extends Design {
	public FileFreq file;

	public Stripes3D(PApplet p, int s, int x, int y) {
		super(p, s, x, y);
		this.file = new FileFreq(50);
	}

	public void display() {
		int l = this.freq.length;
		parent.pushMatrix();
		parent.rotateY(PApplet.radians(0));
		parent.translate(0, (float) (positionY * 1.5), -400);
		for (int k = 0; k < this.file.getsize(); k++) {
			float[] f = this.file.getIndex(k);
			for (int i = 0; i < l; i++) {
				parent.pushMatrix();
				parent.rotateY(PApplet.radians(0));
				parent.translate(positionX + (i - l / 2) * 10, 0, -30 * k);

				parent.stroke(0);
				parent.fill(255);
				if(f[i]>5){
					parent.box(10, 2 * f[i], 30);
				}
				parent.stroke(0);
				parent.fill(255);

				parent.popMatrix();
			}
		}
		parent.popMatrix();

		parent.noStroke();

	}

	public void maj(float[] freq) {
		this.freq = Fourier.scaling(Fourier.CutScaling(freq,(float) 0.75), 1.9, 0.1);
		this.file.maj(Fourier.scaling(Fourier.CutScaling(freq,(float) 0.75), 1.9, 0.1));
	}

}
