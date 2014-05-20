package processing;

import java.awt.Container;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import model.CustomDesign;
import model.ListShapes;
import processing.core.PApplet;
import sound.AudioHandler;
import sound.Fourier;
import utils.Equalizer;
import view.ControlCustomFormWindow;
import design.Barre;
import design.Design;
import design.Lumieres;

public class CustomProcessing extends PApplet {

	private Container parent;

	CustomDesign currentShape = new CustomDesign(this);

	private ListShapes allShapes = new ListShapes(currentShape);

	private CustomDesign s = new CustomDesign(this);

	AudioHandler audio;

	protected boolean troisD;
	Fourier fourier;
	Design form;
	Equalizer eq;
	Lumieres l;
	int i;
	Barre b;
	long timer;

	public CustomProcessing(Container parent) {
		super();
		this.parent = parent;
	}

	public void majSong(String path) {

		audio.majSong(path);
		audio.switchToSong();
		System.out.println(audio.toString());
	}

	public void majInput() {
		audio.switchToInput();
		System.out.println(audio.toString());
	}

	public void setup() {
		size(this.parent.getWidth(), this.parent.getHeight(), P2D);

		audio = new AudioHandler(this);

		fourier = new Fourier(audio);
		fourier.maj();
		l = new Lumieres(this);

		i = 0;
		timer = 0;
	}

	public void draw() {

		this.noFill();
		this.stroke(255);
		this.background(0);

		if (allShapes != null) {
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
		if (SwingUtilities.isLeftMouseButton(e)) {
			if (currentShape.getPoints().size() != 0
					&& currentShape.detect(e.getPoint(), 10)) {
				currentShape.add(e.getX(), e.getY());
				this.currentShape = new CustomDesign(this);
				allShapes.add(currentShape);
			} else {
				currentShape.add(e.getX(), e.getY());
			}
		}
		if (SwingUtilities.isRightMouseButton(e)) {

			for (int i = 0; i < allShapes.size(); i++) {
				ArrayList<Point> list = allShapes.get(i).getPoints();
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).distance(e.getPoint()) < 10) {
						CustomDesign p = allShapes.get(i);

						ControlCustomFormWindow c = new ControlCustomFormWindow(
								p);
						c.setVisible(true);

					}
				}
			}
		}

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
