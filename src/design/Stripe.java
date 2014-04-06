package design;

import processing.core.PApplet;
import sound.CalculFourier;

public class Stripe extends Design{
	
	public float largeur;
	public float espace;
	public int sens;
	

	public Stripe(PApplet p, int s, int x, int y) {
		super(p,s,x,y, 0);

	}

	@Override
	public void maj(float[] freq, int x, int y,int z) {
		this.freq = CalculFourier.QuadScaling(CalculFourier.scaling(freq, 1.9, 0.1));
		this.positionX = x;
		this.positionY = y;
		this.positionZ = z;

	}

	public void display() {

		espace = (float) 0.5;
		

		largeur = (float) (parent.getWidth() / (2 * this.freq.length)) + espace;
		parent.pushMatrix();
		parent.translate(positionX, positionY,-100);
		for (int i = 1; i < freq.length; i++) {

			

			parent.fill(0);
			parent.stroke(255);
			parent.rect( i * (largeur + espace), -freq[i], largeur,
					2 * freq[i] + 2);

			parent.fill(255);
			parent.stroke(255);
			parent.rect(-i * (largeur + espace), -freq[i], largeur,
					2 * freq[i] + 2);

			
		}
		parent.popMatrix();

	}

	@Override
	public void maj(float[] freqg, float[] freqd, int x, int y, int z) {
		this.freq = CalculFourier.QuadScaling(CalculFourier.scaling(freqd, 1.9, 0.1));
		this.positionX = x;
		this.positionY = y;
		this.positionZ = z;
		
	}

	

}
