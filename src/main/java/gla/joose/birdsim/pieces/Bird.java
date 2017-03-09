package gla.joose.birdsim.pieces;

import java.awt.Color;

/**
 * A Bird piece.
 */
public class Bird extends Piece {
    
    public Color color;
    public int counter;
    
    /**
     * Hatches a <code>Bird</code>.
     **/
    public Bird() {
    	color = Color.green;
    	counter = 0;
    }
    
    /**
     * Hatches a <code>Bird</code> of the given color.
     * 
     * @param color The <code>Color</code> of the new piece.
     **/
     Bird(Color color) {
        this.color = color;
    }
    public int count(){return counter++;}
    public int reset(){return counter=0;}
    
}