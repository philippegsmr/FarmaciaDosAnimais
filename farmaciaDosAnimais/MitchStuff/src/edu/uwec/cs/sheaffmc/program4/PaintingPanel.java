package edu.uwec.cs.sheaffmc.program4;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class PaintingPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private ArrayList<PaintingPrimative> list;
	private PaintingPrimative tempPrimative;

	public PaintingPanel() {
		list = new ArrayList<PaintingPrimative>();
		tempPrimative = null;
	}

	public void addPrimative(PaintingPrimative p) {
		this.list.add(p);
	}

	public void removePrimative(PaintingPrimative p) {
		this.list.remove(p);
	}

	public void setTempPrimative(PaintingPrimative p) {
		this.tempPrimative = p;
		repaint();
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (tempPrimative != null) {
			tempPrimative.draw(g);
		}
		if (list != null) {
			for(PaintingPrimative p : list) {
				p.draw(g);
			}
		}
	}

	public void setList(ArrayList<PaintingPrimative> paintingList) {
		list = paintingList;
	}


}
