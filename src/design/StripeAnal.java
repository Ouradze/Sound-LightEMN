package design;

import java.io.IOException;

import processing.core.PApplet;
import sound.AnalyseNote;

public class StripeAnal extends Design {

	public float largeur;
	public float espace;
	public float[] freq;
	public int sens;
	AnalyseNote anal;

	public StripeAnal(PApplet p, int x, int y, int z) throws IOException {
		super(p, x, y, 0);
		anal = new AnalyseNote();
	}

	public void display() {

		espace = (float) 0.5;

		largeur = (float) (parent.getWidth() / (this.freqcentre.length + 1))
				+ espace;
		parent.pushMatrix();
		parent.translate(0, positionY, -100);

		for (int i = 1; i < freqcentre.length + 1; i++) {

			parent.fill(0);
			parent.stroke(255);
			parent.rect(i * (largeur + espace), -freqcentre[i - 1], largeur, // crée
																				// un
																				// rectangle
					2 * freqcentre[i - 1] + 2);

			parent.fill(255);
			parent.stroke(255);
			// parent.rect(-i * (largeur + espace), -freq[i], largeur,
			// 2 * freqcentre[i] + 2);

		}
		parent.popMatrix();

	}

	@Override
	public void scale() {
		// this.freqcentre =
		// CalculFourier.CutScaling(Lissage.Lissercubique(this.freqcentre),(float)
		// 0.8);
		// this.freqgauche =
		// CalculFourier.CutScaling(Lissage.Lissercubique(this.freqgauche),(float)
		// 0.8);
		// this.freqdroite
		// =CalculFourier.CutScaling(Lissage.Lissercubique(this.freqdroite),(float)
		// 0.8);

		anal.maj(this.f.getAudio().getAudio());
		this.freq = this.anal.linear_fn(this.anal.getPCP());
		// this.freq = this.anal.getFFT();

		this.freqcentre = freq;
		this.freqdroite = freq;
		this.freqgauche = freq;
	}

}
