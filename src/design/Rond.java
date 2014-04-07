package design;

import processing.core.PApplet;
import sound.CalculFourier;
import sound.Lissage;

public class Rond extends Design {

	public Rond(PApplet p, int s, int x, int y) {
		super(p, s, x, y,0);

	}

	

	public void display() {
		for (int i = 1; i < freqcentre.length; i++) {

			parent.pushMatrix();
			parent.translate(positionX, positionY);

			parent.rotate(sens * PApplet.radians(i * 180 / freqcentre.length));

			parent.fill(255);
			parent.stroke(0);
			parent.rect((float) (-1), 100, 5, 10 + freqcentre[i] * 2);

			parent.popMatrix();
		}
	}



	
	public void scale() {
		this.freqcentre = CalculFourier.QuadScaling(Lissage.Lissercubique(this.freqcentre));
		this.freqgauche = CalculFourier.QuadScaling(Lissage.Lissercubique(this.freqgauche));
		this.freqdroite =  CalculFourier.QuadScaling(Lissage.Lissercubique(this.freqdroite));
		
	}

	



	

}
