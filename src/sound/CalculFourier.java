package sound;

import ddf.minim.*;
import ddf.minim.analysis.*;

import processing.core.PApplet;

public class CalculFourier {

	public float samplerate;
	public int buffersize;
	public AudioBuffer gauche;
	public AudioBuffer droite;
	public AudioBuffer centre;
	public static final int DROITE = 1;
	public static final int CENTRE = 0;
	public static final int GAUCHE = -1;
	public float valmax;

	

	public CalculFourier(AudioSource s) {
		this.samplerate = s.sampleRate();
		this.buffersize = s.bufferSize();
		this.gauche = s.left;
		this.droite = s.right;
		this.centre = s.mix;

	
	}

	public void majBuff(AudioSource s) {
		this.gauche = s.left;
		this.droite = s.right;
		this.centre = s.mix;

	}

	public float[] getFreq(int sortie) {
		FFT fourier = new FFT(buffersize, samplerate);
		fourier.window(FFT.HAMMING);
		fourier.logAverages(60, 10);

		switch (sortie) {
		case CalculFourier.GAUCHE:
			fourier.forward(this.gauche);
			break;
		case CalculFourier.CENTRE:
			fourier.forward(this.centre);
			break;
		case CalculFourier.DROITE:
			fourier.forward(this.droite);
			break;
		}

		float[] freq = new float[fourier.avgSize()];

		for (int i = 0; i < fourier.avgSize(); i++) {
			freq[i] = fourier.getAvg(i);

		}
		//this.max(freq);
		return freq;

	}

	

	// Rapporte les amplitudes en fontion de la racine carrÃ©e de leur position
	// sur le spectre (amortissement des basses, cf courbe de la fction)
	public static float[] QuadScaling(float[] f) {
		float[] nf = new float[f.length];

		for (int i = 0; i < f.length; i++) {
			float quot = (float) ((float) (i) / (float) (f.length));

			nf[i] = (float) (f[i] * (Math.sqrt(quot)));

		}
		return nf;
	}

	

	public static float[] CutScaling(float[] f, float a) {
		float[] nf = new float[f.length];

		float moyenne = moyenne(f);

		for (int i = 0; i < f.length; i++) {
			if (f[i] > a * moyenne) {
				nf[i] = (f[i] - a * moyenne);
			} else {
				nf[i] = 0;
			}

		}

		return nf;
	}

	

	public static float[] regrouper(float[] f, int n) {
		// Réduit la taille du tableau à f à un tableau de taille n comportant
		// les moyennes des n sections de f.
		int l = f.length / n;
		float[] freq = new float[n];
		float[] temp = new float[l];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < l; j++) {
				temp[j] = f[j + i * l];

			}
			freq[i] = CalculFourier.moyenne(temp);
		}
		return freq;
	}

	public static float moyenne(float[] f) {
		float moyenne = 0;
		for (int i = 0; i < f.length; i++) {
			moyenne += f[i];
		}
		moyenne = moyenne / f.length;
		return moyenne;
	}
	
	public void max(float[] f){
		
		
		for(int i=0; i<f.length;i++){
			this.valmax =  Math.max(this.valmax, f[i]);
		}
		System.out.println(""+this.valmax);
		
	}
	
	

	
}
