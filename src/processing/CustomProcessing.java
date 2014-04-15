package processing;

import java.awt.Container;

import model.CustomShape;
import model.ListShapes;
import processing.core.PApplet;
import processing.core.PShape;

public class CustomProcessing extends PApplet {

	private Container parent;

	CustomShape currentShape = new CustomShape();
	PShape currentVertex = new PShape();

	private ListShapes allShapes = new ListShapes(currentShape);

	private CustomShape s = new CustomShape();

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
		if (allShapes != null) {

			PShape a = new PShape();

			a = createShape();
			a.beginShape();
			a.fill(0, 0, 255);
			a.noStroke();
			a.vertex(0, 0);
			a.vertex(0, 50);
			a.vertex(50, 50);
			a.vertex(50, 0);
			a.endShape(CLOSE);

			this.shape(a);

			for (int i = 0; i < allShapes.size(); i++) {
				s = allShapes.get(i);

				if (s.isComplete()) {
					this.shape(s);
				} else {
					this.shape(s);
				}
			}
		}
	}

	public PShape getShape() {
		return s;
	}

	@Override
	public void mouseDragged(java.awt.event.MouseEvent e) {

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

	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {

	}

}
