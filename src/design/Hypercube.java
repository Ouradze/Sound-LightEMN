package design;

import processing.core.PApplet;
import sound.*;


public class Hypercube extends Design {
	public static final int n = 20;
	public int cote;
	public int coteElem;
	public int profondeur;
	public Matrice mat;

	public Hypercube(PApplet p, int x, int y, int z) {
		super(p, x, y, z);
		cote = 400;
		coteElem = (int) (cote / (float) (n));
		profondeur = coteElem;
	

	}


	public void display() {
		this.majMatrice();		
		parent.pushMatrix();
		parent.translate(this.positionX,this.positionY, this.positionZ-300);
		
		
		parent.rotateY(PApplet.radians(360*parent.mouseX/parent.width));
	

		for (int j = 0; j < n; j++) {
			parent.pushMatrix();
			parent.translate(0, 0, -j * profondeur);
			this.bas(j);
			this.haut(j);
			this.gauche(j);
			this.droite(j);
			parent.popMatrix();
		}
		this.fond();
		parent.popMatrix();
		
		parent.noStroke();

	}

	public void fond() {
		parent.pushMatrix();
		parent.translate(coteElem/2, coteElem/2, 0);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				parent.pushMatrix();

				parent.translate(i*coteElem-cote/2,j*coteElem - cote/2, -n * profondeur);
				parent.noStroke();
				parent.fill(255);
				
				parent.box(coteElem, coteElem, profondeur+this.mat.get(i,j)*2);

				

				parent.fill(255);

				parent.popMatrix();
			}
		}
		parent.popMatrix();
	}
	
	public void haut(int j){
		parent.pushMatrix();
		parent.translate(coteElem/2, -cote/2,0);
		this.cote(j);
		
		
		parent.popMatrix();
	}
	
	
	
	public void cote(int j) {
		
		for (int i = 0; i < n; i++) {
			parent.pushMatrix();

			parent.translate(i*coteElem - cote/2,0, 0);
			parent.noStroke();

			

			parent.box(coteElem, coteElem+this.mat.get(i,j)*2, profondeur);

			
			


			parent.popMatrix();
		}
		
	}

	public void bas(int j) {
		parent.pushMatrix();

		parent.translate(coteElem/2,cote/2, 0);
		this.cote(j);
		

		parent.popMatrix();
	}

	public void gauche(int j) {
		parent.pushMatrix();

		parent.translate(-cote/2, coteElem/2, 0);

		parent.rotateZ(PApplet.radians(90));
		this.cote(j);
		parent.popMatrix();
	}

	public void droite(int j) {
		parent.pushMatrix();

		parent.translate(cote/2, coteElem/2, 0);

		parent.rotateZ(PApplet.radians(90));
		this.cote(j);
		parent.popMatrix();
	}

	@Override
	public void scale() {
		this.freqcentre = CalculFourier.QuadScaling(Lissage.Lissercubique(this.freqcentre));
		this.freqgauche = CalculFourier.QuadScaling(Lissage.Lissercubique(this.freqgauche));
		this.freqdroite =  CalculFourier.QuadScaling(Lissage.Lissercubique(this.freqdroite));
		
	}
	
	public void majMatrice(){
		this.mat = new Matrice(this.freqcentre,n);
	}

	

	

}
