package design;

import processing.core.PApplet;

public class Shape extends Design {
	String shape;

	public Shape(PApplet p, int x, int y, int z, String s) {
		super(p, x, y, z);
		this.shape = s;

	}

	public void scale() {

	}

	@Override
	public void display() {

		parent.loadShape(shape);

	}

}
