package gla.joose.birdsim.boards;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import behaviours.InitBehaviour;
import gla.joose.birdsim.pieces.Grain;
import gla.joose.birdsim.pieces.PaintGrain;

public class ForageInit implements InitBehaviour {


	public void doInitBoard(final Board b) {
		if(b.getClass() == StaticForageBoard.class){
			final StaticForageBoard sb = (StaticForageBoard) b;
			sb.feedBirdButton = new JButton("feed birds");
			sb.buttonPanel.add(sb.feedBirdButton);
			sb.feedBirdButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sb.starveBirdspressed = false;

					Grain grain = new Grain();
					grain.setPaintBehaviour(new PaintGrain());
					int randRow = sb.rand.nextInt((sb.getRows() - 3) + 1) + 0;
					int randCol = sb.rand.nextInt((sb.getColumns() - 3) + 1) + 0;
					sb.place(grain, randRow, randCol);
					grain.setDraggable(false);

					sb.doUpdateStock((StaticForageBoard)sb);
				}
			});

			sb.starveBirdsButton = new JButton("starve birds");
			sb.buttonPanel.add(sb.starveBirdsButton);
			sb.starveBirdsButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sb.starveBirdspressed = true;

				}
			});

			sb.scareBirdsButton = new JButton("scare birds");
			sb.buttonPanel.add(sb.scareBirdsButton);
			sb.scareBirdsButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sb.scareBirds = true;

				}
			});
			sb.noOfBirdsLabel = new JLabel();
			sb.noOfBirdsLabel.setText("#birds: " + 0);
			sb.buttonPanel.add(sb.noOfBirdsLabel);

			sb.noOfGrainsLabel = new JLabel();
			sb.noOfGrainsLabel.setText("#grains: " + 0);
			sb.buttonPanel.add(sb.noOfGrainsLabel);
		}else if(b.getClass() == MovingForageBoard.class){
			final MovingForageBoard mb = (MovingForageBoard) b;
		
		 mb.feedBirdButton = new JButton("feed birds");
		 mb.buttonPanel.add(mb.feedBirdButton);
		 mb.feedBirdButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	mb.starveBirds = false;

	            	Grain grain = new Grain();
	            	grain.setPaintBehaviour(new PaintGrain());
	            	int randRow = mb.rand.nextInt((mb.getRows() - 3) + 1) + 0;
	            	int randCol = mb.rand.nextInt((mb.getColumns() - 3) + 1) + 0;
	            	mb.place(grain,randRow, randCol);
	        		grain.setDraggable(false);
	        		
	        		mb.doUpdateStock((MovingForageBoard)mb);
	        }}); 

		 mb.starveBirdsButton = new JButton("starve birds");
		 mb.buttonPanel.add(mb.starveBirdsButton);
		 mb.starveBirdsButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	mb.starveBirds = true;

	        }}); 
	        
		 mb.scareBirdsButton = new JButton("scare birds");
		 mb.buttonPanel.add(mb.scareBirdsButton);
		 mb.scareBirdsButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	mb.scareBirds = true;

	        }}); 
		 mb.noOfBirdsLabel = new JLabel();
		 mb.noOfBirdsLabel.setText("#birds: "+0);
		 mb.buttonPanel.add(mb.noOfBirdsLabel);

		 mb.noOfGrainsLabel = new JLabel();
		 mb.noOfGrainsLabel.setText("#grains: "+0);
		 mb.buttonPanel.add(mb.noOfGrainsLabel);
		}
	}

}
