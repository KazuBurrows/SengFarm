package Item;

import Crop.Crop;
import Farm.Farm;

public class Fertilizer extends Item {
	
	/*
	 * Constructor
	 */
	public Fertilizer() {
		super("Fertilizer", 0, "Some description", "Something");
		
	}
	
	
	
	
	@Override
	public void useItem(Farm farm) {
		
		// Prompt user to select item
		Crop crop = farm.getCrop();
		
		int reduceBy = 2;
		crop.reduceHarvestDay(reduceBy);
		
	}
	
	
	
	
}
