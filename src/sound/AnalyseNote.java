package sound;

import java.util.ArrayList;

import sound.*;

public class AnalyseNote {
	
	Fourier four;
	float[] fregbrute;
	float samplerate;
	float moyenne;
	ArrayList<ArrayList<Integer>> Liste_of_note = new ArrayList<>();
	
	

	public AnalyseNote(){}
	
	public void maj(float[] tab , float samplerate){
		this.fregbrute=tab;
		this.moyenne=CalculFourier.moyenne(tab);
		this.samplerate=samplerate;
		epure();
		for(int i=0; i<12 ; i++){
			ArrayList<Integer> tab2 = new ArrayList<Integer>();
			for(int j = 0; j<10 ; j++){
				if(this.fregbrute[12*j+i]!=0){
					tab2.add(j);
				}
			}
			this.Liste_of_note.add(tab2);
		}
		
		detectHarmonic();
	}
	
	public void epure(){
		for( int i=0;i<this.fregbrute.length;i++){
			if(this.fregbrute[i]<(this.moyenne)){
				this.fregbrute[i]=0;
			}
		}
	}
	
	public void detectHarmonic(){
	ArrayList<Integer> curent_Array = new ArrayList<Integer>();
		for(int i= 0; i<this.Liste_of_note.size();i++){
			curent_Array=this.Liste_of_note.get(i);
			for(int j=0 ; j<curent_Array.size() ; j++){
				try{
					if(!(curent_Array.get(j+1)==curent_Array.get(j)+1||curent_Array.get(j-1)==curent_Array.get(j)-1)){
						this.fregbrute[12*curent_Array.get(j)+i]=0;
					}
				}
				catch(Exception e){
					//e.printStackTrace();
				}
			}
			
		}
	}
	
	public float[] getFFTepure(){
		return this.fregbrute;
	}
	
	public float[][] getMatrice(){
		float[][] f =  new float[12][50];
		f[6][25] = 1;
		return f;
	}
}
