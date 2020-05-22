package Main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Animal.Animal;
import Animal.Cow;
import Crop.Apple;
import Crop.Crop;
import Farm.Farm;
import Farm.Farmer;
import InputHandler.InputHandler;
import Item.Fertilizer;
import Item.Item;

public class Game {
	
	private int gameDuration;						// The total duration of game
	private int currentDay = 0;							// 
	
	private int totalActions = 2;						// Total actions player has available
	private int totalExtraActions = 0;
	
	Farmer farmer;
	Farm farm;
	Store store;
	Event event;
	
	
	/*
	 * Constructor
	 */
	public Game()
	{
		setGameDuration();
		
		farmer = new Farmer();
		farm = instatiateFarm();
		store = new Store();
//		event = new Event();
		
		
		Apple a = new Apple(currentDay);
		farm.addCrop(a, currentDay);
		
		Fertilizer f = new Fertilizer();
		farm.addItem(f);
		
		Fertilizer f2 = new Fertilizer();
		farm.addItem(f2);
		
		
		
		Cow c1 = new Cow();
		farm.addAnimal(c1);
		Cow c2 = new Cow();
		farm.addAnimal(c2);
		Cow c3 = new Cow();
		farm.addAnimal(c3);
		Cow c4 = new Cow();
		farm.addAnimal(c4);
		
		
		
		
		runGame();
	}
	
	
	
	private Farm instatiateFarm()
	{
		String mode = "instatiate farm";
		String userInput;
		int navOption;
		String message = "Enter a number to select a farm type.";
		
		InputHandler.printNavigationOption(mode);
		
		userInput = InputHandler.getUserInput(mode, message);
		navOption = Integer.parseInt(userInput);
		
		
		Farm local_farm;
		
		if (navOption == 0) {
			local_farm = new Farm(farmer, "dairy");
			
		} else if (navOption == 1) {
			local_farm = new Farm(farmer, "crop");
			
		} else {
			local_farm = new Farm(farmer, "animal");
			
		}
		
		
		return local_farm;
		
	}
	
	
	
	
	/*
	 * Get gameDuration
	 * 
	 * @return			The total duration of game
	 */
	private int getGameDuration()
	{
		
		return gameDuration;
	}
	
	
	
	/*
	 * Set game duration
	 */
	private void setGameDuration()
	{
 		String mode = "game duration";
 		String message = "Enter your desired game duration(days).";
 		
		String days = InputHandler.getUserInput(mode, message);
		
 		gameDuration = Integer.parseInt(days);
	}
	
	
	
	
	/*
	 * 
	 * 
	 * @return			Current day in game
	 */
	private int getCurrentDay()
	{
		
		return currentDay;
	}
	
	
	
	/*
	 * Proceed to the next day
	 */
	private void nextDay()
	{
		currentDay++;
		resetActions();
		
		if (currentDay <= gameDuration) {
			farm.endOfDayProfit();
			
			System.out.println("Proceeding to the next day.");
			printGameStatus();
			
																			// DON'T NEED THIS
			// Change crops harvest date
//			ArrayList<Crop> crops = farm.getAllCrop();
//			Iterator<Crop> c_itr = crops.iterator();
//			Crop crop;
//			while (c_itr.hasNext()) {
//				crop = c_itr.next();
//				
//				crop.reduceHarvestDay(1);
//				System.out.println("getHarvestDay " + crop.getHarvestDay() + " currentDay " + currentDay);
//				
//			}
			
			int animal_health;
			int animal_happiness;
			String msg = "%s's has died.";
			// Change animals happiness and health
			ArrayList<Animal> animals = farm.getAllAnimal();
			Iterator<Animal> a_itr = animals.iterator();
			Animal animal;
			while (a_itr.hasNext()) {
				animal = a_itr.next();
				
				animal.reduceHealth(10);
				animal.reduceHappiness(12);
				
				animal_health = animal.getHealth();
				animal_happiness = animal.getHappiness();
				if (animal_health == 0 || animal_happiness == 0) {
					farm.removeAnimal(animal);
					System.out.println(String.format(msg, animal.getHealth()));
					
				}
			}
			
			
			
			
			
			//event.checkForEvent(farm);
		}
		
		
		
	}
	
	
	
