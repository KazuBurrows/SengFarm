package Item;

import Crop.Crop;
import Farm.Farm;

public class Fertilizer extends Item {
	
	/*
	 * Constructor
	 */
	public Fertilizer() {
		super("Fertilizer", 20, "Some description", "Something");
		
	}
	
	
	
	
	@Override
	public void useItem(Object crop) {
		((Crop) crop).reduceHarvestDay(2);
		
	}
	
	
	
	
}
