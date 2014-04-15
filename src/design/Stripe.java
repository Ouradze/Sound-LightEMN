package design;

import processing.core.PApplet;
import sound.CalculFourier;
import sound.Lissage;

public class Stripe extends Design{
	
	public float largeur;
	public float espace;
	public int sens;
	

	public Stripe(PApplet p,  int x, int y) {
		super(p,x,y, 0);

	}

	

	public void display() {

		espace = (float) 0.5;
		

		largeur = (float) (parent.getWidth() / (2 * this.freqcentre.length)) + espace;
		parent.pushMatrix();
		parent.translate(positionX, positionY,-100);
		for (int i = 1; i < this.freqcentre.length; i++) {

			

			parent.fill(0);
			parent.stroke(255);
			parent.rect( i * (largeur + espace), -freqcentre[i], largeur,
					2 * freqcentre[i] + 2);

			parent.fill(255);
			parent.stroke(255);
			parent.rect(-i * (largeur + espace), -freqcentre[i], largeur,
					2 * freqcentre[i] + 2);

			
		}
		parent.popMatrix();

	}

	@Override
	public void scale() {
		this.freqcentre = CalculFourier.CutScaling(Lissage.Lissercubique(this.freqcentre),(float) 0.8);
		this.freqgauche = CalculFourier.CutScaling(Lissage.Lissercubique(this.freqgauche),(float) 0.8);
		this.freqdroite =CalculFourier.CutScaling(Lissage.Lissercubique(this.freqdroite),(float) 0.8);
		
	}

	

	

}
