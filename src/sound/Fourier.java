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
		return this.freqgauche;
	}

	public float[] getCentre() {
		return this.freqcentre;
	}

	public float[] getDroite() {
		return this.freqdroite;
	}
	
	public void maj(){
		cFourier.majBuff(audio.getAudio());
		this.freqgauche = this.cFourier.getFreq(CalculFourier.GAUCHE);
		this.freqcentre = this.cFourier.getFreq(CalculFourier.CENTRE);
		this.freqdroite = this.cFourier.getFreq(CalculFourier.DROITE);
	}

}
