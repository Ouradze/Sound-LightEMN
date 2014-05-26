package sound;

import java.io.IOException;
import java.util.ArrayList;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioSource;
import ddf.minim.analysis.FFT;

public class AnalyseNote {

	public AudioBuffer audios;
	public ArrayList<Float> list;
	public static double[] fond = { 32.7, 34.65, 36.71, 38.89, 41.20, 43.65,
			46.25, 49, 51.91, 55, 58.27, 61.74 };

	public float samplerate;

	public float[] outfft;
	public float[][] outfft_note;
	public float[] mean_note;
	public float[] PCP;

	public int N;
	public static double[] coef = { 0.091743119, 0.091743119, 0.084097859,
			0.084097859, 0.086009174, 0.086009174, 0.085053517, 0.085531346,
			0.085411888, 0.08535216 };

	public AnalyseNote() throws IOException {

		this.N = 4096;
		this.list = new ArrayList<Float>(this.N);
		this.PCP = new float[12];
		this.outfft = new float[this.N];
		this.outfft_note = new float[12][100];

		for (int i = 0; i < this.N; i++) {
			this.list.add((float) 0);
		}

	}

	public void maj(AudioSource audio) {

		this.audios = audio.mix;
		this.N = (int) this.samplerate;
		for (int i = 0; i < this.audios.size(); i++) {
			this.list.remove(0);
			this.list.add(this.audios.get(i));
		}
		float[] A = array(this.list);
		FFT fft = new FFT(A.length, this.samplerate);
		fft.window(FFT.HAMMING);
		float val_max = 0;
		fft.forward(A);
		float sup = 0;
		for (int i = 0; i < fft.specSize(); i++) {
			this.outfft[i] = fft.getBand(i);
			if (this.outfft[i] > sup) {
				sup = this.outfft[i];
			}
		}

		for (int i = 0; i < 12; i++) {
			float PCPi = 0;
			int nb = 0;
			for (int j = 3; j < 10; j++) {
				for (int k = (int) ((coef[j]) * (fond[i] - 0.5) * (Math.pow(2,
						j))); k <= (int) ((coef[j]) * (fond[i] + 0.5) * (Math
						.pow(2, j))); k++) {

					PCPi = PCPi + outfft[k];
					nb++;

				}
			}
			PCP[i] = PCPi / nb;
		}
		for (int i = 0; i < PCP.length; i++) {
			if (PCP[i] >= val_max) {
				val_max = PCP[i];
			}
		}
		if (val_max != 0) {
			for (int i = 0; i < PCP.length; i++) {
				PCP[i] = PCP[i] / val_max;
			}
		}
		for (int j = 0; j < 12; j++) {
			for (int i = 99; i > 0; i = i - 1) {
				this.outfft_note[j][i] = this.outfft_note[j][i - 1];
			}
		}
		for (int j = 0; j < 12; j++) {
			this.outfft_note[j][0] = this.PCP[j];
		}
	}

	public float[][] getMatrice() {
		return this.outfft_note;
	}

	public float[] array(ArrayList<Float> q) {
		float[] A = new float[q.size()];
		for (int i = 0; i < q.size(); i++) {
			A[i] = q.get(i);
		}
		return A;
	}

	public float[] getPCP() {

		return this.PCP;
	}

	public float[] linear_fn(float[] a) {
		float b = 0;
		float val_max = 0;
		float val_min = 0;

		float[] out = new float[a.length];
		for (int i = 0; i < a.length; i++) {
			b = b + a[i];
			if (out[i] >= val_max) {
				val_max = a[i];
			}
			if (out[i] <= val_min) {
				val_min = a[i];
			}
		}
		b = b / a.length;

		for (int i = 0; i < a.length; i++) {
			if (a[i] > (99.99 / 100) * b) {
				out[i] = 300 * a[i];
			} else {
				out[i] = 0;
			}
		}
		return out;
	}

	public float[] getFFT() {
		return this.outfft;
	}

}