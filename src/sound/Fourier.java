package sound;

import ddf.minim.*;
import ddf.minim.analysis.*;

import processing.core.PApplet;

public class Fourier {

	public float samplerate;
	public int buffersize;
	public AudioBuffer gauche;
	public AudioBuffer droite;
	public AudioBuffer centre;
	public static final int DROITE = 1;
	public static final int CENTRE = 0;
	public static final int GAUCHE = -1;

	public PApplet parent;

	public Fourier(AudioSource s, PApplet p) {
		this.samplerate = s.sampleRate();
		this.buffersize = s.bufferSize();
		this.gauche = s.left;
		this.droite = s.right;
		this.centre = s.mix;

		this.parent = p;

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
		case Fourier.GAUCHE:
			fourier.forward(this.gauche);
			break;
		case Fourier.CENTRE:
			fourier.forward(this.centre);
			break;
		case Fourier.DROITE:
			fourier.forward(this.droite);
			break;
		}

		float[] freq = new float[fourier.avgSize()];

		for (int i = 0; i < fourier.avgSize(); i++) {
			freq[i] = fourier.getAvg(i);

		}

		return freq;

	}

	// Diminue les "pics" d'intensité : si l'amplitude dépasse a*moyenne,
	// celle-ci est amortie de b fois la distance à la moyenne
	// Par conséquent : a>=1 et 0 <= b <=1 pour rester cohérent
	public static float[] scaling(float[] f, double a, double b) {
		float[] nf = new float[f.length];

		float moyenne = moyenne(f);

		for (int i = 0; i < f.length; i++) {
			if (f[i] > a * moyenne) {
				float nbr = f[i] - moyenne;
				nf[i] = (float) ((f[i] - b * nbr));
			} else {
				nf[i] = f[i];
			}

		}

		return nf;

	}

	// Rapporte les amplitudes en fontion de la racine carrée de leur position
	// sur le spectre (amortissement des basses, cf courbe de la fction)
	public static float[] QuadScaling(float[] f) {
		float[] nf = new float[f.length];

		for (int i = 0; i < f.length; i++) {
			float quot = (float) ((float) (i) / (float) (f.length));

			nf[i] = (float) (f[i] * (Math.sqrt(quot)));

		}
		return nf;
	}

	public static float[] ExpScaling(float[] f) {
		float[] nf = new float[f.length];

		for (int i = 0; i < f.length; i++) {
			float quot = (float) ((float) (i) / (float) (f.length));

			nf[i] = (float) (f[i] * (1 - Math.exp(-quot)));

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

	public static float[] StandardScaling(float[] f, double a, double b,
			boolean quad) {
		float[] nf = new float[f.length];
		float moyenne = moyenne(f);
		for (int i = 0; i < f.length; i++) {
			if (f[i] > a * moyenne) {
				nf[i] = (float) ((f[i] - a * moyenne) * b);
			} else {
				nf[i] = 0;
			}
			if (quad) {
				float quot = (float) ((float) (i) / (float) (f.length));

				nf[i] = (float) (nf[i] * (Math.sqrt(quot)));
			}

		}
		return nf;
	}
<<<<<<< HEAD

	public static float[] regrouper(float[] f, int n) {

		int l = f.length / n;
		float[] freq = new float[n];
		float[] temp = new float[l];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < l; j++) {
				temp[j] = f[j + i * l];

			}
			freq[i] = Fourier.moyenne(temp);
		}
		return freq;
	}

=======
	public static float[] regrouper(float[] f, int n){
		
		int l = f.length/n;
		float[] freq =  new float[n];
		float[] temp = new float[l];
		for(int i=0; i<n;i++){
			for(int j=0; j<l;j++){
				temp[j]= f[j+i*l];
				
			}
			freq[i]=Fourier.moyenne(temp);
		}
		return freq;
	}
	
	
>>>>>>> origin/HEAD
	public static float moyenne(float[] f) {
		float moyenne = 0;
		for (int i = 0; i < f.length; i++) {
			moyenne += f[i];
		}
		moyenne = moyenne / f.length;
		return moyenne;
	}
}
