package Item;

import Farm.Farm;

public class Food extends Item {

	public Food() {
		super("Animal food", 10, "Some description", "Something");
		
	}
	
	@Override
	public void useItem(Object object) {
		// Do something
		System.out.println("This is food.");
		
	}

}
