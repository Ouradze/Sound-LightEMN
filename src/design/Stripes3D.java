package design;

import processing.core.PApplet;
import sound.Fourier;

public class Stripes3D extends Design {

	
	
	
	public Stripes3D(PApplet p, int s, int x, int y){
		super(p,s,x,y);	 
	}
	
	public void display() {
		int l = this.freq.length;
		parent.pushMatrix();
		parent.rotateY(PApplet.radians(-10));
		parent.translate(0, (float) (positionY*1.5),-400);
		for(int i=0; i<l;i++){
		parent.pushMatrix();
		parent.rotateY(PApplet.radians(0));
		parent.translate(positionX+(i-l/2)*10, 0,0);
		parent.box(10,2*this.freq[i],30);
		parent.popMatrix();
		}
		parent.popMatrix();
	}

	
	public void maj(float[] freq) {
		this.freq = Fourier.scaling(freq, 1.9, 0.1);
	}

}
