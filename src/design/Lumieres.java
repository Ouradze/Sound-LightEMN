package design;

import processing.core.PApplet;

public class Lumieres {

	int rouge;
	int vert;
	int bleu;
	PApplet parent;


	public Lumieres(PApplet p) {
		this.parent = p;
	}

	public void alterne(int inc) {
		rouge = 0;
		vert = 0;
		bleu = 0;
		int n = inc % (3 * 255);
		int i;
		if (n <= 255) { // zone 1

			rouge = n;
			bleu = 255 - n;
		} else if (n <= 2 * 255) { // zone 2
			i = n - 255;
			rouge = 255 - i;
			vert = i;
		} else { // zone 3
			i = n - 2 * 255;
			vert = 255 - i;
			bleu = i;
		}

		parent.pointLight(rouge, vert, bleu, parent.width / 2,
				parent.height / 2, 400);

	}

	public void rouge() {
		parent.pointLight(255, 0, 0, parent.width / 2, parent.height / 2, 400);

	}

	public void vert() {
		parent.pointLight(0, 255, 0, parent.width / 2, parent.height / 2, 400);

	}

	public void bleu() {
		parent.pointLight(0, 0, 255, parent.width / 2, parent.height / 2, 400);

	}


}
