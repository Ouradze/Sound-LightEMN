package design;

import processing.core.PApplet;
import sound.CalculFourier;
import sound.Lissage;

public class Cercles extends Design {
	public double L;
	public double alpha;

	public Cercles(PApplet p, int x, int y) {
		super(p,  x, y,0);
		L = p.height/2;
		this.coefs = new double[]{0.2,0.23,0.23,0.24,0.24,0.24,0.24,0.24,0.24,0.25,0.25,0.25,0.25,0.27,0.28,0.28,0.28,0.28,0.28,0.28,0.28,0.28,0.28,0.29,0.31,0.31,0.33,0.36,0.38,0.41,0.41,0.41,0.41,0.41,0.44,0.46,0.5,0.54,0.59,0.66,0.71,0.77,0.82,0.85,0.9,0.93,0.96,0.95,0.98,0.99,0.99,0.99,0.98,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99,0.99};	}



	@Override
	public void display() {
		for (int i = 1; i < this.freqcentre.length; i++) {


			parent.pushMatrix();
			
			parent.smooth();
			parent.background(0);
			
			parent.translate(this.positionX,this.positionY,0);
			
			parent.fill(255);
			parent.stroke(255);
			parent.beginShape(PApplet.QUADS);
			parent.vertex(i*freqgauche.length,0,0);
			alpha = alpha + 0.01;
			for (float x=0;x<1;x+=0.01){

				for (float y=0;y<1;y+=0.01){	  
					parent.vertex((float) (L+i*freqgauche.length)*PApplet.cos((float) alpha), (float) (L+i*freqgauche.length)*PApplet.sin((float) alpha),0);
					alpha = alpha + 0.1;
				}
			}
			parent.vertex(i*freqgauche.length,0,0);
			parent.endShape();
			
			parent.popMatrix();
		}
	}


	public void scale() {
		this.freqcentre = CalculFourier.QuadScaling(Lissage.Lissercubique(this.freqcentre));
		this.freqgauche = CalculFourier.QuadScaling(Lissage.Lissercubique(this.freqgauche));
		this.freqdroite =  CalculFourier.QuadScaling(Lissage.Lissercubique(this.freqdroite));
		
	}



}
