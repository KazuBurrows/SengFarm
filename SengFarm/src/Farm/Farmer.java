package Farm;
import java.util.Scanner;

///**
// * Explanation of method functionality.
// *
// * @param comet		What the parameter represents.
// * @return 			What the method will return.
// */





public class Farmer {
	
	private String name;
	private int age;
	
	
	
	/*
	 * Constructor to set name and age.
	 */
	public Farmer()
	{
		setName();
		setAge();
		
	}
	
	
	/*
	 * Get the object's name.
	 * 
	 * @return 		The object's name.
	 */
	public String getName()
	{
		return name;
	}
	
	
	
	/*
	 * Set the object's name by user input.
	 */
	private void setName()
	{
		String scannerMsg = "Enter your farmer's name";
		String inputName;
		String verifiedInput;
		
 		while (true) {
 			inputName = userInputHelper(scannerMsg);
 			verifiedInput = verifyUserInput(inputName, "name");
 	 		
 			if (verifiedInput == "null") {
 	 			System.out.println("The length of the name must be between 3 and 15 characters\n and must not include numbers or special charaters.");
 	 			
 	 		} else {
 	 			name = inputName;
 	 			
 	 			System.out.println(String.format("Farmer's name set to: %s.", inputName));
 	 			break;
 	 		}
 		}
	}
	
	
	
	/*
	 * Get the object's age.
	 * 
	 * return 		The object's age.
	 */
	public int getAge()
	{
		return age;
	}
	
	
	
	/*
	 * Set the object's age by user input.
	 */
	private void setAge()
	{
		String scannerMsg = "Enter your farmer's name";
		String inputAge;
		String verifiedInput;
		
		
 		while (true) {
 			inputAge = userInputHelper(scannerMsg);
 			verifiedInput = verifyUserInput(inputAge, "age");
 	 		
 			if (verifiedInput == "null") {
 	 			System.out.println("Farmer's age must be a number greater than 0.");
 	 			
 	 		} else {
 	 			age = Integer.parseInt(inputAge);
 	 			
 	 			System.out.println(String.format("Farmer's age set to: %s.", inputAge));
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
		
// 		sc.close();
 		
 		return userInput;
		
	}
	
	
	
	
	/* 
	 * Verify user input.
	 * 
	 * @param userInput			User's input from Scanner
	 * @param inputType			The type of verification needing to performed.
	 * 
	 * @return 					Return null for user error, else return @param userInput
	 */
	private static String verifyUserInput(String userInput, String verifyType)
	{
		
		if ("name" == verifyType) {

			/* Checks for numerical numbers in userInput string.
			 * 
			 * Taken from https://stackoverflow.com/questions/18590901/check-if-a-string-contains-numbers-java
			 */
			if (userInput.matches(".*\\d.*")) {
				
				return "null";
			}
			
			
			int inputSize = userInput.length();
			if (inputSize < 3 || inputSize > 15) {	// Checks for name length.
				
				return "null";
			}
			

		
		} else {
			try {		// Try to convert userInput to string
				int inputAge = Integer.parseInt(userInput);
				
				if (inputAge < 1) {
					
					return "null";
				}
				
			} catch(Exception e) {
				
				return "null";
			}
		}
		
		
		return userInput;
	}
	
	
	
	
	public static void main(String[] args) {
		
		Farmer f = new Farmer();
		f.getName();
	}
}



