package sound;

public class Lissage {

	public static final float[] coefscubiques = { -(float) (3) / 35,
			(float) (12) / 35, (float) (17) / 35, (float) (12) / 35,
			-(float) (3) / 35 };
	public static final float[] coefsquad = { (float) (-21) / 231,
			(float) (14) / 231, (float) (39) / 231, (float) (54) / 231,
			(float) (59) / 231, (float) (54) / 231, (float) (39) / 231,
			(float) (14) /231, (float) (-21) / 231 };

	public static float[] Lissercubique(float[] f) {

		float[] freq = new float[f.length];
		for (int i = 2; i < freq.length - 2; i++) {
			float somme = 0;
			for (int j = 0; j < 3; j++) {
				somme += f[i + j - 2] * Lissage.coefscubiques[j];
			}
			freq[i] = somme;
		}

		return freq;
	}

	public static float[] Lisserquad(float[] f) {

		float[] freq = new float[f.length];
		for (int i = 1; i < freq.length -1; i++) {
			if (i < 8 || i >= freq.length - 8) {
				freq[i] = f[i];
			} else {
				float somme = 0;
				for (int j = 0; j < 9; j++) {
					somme += f[i + j - 8] * Lissage.coefsquad[j];
				}
				freq[i] = somme;
			}
		}

		return freq;
	}

}
