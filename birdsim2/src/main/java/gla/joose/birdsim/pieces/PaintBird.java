package gla.joose.birdsim.pieces;

import java.awt.Graphics;
import java.awt.Rectangle;

import behaviours.PaintBehaviour;

public class PaintBird implements PaintBehaviour {

	public void paint(Graphics g, Rectangle r, Piece p) {
			if(p.getClass() == Bird.class){
				Bird b = (Bird) p;
				g.setColor(b.color);
				g.fillArc(r.x, r.y, r.width, r.height, 50, 270);
			}
	}

	
}