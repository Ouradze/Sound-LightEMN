package model;

import java.util.ArrayList;

import design.Design;

public class ListShapes extends ArrayList<CustomDesign> {

	private CustomDesign currentShape;

	public ListShapes() {
		this.currentShape = null;
	}

	public ListShapes(CustomDesign c) {
		this.currentShape = c;
		this.add(currentShape);
	}

	public void setCurrentShape(CustomDesign p) {
		this.currentShape = p;
	}

	public Design getCurrentShape() {
		return this.currentShape;
	}

}
