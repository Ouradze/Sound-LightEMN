package utils;

public class Point {

	public float x;
	public float y;
	public float z;

	public Point() {
		this.x = 0;
		this.y = 0;
		this.z = 0;

	}

	public Point(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public float x() {
		return this.x;
	}

	public float y() {
		return this.y;
	}

	public float z() {
		return this.z;
	}
	
	public void decaler(float x, float y, float z) {
		this.x += x;
		this.y += y;
		this.z += z;
	}
	
	public String toString(){
		return "("+this.x+","+this.y+","+this.z+")";
		
		
	}

}
