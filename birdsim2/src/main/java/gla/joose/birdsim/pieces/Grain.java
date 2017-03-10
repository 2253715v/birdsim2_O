package gla.joose.birdsim.pieces;


/**
 * A grain piece.
 */
public class Grain extends Piece {
    
    double perches =0; //the number of perches on the grain by birds
    float remaining = 1.0f; //fraction fo the grain remaining
    
    /**
     * Constructs a <code>RoundPiece</code>.
     **/
    public Grain() {
    }
    
    public void deplete(){
    	perches = perches +1;
    	remaining -= 0.05f;
    }
    
        
    public float getRemaining() {
		return remaining;
	}
}