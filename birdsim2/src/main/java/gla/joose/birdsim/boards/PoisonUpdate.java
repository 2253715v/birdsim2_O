package gla.joose.birdsim.boards;

import behaviours.UpdateStockBehaviour;

public class PoisonUpdate implements UpdateStockBehaviour {
	

	public void doUpdateStock(Board b) {
		if(b.getClass() == PoisonBoard.class ){
			PoisonBoard sb =(PoisonBoard)b;
			sb.updateStock();
			sb.noOfBirdsLabel.setText("#birds: "+sb.noofbirds);
			sb.noOfGrainsLabel.setText("#grains: "+sb.noofgrains);
			sb.noOfPoisonGrainsLabel.setText("#poison: "+sb.noofPoisongrains);
		}
	}
}
