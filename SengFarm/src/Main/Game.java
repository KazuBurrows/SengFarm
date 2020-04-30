package Main;

import java.util.Scanner;

import Farm.Farm;
import Farm.Farmer;

public class Game {
	
	private int gameDuration;						// The total duration of game
	private int currentDay;							// 
	
	private int totalActions;						// Total actions player has available
	
	
	/*
	 * Constructor
	 */
	public Game()
	{
		gameDuration = setGameDuration();
		currentDay = 0;
		
		totalActions = 2;
		
		
		main();
		
	}
	
	
	
	/*
	 * 
	 * 
	 * @return			The total duration of game
	 */
	private int getGameDuration()
	{
		
		return gameDuration;
	}
	
	
	
	private int setGameDuration()
	{
		String scannerMsg = "Enter your farmer's name";
		String days;
		
 		while (true) {
 			days = userInputHelper(scannerMsg);
 			break;
 			
 		}
		
 		
 		return Integer.parseInt(days);
		
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
	
	
	
	private void nextDay()
	{
		currentDay++;
		
	}
	
	
	/*
	 * 
	 * 
	 * @return			Total actions player has available
	 */
	private int totalActions()
	{
		
		return totalActions;
	}
	
	
	
	/*
	 * Add an extra action to total actions player has available
	 */
	public void addAction()
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
	 * Verify user input
	 * 
	 * @return			Code
	 */
	private int verifyUserInput()
	{
		
		
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
	
	
	

	/*
	 * Run game
	 */
	private void runGame()
	{
		Farmer farmer = new Farmer();
		Farm farm = new Farm(farmer);
		Store store = new Store();
		Event event = new Event();
		
		
		while (currentDay < gameDuration)
		{
			event.checkForEvent();
			
			// Give user options
			
			
			
		}
		
	}
	
	
	
	public static void main(String[] args)
	{
		Game game = new Game();
		game.runGame();
		
	}

	
}



















