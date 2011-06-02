package edu.uwec.cs.sheaffmc.program4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

public class Circle extends PaintingPrimative implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Point centerPoint;
	private Point radiusPoint;

	public Circle() {
		this(Color.WHITE, null, null);
	}
	
	public Circle(Color c, Point center, Point radius) {
		super(c);
		centerPoint = center;
		radiusPoint = radius;
	}
	
	public void drawGeometry(Graphics g) {
		int radius = (int) Math.abs(centerPoint.distance(radiusPoint));
		int startX = centerPoint.x;
		int startY = centerPoint.y;
		if (radiusPoint.x < centerPoint.x) {
			startX = radiusPoint.x;
		}
		if (radiusPoint.y < centerPoint.y) {
			startY = radiusPoint.y;
		}
		
		g.drawOval(startX, startY, radius, radius);
	}

	@Override
	public String toString() {
		return ("circle");
	}
	
	public boolean equals(Object o) {
		Circle c = (Circle) o;
		
		return (this.color.equals(c.color) &&
				this.centerPoint.equals(c.centerPoint) &&
				this.radiusPoint.equals(c.radiusPoint));
	}
}
