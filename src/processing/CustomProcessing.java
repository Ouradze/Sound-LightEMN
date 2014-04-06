package processing;

import java.awt.Container;

import model.CustomShape;
import processing.core.PApplet;
import processing.core.PShape;

public class CustomProcessing extends PApplet {

	private Container parent;

	private PShape s;

	public CustomProcessing(Container parent) {
		super();

		this.parent = parent;
	}

	public void setup() {
		size(this.parent.getWidth(), this.parent.getHeight(), P2D);

		// Creating a custom PShape as a square, by
		// specifying a series of vertices.
		s = createShape();
		s.beginShape();
		s.fill(0, 0, 0);
		s.noStroke();
		s.vertex(0, 0);
		s.vertex(0, 50);
		s.vertex(50, 50);
		s.vertex(50, 0);
		s.endShape(CLOSE);

	}


	public void draw() {
		shape(s, this.parent.getWidth(), this.parent.getHeight());
		
		/*for(int i = 0; i < allShapes.size();i++){
			ListPoint s = allShapes.get(i);			

			if(s.isComplete()){

				Path2D.Double path = new Path2D.Double();

				path.moveTo(((Line2D.Double)s.get(0)).getP1().getX(),((Line2D.Double)s.get(0)).getP1().getY());

				for (int j = 0; j < allShapes.get(i).size(); j++ ){
					g2d.draw(s.get(j));
					path.lineTo(((Line2D.Double)s.get(j)).getP1().getX(), ((Line2D.Double)s.get(j)).getP1().getY());

				}
				g2d.setColor(Color.WHITE);
				path.closePath();
				g2d.fill(path);
			}
			else{
				for (int j = 0; j < allShapes.get(i).size(); j++ ){
					g2d.draw(s.get(j));
				}
			}
		}*/
	}
	
	public PShape getShape(){
		return s;
	}
}
