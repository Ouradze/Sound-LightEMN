package Outils;

import sound.CalculFourier;

public class MatriceFreq {

	public float[] freq;
	public int n;
	public float[][] matrice;

	public MatriceFreq(float[] f, int i) {
		this.freq = CalculFourier.regrouper(f, i);
		this.n = i;
		this.construireMatriceCarresConcentriques();
	}

	public void construireMatriceCarresConcentriques() {
		this.matrice = new float[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n - i; j++) {

				float f = this.freq[i];
				matrice[i][j] = f;
				matrice[j][i] = f;
				matrice[n - i - 1][n - j - 1] = f;
				matrice[n - j - 1][n - i - 1] = f;
			}
		}

	}

	public void construireMatriceNulle() {
		this.matrice = new float[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				matrice[i][j] = 0;


			}
		}
	}

	public void afficher() {


		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(" " + this.matrice[i][j]);
			}
			System.out.println("");
		}

	}

	public float get(int i, int j) {

		return this.matrice[i][j];
	}

}
