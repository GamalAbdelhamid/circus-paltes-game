package layer;

import java.awt.Graphics2D;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import level.Level;
import plate.Plate;
import View.Constants;

public abstract class Layer {
	final static Logger logger = Logger.getLogger(Layer.class);
	protected ArrayList<Plate> plates;
	int fallingX;
	int upperY;
	protected Level level;
	protected Pool pool = Pool.getInstance();
	protected Plate temp;
	protected Constants cons = new Constants();
	
	public Layer(Level level) {
		this.level = level;
		pool.setLevel(this.level);
		PropertyConfigurator.configure("log4j.properties");
	}
	
	public void move(){}
	public void draw(Graphics2D g){}
	protected void changeState(Plate plate){
		if(plate.getState() == 0)
			plate.setState(1);
		else
			plate.setState(0);
	}
	public void addPlate() {}

}
