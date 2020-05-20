package InputHandler;

import java.util.ArrayList;
import java.util.Scanner;

public class InputHandler {

	
	
	/*
	 * 
	 * 
	 * @param inputMode				Where this method was called from
	 * @param message				Message to print to user
	 */
	public static String getUserInput(String mode, String message)
	{
		
		String scannerMsg = message;
		String userInput;
		
 		while (true) {
 			userInput = userInputHelper(scannerMsg);
 			
 			if (validInput(mode, userInput)) {							// If input is valid
 				break;
 			}
 		}
		
		
		return userInput;
	}
	
	
	
	public static String getSpecialUserInput(String mode, String message, int indexRange)
	{
		String scannerMsg = message;
		String userInput;
		
 		while (true) {
 			userInput = userInputHelper(scannerMsg);
 			
 			if (specialValidInput(mode, userInput, indexRange)) {							// If input is valid
 				break;
 			}
 		}
		
		
		return userInput;
		
		
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
	 * 
	 * 
	 * @param mode
	 * @param userInput
	 * @return
	 */
	private static boolean validInput(String mode, String userInput)
	{
		
		switch (mode) {
		case "game duration":
			if (validGameDuration(userInput)) {
				return true;
			}
			
			break;
			
		case "farmer name":
			if (validFarmerName(userInput)) {
				return true;
			}
			
			break;
		
		case "farmer age":
			if (validFarmerAge(userInput)) {
				return true;
			}
			
			break;
			
		case "farm name":
			if (validFarmName(userInput)) {
				return true;
			}
			
			break;
			
		case "main menu":
			if (validNavigationOption(userInput, 6)) {
				return true;
			}
			
			break;
			
		case "main status":
			if (validNavigationOption(userInput, 2)) {
				return true;
			}
			
			break;
			
		case "farm status":
			if (validNavigationOption(userInput, 4)) {
				return true;
			}
			
			break;
			
			
		case "select tend crop":
			if (validNavigationOption(userInput, 3)) {
				return true;
			}
			
			break;
			
		case "select tend animal":
			if (validNavigationOption(userInput, 4)) {
				return true;
			}
			
			break;
			
			
		case "browse store":
			if (validNavigationOption(userInput, 3)) {
				return true;
			}
			
			break;
			
		case "browse items":
			if (validNavigationOption(userInput, 6)) {
				return true;
			}
			
			break;
			
		case "browse crops":
			if (validNavigationOption(userInput, 4)) {
				return true;
			}
			
			break;
			
		case "browse animals":
			if (validNavigationOption(userInput, 3)) {
				return true;
			}
			
			break;
		}
		
		System.out.println("Please select a valid number.");
		return false;
	}
	
	
	
	
	private static boolean specialValidInput(String mode, String userInput, int indexRange)
	{
		if (validNavigationOption(userInput, indexRange)) {
			
			return true;
		}
		
		
		return false;
	}
	
	
	
	
	/*
	 * Validate user's input for game duration
	 * 
	 * @param userInput
	 * @return
	 */
	private static boolean validGameDuration(String userInput)
	{
		
		try {															// Try to convert input to integer and check input range
			int duration = Integer.parseInt(userInput);
			
			if (duration < 1 || duration > 6) {							// Check if game duration is within range
				System.out.println("Game duration must be a number between 1 and 6 inclusive.");
				
				return false;
			}
		}
		
		catch (NumberFormatException e) {								// Catch for input conversion from string to integer
			System.out.println("Game duration must be an integer.");
			
			return false;
		}
		
		
		return true;
	}
	
	
	
	
	
	/*
	 * Validate user's input for farmer's name
	 * 
	 * @param userInput
	 * @return
	 */
	private static boolean validFarmerName(String userInput)
	{
		int nameLength = userInput.length();
		
		if (nameLength < 3 || nameLength > 15) {						// Check if length of name is within range
			System.out.println("The length of the name must be between 3 and 15 characters"
					+ "\r\nand must not include numbers or special charaters.");
			
			return false;
		}
		
		
		if (userInput.matches(".*\\d.*")) {								// Check if name contains any special characters and integers
			System.out.println("Farmer's name must only contain alphabetical characters(a-b and A-B).");
			
			return false;
		}
		
		
		return true;
	}
	
	
	
	
	/*
	 * Validate user's input for farmer's age
	 * 
	 * @param userInput
	 * @return
	 */
	private static boolean validFarmerAge(String userInput)
	{
		try {															// Try to convert input to integer and check input range
			int age = Integer.parseInt(userInput);
			
			if (age < 0) {												// Check if age is within range
				System.out.println("Farmer's age must be greater than 0.");
				
				return false;
			}
		}
		
		catch (NumberFormatException e) {								// Catch for input conversion from string to integer
			System.out.println("Farmer's age must be an integer.");
			
			return false;
		}
		
		
		return true;
	}
	
	
	
	
	/*
	 * Validate user's input for farm's name
	 * 
	 * @param userInput
	 * @return
	 */
	private static boolean validFarmName(String userInput)
	{
		int nameLength = userInput.length();
		
		if (nameLength < 3) {											// Check if length of name is within range
			System.out.println("Farm name length must be 3 or greater.");
			
			return false;
		}
		
		if (userInput.matches(".*\\d.*")) {								// Check if name contains any special characters and integers
			System.out.println("Farm's name must only contain alphabetical characters(a-b and A-B).");
			
			return false;
		}
		
		
		return true;
	}
	
	
	
	
	/*
	 * Validate user's input for main menu option value
	 * 
	 * @param userInput
	 * @return
	 */
	private static boolean validNavigationOption(String userInput, int numOptions)
	{
//		System.out.println("validNavigationOption " + userInput + " numOptions " + numOptions);
		
		try {															// Try to convert input to integer and check input range
			int option = Integer.parseInt(userInput);
			
			if (option < 0 || option > numOptions) {								// Check if option value is within range
				String outOfRangeMessage = "Your option must be a number between 0 and %s inclusive.";
				System.out.println(String.format(outOfRangeMessage, numOptions));
				
				return false;
			}
		}
		
		catch (NumberFormatException e) {								// Catch for input conversion from string to integer
			System.out.println("Your option value must be an integer.");
			
			return false;
		}
		
		
		return true;
	}
	
	
	
	
	
	/*
	 * Print navigation options for main menu
	 */
	public static void printNavigationOption(String mode)
	{
		
		ArrayList<String> userOptions = new ArrayList<String>();
		String option;
		String cancel_option = "%s: Return to main menu.";
		
		switch (mode) {
		case "main menu":
			String checkStatus = "%s: Check game status.";
			String tendFarm = "%s: Tend to Farm.";
			String tendCrop = "%s: Tend to crops.";
			String tendAnimal = "%s: Tend to animals.";
			String browseStore = "%s: Browse the store.";
			String endDay = "%s: Go to next day.";
			
			userOptions.add(checkStatus);
			userOptions.add(tendFarm);
			userOptions.add(tendCrop);
			userOptions.add(tendAnimal);
			userOptions.add(browseStore);
			userOptions.add(endDay);
			
			break;
			
			
		case "main status":
			String gameStatus = "%s: Check game status.";
			String farmStatus = "%s: Check farm status.";
			
			
			userOptions.add(gameStatus);
			userOptions.add(farmStatus);
			
			break;
			
			
		
		case "farm status":
			String totalMoney = "%s: Check money.";
			String cropStatus = "%s: Check crops.";
			String animalStatus = "%s: Check animals.";
			String browseInventory = "%s: Browse inventory.";
			
			userOptions.add(totalMoney);
			userOptions.add(cropStatus);
			userOptions.add(animalStatus);
			userOptions.add(browseInventory);
			
			break;
		
			
		
		case "select tend crop":
			String useWater = "%s: Use water.";
			String useItem = "%s: Use an item.";
			String harvest = "%s: Harvest crop.";
			
			userOptions.add(useWater);
			userOptions.add(useItem);
			userOptions.add(harvest);
		
			break;
			
			
		case "select tend animal":
			String useRegFood = "%s: Feed regular food.";
			String useSpecFood = "%s: Feed special food.";
			String play = "%s: Play with animal.";
			String playToy = "%s: Play with animal with toy.";
			
			userOptions.add(useRegFood);
			userOptions.add(useSpecFood);
			userOptions.add(play);
			userOptions.add(playToy);
			
			break;
			
			
		case "browse store":
			String browseItem = "%s: Browse items.";
			String browseCrop = "%s: Browse crops.";
			String browseAnimal = "%s: Browse animals.";
			
			userOptions.add(browseItem);
			userOptions.add(browseCrop);
			userOptions.add(browseAnimal);
			
			break;
			
		}
		
		if (mode != "main menu") {
			userOptions.add(cancel_option);		// Cancel option
		}
		
		
		// Print navigation options
		for (int i = 0; i < userOptions.size(); i++) {
			option = userOptions.get(i);
			
			System.out.println(String.format(option, i));
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
//	public static void main(String[] args) {
//		
//		InputHandler.validInput("game duration", "yesy");
//		
//	}
//	
	
	
	
	
	
	
	
	
	
	
}
