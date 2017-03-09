package gla.joose.birdsim.pieces;

public class PoisonGrain extends Grain {

	double perches = 0; // the number of perches on the grain by birds
	float remaining = 1.0f; // fraction fo the grain remaining

	public PoisonGrain() {
		// TODO Auto-generated constructor stub
	}

	public void deplete() {
		perches = perches + 1;
		remaining -= 0.05f;
	}

	public float getRemaining() {
		return remaining;
	}
}
