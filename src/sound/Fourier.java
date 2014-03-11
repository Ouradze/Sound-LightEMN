package sound;



import ddf.minim.*;
import ddf.minim.analysis.*;


import processing.core.PApplet;

public class Fourier {

	public float samplerate;
	public int buffersize;
	public AudioBuffer gauche;
	public AudioBuffer droite;

	public PApplet parent;

	public Fourier(AudioSource s, PApplet p) {
		this.samplerate = s.sampleRate();
		this.buffersize = s.bufferSize();
		this.gauche = s.left;
		this.droite = s.right;

		this.parent = p;

	}

	public void majBuff(AudioSource s) {
		this.gauche = s.left;
		this.droite = s.right;

	}

	public float[] getFreqg() {
		FFT fourierg = new FFT(buffersize, samplerate);
		fourierg.window(FFT.HAMMING);
		fourierg.logAverages(60, 10);

		fourierg.forward(this.gauche);

		float[] freqg = new float[fourierg.avgSize()];

		for (int i = 0; i < fourierg.avgSize(); i++) {
			freqg[i] = fourierg.getAvg(i);

		}

		return freqg;

	}

	public float[] getFreqd() {
		FFT fourierd = new FFT(buffersize, samplerate);
		fourierd.window(FFT.BARTLETT);
		fourierd.logAverages(60, 10);

		fourierd.forward(this.droite);

		float[] freqd = new float[fourierd.avgSize()];

		for (int i = 0; i < fourierd.avgSize(); i++) {
			freqd[i] = fourierd.getAvg(i);

		}

		return freqd;

	}

	//Diminue les "pics" d'intensité : si l'amplitude dépasse  a*moyenne, celle-ci est amortie de b fois la distance à la moyenne
	//Par conséquent : a>=1 et 0 <= b <=1 pour rester cohérent
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
	
	//Rapporte les amplitudes en fontion de la racine carrée de leur position sur le spectre (amortissement des basses, cf courbe de la fction)
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
			
			nf[i] = (float) (f[i] * (1-Math.exp(-quot)));

		}
		return nf;
	}
	public static float[] CutScaling(float[] f, float a){
		float[] nf = new float[f.length];

		float moyenne = moyenne(f);

		for (int i = 0; i < f.length; i++) {
			if (f[i] > a * moyenne) {
				nf[i] = (f[i]-a*moyenne);
			} else {
				nf[i] = 0;
			}

		}

		return nf;
	}
	public static float moyenne(float[] f) {
		float moyenne = 0;
		for (int i = 0; i < f.length; i++) {
			moyenne += f[i];
		}
		moyenne = moyenne / f.length;
		return moyenne;
	}
}
