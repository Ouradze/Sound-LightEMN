package design;

import processing.core.PApplet;

public abstract class Design {

	public float[] freq; // valeurs des amplitudes correpondant à chaque
							// fréquence
	public PApplet parent;
	public int sens; // permet de définir la sortie stéréo gauche (-1) ou
						// droite (1), utile en cas de symétrie
	public int positionX; // position du centre du graphique
	public int positionY; // position du centre du graphique
	public int positionZ;

	public Design(PApplet p, int s, int x, int y, int z) {
		this.sens = s;
		this.parent = p;
		this.positionX = x;
		this.positionY = y;
		this.positionZ = z;

	}

	public abstract void maj(float[] freq, int x, int y, int z);

	public abstract void display();

}