	/*
	 * 
	 * 
	 * @return			Total actions player has available
	 */
	private int getTotalActions()
	{
		
		return totalActions;
	}
	
	
	
	/*
	 * Reset total actions to 2 actions
	 */
	private void resetActions()
	{
		totalActions = 2;
		
	}
	
	
	
	
	/*
	 * Add an extra action to total actions player has available
	 */
	private void addAction()
	{
		totalActions += 1;
		
	}
	
	
	
	/*
	 * Subtract total actions player has available by one
	 */
	private void subtractAction()
	{
		totalActions -= 1;
		
	}
	
	
	
	
	
	private int getTotalExtraActions()
	{
		return totalExtraActions;
	}
	
	
	
	
	private void addExtraAction()
	{
		totalExtraActions++;
		
	}
	
	
	
	private void subtractExtraAction()
	{
		totalExtraActions--;
		
	}
	
	
	
	
	/*
	 * Print game status.
	 */
	private void printGameStatus()
	{
		String remainingDays = "Day %s of %s.";
		String remainingActions = "Remaining actions available: %s.";
		
		System.out.println(String.format(remainingDays, getCurrentDay(), getGameDuration()));
		System.out.println(String.format(remainingActions, getTotalActions() + getTotalExtraActions()));
		
	}
	

	
	/*
	 * Main menu of game.
	 */
	private void mainMenu()
	{

 		String mode = "main menu";
 		String message = "Enter number to select an action.";
 		
 		InputHandler.printNavigationOption(mode);
		String selectedOption = InputHandler.getUserInput(mode, message);
		
		
 		handleAction(mode, Integer.parseInt(selectedOption));
		
	}
	
	
	
