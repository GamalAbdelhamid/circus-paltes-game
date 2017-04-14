package layer;

import java.awt.Graphics2D;
import java.util.ArrayList;

import jester.Player1;
import jester.Player2;
import level.Level;
import plate.Plate;

public class Left2 extends Layer {

	public Left2(Level level) {
		super(level);
		plates = new ArrayList<>();
		logger.debug("left2 created successfully");
	}
	
	
	@Override
	public void move(){
		for(int i = 0 ; i < plates.size() ; i++) {
			Plate plate = plates.get(i);
			if(plate.getState() == 0) {
				if(plate.getCenter().x >= cons.getWidth() / 5) {
					changeState(plate);
				}
				else{
					plate.move(level.getDx(), 0);
				}
			}
			else {
				if(Player1.getInstance().catchCheck(plate)) {
					Player1.getInstance().catchPlate(plate);
					plates.remove(plate);
					logger.info("a plate is catched");
				} else if(Player2.getInstance().catchCheck(plate)) {
					Player2.getInstance().catchPlate(plate);
					plates.remove(plate);
					logger.info("a plate is catched");
				} else {
				plate.move(level.getDx() / 2, level.getDy());
				}
			}
		}
	}
	
	@Override
	public void draw(Graphics2D g) {
		for(int i = 0 ; i < plates.size() ; i++) {
			Plate plate = plates.get(i);
			plate.draw(g);
		}
	}
	
	@Override
	public void addPlate() {
		temp = pool.getPlate();
		temp.setCenter(5, 50);
		plates.add(temp);
	}


}
