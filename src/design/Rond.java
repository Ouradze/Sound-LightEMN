package design;

import processing.core.PApplet;
import sound.Fourier;

public class Rond {
	
	public float[] freq;
	public PApplet parent;
	public int sens;
	public int positionX;
	public int positionY;
	
	public Rond(PApplet p, int s, int x, int y){
		this.sens=s;
		this.parent = p;
		this.positionX = x;
		this.positionY = y ;	 
		 
	}
	
	public void maj(float [] freq){
		//Mise à l'échelle adéquate des valeurs de la FFT (à adapter en fonction du graphisme)
		this.freq = Fourier.QuadScaling(Fourier.scaling(freq, 1.5, 0.8));
	}
	public void display(){
		for(int i = 1; i< freq.length;i++){
			
		parent.pushMatrix();
		parent.translate(positionX, positionY);
		
		parent.rotate(sens*PApplet.radians(i*180 / freq.length));
		
		parent.fill(255);
		parent.stroke(0);
		parent.rect((float)(-1),100,5,10+freq[i]*2);
		
		
		parent.popMatrix();
		}
	}

}
