package processing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import processing.core.PGraphics;

/**
 * 
 * @author mehdi & guillaume
 * 
 *         Class which record the current image in the full Window, and display
 *         it on a second screen '/!\ Not yet functional
 * 
 */
public class RecorderProcessing extends AbstractProcessing {

	PGraphics p;

	/**
	 * ProcessingSketch Recorded
	 */
	AbstractProcessing model;

	public RecorderProcessing(Container parent) {
		super(parent);
		System.out.println("Recorder : " + parent.getWidth());
	}

	public void majForme(String s, String path) {

	}

	@Override
	public void setup() {

		p = new PGraphics();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		parent.setSize(screenSize.width, screenSize.height);
		p = createGraphics(model.displayWidth, model.displayHeight);
		System.out.println("Setup : " + parent.getWidth());

		size(this.parent.getWidth(), this.parent.getHeight(), P3D);
	}

	@Override
	public void draw() {
		model.loadPixels();
		copy(model.get(), 0, 0, model.displayWidth, model.displayHeight, 0, 0,
				this.displayWidth, this.displayHeight);
		model.updatePixels();
	}

	public void setModel(AbstractProcessing model) {
		if (!(model instanceof RecorderProcessing)) {
			this.model = model;
			p = model.recorder;
		}
	}
}
