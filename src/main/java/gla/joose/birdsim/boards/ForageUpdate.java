package gla.joose.birdsim.boards;

import behaviours.UpdateStockBehaviour;

public class ForageUpdate implements UpdateStockBehaviour{
	public void doUpdateStock(Board b){
		if(b.getClass() == StaticForageBoard.class ){
			StaticForageBoard sb =(StaticForageBoard)b;
			sb.updateStock();
			sb.noOfBirdsLabel.setText("#birds: "+sb.noofbirds);
			sb.noOfGrainsLabel.setText("#grains: "+sb.noofgrains);
		}else if(b.getClass() == MovingForageBoard.class ){
			MovingForageBoard mb =(MovingForageBoard)b;
			mb.updateStock();
			mb.noOfBirdsLabel.setText("#birds: "+mb.noofbirds);
			mb.noOfGrainsLabel.setText("#grains: "+mb.noofgrains);
		}
	}
}
