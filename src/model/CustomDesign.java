package model;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PShape;
import design.Design;

/**
 * @author mehdi
 * 
 *         Represents the shapes used to draw the form in the Class
 *         CustomProcessing
 * 
 */
public class CustomDesign extends Design {
	/**
	 * All the point contained in the shape
	 */
	private ArrayList<Point> points;
	/**
	 * true if the shape is completed
	 */
	private boolean complete;
	/**
	 * shape color to display on the screen
	 */
	private Color color;

	/**
	 * @param parent
	 *            PApplet parent, where the shape will be displayed
	 * 
	 *            Create a custom shape with white color, not completed
	 */
	public CustomDesign(PApplet parent) {
		super(parent, 0, 0, 0);
		this.points = new ArrayList<Point>();
		this.complete = false;
		this.color = new Color(255, 255, 255);

	}

	@Override
	public void scale() {
		// TODO Auto-generated method stub

	}

	/**
	 * Method called to display the shape
	 */
	@Override
	public void display() {
		if (this.complete) {

			PShape s = parent.createShape();
			s.beginShape();

			for (int i = 1; i < points.size(); i++) {

				Point p = points.get(i);

				s.fill(this.color.getRed(), this.color.getGreen(),
						this.color.getBlue());
				s.stroke(this.color.getRed(), this.color.getGreen(),
						this.color.getBlue());
				s.vertex(p.x, p.y);
			}

			s.endShape();
			parent.shape(s);

		} else {
			for (int i = 1; i < points.size(); i++) {

				Point p1 = points.get(i - 1);
				Point p2 = points.get(i);

				parent.fill(255);
				parent.stroke(255);
				parent.line(p1.x, p1.y, p2.x, p2.y);
			}
		}

	}

	/**
	 * 
	 * @param p
	 *            Point in the shape
	 * @param d
	 *            Distance maximum between this and p
	 * @return true if p is closer to this than d
	 */
	public boolean detect(Point p, int d) {
		Point first = this.points.get(0);

		if (first.distance(p) < d && points.size() > 2) {
			this.complete = true;
			return true;
		} else {
			return false;
		}
	}

	public void setColor(Color x) {
		this.color = x;
	}

	public Color getColor() {
		return this.color;
	}

	public ArrayList<Point> getPoints() {
		return this.points;
	}

	public boolean isComplete() {
		return this.complete;
	}

	public void setComplete() {
		this.complete = true;
	}

	/**
	 * 
	 * @param x
	 *            axis
	 * @param y
	 *            axis
	 * 
	 *            Add a point to the shape
	 */
	public void add(int x, int y) {
		points.add(new Point(x, y));
	}
}
