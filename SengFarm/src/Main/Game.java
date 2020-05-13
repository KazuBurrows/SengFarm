package Main;

import java.util.ArrayList;
import java.util.Scanner;

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
		farm = new Farm(farmer);
		store = new Store();
		event = new Event();
		
		Apple a = new Apple(currentDay);
		farm.addCrop(a);
		
		Fertilizer f = new Fertilizer();
		farm.addItem(f);
		
		Fertilizer f2 = new Fertilizer();
		farm.addItem(f2);
		
		
		runGame();
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
		
		event.checkForEvent(farm);
		
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
	
	
	
	/*
	 * Print game status.
	 */
	private void printGameStatus()
	{
		String remainingDays = "Day %s of %s.";
		String remainingActions = "Remaining actions available: %s.";
		
		System.out.println(String.format(remainingDays, getCurrentDay(), getGameDuration()));
		System.out.println(String.format(remainingActions, getTotalActions()));
		
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
				
			case 1:
				// Tend to farm
				mode = "tend farm";
				
				
				
				break;
				
			case 2:
				// Tend to crops
				
				mode = "tend crop";
				
				farm.browseCrops(currentDay);
				int numCrops = farm.getNumCrops();
				
				if (numCrops <= 0) {
					break;
				}
				userInput = InputHandler.getSpecialUserInput(mode, message, numCrops);
				navOption = Integer.parseInt(userInput);
				
				Crop crop = farm.getCrop(navOption);
				
				
				// Options water or use item
				mode = "select tend crop";
				
				InputHandler.printNavigationOption(mode);
				
				userInput = InputHandler.getUserInput(mode, message);
				navOption = Integer.parseInt(userInput);
				
				
				switch (navOption) {
				case 0:												// water
					if (getTotalActions() <= 0) {
						System.out.println("You do not have any more actions available. "
								+ "Proceed to the next day for more actions or purchase an action from the store. ");
						
					} else {
						crop.reduceHarvestDay(1);
						subtractAction();
						
						msg = "%s was watered and is ready for harvest in %s days.";
						System.out.println(String.format(msg, crop.getName(), Math.max(0, crop.getHarvestDay() - currentDay)));
						msg = "You have %s remaining actions left.";
						System.out.println(String.format(msg, totalActions));
					}
					
					break;
					
				case 1:												// item
					System.out.println("In navigation option item(case 1)");
					
					if (getTotalActions() <= 0) {
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
						
						msg = "%s has been used on %s and is ready for harvest in %s days.";
						System.out.println(String.format(msg, item.getName(), crop.getName(), Math.max(0, crop.getHarvestDay() - currentDay)));
						msg = "You have %s remaining actions left.";
						System.out.println(String.format(message, totalActions));
						
					}
					

					break;
					
				case 2:												// harvest
					farm.harvestCrop(crop, currentDay);
					
					break;
				
				}
				

				break;
				
			case 3:
				// List animals to tend to
					// User selects animal
					// Feed
					// or
					// Play
				break;
				
			case 4:
				// Browse store
					// Print what's for sale with quantity and price
				
				farm.printMoney();
				
				mode = "browse store";
				store.printInventory();
				
				userInput = InputHandler.getUserInput(mode, message);
				navOption = Integer.parseInt(userInput);
				
				
				// Check if item can be bought
				Item item = store.purchaseItem(navOption, farm.getMoney());
				
				if (item == null) {
					System.out.println("Could not purchase item because not enough money to purchase item or item is not in stock.");
					
				} else {
					farm.addItem(item);
					System.out.println(String.format("You have purchased one %s.", item.getName()));
					farm.subtractMoney(item.getPrice());
					
				}
				
				
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
			
			}
			
		}
		
		

	}
	
	
	
	
	

	/*
	 * Run game
	 */
	private void runGame()
	{
		
		while (currentDay < gameDuration)
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



















