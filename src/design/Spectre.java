package design;

import processing.core.PApplet;
import sound.*;

public class Spectre extends Design{
	
	float[][] c;
	AnalyseNote ana;
	private static final int largeur =  5;
	private static final int hauteur =  10;
	
	public Spectre(PApplet p, int x, int y, int z) {
		super(p, x, y, z);
		ana = new AnalyseNote();
		c = ana.getMatrice();
		
	}

	
	public void scale() {
		ana.maj(this.f.getFreqBrute(), f.getSampleRate());
		c =  ana.getMatrice();
	}

	
	public void display() {
		this.parent.pushMatrix();
		this.parent.translate(200, this.parent.height/2 - hauteur*this.c.length/2, 200);
		
		
		
		for(int i = 0; i<this.c.length;i++){
			
			for(int j =0; j< this.c[i].length;j++){
				
				this.creercarre(i, j);
				
			}
		}
		
		
		
		
		
		
		this.parent.popMatrix();
		
	}
	
	public void creercarre(int i, int j){
		
		
		this.parent.beginShape();
		float value =  this.c[i][j];
		this.parent.fill(255*value, 0, 255*(1-value));
		this.parent.vertex(j*largeur, i*hauteur, 0);
		this.parent.vertex((j+1)*largeur, i*hauteur, 0);
		this.parent.vertex((j+1)*largeur, (i+1)*hauteur, 0);
		this.parent.vertex(j*largeur, (i+1)*hauteur, 0);
		this.parent.endShape(PApplet.CLOSE);
			
	}
	
	

}
