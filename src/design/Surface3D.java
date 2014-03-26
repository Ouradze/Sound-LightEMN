package design;

import processing.core.PApplet;
import sound.*;

public class Surface3D extends Design {
	public FileFreq file;

	public Surface3D(PApplet p, int s, int x, int y) {
		super(p, s, x, y);
		this.file = new FileFreq(25);
	}

	public void display() {
		int largeur = 10;
		int l = this.freq.length;
		parent.pushMatrix();
		parent.rotateY(PApplet.radians(-10));
		parent.translate(0, (float) (positionY * 1.5), -400);
		if (file.getsize() > 1) {
			for (int k = 0; k < this.file.getsize() - 1; k++) {
				float[] f1 = this.file.getIndex(k);
				float[] f2 = this.file.getIndex(k+1);
				for (int i = 0; i < l-1; i++) {
					parent.pushMatrix();
					
					parent.translate(positionX + (i - l / 2) * largeur, 0, -largeur * k);
					

					if(k==0){
					parent.stroke(255);
					parent.line(0, -f1[i]*2, 0,largeur, -f1[i+1]*2,0);
					}
					//Cr�ation de deux triangles couvrant 1 carr� de surface
					//triangle 1
					parent.fill(255);
					parent.noStroke();
					parent.beginShape();
					parent.vertex(0, -f2[i]*2, -largeur); 		//A
					parent.vertex(0, -f1[i]*2, 0); 				//B
					parent.vertex(largeur, -f1[i+1]*2,0);		//C
					parent.endShape();
					
					//triangle 2
					parent.beginShape();
					parent.vertex(0, -f2[i]*2, -largeur); 			//A
					parent.vertex(largeur, -f1[i+1]*2,0);			//C
					parent.vertex(largeur, -f2[i+1]*2, -largeur);	//D
					parent.endShape();
					
					parent.popMatrix();
				}
			}
		}
		parent.popMatrix();

		parent.noStroke();
		

	}

	public void maj(float[] freq) {
		float[] f = Lissage.Lisser(freq);
		this.freq = f;
		this.file.maj(f);
	}

}
