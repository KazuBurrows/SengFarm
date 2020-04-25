
public class Game {
	
	private int gameDuration;						// The total duration of game
	private int currentDay;							// 
	
	private int totalActions;						// Total actions player has available
	
	
	/*
	 * Constructor
	 */
	public Game(int totalDays)
	{
		gameDuration = totalDays;
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
	 * Verify user input
	 * 
	 * @return			Code
	 */
	private int verifyUserInput()
	{
		
		
	}
	
	
	
	
	/*
	 * Run game
	 */
	private void main()
	{
		
		// Farmer
		// Farm
		// Store
		
		
		// Loop for user input(when they start playing the game)
			// Event		- Called at the start of every day
		
	}
	
	
	
	
}
