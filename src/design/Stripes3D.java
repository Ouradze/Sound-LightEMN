package design;

import processing.core.PApplet;

public class Stripes3D extends Design {

	
	
	
	public Stripes3D(PApplet p, int s, int x, int y){
		super(p,s,x,y);	 
	}
	
	public void display() {
		int l = this.freq.length;
		for(int i=0; i<l;i++){
		parent.pushMatrix();
		parent.rotateY(PApplet.radians(0));
		parent.translate(positionX+(i-l/2)*10, (float) (positionY*1.5),-400);
		parent.box(10,this.freq[i],10);
		parent.popMatrix();
		}
	}

	
	public void maj(float[] freq) {
		this.freq=freq;
	}

}
