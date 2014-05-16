package model;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PShape;
import design.Design;

public class CustomDesign extends Design {

	private ArrayList<Point> points;
	private boolean complete;
	private Color color;

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

	public void add(int x, int y) {
		points.add(new Point(x, y));
	}
}
