package design;

import processing.core.*;
import processing.opengl.*;
import sound.*;
import utils.*;

public class Surface extends Design {

	public FileFreq file;
	private int largeur;
	private int taille;

	PGraphicsOpenGL p;
	PShapeOpenGL surface;
	MatricePositions mat;
	public boolean complet;

	public Surface(PApplet p, int x, int y, int z) {
		super(p, x, y, z);
		this.file = new FileFreq(100);

		this.coefs = new double[] { 0.07, 0.07, 0.08, 0.08, 0.08, 0.08, 0.09,
				0.1, 0.12, 0.13, 0.13, 0.16, 0.22, 0.24, 0.27, 0.28, 0.3, 0.32,
				0.32, 0.36, 0.39, 0.43, 0.47, 0.49, 0.54, 0.57, 0.61, 0.64,
				0.68, 0.73, 0.77, 0.81, 0.85, 0.91, 0.95, 0.97, 0.99, 0.94,
				0.94, 0.94, 0.94, 0.94, 0.94, 0.94, 0.94, 0.94, 0.94, 0.94,
				0.94, 0.94, 0.94, 0.94, 0.94, 0.94, 0.94, 0.94, 0.94, 0.94,
				0.94, 0.94, 0.94, 0.94, 0.94, 0.94, 0.94, 0.94, 0.94, 0.94,
				0.94, 0.94, 0.94, 0.94, 0.94, 0.94, 0.94, 0.94, 0.94, 0.94,
				0.94, 0.94, 0.94, 0.94, 0.94, 0.94, 0.94, 0.94, 0.94, 0.94,
				0.94, 0.94 };

		this.taille = (int) ((double) this.coefs.length * 0.8);
		this.largeur = parent.width / this.taille;
		this.mat = new MatricePositions(100, this.coefs.length, this.largeur);
		this.mat.majPositions(x, y, z);
		this.mat.majLargeur(this.largeur);
		surface = (PShapeOpenGL) parent.createShape(PApplet.GROUP);
		complet = false;
		

	}

	public void display() {
		this.majFile();

		parent.pushMatrix();
		parent.translate(0, (float) (parent.height*0.4), 0);
		
		if (this.file.getsize() > 1) {
			if (!complet) {
				this.initSurface();
				this.modifSurface();
			} else {
				this.modifSurface();
				
			}
			parent.shape(surface);
		}
		
		this.creerLigneFrontale();
		parent.popMatrix();
	}
	
	
	public void creerLigneFrontale() {

		
		
		parent.stroke(255);
		parent.beginShape(PApplet.LINE_STRIP);
		
		for(int i=0; i< mat.getLongueur();i++){
		Point p = this.mat.getPoint(0, i);
		parent.vertex(p.x,p.y ,  p.z);
		}
		
		parent.endShape();

	}

	@Override
	public void scale() {
		
		this.freqcentre = CalculFourier.CutScaling(
				Lissage.Lissercubique(CalculFourier.moyennelocale(
						this.freqcentre, 5)), (float) 0.8);
		this.freqgauche = CalculFourier.CutScaling(
				Lissage.Lissercubique(CalculFourier.moyennelocale(
						this.freqgauche, 5)), (float) 0.8);
		this.freqdroite = CalculFourier.CutScaling(
				Lissage.Lissercubique(CalculFourier.moyennelocale(
						this.freqdroite, 5)), (float) 0.8);
		
		this.taille = (int) ((double) this.freqcentre.length * 0.8);
		this.largeur = parent.width / this.taille;
		this.mat.majPositions(this.positionX, this.positionY, this.positionZ);
		this.mat.majLargeur(this.largeur);

	}

	public void initSurface() {

		parent.noStroke();
		

		PShapeOpenGL ligne = (PShapeOpenGL) parent.createShape();
		ligne.beginShape(PApplet.TRIANGLE_STRIP);
		ligne.fill(255);

		int j = this.file.getsize() - 2;
	
		for (int i = 0; i < this.coefs.length; i++) {
			Point a = mat.getPoint(j, i);
			ligne.vertex(a.x, a.y, a.z);

			Point b = mat.getPoint(j + 1, i);
			ligne.vertex(b.x, b.y, b.z);
		}
		
		//ligne.specular(255);
		ligne.endShape();
		

		this.surface.addChild(ligne);
		//this.surface.specular(255);
		if (surface.getChildCount() == this.file.getsizeMax()) {
			complet = true;
		}

	}

	public void modifSurface() {
		
			for (int j = 0; j < surface.getChildCount()-1; j++) {

				PShapeOpenGL ligne = (PShapeOpenGL) surface.getChild(j);

				surface.removeChild(j);
				surface.addChild(this.modifLigne(ligne, j), j);

			}
		

	}

	public PShapeOpenGL modifLigne(PShapeOpenGL ligne, int j) {

		

		for (int i = 0; i < ligne.getVertexCount() / 2; i++) {
			PVector vB = ligne.getVertex(2 * i);
			Point b = this.mat.getPoint(j, i);
			vB.x = b.x;
			vB.y = b.y;
			vB.z = b.z;
			ligne.setVertex(2 * i, vB);

			PVector vA = ligne.getVertex(2 * i + 1);
			Point a = this.mat.getPoint(j + 1, i);
			vA.x = a.x;
			vA.y = a.y;
			vA.z = a.z;
			ligne.setVertex(2 * i + 1, vA);

		}

		return ligne;

	}

	public void majFile() {
		this.file.maj(this.freqcentre);
		this.mat.majMatrice(this.file);

	}

}
