package design;

import processing.core.PApplet;

public class Cercles extends Design {
	public double L;
	public double alpha;

	public Cercles(PApplet p, int x, int y) {
		super(p, x, y, 0);
		L = this.positionY;

	}

	@Override
	public void display() {
		parent.pushMatrix();

		parent.translate(this.positionX, this.positionY, 200);

	
		for (int j = 0; j < this.freqcentre.length / 2; j++) {
			double R;
			if (this.freqcentre[j] < 100) {
				R = 10 * j + this.freqcentre[j]/5;
			} else {
				R = 10 * (j + 1);
			}
			parent.beginShape();
			parent.noFill();
			parent.stroke(255);
			
			for (int k = 0; k <= 100; k++) {

				float alpha = (float) (k * 2 * Math.PI) / 100;
				parent.vertex((float) R * PApplet.cos(alpha), (float) R
						* PApplet.sin(alpha));

			}
			parent.endShape(PApplet.CLOSE);
		}
		
		parent.popMatrix();
	}

	@Override
	public void scale() {
	}
}
