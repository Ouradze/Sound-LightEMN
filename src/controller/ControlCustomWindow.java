package controller;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import model.CustomShape;
import model.ListShapes;
import processing.core.PApplet;
import processing.core.PVector;

/**
 * 
 * @author Mehdi Raddadi
 * 
 */
public class ControlCustomWindow implements MouseListener, MouseMotionListener {

	private PApplet parent;

	CustomShape currentShape = new CustomShape();
	ListShapes allShapes = new ListShapes();
	PVector currentVertex = new PVector();

	public ControlCustomWindow(PApplet p) {
		this.parent = p;
	}

	@Override
	public void mouseDragged(java.awt.event.MouseEvent e) {
		CustomShape add = new CustomShape();

		/*
		 * if (allShapes.get(0).getChild(0) != null &&
		 * currentShape.detect(e.getPoint().x, e.getPoint().y)) { currentVertex
		 * = allShapes.get(0).getVertex(0);
		 * 
		 * CustomShape shape = (CustomShape) allShapes.get(0);
		 * 
		 * currentVertex = shape.getVertex(0);
		 * 
		 * add.vertex(currentVertex.x, currentVertex.y);
		 * 
		 * shape.addChild(add); } else { currentVertex =
		 * this.currentShape.getChild( currentShape.getChildCount() -
		 * 1).getVertex(0); add.vertex(currentVertex.x, currentVertex.y); }
		 */

	}

	@Override
	public void mouseMoved(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("CLICK");

	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {

		CustomShape add = new CustomShape();

		if (allShapes.getCurrentShape() == null || currentShape.isComplete()) {

			currentShape = new CustomShape();
			// allShapes.add(currentShape);
			// allShapes.setCurrentShape(currentShape);
			add.vertex(e.getX(), e.getY());
			// currentLine = new Line2D.Double (e.getPoint () , e.getPoint () );
		} else {
			float x = currentShape.getChild(currentShape.getChildCount() - 1)
					.getVertexX(0);
			System.out.println("x : " + x);
			add.vertex(e.getX(), e.getY());
		}

		currentShape.addChild(add);
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		currentVertex = null;
		System.out.println(currentShape.isComplete());

	}
}
