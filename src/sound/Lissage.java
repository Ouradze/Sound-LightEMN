package sound;

public class Lissage {
	
	public static final float[] coefs = {-(float)(3)/35,(float)(12)/35,(float)(17)/35,(float)(12)/35,-(float)(3)/35};
	
	
	public static float[] Lisser(float[] f){
		
		float[] freq = new float[f.length];
		for(int i=2; i <freq.length-2;i++){
			float somme= 0;
			for(int j=0; j<3;j++){
				somme+=f[i+j-2]*Lissage.coefs[j];
			}
			freq[i]=somme+1-1;
		}
		
		return freq;
	}
	
	
	
	


}
