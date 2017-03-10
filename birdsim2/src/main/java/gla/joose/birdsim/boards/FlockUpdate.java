package gla.joose.birdsim.boards;

public class FlockUpdate {
	public void doUpdateStock(Board b) {
		if(b.getClass() == FlockBoard.class ){
		FlockBoard fb = (FlockBoard)b;
		fb.updateStock();
		fb.noOfBirdsLabel.setText("#birds: " + fb.noofbirds);
		}
	}
}
