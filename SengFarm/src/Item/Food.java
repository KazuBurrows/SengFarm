package Item;

import Animal.Animal;
import Crop.Crop;
import Farm.Farm;

public class Food extends Item {

	private int increaseHealthAmount = 10;
	private int increaseHappinessAmount = 30;
	
	public Food() {
		super("Animal food", 10, "Some description", "Something");
		
	}
	
	@Override
	public void useItem(Object animal, String farmType) {
		// Do something
		
		((Animal) animal).feedAnimal(increaseHealthAmount, increaseHappinessAmount, farmType);
		
	}

}
