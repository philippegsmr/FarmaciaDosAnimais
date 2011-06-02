package edu.uwec.cs.sheaffmc.program4;

import java.awt.*;
import java.io.Serializable;

public abstract class PaintingPrimative implements Serializable {

	protected Color color;
	
	public PaintingPrimative(Color c) {
		color = c;
	}
	
	public void setColor(Color c) {
		color = c;
	}
	
	public final void draw(Graphics g) {
		g.setColor(this.color);
		drawGeometry(g);
	}
	
	
	protected abstract void drawGeometry(Graphics g);
	
	public abstract String toString();
}
