package model;

import java.util.ArrayList;

import processing.core.*;

public class ListShapes extends ArrayList<CustomShape>{

	private CustomShape currentShape;

	public void setCurrentShape(CustomShape p){
		this.currentShape = p;
	}

	public PShape getCurrentShape(){
		return this.currentShape;
	}

}
