package model;

import java.util.ArrayList;

import processing.core.*;

public class ListShapes extends ArrayList<CustomShape>{

	private CustomShape currentShape;
	
	public ListShapes(){
		this.currentShape = null;
	}
	
	public ListShapes(CustomShape c){
		this.currentShape = c;
	}

	public void setCurrentShape(CustomShape p){
		this.currentShape = p;
	}

	public PShape getCurrentShape(){
		return this.currentShape;
	}

}
