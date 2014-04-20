package sound;

public class Fourier {

	AudioHandler audio;
	CalculFourier cFourier;

	private float[] freqgauche;
	private float[] freqcentre;
	private float[] freqdroite;
	private double[] coefs;

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
	
	public double[] getCoefs(){
		return this.coefs;
	}
	
	public void setCoefs(double[] t){
		this.coefs =  t.clone();
		for(int i =0; i< t.length;i++){
			this.coefs[i] =  this.coefs[i]*2;
		}
		this.appliCoefs();
	}
	
	public void maj(){
		cFourier.majBuff(audio.getAudio());
		this.freqgauche = this.cFourier.getFreq(CalculFourier.GAUCHE);
		this.freqcentre = this.cFourier.getFreq(CalculFourier.CENTRE);
		this.freqdroite = this.cFourier.getFreq(CalculFourier.DROITE);
	}
	
	public void appliCoefs(){
		for(int i=0; i< coefs.length;i++){
			this.freqcentre[i] = (float) (this.coefs[i]*this.freqcentre[i]);
			this.freqgauche[i] = (float) (this.coefs[i]*this.freqgauche[i]);
			this.freqdroite[i] = (float) (this.coefs[i]*this.freqdroite[i]);
		}
	}

}
