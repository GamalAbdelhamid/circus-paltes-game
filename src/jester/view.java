package jester;


import java.awt.Component;
import java.awt.geom.Area;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class view {
	 public static void main(final String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                createAndShowGUI();
	            }
	        });
	    }

	    private static void createAndShowGUI() {
	        JFrame f = new JFrame();
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.getContentPane().add(new ControlJester());
	        Area area = new Area();
	//        f.add(area);
	        f.setSize(1200, 700);
	        f.setLocationRelativeTo(null);
	        f.setVisible(true);
	    }
}
