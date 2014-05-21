package model;

import java.util.ArrayList;

import design.Design;

/**
 * 
 * @author mehdi Class containing all the shapes used in the class CustomDesign
 */
public class ListShapes extends ArrayList<CustomDesign> {
	/**
	 * Shape currently created
	 */
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
