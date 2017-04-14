package layer;

import java.util.ArrayList;
import level.Easy;
import level.Level;
import plate.Plate;
import plate.plateFactory;

public class Pool {
	private Level level = new Easy();
	private static Pool instance = new Pool();
	private plateFactory plateFactory = new plateFactory(level);
	private ArrayList<Plate> outPlates = new ArrayList<Plate>();
	private ArrayList<Plate> inPlates = new ArrayList<Plate>();
	private int maxSize = 1000;
	private int counter = 0;
	private int idCounter = 0 ;

	private Pool() {

	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
		plateFactory.setLevel(level);
	}
	
	public static Pool getInstance() {
		if (instance == null) {
			instance = new Pool();
		}
		return instance;
	}

	public void addPlate() {
		if (counter <= maxSize) {
			outPlates.add(plateFactory.getPlate());
			outPlates.get(outPlates.size() - 1).setId(idCounter);
			counter++;
			idCounter++;
		}
	}
	
	public Plate getPlate() {
		if(outPlates.size() == 0) {
			addPlate();
		}
		inPlates.add(outPlates.get(outPlates.size() - 1));
		outPlates.remove(outPlates.size() - 1);
		return inPlates.get(inPlates.size() - 1);
	}
	
	public void recyclePlate(Plate plate) {
				outPlates.add(plate);
				inPlates.remove(plate);
	}
	
	public void releasePlate(Plate plate) {
				inPlates.remove(plate);
				counter--;
	}
}
