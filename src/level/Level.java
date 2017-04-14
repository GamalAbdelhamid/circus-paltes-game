package level;

import java.awt.Color;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import layer.Layer;

public abstract class Level {
	
	final static Logger logger = Logger.getLogger(Layer.class);
	protected Color colors[];
	protected int maxHeight;
	protected int dt;
	protected int width;
	protected int height;
	protected int dx;
	protected int dy;
	public Level() {
		PropertyConfigurator.configure("log4j.properties");
	}
	
	public Color getRandomColor() {
		Random random = new Random();
		int x = random.nextInt(colors.length);
		return colors[x];
	}

	public int getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}

	public int getDt() {
		return dt;
	}

	public void setDt(int dt) {
		this.dt = dt;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}
	
	
	

}
