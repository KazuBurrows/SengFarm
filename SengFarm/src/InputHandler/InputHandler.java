package InputHandler;

import java.util.Scanner;

public class InputHandler {

	
	
	
	public static void getUserInput(String inputMode, String message)
	{
		
		String scannerMsg = message;
		String userInput;
		
 		while (true) {
 			userInput = userInputHelper(scannerMsg);
 			
 			// Make a check using inputMode
 			if (validInput(inputMode, userInput)) {
 				
 				
 				break;
 			}
 			
 			
 			
 		}
		
		
		
		
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
	
	
	
	
	public static boolean validInput(String mode, String userInput)
	{
		
		switch (mode) {
		case "game duration":
			if (validGameDuration(userInput)) {
				// Do something
			}
			
			break;
			
		case "farmer name":
			if (validFarmerName(userInput)) {
				// Do something
			}
			
			break;
		
		case "farmer age":
			if (validFarmerAge(userInput)) {
				// Do something
			}
			
			break;
			
		case "farm name":
			if (validFarmName(userInput)) {
				// Do something
			}
			
			break;
			
		case "main menu":
			if (validMainMenuOption(userInput)) {
				// Do something
			}
			
			break;
			
		
		}
			
		

		// If invalid then print some message
		
		return true;
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
	private static boolean validMainMenuOption(String userInput)
	{
		try {															// Try to convert input to integer and check input range
			int option = Integer.parseInt(userInput);
			
			if (option < 0 || option > 5) {								// Check if option value is within range
				System.out.println("Menu option must be a number between 0 and 5 inclusive.");
				
				return false;
			}
		}
		
		catch (NumberFormatException e) {								// Catch for input conversion from string to integer
			System.out.println("Menu option value must be an integer.");
			
			return false;
		}
		
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
//	public static void main(String[] args) {
//		
//		InputHandler.validInput("game duration", "yesy");
//		
//	}
//	
	
	
	
	
	
	
	
	
	
	
}
