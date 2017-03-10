package gla.joose.birdsim.pieces;

import java.awt.Color;

/**
 * A Bird piece.
 */
public class Bird extends Piece {
    
    public Color color;
    
    /**
     * Hatches a <code>Bird</code>.
     **/
    public Bird() {
    	color = Color.green;
    }
    
    /**
     * Hatches a <code>Bird</code> of the given color.
     * 
     * @param color The <code>Color</code> of the new piece.
     **/
     Bird(Color color) {
        this.color = color;
    }
    
    
}