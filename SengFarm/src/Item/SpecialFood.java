package Item;

import Animal.Animal;

public class SpecialFood extends Item {

	private int increaseHealthAmount = 20;
	private int increaseHappinessAmount = 40;
	
	public SpecialFood() {
		super("Special animal food", 16, "Some description", "Something");
		
	}
	
	
	
	@Override
	public void useItem(Object animal) {
		// Do something
		((Animal) animal).feedAnimal(increaseHealthAmount, increaseHappinessAmount);
	}

}
