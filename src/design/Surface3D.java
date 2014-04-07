package design;

import processing.core.*;
import sound.*;

public class Surface3D extends Design {

	public FileFreq file;
	private int largeur;
	private int taille;
	private static final String Surface = "ADBC";
	private static final String Lignes = "BACD";
	private float[][] points;
	private static final int[] seq = { 0,3,1,2};

	public Surface3D(PApplet p, int s, int x, int y, int z) {
		super(p, s, x, y,z);
		this.file = new FileFreq(100);
		
	}

	public void display() {
		this.majFile();
		
		parent.pushMatrix();
		
		parent.translate(0, (float) (2*positionY)-70, 0);
		if (file.getsize() > 1) {

			parent.noStroke();
			parent.fill(255);

			parent.beginShape(PApplet.TRIANGLE_STRIP);
			
			for (int k = 0; k < this.file.getsize() - 1; k++) {

				for (int i = 0; i < this.taille - 1; i++) {

					this.creerUniteSurface(i, k, Surface3D.Lignes);

				}
				
			}
			parent.endShape();

			
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
		parent.stroke(255);
		parent.beginShape(PApplet.LINES);
		parent.vertex(positionX + (i - l / 2) * largeur, -f[i] * 2, 0);
		parent.vertex(positionX + (i + 1 - l / 2) * largeur, -f[i + 1] * 2, 0);
		parent.endShape();

	}

	public void creerUniteSurface(int i, int k, String ordre) {

		this.creerPoints(i, k);

		switch (ordre) {
		case Surface3D.Surface: // ADBC
			parent.vertex(this.points[Surface3D.seq[0]][0], this.points[Surface3D.seq[0]][1],
					this.points[Surface3D.seq[0]][2]);
			parent.vertex(this.points[Surface3D.seq[1]][0], this.points[Surface3D.seq[1]][1],
					this.points[Surface3D.seq[1]][2]);
			parent.vertex(this.points[Surface3D.seq[2]][0], this.points[Surface3D.seq[2]][1],
					this.points[Surface3D.seq[2]][2]);
			parent.vertex(this.points[Surface3D.seq[3]][0], this.points[Surface3D.seq[3]][1],
					this.points[Surface3D.seq[3]][2]);
			break;
		case Surface3D.Lignes:
			parent.vertex(this.points[0][0], this.points[0][1],
					this.points[0][2]);
			parent.vertex(this.points[1][0], this.points[1][1],
					this.points[1][2]);
			parent.vertex(this.points[3][0], this.points[3][1],
					this.points[3][2]);
			parent.vertex(this.points[2][0], this.points[2][1],
					this.points[2][2]);
			break;

		}

		parent.noStroke();
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
		this.freqcentre = Lissage.Lissercubique(this.freqcentre);
		this.freqgauche = Lissage.Lissercubique(this.freqgauche);
		this.freqdroite = Lissage.Lissercubique(this.freqdroite);
		this.taille = this.freqcentre.length;
		this.largeur = 10;
	}
	
	public void majFile(){
		this.file.maj(this.freqcentre);
		
	}

	

}
