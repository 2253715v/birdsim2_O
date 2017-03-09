package gla.joose.birdsim.boards;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import behaviours.InitBehaviour;
import gla.joose.birdsim.pieces.Grain;
import gla.joose.birdsim.pieces.PaintGrain;
import gla.joose.birdsim.pieces.PaintPoisonGrain;
import gla.joose.birdsim.pieces.PoisonGrain;

public class PoisonInit implements InitBehaviour {
	public void doInitBoard(final Board b){
		if(b.getClass() == PoisonBoard.class){
			final PoisonBoard pb = (PoisonBoard) b;
		
		 pb.feedBirdButton = new JButton("feed birds");
		 pb.buttonPanel.add(pb.feedBirdButton);
		 pb.feedBirdButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	pb.starveBirds = false;

	            	Grain grain = new Grain();
	            	grain.setPaintBehaviour(new PaintGrain());
	            	int randRow = pb.rand.nextInt((pb.getRows() - 3) + 1) + 0;
	            	int randCol = pb.rand.nextInt((pb.getColumns() - 3) + 1) + 0;
	            	pb.place(grain,randRow, randCol);
	        		grain.setDraggable(false);
	        		
	        		pb.doUpdateStock((PoisonBoard)pb);
	        }}); 

		 pb.starveBirdsButton = new JButton("starve birds");
		 pb.buttonPanel.add(pb.starveBirdsButton);
		 pb.starveBirdsButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	pb.starveBirds = true;

	        }}); 
		 
//		 pb.poisonBirdsButton = new JButton("poison birds");
//		 pb.buttonPanel.add(pb.poisonBirdsButton);
//		 pb.poisonBirdsButton.addActionListener(new ActionListener() {
//			 public void actionPerformed(ActionEvent e) {
//	            	pb.starveBirds = false;
//	            	PoisonGrain grain = new PoisonGrain();
//	            	grain.setPaintBehaviour(new PaintPoisonGrain());
//	            	int randRow = pb.rand.nextInt((pb.getRows() - 3) + 1) + 0;
//	            	int randCol = pb.rand.nextInt((pb.getColumns() - 3) + 1) + 0;
//	            	pb.place(grain,randRow, randCol);
//	        		grain.setDraggable(false);
//	        		
//	        		pb.doUpdateStock((PoisonBoard)pb);
//
//	        }});
	        
		 pb.scareBirdsButton = new JButton("scare birds");
		 pb.buttonPanel.add(pb.scareBirdsButton);
		 pb.scareBirdsButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	pb.scareBirds = true;

	        }}); 
		 pb.noOfBirdsLabel = new JLabel();
		 pb.noOfBirdsLabel.setText("#birds: "+0);
		 pb.buttonPanel.add(pb.noOfBirdsLabel);

		 pb.noOfGrainsLabel = new JLabel();
		 pb.noOfGrainsLabel.setText("#grains: "+0);
		 pb.buttonPanel.add(pb.noOfGrainsLabel);
		}
	}
}
