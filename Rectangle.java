package plate;

import java.awt.Graphics2D;

import level.Level;

public class Rectangle extends Plate{
	 public Rectangle(Level level) {
		 super(level);
	 }
	
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillRect(center.x, center.y, width, height);
	}

}
