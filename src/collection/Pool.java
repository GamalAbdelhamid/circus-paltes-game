package collection;

import java.util.ArrayList;
import level.Easy;
import level.Level;
import plate.Plate;
import plate.plateFactory;

public class Pool {
	private Level level = new Easy();
	private static Pool instance = new Pool();
	private plateFactory platefactory = new plateFactory(level);
	private ArrayList<Plate> outplates = new ArrayList<Plate>();
	private ArrayList<Plate> inplates = new ArrayList<Plate>();
	private int maxSize = 300;
	private int counter = 0;
	private int idCounter = 0 ;

	private Pool() {

	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	
	public Pool getInstance() {
		if (instance == null) {
			instance = new Pool();
		}
		return instance;
	}

	public void addPlate() {
		if (counter <= maxSize) {
			outplates.add(platefactory.getPlate());
			outplates.get(outplates.size() - 1).setId(idCounter);
			counter++;
			idCounter++;
		}
	}
	
	public Plate getPlate() {
		if(outplates.size() == 0) {
			addPlate();
		}
		inplates.add(outplates.get(outplates.size() - 1));
		outplates.remove(outplates.size() - 1);
		return inplates.get(inplates.size() - 1);
	}
	
	public void reSyclePlate(Plate plate) {
		for(Plate x : inplates) {
			if(x.getId() == plate.getId()) {
				outplates.add(x);
				inplates.remove(x);
			}
		}
	}
	
	public void releasePlate(Plate plate) {
		for(Plate x : inplates) {
			if(x.getId() == plate.getId()) {
				inplates.remove(x);
				counter--;
			}
		}
	}
}
