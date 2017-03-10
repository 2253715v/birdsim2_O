package gla.joose.birdsim.boards;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PoisonBoard extends Board {
	
	JButton poisonBirdsButton;
	JLabel noOfPoisonGrainsLabel;
	
	JPanel buttonPanel;
    JButton hatchEggButton;
    JButton feedBirdButton;
    JButton scareBirdsButton;
    JButton starveBirdsButton;
    
    
    JLabel noOfGrainsLabel;    
    JLabel noOfBirdsLabel;
    
    Thread runningthread;
	public int noofPoisongrains;

	public PoisonBoard(int rows, int columns) {
		super(rows, columns);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initBoard(final JFrame frame) {
		JPanel display = getJPanel();
        frame.getContentPane().add(display, BorderLayout.CENTER);
        
        // Install button panel
        buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        hatchEggButton = new JButton("hatch egg");
        buttonPanel.add(hatchEggButton);
        hatchEggButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	scareBirds = false;
            	runningthread = new Thread(new Runnable(){
					public void run() {
						performFly();
					}            		
            	});
            	runningthread.start();
        }}); 
        
       doInitBoard((PoisonBoard)this);

        // Implement window close box
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	scareBirds = true;
            	if(runningthread !=null){
                    clear();
                    try {
						runningthread.join();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
            	}
            	frame.dispose();
                System.exit(0);
        }});

        frame.pack();
        frame.setSize(650, 650);
        frame.setVisible(true);
        		
	}

}
