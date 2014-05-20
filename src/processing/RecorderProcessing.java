package processing;

import java.awt.Container;

import processing.core.PGraphics;

public class RecorderProcessing extends AbstractProcessing {

	PGraphics p;
	AbstractProcessing model;

	public RecorderProcessing(Container parent) {
		super(parent);

	}

	public void majForme(String s, String path) {

	}

	@Override
	public void setup() {
		p = model.recorder;
	}

	@Override
	public void draw() {

		p.beginDraw();
		p.endDraw();

	}

	public void setModel(AbstractProcessing model) {
		if (!(model instanceof RecorderProcessing)) {
			this.model = model;
			p = model.recorder;
		}

	}

}
