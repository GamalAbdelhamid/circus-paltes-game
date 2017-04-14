package jester;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;

import javax.swing.JComponent;
import javax.swing.JPanel;

import plate.Plate;

public class ControlJester extends JComponent implements MouseMotionListener {

	Jester player  ;
//	Plate plate;
	public ControlJester() {
		player = Player1.getInstance();
		addMouseMotionListener(this);
	}
	
	protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D) gr;
        player.draw(g);
    }
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
			
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		if(arg0.getX() > 1000) {
			player.move(1080);
		} else {
			player.move(arg0.getX());
		}
	//	player.catchCheck(plate);
		repaint();
	}


}
