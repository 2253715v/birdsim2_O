package gla.joose.birdsim;

import javax.swing.JFrame;

import gla.joose.birdsim.boards.Board;
import gla.joose.birdsim.boards.FlockBoard;
import gla.joose.birdsim.boards.FlockInit;
import gla.joose.birdsim.boards.ForageInit;
import gla.joose.birdsim.boards.ForageUpdate;
import gla.joose.birdsim.boards.MovingFly;
import gla.joose.birdsim.boards.MovingForageBoard;
import gla.joose.birdsim.boards.PoisonBoard;
import gla.joose.birdsim.boards.PoisonFly;
import gla.joose.birdsim.boards.PoisonInit;
import gla.joose.birdsim.boards.PoisonUpdate;
import gla.joose.birdsim.boards.RandomFly;
import gla.joose.birdsim.boards.StaticFly;
import gla.joose.birdsim.boards.StaticForageBoard;


/**
 *  @author inah
 *  The main method for bootstrapping BirdSim.
 */
public class Play extends JFrame {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		Play play = new Play();
		
//		Board forageBoard = new StaticForageBoard(50,50);
//		forageBoard.setInitBehaviour(new ForageInit());
//		forageBoard.setUpdateStockBehaviour(new ForageUpdate());
//		forageBoard.initBoard(play);
//		forageBoard.setFLyBehav(new StaticFly());
		
		Board forageBoard = new MovingForageBoard(50,50);
		forageBoard.setInitBehaviour(new ForageInit());
		forageBoard.setUpdateStockBehaviour(new ForageUpdate());
		forageBoard.initBoard(play);
		forageBoard.setFLyBehav(new MovingFly());
//		
//		Board simpleBoard = new FlockBoard(50,50);
//		simpleBoard.setInitBehaviour(new FlockInit());
//		simpleBoard.initBoard(play);
//		simpleBoard.setFLyBehav(new RandomFly());
		
//		Board forageBoard = new PoisonBoard(50,50);
//		forageBoard.setInitBehaviour(new PoisonInit());
//		forageBoard.setUpdateStockBehaviour(new PoisonUpdate());
//		forageBoard.initBoard(play);
//		forageBoard.setFLyBehav(new PoisonFly());
		
		

	}

}
