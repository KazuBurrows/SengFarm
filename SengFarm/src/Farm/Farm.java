package Farm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Crop.Apple;
import Crop.Corn;
import Crop.Crop;
import Item.Item;

public class Farm extends FarmBonus {
	
	private String name;
	private Farmer farmer;
	private int money;
	
//	private ArrayList<Animal> animals = new ArrayList<Animal>();				// Animals on farm
	private ArrayList<Crop> crops = new ArrayList<Crop>();						// Growing crops on farm
	private ArrayList<Item> items = new ArrayList<Item>();						// All items owned
	
	
	
	/*
	 * Constructor
	 * 
	 * @param farmerCharacter		Farmer object
	 * @param initialMoney			Initial money for farm
	 */
	public Farm(Farmer farmerCharacter)
	{
		setName();
		farmer = farmerCharacter;
		setMoney();
		
	}
	
	
	/*
	 *  Prints the farm’s crops and animals. Includes crop’s time growing, 
	 *  the time left until a crop’s harvest, and an animal’s happiness levels. 
	 */
	public void getStatus()
	{
//		String cropMessage = "Crop status./n  {}: x{}, Harvest in {} days.";
		String cropMessage = "{}: Harvest in {} days.";
		
		Crop crop;
		System.out.println("Crop Status");
		
		Iterator<Crop> cropIter = crops.iterator();
		while (cropIter.hasNext()) {
			crop = cropIter.next();
			
			System.out.println(String.format(cropMessage, crop.getName(), crop.getHarvestDay()));
				
        }
		
		
		
		String animalMessage = "{}: Happiness at {}.";
		
		Animal animal;
		System.out.println("Animal Status");
		
		Iterator<Animal> animalIter = animals.iterator();
		while (animalIter.hasNext()) {
			animal = animalIter.next();
			
			System.out.println(String.format(animalMessage, animal.getName(), animal.getHappy()));
				
        }
		
		
	}
	
	
	
	/*
	 * Get the name of the farm
	 * 
	 * @return		Farm's name
	 */
	public String getName()
	{
		
		return name;
	}
	
	
	
	
	private void setName()
	{
		String scannerMsg = "Enter your farm's name";
		String inputName;
		
 		while (true) {
 			inputName = userInputHelper(scannerMsg);
 			break;
 			
 		}
		
 		
 		name = inputName;
		
	}
	
	
	
	/*
	 * Get total amount of money the farm has
	 * 
	 * @return		Farm's money
	 */
	public int getMoney()
	{
		
		return money;
	}
	
	
	
	private void setMoney()
	{
		
		money = 1000;
	}
	
	
	/*
	 * Add money to the farm's money
	 */
	public void addMoney(int amount)
	{
		money += amount;
		
	}
	
	
	
	/*
	 * Subtract money from the farm's money
	 */
	public void subtractMoney(int amount)
	{
		money -= amount;
		
	}
	
	
	
	/*
	 * Get the number of animals on the farm
	 * 
	 * @return		Total number of animals
	 */
	public int getNumAnimals()
	{
		
		return animals.size();
	}
	
	
	
	/*
	 * Append a new animal to animals arrayList
	 * 
	 * @param animal		Animal object being appended
	 */
	public void addAnimal(Animal animal)
	{
		animals.add(animal);
		
	}
	
	
	
	/*
	 * Pop an animal off the animals arrayList
	 * 
	 * @param animal		Animal object being removed
	 */
	public void removeAnimal(Animal animal)
	{
		animals.remove(animal);
		
	}
	
	
	
	/*
	 * Get the quantity and type of crops are on the farm
	 */
	public void printCrops()
	{
		
		
		
	}
	
	
	
	/*
	 * Get a crop object selected by player
	 * 
	 * @return			Crop selected by the player
	 */
	public Crop getCrop()
	{
		
		// print select options
		
		// get input
		
		// verify
		
		// get crop
		
		// return crop
		
		
		
		String msg = "%s: %s harvest day %s.";
		
		Crop crop = null;
		
		for (int i = 0; i < crops.size(); i++)
		{
			crop = crops.get(i);
			
			
			System.out.println(String.format(msg, i, crop.getName(), crop.getHarvestDay()));
			
			
		}
		
		
		String scannerMsg = "Enter number.";
		int userInput = 0;

		
 		while (true) {
 			userInput = Integer.parseInt(userInputHelper(scannerMsg));
 	 		break;
 			
 		}
		
		
 		
 		
		
		
		return crops.get(userInput);
		
	}
	
	
	
	/*
	 * Append a new crop to crops arrayList
	 * 
	 * @param crop		Crop object being appended
	 */
	public void addCrop(Crop crop)
	{
		crops.add(crop);
		
	}
	
	
	
	/*
	 * Pop a crop off the animals arrayList
	 * 
	 * @param crop		Crop object being removed
	 */
	public void removeCrop(Crop crop)
	{
		crops.remove(crop);
		
	}
	
	
	
	/*
	 * Get the quantity and type of items are in the farm's inventory
	 */
	public void printItems()
	{
		
		// print select options
		
		// get input
		
		// verify
		
		// get crop
		
		// return crop
		
		
	}
	
	
	
	/*
	 * Get a item object selected by player
	 * 
	 * @return			Item selected by the player
	 */
	public Item getItem()
	{
		
		
	}
	
	
	
	/*
	 * Append a new item to items arrayList
	 * 
	 * @param item		Item object being appended
	 */
	public void addItem(Item item)
	{
		items.add(item);
		
	}
	
	
	
	/*
	 * Pop an item off the items arrayList
	 * 
	 * @param item		Item object being removed
	 */
	public void removeItem(Item item)
	{
		items.remove(item);
		
	}


	@Override
	public void applyBonus() {
		// TODO Auto-generated method stub
		
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
	
	
	
	
	
	public static void main(String[] args)
	{
		
		Farmer fer = new Farmer();
		Farm f = new Farm("Test", fer, 0);
		
		Apple a = new Apple();
		Corn c = new Corn();
		
		f.addCrop(a);
		f.addCrop(c);
		
		f.getCrop();
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
