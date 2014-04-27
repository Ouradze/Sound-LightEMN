package model;

import processing.core.PShape;

public class CustomShape extends PShape{
	
	private boolean complete = false;
	
	public CustomShape(){
		this.complete = false;
	}
	
	public boolean detect(int x, int y){
		
		 PShape first = this.getChild(0);
		 PShape p = new PShape();
		 p.vertex(x, y);
		
		if(first.getVertex(0).dist(p.getVertex(0)) < 10.0 && this.getChildCount() > 2){
			this.complete = true;
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isComplete(){
		return this.complete;
	}
}
