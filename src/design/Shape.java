package design;

import processing.core.PApplet;
import processing.core.PShape;

public class Shape extends Design {
	PShape shape;
	
	public Shape(PApplet p, int x, int y, int z, PShape ps ) {
		super(p, x, y, z);
		this.shape = ps;
		
	}

	
	public void scale() {
		
		
	}

	@Override
	public void display() {
		
		parent.loadShape(shape.getName());
		
		
	}

}
