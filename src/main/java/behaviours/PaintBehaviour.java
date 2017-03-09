package behaviours;

import java.awt.Graphics;
import java.awt.Rectangle;

import gla.joose.birdsim.pieces.Piece;

public interface PaintBehaviour {
	/**
     * Paints this piece on the board within the given rectangle;
     * must be implemented by a subclass.
     * 
     * @param g The Graphics object on which painting should be done.
     * @param r The rectangle in which to paint this piece.
     */
	public void paint(Graphics g, Rectangle r,Piece p);
	
}
