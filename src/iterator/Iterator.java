package iterator;

import java.util.ArrayList;

import plate.Plate;

public class Iterator implements ItreatorIF {
	private ArrayList<Plate> plates;
	public Iterator(ArrayList<Plate> plates) {
		this.plates = plates;
	}
	
	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Plate next() {
		return null;
	}

}
