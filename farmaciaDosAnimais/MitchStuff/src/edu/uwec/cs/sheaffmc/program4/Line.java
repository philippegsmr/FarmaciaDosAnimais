package edu.uwec.cs.sheaffmc.program4;

import java.awt.*;
import java.io.Serializable;

public class Line extends PaintingPrimative implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Point startPoint;
	private Point endPoint;
	
	public Line() {
		this(Color.WHITE, null, null);
	}

	public Line(Color c, Point start, Point end) {
		super(c);
		startPoint = start;
		endPoint = end;
	}
	
	public void drawGeometry(Graphics g) {
		g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
	}

	@Override
	public String toString() {
		return ("line");
	}
	
	public boolean equals(Object o) {
		Line c = (Line) o;
		
		return (this.color.equals(c.color) &&
				this.startPoint.equals(c.startPoint) &&
				this.endPoint.equals(c.endPoint));
	}
	
}
