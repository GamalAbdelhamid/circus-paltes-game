package plate;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import level.Level;

public abstract class Plate {
	protected Point center = new Point(0, 0);
	protected int id;
	protected int width;
	protected int height;
	protected Color color;
	protected int state = 0; 
	
	public Plate() {
	}
	public Plate(Level level) {
		width = level.getWidth();
		height = level.getHeight();
	}

	

	public void setCenter(int x, int y) {
		center.x = x;
		center.y = y; 
	}
	public Point getCenter() {
		return center;
	}
	public void setWidth(int newWidth) {
		width = newWidth;
	}
	public int getWidth() {
		return width;
	}
	public void setHeight(int newHeight) {
		height = newHeight;
	}
	public int getHeight() {
		return height;
	}
	public void setColor(Color newColor) {
		color = newColor;
	}
	public Color getColor() {
		return color;
	}
	public void setId(int newId) {
		id = newId;
	}
	public int getId() {
		return id;
	}
	public void setState(int newState) {
		state = newState;
	}
	public int getState() {
		return state;
	}
	
	
	public void move(int dx, int dy) {
		 int newX = center.x + dx;
		 int newY = center.y + dy;
		 center.x = newX;
		 center.y = newY;
	}
	
	public void draw(Graphics2D g){
		
	}
	public void init(Level level) {
		width = level.getWidth();
		height = level.getHeight();
	}
	

}
