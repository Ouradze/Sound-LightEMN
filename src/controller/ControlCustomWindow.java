package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;

import model.CustomShape;
import model.ListShapes;
import processing.core.*;

public class ControlCustomWindow implements MouseListener, MouseMotionListener{
	
	CustomShape currentShape = new CustomShape();
	ListShapes allShapes = new ListShapes();
	PVector currentVertex = new PVector();
	
	public ControlCustomWindow(CustomShape c){
		this.currentShape = c;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		
		CustomShape add = new CustomShape();
		
		if(allShapes.get(0).getChild(0) != null && currentShape.detect((PShape)(arg0.getSource()))){
			currentVertex = allShapes.get(0).getVertex(0);
			
			CustomShape shape = (CustomShape)allShapes.get(0);
			
			currentVertex = shape.getVertex(0);
			
			add.vertex(currentVertex.x,currentVertex.y);
			
			shape.addChild(add);
		}
		else{
			add.vertex(currentVertex.x,currentVertex.y);
			//Line2D shape = ( Line2D ) currentLine;
			//shape.setLine ( shape.getP1 (), e.getPoint () );
			//repaint ();
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		//currentLine = null;
		//System.out.println(currentShape.isComplete());
		
	}
}
