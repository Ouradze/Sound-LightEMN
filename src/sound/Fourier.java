package sound;

public class Fourier {

	AudioHandler audio;
	CalculFourier cFourier;

	private float[] freqgauche;
	private float[] freqcentre;
	private float[] freqdroite;

	public Fourier(AudioHandler audio) {
		this.audio = audio;
		this.cFourier = new CalculFourier(audio.getAudio());
	}

	public float[] getGauche() {
		return this.cFourier.getFreq(CalculFourier.GAUCHE);
	}

	public float[] getCentre() {
		return this.cFourier.getFreq(CalculFourier.CENTRE);
	}

	public float[] getDroite() {
		return this.cFourier.getFreq(CalculFourier.DROITE);
	}

}
