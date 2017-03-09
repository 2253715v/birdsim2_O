package gla.joose.birdsim.boards;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

import behaviours.InitBehaviour;

public class FlockInit implements InitBehaviour {
	public void doInitBoard(final Board b) {
		if(b.getClass() == FlockBoard.class){
			final FlockBoard fb = (FlockBoard) b;
			fb.hatchEggButton = new JButton("hatch egg");
			fb.buttonPanel.add(fb.hatchEggButton);
			fb.hatchEggButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					fb.scareBirds = false;
					fb.runningthread = new Thread(new Runnable() {
						public void run() {
							fb.performFly();
						}
					});
					fb.runningthread.start();
				}
			});
			fb.scareBirdsButton = new JButton("scare birds");
			fb.buttonPanel.add(fb.scareBirdsButton);
			fb.scareBirdsButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fb.scareBirds = true;
				}
			});

			fb.noOfBirdsLabel = new JLabel();
			fb.noOfBirdsLabel.setText("#birds: " + 0);
			fb.buttonPanel.add(fb.noOfBirdsLabel);

		}
	}

}
