package gla.joose.birdsim.boards;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A BirdSim board with generic bird flying behaviour.
 */
public class FlockBoard extends Board {

	JPanel buttonPanel;
	JButton hatchEggButton;
	JButton scareBirdsButton;
	JLabel noOfBirdsLabel;

	Thread runningthread;

	public FlockBoard(int rows, int columns) {
		super(rows, columns);
	}

	@Override
	public void initBoard(final JFrame frame) {
		JPanel display = getJPanel();
		frame.getContentPane().add(display, BorderLayout.CENTER);

		// Install button panel
		buttonPanel = new JPanel();
		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		doInitBoard((FlockBoard) this);

		// Implement window close box
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// used to invoke birds removal from the board
				scareBirds = true;
				if (runningthread != null) {
					clear();
					try {
						runningthread.join();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				frame.dispose();
				System.exit(0);
			}
		});
		frame.pack();
		frame.setSize(650, 650);
		frame.setVisible(true);

	}

}
