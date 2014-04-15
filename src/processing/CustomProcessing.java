package processing;

import java.awt.Container;
import java.awt.Point;
import java.util.ArrayList;

import model.CustomDesign;
import model.ListShapes;
import processing.core.PApplet;
import processing.core.PShape;

public class CustomProcessing extends PApplet {

	private Container parent;

	CustomDesign currentShape = new CustomDesign(this);

	private ListShapes allShapes = new ListShapes(currentShape);

	private CustomDesign s = new CustomDesign(this);

	public CustomProcessing(Container parent) {
		super();
		this.parent = parent;
	}

	public void setup() {
		size(this.parent.getWidth(), this.parent.getHeight(), P2D);
	}

	public void draw() {

		this.noFill();
		this.stroke(255);
		this.background(0);

		if (allShapes != null) {

			PShape a = new PShape();

			/*
			 * a = createShape(); a.beginShape(); a.fill(0, 0, 255);
			 * a.noStroke(); a.vertex(0, 0); a.vertex(0, 50); a.vertex(50, 50);
			 * a.vertex(50, 0); a.endShape(CLOSE);
			 */

			// this.shape(a);
			for (int i = 0; i < allShapes.size(); i++) {
				allShapes.get(i).display();
			}
		}
	}

	@Override
	public void mouseDragged(java.awt.event.MouseEvent e) {
		for (int i = 0; i < allShapes.size(); i++) {
			ArrayList<Point> list = allShapes.get(i).getPoints();
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).distance(e.getPoint()) < 10) {
					list.get(j).move(e.getX(), e.getY());
				}
			}
		}
	}

	@Override
	public void mouseMoved(java.awt.event.MouseEvent e) {

	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {

	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {

	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {

	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		if (currentShape.getPoints().size() != 0
				&& currentShape.detect(e.getPoint(), 10)) {
			currentShape.add(e.getX(), e.getY());
			this.currentShape = new CustomDesign(this);
			allShapes.add(currentShape);
		} else {
			currentShape.add(e.getX(), e.getY());
		}
		System.out.println("Added, X " + e.getX() + " Y " + e.getY());
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {

	}

}
