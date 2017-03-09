package gla.joose.birdsim.pieces;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import behaviours.PaintBehaviour;

public class PaintGrain implements PaintBehaviour {

	public void paint(Graphics g, Rectangle r, Piece p) {
		if(p.getClass() == PoisonGrain.class){
			PoisonGrain gr = (PoisonGrain) p;
	        g.setColor(Color.blue);
	        g.fillOval(r.x, r.y, r.width, r.height);
		}		
	}


}
