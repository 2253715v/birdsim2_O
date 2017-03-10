package gla.joose.birdsim.boards;

import behaviours.UpdateStockBehaviour;

public class FlockUpdate implements UpdateStockBehaviour{
	public void doUpdateStock(Board b) {
		if(b.getClass() == FlockBoard.class ){
		FlockBoard fb = (FlockBoard)b;
		fb.updateStock();
		fb.noOfBirdsLabel.setText("#birds: " + fb.noofbirds);
		}
	}
}
