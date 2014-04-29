package design;

import processing.core.PApplet;
import sound.CalculFourier;
import sound.Lissage;

public class Rond extends Design {

	public Rond(PApplet p, int x, int y) {
		super(p, x, y,0);
		this.coefs = new double[]{0.2,0.23,0.23,0.24,0.24,0.24,0.24,0.24,0.24,0.25,0.25,0.25,0.25,0.27,0.28,0.28,0.28,0.28,0.28,0.28,0.28,0.28,0.28,0.29,0.31,0.31,0.33,0.36,0.38,0.41,0.41,0.41,0.41,0.41,0.44,0.46,0.5,0.54,0.59,0.66,0.71,0.77,0.82,0.85,0.9,0.93,0.96,0.95,0.98,0.99,0.99,0.99,0.98,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99};	}

	

	

	public void display() {
		for (int i = 1; i < freqcentre.length; i++) {

			// cote gauche
			
			parent.pushMatrix();
			parent.translate(positionX, positionY);

			parent.rotate(PApplet.radians(i * 180 / freqgauche.length));

			parent.fill(255);
			parent.stroke(255);
			parent.rect((float) (-1), 100, 5, 10 + freqgauche[i] * 2);

			parent.popMatrix();
			
			parent.pushMatrix();
			parent.translate(positionX, positionY);

			parent.rotate(PApplet.radians(i * 180 / freqgauche.length));

			parent.fill(255);
			parent.stroke(255);
			parent.rect((float) (-1), 100, 5, 10 - freqgauche[i] * 2);

			parent.popMatrix();
			
			// Cote droit
			
			parent.pushMatrix();
			parent.translate(positionX, positionY);

			parent.rotate((-1) * PApplet.radians(i * 180 / freqdroite.length));

			parent.fill(255);
			parent.stroke(255);
			parent.rect((float) (-1), 100, 5, 10 + freqdroite[i] * 2);

			parent.popMatrix();
			
			parent.pushMatrix();
			parent.translate(positionX, positionY);

			parent.rotate((-1) * PApplet.radians(i * 180 / freqdroite.length));

			parent.fill(255);
			parent.stroke(255);
			parent.rect((float) (-1), 100, 5, 10 - freqdroite[i] * 2);

			parent.popMatrix();
			
			
			
		}
	}



	
	public void scale() {
		this.freqcentre = CalculFourier.QuadScaling(Lissage.Lissercubique(this.freqcentre));
		this.freqgauche = CalculFourier.QuadScaling(Lissage.Lissercubique(this.freqgauche));
		this.freqdroite =  CalculFourier.QuadScaling(Lissage.Lissercubique(this.freqdroite));
		
	}

	



	

}
