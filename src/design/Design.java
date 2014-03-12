package design;

import processing.core.PApplet;

public abstract class  Design {
	
	public float[] freq; //valeurs des amplitudes correpondant à chaque fréquence
	public PApplet parent; 
	public int sens;	// permet de définir la sortie gauche (-1) ou droite (1), utile en cas de symétrie
	public int positionX; //position du centre du graphique, par défaut : parent.width/2
	public int positionY; //position du centre du graphique , par défant : parent.height/2
	

	


	public Design(PApplet p, int s, int x, int y) {
		this.sens=s;
		this.parent = p;
		this.positionX = x;
		this.positionY = y ;	 
		}



	public abstract void maj(float [] freq);
	
	public abstract void display();

}
