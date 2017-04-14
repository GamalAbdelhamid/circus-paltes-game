package plate;

import java.awt.Graphics2D;

import level.Level;

public class Oval extends Plate {
	
	public Oval() {
		super();
	}
	
	public Oval(Level level) {
		super(level);
	}
	
	public void draw(Graphics2D g){
		g.setColor(color);
		g.fillOval(center.x, center.y, width, height);
	}

}
