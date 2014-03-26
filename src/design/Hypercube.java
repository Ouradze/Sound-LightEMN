package design;

import processing.core.PApplet;
import sound.FileFreq;
import sound.Lissage;

public class Hypercube extends Design{
	public static final int n=50;
	public int l;
	
	public Hypercube(PApplet p, int s, int x, int y) {
		super(p, s, x, y);
		l = (int) ((float)(parent.width)/(float)(n));;
		
	}

	
	public void maj(float[] freq) {
		float[] f = Lissage.Lisser(freq);
		this.freq = f;
		
		
	}

	@Override
	public void display() {
		
		
		
	
		for(int j=0; j<n;j++){
			parent.pushMatrix();
			parent.translate(0, 0, -j*l);
			this.bas();
			this.haut();
			parent.popMatrix();
		}
	

		parent.noStroke();

	}
	public void haut(){
		parent.pushMatrix();
		parent.translate(0,0, 0);
		for (int i = 0; i < n; i++) {
			parent.pushMatrix();
			parent.rotateY(PApplet.radians(0));
			parent.translate(parent.width/2 + (i - ((float)(n) / (float)(2))) * l, 0, 0);
			parent.stroke(0);
			parent.fill(255);
			
			parent.box(l, l, l);
			
			parent.stroke(0);
			parent.fill(255);

			parent.popMatrix();
		}
		parent.popMatrix();
		
	}
	public void bas(){
		parent.pushMatrix();
		parent.translate(0, parent.height, 0);
		for (int i = 0; i < n; i++) {
			parent.pushMatrix();
			parent.rotateY(PApplet.radians(0));
			parent.translate(parent.width/2 + (i - ((float)(n) / (float)(2))) * l, 0, 0);
			parent.stroke(0);
			parent.fill(255);
			
			parent.box(l, l, l);
			
			parent.stroke(0);
			parent.fill(255);

			parent.popMatrix();
		}
		parent.popMatrix();
	}
	
	

}
