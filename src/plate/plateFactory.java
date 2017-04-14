package plate;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFileChooser;

import level.Level;

public class plateFactory {
	private Level level; 
	DynamicLoader load ;
	private boolean state = false;
	private ArrayList<String> extraPlatesUrl ;
	
	public plateFactory(Level level) {
		this.level = level;
		extraPlatesUrl = new ArrayList();
		load = new DynamicLoader();
	}
	private Plate objectPlate;
	public Plate getPlate(){
		int type = 0;
		if(state) {
			type = new Random().nextInt(2);
		} else {
			type = new Random().nextInt(1);
		}
		
		if(type == 0) {
			objectPlate = new Oval(this.level);
		}
		else if(state) {
			if(extraPlatesUrl.size() >= 1) {
				int x = new Random().nextInt(extraPlatesUrl.size());
				try {
					objectPlate = load.getPlate(extraPlatesUrl.get(x), level);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
					
				}
			}
		}
		objectPlate.setColor(level.getRandomColor());
		return objectPlate;
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}
	
	private void changeState() {
		state = true;
	}
	
	public void addPlate() {
		JFileChooser loadFile = new JFileChooser();
	    loadFile.showDialog(null, "Load");
	    loadFile.getSelectedFile();
		try {
			if(loadFile.getSelectedFile() !=null) {
				load.getPlate(loadFile.getSelectedFile().toString(), level);
				extraPlatesUrl.add(loadFile.getSelectedFile().toString());
				changeState();
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			
		}
	}
	public Plate newPlate(int i) {
		
		try {
			return load.getPlate(extraPlatesUrl.get(i), level);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
		}
		return null;
	}
}
