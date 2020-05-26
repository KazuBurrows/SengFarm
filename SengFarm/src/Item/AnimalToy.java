package Item;

import Animal.Animal;
import Farm.Farm;

public class AnimalToy extends Item {

	private int increaseHealthAmount = 20;
	private int increaseHappinessAmount = 30;
	
	public AnimalToy() {
		super("Animal's toy", 30, "Some description", "Something");
		
	}
	
	@Override
	public void useItem(Object animal, String farmType) {
		// Do something
		((Animal) animal).playAnimal(increaseHealthAmount, increaseHappinessAmount, farmType);
	}

}
