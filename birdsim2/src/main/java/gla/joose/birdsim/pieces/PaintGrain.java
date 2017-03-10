package gla.joose.birdsim.pieces;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import behaviours.PaintBehaviour;

public class PaintGrain implements PaintBehaviour {

	public void paint(Graphics g, Rectangle r, Piece p) {
		if(p.getClass() == Grain.class){
			Grain gr = (Grain) p;
			int color = Color.HSBtoRGB(1, gr.remaining, 1);
	        g.setColor(new Color(color));
	        g.fillOval(r.x, r.y, r.width, r.height);
		}		
	}


}
