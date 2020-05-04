package Main;

import java.util.Scanner;

import Farm.Farm;
import Farm.Farmer;
import InputHandler.InputHandler;

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
		
//		Event.checkForEvent();
		
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
		
		if (actionType == "main menu") {
			switch (option) {
			case 0:
				mode = "main status";
				
				InputHandler.printNavigationOption(mode);
				
				String userInput = InputHandler.getUserInput(mode, message);
				int navOption = Integer.parseInt(userInput);
				
				handleAction(mode, navOption);
				
				break;
				
			case 1:
				// Tend to farm
				break;
				
			case 2:
				// List crops to tend to
					// User selects crop
					// Water crop
					// or
					// Use item on crop
					// or
					// harvest crop
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
				break;
				
			case 5:
				// Precede to next day
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
		 		
				String userInput = InputHandler.getUserInput(mode, message);
				int navOption = Integer.parseInt(userInput);
				
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
				farm.printCrops();
				
				break;
				
			case 2:
				// Print animal status
				farm.printAnimals();
				
				break;
				
			case 3:
				// Browse inventory	- Just looking in inventory
				
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
		
	}
	
	
	
	
	public static void main(String[] args)
	{
		Game game = new Game();
//		game.runGame();
		
	}

	
}



















