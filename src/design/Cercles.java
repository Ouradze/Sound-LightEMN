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
		
		
		
		parent.beginShape(PApplet.LINE);
		parent.stroke(255);
		for (int k = 0; k < 100; k++) {
			double R = this.freqcentre[5] * 4;
			float alpha = (float) (k * 2 * Math.PI) / 100;
			parent.vertex((float) R * PApplet.cos(alpha),
					(float) R * PApplet.sin(alpha));
			
			
		}
		parent.endShape();
		parent.popMatrix();
	}

	@Override
	public void scale() {
	}
}
