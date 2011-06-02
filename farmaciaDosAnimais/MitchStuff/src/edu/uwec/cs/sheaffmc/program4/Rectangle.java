package edu.uwec.cs.sheaffmc.program4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

public class Rectangle extends PaintingPrimative implements Serializable{

	private static final long serialVersionUID = 1L;
	private Point startPoint;
	private Point endPoint;
	
	public Rectangle() {
		this(Color.WHITE, null, null);
	}
	
	public Rectangle(Color c, Point start, Point end) {
		super(c);
		startPoint = start;
		endPoint = end;
	}

	@Override
	protected void drawGeometry(Graphics g) {
		int startX = startPoint.x;
		int startY = startPoint.y;
		int endX = endPoint.x;
		int endY = endPoint.y;
		
		if (endPoint.x < startPoint.x) {
			startX = endPoint.x;
			endX = startPoint.x;
		}
		if (endPoint.y < startPoint.y) {
			startY = endPoint.y;
			endY = startPoint.y;
		}
		
		g.drawRect(startX, startY, Math.abs(endX - startX), Math.abs(endY - startY));
	}
	
	@Override
	public String toString() {
		return ("rectangle");
	}
	
	public boolean equals(Object o) {
		Rectangle c = (Rectangle) o;
		
		return (this.color.equals(c.color) &&
				this.startPoint.equals(c.startPoint) &&
				this.endPoint.equals(c.endPoint));
	}

}
