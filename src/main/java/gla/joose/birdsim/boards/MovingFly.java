package gla.joose.birdsim.boards;

import behaviours.FlyBehaviour;
import gla.joose.birdsim.pieces.Bird;
import gla.joose.birdsim.pieces.Grain;
import gla.joose.birdsim.pieces.PaintBird;
import gla.joose.birdsim.pieces.Piece;
import gla.joose.birdsim.util.Distance;
import gla.joose.birdsim.util.DistanceMgr;

public class MovingFly implements FlyBehaviour {


	public void fly(Board b) {

		Bird bird = new Bird();
		bird.setPaintBehaviour(new PaintBird());
		
		int randRow = b.rand.nextInt((b.getRows() - 3) + 1) + 0;
    	int randCol = b.rand.nextInt((b.getColumns() - 3) + 1) + 0;    	
    	b.place(bird,randRow, randCol);
		bird.setDraggable(false);
		bird.setSpeed(20);
		b.doUpdateStock((MovingForageBoard)b);
		
		while(!b.scareBirds){
			
			DistanceMgr dmgr = new DistanceMgr();
			int current_row = bird.getRow();
			int current_col = bird.getColumn();
			
			synchronized(b.allPieces){
				for (int i=0;i< b.getAllPieces().size(); i++) {
	                Piece piece = b.getAllPieces().get(i);
	                if(piece instanceof Grain){
	                	
	                int dist_from_food_row = current_row - piece.getRow();
		                	int dist_from_food_col = piece.getColumn() - current_col;
		                	Distance d = null;
		                	if(dist_from_food_row <= dist_from_food_col){
		                		d = new Distance(bird, (Grain)piece, dist_from_food_row, dist_from_food_col);
		                	}
		                	else{
		               		 	d = new Distance(bird, (Grain)piece, dist_from_food_row, dist_from_food_col);
		                	}                    	
		                	dmgr.addDistance(d);		
	                	
	                	
	                }
				}	       
			}
			////
			
			Distance distances[] = dmgr.getDistances();
			boolean movedone = false;

			for(int i =0; i< distances.length;i++){
				Distance d = distances[i];
				
				if(d.getRowDist() <= d.getColDist()){
					
					if(d.getRowDist() >0){
						boolean can_move_down= bird.canMoveTo(current_row-1, current_col);
			    		if(can_move_down){
							bird.moveTo(current_row-1, current_col);
							movedone = true;
							break;
						}
					}
					else if(d.getRowDist() < 0){
						boolean can_move_down= bird.canMoveTo(current_row+1, current_col);
			    		if(can_move_down){
							bird.moveTo(current_row+1, current_col);
							movedone = true;
							break;
						}
					}
					else if(d.getRowDist() ==0){
						if(d.getColDist() >0){
							boolean can_move_right = bird.canMoveTo(current_row, current_col+1);
							if(can_move_right){
								bird.moveTo(current_row, current_col+1);
								movedone = true;
								break;
							}
						}
						else if(d.getColDist()< 0){
							boolean can_move_left = bird.canMoveTo(current_row, current_col-1);
							if(can_move_left){
								bird.moveTo(current_row, current_col-1);
								movedone = true;
								break;
							}
						}
						else if(d.getColDist() ==0){
							//bingo -food found (eat and move away)
							Grain grain = (Grain)d.getTargetpiece();
							grain.deplete();

							int randRowf = b.rand.nextInt((b.getRows() - 3) + 1) + 0;
			            	int randColf= b.rand.nextInt((b.getColumns() - 3) + 1) + 0; 
			            	grain.moveTo(randRowf, randColf);
							grain.setSpeed(10);
							if(b.starveBirds){
		                		grain.remove();
		                		b.doUpdateStock((MovingForageBoard)b);
		                	}
							else if(grain.getRemaining() <=0){
			        			grain.remove();	
			        			b.doUpdateStock((MovingForageBoard)b);
			        		} 
			        		int randRow1 = b.rand.nextInt((b.getRows() - 3) + 1) + 0;
			            	int randCol2 = b.rand.nextInt((b.getColumns() - 3) + 1) + 0; 
			            	bird.moveTo(randRow1, randCol2);
			        		bird.setSpeed(20);
							movedone = true;
							break;


						}
						
					}
				}
				///////
				else if(d.getRowDist() > d.getColDist()){
	            	
					if(d.getColDist() >0){
						boolean can_move_right = bird.canMoveTo(current_row, current_col+1);
						if(can_move_right){
							bird.moveTo(current_row, current_col+1);
							movedone = true;
							break;
						}
					}
					else if(d.getColDist()<0){
						boolean can_move_left = bird.canMoveTo(current_row, current_col-1);
						if(can_move_left){
							bird.moveTo(current_row, current_col-1);
							movedone = true;
							break;
						}
					}
					else if(d.getColDist() == 0){
						if(d.getRowDist() >0){
							boolean can_move_up= bird.canMoveTo(current_row-1, current_col);
				    		if(can_move_up){
								bird.moveTo(current_row-1, current_col);
								movedone = true;
								break;
							}
							
						}
						else if(d.getRowDist() < 0){
							boolean can_move_down = bird.canMoveTo(current_row+1, current_col);///kkkk
				    		if(can_move_down){
								bird.moveTo(current_row+1, current_col);
								movedone = true;
								break;
							} 
						}
						else if(d.getRowDist() ==0){
							//bingo -food found (eat and move away)
							Grain grain = (Grain)d.getTargetpiece();
							grain.deplete();
							
							int randRowf = b.rand.nextInt((b.getRows() - 3) + 1) + 0;
			            	int randColf= b.rand.nextInt((b.getColumns() - 3) + 1) + 0; 
			            	grain.moveTo(randRowf, randColf);
							grain.setSpeed(10);

							if(b.starveBirds){
		                		grain.remove();
		                		b.doUpdateStock((MovingForageBoard)b);
		                	}
							else if(grain.getRemaining() <=0){
			        			grain.remove();	
			        			b.doUpdateStock((MovingForageBoard)b);
			        		} 
			        		int randRow1 = b.rand.nextInt((b.getRows() - 3) + 1) + 0;
			            	int randCol2 = b.rand.nextInt((b.getColumns() - 3) + 1) + 0; 
			            	bird.moveTo(randRow1, randCol2);	
			        		bird.setSpeed(20);
							movedone = true;
							break;

						}
					}
				}
			}
			if(!movedone){
				int randRow1 = b.rand.nextInt((b.getRows() - 3) + 1) + 0;
            	int randCol2 = b.rand.nextInt((b.getColumns() - 3) + 1) + 0; 
            	bird.moveTo(randRow1, randCol2);
			}
			
		} 
		bird.remove();
		b.doUpdateStock((MovingForageBoard)b);
       
	}
}
