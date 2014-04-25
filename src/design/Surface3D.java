package design;

import processing.core.*;
import processing.opengl.*;
import sound.*;

public class Surface3D extends Design {

	public FileFreq file;
	private int largeur ;
	private int taille;
	private static final String Surface = "ADBC";
	private static final String Lignes = "BACD";
	private float[][] points;
	private static final int[] seq = { 0,3,1,2};
	PGraphicsOpenGL p;


	public Surface3D(PApplet p,  int x, int y, int z) {
		super(p, x, y,z);
		this.file = new FileFreq(100);
		
		this.coefs =  new double[]{0.07,0.07,0.08,0.08,0.08,0.08,0.09,0.1,0.12,0.13,0.13,0.16,0.22,0.24,0.27,0.28,0.3,0.32,0.32,0.36,0.39,0.43,0.47,0.49,0.54,0.57,0.61,0.64,0.68,0.73,0.77,0.81,0.85,0.91,0.95,0.97,0.99,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94,0.94};
//		for(int i =0; i< this.coefs.length;i++){
//			this.coefs[i]=0.5;
//		}
	}

	public void display() {
		this.majFile();
		p = (PGraphicsOpenGL) parent.g;
		
		parent.pushMatrix();
		
		parent.translate(0, (float) (2*positionY)-70, 0);
		if (file.getsize() > 1) {

			parent.noStroke();
			parent.fill(255);

			p.beginShape(PApplet.TRIANGLE_STRIP);
			
			for (int k = 0; k < this.file.getsize() - 1; k++) {
				
				for (int i = 0; i < this.taille - 1; i++) {

					this.creerUniteSurface(i, k, Surface3D.Surface);

				}
				
			}
			p.endShape();

			
		}
		for (int i = 0; i < this.taille - 1; i++) {
			this.creerLigne(i);
		}

		parent.popMatrix();

		parent.noStroke();

	}

	public void creerLigne(int i) {

		float[] f = this.freqcentre;
		int l = this.taille;
		p.stroke(255);
		p.beginShape(PApplet.LINES);
		p.vertex(positionX + (i - l / 2) * largeur, -f[i] * 2, 0);
		p.vertex(positionX + (i + 1 - l / 2) * largeur, -f[i + 1] * 2, 0);
		p.endShape();

	}

	public void creerUniteSurface(int i, int k, String ordre) {

		this.creerPoints(i, k);
		//parent.stroke(255);
		switch (ordre) {
		case Surface3D.Surface: // ADBC
			p.vertex(this.points[Surface3D.seq[0]][0], this.points[Surface3D.seq[0]][1],
					this.points[Surface3D.seq[0]][2]);
			p.vertex(this.points[Surface3D.seq[1]][0], this.points[Surface3D.seq[1]][1],
					this.points[Surface3D.seq[1]][2]);
			p.vertex(this.points[Surface3D.seq[2]][0], this.points[Surface3D.seq[2]][1],
					this.points[Surface3D.seq[2]][2]);
			p.vertex(this.points[Surface3D.seq[3]][0], this.points[Surface3D.seq[3]][1],
					this.points[Surface3D.seq[3]][2]);
			break;
		case Surface3D.Lignes:
			p.vertex(this.points[0][0], this.points[0][1],
					this.points[0][2]);
			p.vertex(this.points[1][0], this.points[1][1],
					this.points[1][2]);
			p.vertex(this.points[3][0], this.points[3][1],
					this.points[3][2]);
			p.vertex(this.points[2][0], this.points[2][1],
					this.points[2][2]);
			break;

		}

		
	}

	public void creerPoints(int i, int k) {
		float[] f1 = this.file.getIndex(k);
		float[] f2 = this.file.getIndex(k + 1);

		float[] A = { positionX + (i - this.taille / 2) * largeur, -f2[i] * 2,
				-largeur * (k + 1) };
		float[] B = { positionX + (i - this.taille / 2) * largeur, -f1[i] * 2,
				-largeur * k };
		float[] C = { positionX + (i + 1 - this.taille / 2) * largeur,
				-f1[i + 1] * 2, -largeur * k };
		float[] D = { positionX + (i + 1 - this.taille / 2) * largeur,
				-f2[i + 1] * 2, -largeur * (k + 1) };

		this.points = new float[][] { A, B, C, D };

	}

	

	@Override
	public void scale() {
//		this.freqcentre = Lissage.Lissercubique(this.freqcentre);
//		this.freqgauche = Lissage.Lissercubique(this.freqgauche);
//		this.freqdroite = Lissage.Lissercubique(this.freqdroite);
		this.freqcentre = CalculFourier.CutScaling(Lissage.Lissercubique(CalculFourier.moyennelocale(this.freqcentre,5)),(float)0.8);
		this.freqgauche = CalculFourier.CutScaling(Lissage.Lissercubique(CalculFourier.moyennelocale(this.freqgauche,5)),(float) 0.8);
		this.freqdroite =CalculFourier.CutScaling(Lissage.Lissercubique(CalculFourier.moyennelocale(this.freqdroite,5)),(float) 0.8);
		this.taille = (int) ((double)this.freqcentre.length*0.8);
		this.largeur = parent.width/this.taille;
		
	}
	
	public void majFile(){
		this.file.maj(this.freqcentre);
		
	}

	

}
