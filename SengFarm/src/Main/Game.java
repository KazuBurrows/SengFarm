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
	 * Reads user input.
	 * 
	 * @param scannerMsg		A message to ask the user.
	 * @return 					User's input.
	 */
	private static String userInputHelper(String scannerMsg)
	{
		
		String userInput; 
 		System.out.println(scannerMsg);
		
		Scanner sc = new Scanner(System.in);
 		userInput = sc.nextLine();
		
 		
 		return userInput;
		
	}
	
	

	
	
	private void mainMenu()
	{
		String actionType = "main menu";
		
		String checkStatus = "%s: Check farm status.";
		String tendFarm = "%s: Tend to Farm.";
		String tendCrop = "%s: Tend to crops.";
		String tendAnimal = "%s: Tend to animals.";
		String browseStore = "%s: Browse the store.";
		String endDay = "%s: Go to next day.";
		
		String[] userOptions = {checkStatus, tendFarm, tendCrop, tendAnimal, browseStore, endDay};
		String option;
		
		for (int i = 0; i < userOptions.length; i++) {
			option = userOptions[i];
			
			System.out.println(String.format(option, i));
		}
		
		
		
		String scannerMsg = "Enter number to select an action.";
		String inputOption;
		
 		while (true) {
 			inputOption = userInputHelper(scannerMsg);
 			break;
 			
 		}
 		
 		
 		String mode = "main menu";
 		String message = "Enter number to select an action.";
 		
		String selectedOption = InputHandler.getUserInput(mode, message);
		
 		
 		
 		
 		handleAction(actionType, Integer.parseInt(inputOption));
//		return Integer.parseInt(inputOption);
		
	}
	
	
	
	private void handleAction(String actionType, int option)
	{
		
		if (actionType == "main menu") {
			
			switch (option) {
			
			case 0:
				// Get status options
					// Game status
					// Farm status
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
		

	}
	
	
	
	
	

	/*
	 * Run game
	 */
	private void runGame()
	{
		
		while (currentDay < gameDuration)
		{
			
			mainMenu();
			
			
			
		}
		
	}
	
	
	
	public static void main(String[] args)
	{
		Game game = new Game();
//		game.runGame();
		
	}

	
}



