	/*
	 * Handle user selected action.
	 */
	private void handleAction(String actionType, int option)
	{
		String mode;
		String message = "Enter number to select an action.";
		String msg;
		String userInput;
		int navOption;
		
		if (actionType == "main menu") {
			switch (option) {
			case 0:
				mode = "main status";
				
				InputHandler.printNavigationOption(mode);
				
				userInput = InputHandler.getUserInput(mode, message);
				navOption = Integer.parseInt(userInput);
				
				handleAction(mode, navOption);
				
				break;
				
			case 1:													// Tend to farm
				mode = "tend farm";
				
				
				
				break;
				
			case 2:													// Tend to crops
				
				mode = "tend crop";
				
				farm.browseCrops(currentDay);
				int numCrops = farm.getNumCrops();
				
				if (numCrops <= 0) {
					System.out.println("There are no crops to tend to. Visit the store to purchase crops.");
					
					break;
				}
				
				// Selecting crop
				
				userInput = InputHandler.getSpecialUserInput(mode, message, numCrops);
				navOption = Integer.parseInt(userInput);
				
				
				// Check if user want's to select crop or return to main menu
				if (navOption == numCrops) {
					break;
					
				}
				
				
				
				Crop crop = farm.getCrop(navOption);
				
				
				// Options water or use item
				mode = "select tend crop";
				
				InputHandler.printNavigationOption(mode);
				
				userInput = InputHandler.getUserInput(mode, message);
				navOption = Integer.parseInt(userInput);
				
				
				switch (navOption) {
				case 0:							// water
					if (getTotalActions() + getTotalExtraActions() <= 0) {
						System.out.println("You do not have any more actions available. "
								+ "Proceed to the next day for more actions or purchase an action from the store. ");
						
					} else {
						crop.reduceHarvestDay(1);
						
						if (getTotalActions() > 0) {
							subtractAction();
							
						} else {
							subtractExtraAction();
							
						}
						
						
						msg = "%s was watered and is ready for harvest in %s days.";
						System.out.println(String.format(msg, crop.getName(), Math.max(0, crop.getHarvestDay() - currentDay)));
						msg = "You have %s remaining actions left.";
						System.out.println(String.format(msg, totalActions + totalExtraActions));
					}
					
					break;
					
				case 1:							// item
					System.out.println("In navigation option item(case 1)");
					
					if (getTotalActions() + getTotalExtraActions() <= 0) {
						System.out.println("You do not have any more actions available. "
								+ "Proceed to the next day for more actions or purchase an action from the store. ");
						
					} else {
						mode = "tend crop item";
						
						ArrayList<Item> inventory = farm.browseInventory("tend crop");
						int numItems = inventory.size();
						msg = "%s: %s";
						
						Item item;
						for (int i=0; i<inventory.size(); i++) {
							item = inventory.get(i);
							
							System.out.println(String.format(msg, i, item.getName()));
						}
						
						userInput = InputHandler.getSpecialUserInput(mode, message, numCrops);
						navOption = Integer.parseInt(userInput);
						
						item = inventory.get(navOption);
						item.useItem(crop);							// Apply item on crop
						farm.removeItem(item);
						
						
						if (getTotalActions() > 0) {
							subtractAction();
							
						} else {
							subtractExtraAction();
							
						}
						
						
						msg = "%s has been used on %s and is ready for harvest in %s days.";
						System.out.println(String.format(msg, item.getName(), crop.getName(), Math.max(0, crop.getHarvestDay() - currentDay)));
						msg = "You have %s remaining actions left.";
						System.out.println(String.format(message, totalActions + totalExtraActions));
						
					}
					

					break;
					
				case 2:												// harvest
					farm.harvestCrop(crop, currentDay);
					
					break;
				
				case 3:												// Cancel or return to main menu
					
					break;
					
				}
				
				break;
				
			case 3:													// Tend animals
				// List animals to tend to
					// User selects animal
					// Feed
					// or
					// Play
				
				mode = "tend animal";
				
				farm.browseAnimals();
				int numAnimals = farm.getNumAnimals();
				
				if (numAnimals <= 0) {
					break;
				}
				
				userInput = InputHandler.getSpecialUserInput(mode, message, numAnimals);
				navOption = Integer.parseInt(userInput);
				
				
				if (navOption == numAnimals) {						// Return to main menu
					break;
				}
				
				
				Animal animal = farm.getAnimal(navOption);
				
				// Options Feed with food, Feed with special food, play, play with toy
				mode = "select tend animal";
				
				InputHandler.printNavigationOption(mode);
				
				userInput = InputHandler.getUserInput(mode, message);
				navOption = Integer.parseInt(userInput);
				
				String item_type;
				switch (navOption) {
				case 0:			// Regular food
					
					// Check if food exists in items and same for the other options loop back to case 3 if none exists
					
					item_type = "Animal food";
					if (farm.getSpecialNumItems(item_type) > 0) {
						
						// get item
						Item item = farm.getItem(item_type);
						
						if (item == null) {
							System.out.println("Don't really need this check.");
							
						} else {
							item.useItem(animal);
						}
						
						
						
						
					} else {
						System.out.println("There are no regular food items in your inventory.");
						
					}
					
					
					
					
					break;
					
				case 1:			// Special food
					
					item_type = "Special animal food";
					if (farm.getSpecialNumItems(item_type) > 0) {
						
						
						// get item
						Item item = farm.getItem(item_type);
						
						if (item == null) {
							System.out.println("Don't really need this check.");
							
						} else {
							item.useItem(animal);
						}
						
						
						
						
					} else {
						System.out.println("There are no special food items in your inventory.");
						
					}
					
					
					break;
					
				case 2:			// Play
					animal.addHappiness(10, farm.getFarmType());
					
					break;
					
				case 3:			// Play with toy
					
					item_type = "Animal's toy";
					if (farm.getSpecialNumItems(item_type) > 0) {
						
						
						// get item
						Item item = farm.getItem(item_type);
						
						if (item == null) {
							System.out.println("Don't really need this check.");
							
						} else {
							item.useItem(animal);
						}
						
						
						
					} else {
						System.out.println("There are no animal toy items in your inventory.");
						
					}
					
					
					
					break;
					
					
				case 4:
					break;
				
				
				}
				
				
				
				break;
				
			case 4:													// Browse store
				farm.printMoney();
				mode = "browse store";
				
				InputHandler.printNavigationOption(mode);
				userInput = InputHandler.getUserInput(mode, message);
				navOption = Integer.parseInt(userInput);
				
				handleAction(mode, navOption);
				
				break;
				
			case 5:
				// Precede to next day
				nextDay();
				
				break;
				
			}
		}
		
		
		if (actionType == "main status") {
			switch (option) {
			case 0:
				printGameStatus();
				
				break;
				
			case 1:
				mode = "farm status";
		 		
		 		InputHandler.printNavigationOption(mode);
		 		
				userInput = InputHandler.getUserInput(mode, message);
				navOption = Integer.parseInt(userInput);
				
				handleAction(mode, navOption);
				
				break;
				
			case 2:
				
				break;
				
			}
			
			
		}
		
		
		if (actionType == "farm status") {
			switch (option) {
			case 0:
				// Print farm's money
				farm.printMoney();
				
				break;
				
			case 1:
				// Print crop status
				farm.printCrops(currentDay);
				
				break;
				
			case 2:
				// Print animal status
				farm.printAnimals();											// NOT FINISHED
				
				break;
				
			case 3:
				// Print inventory	- Just looking in inventory
				farm.printItems();
				
				break;
			
			case 4:
				break;
				
			}
			
		}
		
		
		if (actionType == "browse store") {
			int cancel_option;
			
			switch(option) {
			case 0:				// Browse items
				mode = "browse items";
				store.printItemInventory();
				
				userInput = InputHandler.getUserInput(mode, message);
				navOption = Integer.parseInt(userInput);
				
				cancel_option = 6;
				if (navOption == cancel_option) {						// Return main menu
					break;
				}
				
				
				// Check if item can be bought
				Item item = store.purchaseItem(navOption, farm.getMoney());
				
				if (item == null) {
					System.out.println("Could not purchase item because not enough money to purchase item or item is not in stock.");
					
				} else {
					if (Item.itemInstanceOf(item) == 4) {
						addExtraAction();
						
					} else {
						farm.addItem(item);
						
					}
					
					System.out.println(String.format("You have purchased one %s.", item.getName()));
					farm.subtractMoney(item.getPrice());
					
				}
				
				break;
				
			case 1:				// Browse crops
				mode = "browse crops";
				store.printCropInventory();
				
				userInput = InputHandler.getUserInput(mode, message);
				navOption = Integer.parseInt(userInput);
				
				cancel_option = 4;
				if (navOption == cancel_option) {						// Return main menu
					break;
				}
				
				// Check if item can be bought
				Crop crop = store.purchaseCrop(navOption, farm.getMoney(), getCurrentDay());
				
				if (crop == null) {
					System.out.println("Could not purchase item because not enough money to purchase item or item is not in stock.");
					
				} else {
					farm.addCrop(crop, currentDay);
					System.out.println(String.format("You have purchased one %s.", crop.getName()));
					farm.subtractMoney(crop.getPrice());
					
				}
				
				
				break;
				
			case 2:				// Browse animals
				mode = "browse animals";
				store.printAnimalInventory();
				
				userInput = InputHandler.getUserInput(mode, message);
				navOption = Integer.parseInt(userInput);
				
				cancel_option = 3;
				if (navOption == cancel_option) {						// Return main menu
					break;
				}
				
				
				Animal animal = store.purchaseAnimal(navOption, farm.getMoney());
				
				if (animal == null) {
					System.out.println("Could not purchase animal because not enough money to purchase animal or animal is not in stock.");
					
				} else {
					farm.addAnimal(animal);
					System.out.println(String.format("You have purchased one %s.", animal.getName()));
					farm.subtractMoney(animal.getPrice());
					
				}
				
				break;
				
				
			case 3:
				break;
				
			}
			
		}
		
	}
	
	
	
	
	

	/*
	 * Run game
	 */
	private void runGame()
	{
		
		while (currentDay <= gameDuration)
		{
//			System.out.println("Main loop iteration.");
			mainMenu();
			
		}
		
		
		
		System.out.println("End of game.");
		
		// Print game status/ experience
		
		
		
		
	}
	
	
	
	
	public static void main(String[] args)
	{
		Game game = new Game();
//		game.runGame();
		
	}

	
}



















