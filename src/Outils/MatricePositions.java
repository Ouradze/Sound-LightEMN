package Outils;

public class MatricePositions {

	private Point[][] points;
	private int longueur;
	private int profondeur;
	private int largeur; // distance entre deux points
	public int positionX;
	public int positionY;
	public int positionZ;

	public MatricePositions(int i, int j, int largeur) {
		this.profondeur = i;
		this.longueur = j;
		this.points = new Point[i][j];
		this.largeur = largeur;
		this.initMatrice();
	}

	public void majMatrice(FileFreq f) {
		if (f.getsize() >= 1) {

			for (int j = 0; j < f.getsize(); j++) {
				float[] f1 = f.getIndex(j);
				
				for (int i = 0; i < this.longueur; i++) {
					this.points[j][i].y = (float) (positionY - 2.5 * f1[i]*this.largeur/12);
				}

			}

		}
	}

	public void initMatrice() {
		
		for (int i = 0; i < this.profondeur; i++) {
			for (int j = 0; j < this.longueur; j++) {
				
				this.points[i][j] = new Point( (j - this.longueur/2)* this.largeur,0 ,  - this.largeur * (i));
			}
		}
	}

	public void majPositions(int x, int y, int z) {
		float deltaX = x - this.positionX;
		float deltaY = y - this.positionY;
		float deltaZ = z - this.positionZ;
	
		if (deltaX != 0 || deltaY != 0 || deltaZ != 0) {
			for (int j = 0; j < this.profondeur; j++) {
				for (int i = 0; i < this.longueur; i++) {
					this.points[j][i].decaler(deltaX, deltaY, deltaZ);
				}
			}
		}
		this.positionX =  x;
		this.positionY =  y;
		this.positionZ =  z;
	}
	
	public void majLargeur(int largeur){
		this.largeur = largeur;
		for (int i = 0; i < this.profondeur; i++) {
			for (int j = 0; j < this.longueur; j++) {
				this.points[i][j].x = positionX + (j - this.longueur / 2)
						* this.largeur;
						
				points[i][j].z = positionZ - this.largeur * (i);
			}
		}
	}

	public Point getPoint(int i, int j) {
		return this.points[i][j];
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < this.profondeur; i++) {
			for (int j = 0; j < this.longueur; j++) {
				s += this.points[i][j];
			}
			s += '\n';
		}
		return s;
	}
	
	public int getLongueur(){
		return this.longueur;
	}

}
