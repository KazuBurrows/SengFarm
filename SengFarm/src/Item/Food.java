package Item;

import Farm.Farm;

public class Food extends Item {

	public Food() {
		super("Animal food", 0, "Some description", "Something");
		
	}
	
	@Override
	public void useItem(Farm farm) {
		// Do something
		System.out.println("This is food.");
		
	}

}
