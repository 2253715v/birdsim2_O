package gla.joose.birdsim.boards;

import behaviours.FlyBehaviour;
import gla.joose.birdsim.pieces.Bird;
import gla.joose.birdsim.pieces.PaintBird;

public class RandomFly implements FlyBehaviour {

	public void fly(Board b) {
		Bird bird = new Bird();
		bird.setPaintBehaviour(new PaintBird());
		
		int randRow = b.rand.nextInt((b.getRows() - 3) + 1) + 0;
    	int randCol = b.rand.nextInt((b.getColumns() - 3) + 1) + 0;
    	
		b.place(bird,randRow, randCol);
		bird.setDraggable(false);
		bird.setSpeed(20);
		b.doUpdateStock((FlockBoard)b);
		
		while(!b.scareBirds){
			randRow = b.rand.nextInt((b.getRows() - 3) + 1) + 0;
        	randCol = b.rand.nextInt((b.getColumns() - 3) + 1) + 0; 
        	bird.moveTo(randRow, randCol);
    		bird.setSpeed(20);
    		bird.count();
			if(bird.counter==10)break;
		} 
		bird.remove();
		b.doUpdateStock((FlockBoard)b);
	}

}
