package Farm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Crop.Apple;
import Crop.Corn;
import Crop.Crop;
import InputHandler.InputHandler;
import Item.Fertilizer;
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
	 * Get the name of the farm
	 * 
	 * @return		Farm's name
	 */
	public String getName()
	{
		
		return name;
	}
	
	
	
	/*
	 * 
	 */
	private void setName()
	{
 		String mode = "farm name";
 		String message = "Enter your farm's name.";
 		
		String farmName = InputHandler.getUserInput(mode, message);
		
 		name = farmName;
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
	
	
	
	/*
	 * 
	 */
	public void printMoney()
	{
		String moneyStatus = "The farm has $%s.";
		System.out.println(String.format(moneyStatus, getMoney()));
		
	}
	
	
	
	/*
	 * Set farm's money with fixed amount
	 */
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
	
	
	
	public void printAnimals()
	{
	
		
	}
	
	
//	
//	/*
//	 * Get the number of animals on the farm
//	 * 
//	 * @return		Total number of animals
//	 */
//	public int getNumAnimals()
//	{
//		
//		return animals.size();
//	}
//	
//	
//	
//	/*
//	 * Append a new animal to animals arrayList
//	 * 
//	 * @param animal		Animal object being appended
//	 */
//	public void addAnimal(Animal animal)
//	{
//		animals.add(animal);
//		
//	}
//	
//	
//	
//	/*
//	 * Pop an animal off the animals arrayList
//	 * 
//	 * @param animal		Animal object being removed
//	 */
//	public void removeAnimal(Animal animal)
//	{
//		animals.remove(animal);
//		
//	}
	
	
	
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
		
		String[] itemKeys = {"Fertilizer", "Animal food", "Animal's favourite food", "Animal toy", "Extra game action", "Store Coupon"};
		int[] itemCount = new int[6];
		
		Iterator<Item> itr = items.iterator();
		
		Item item;
		int index;
		while (itr.hasNext()) {
			item = itr.next();
			index = Item.itemInstanceOf(item);
			
			itemCount[index]++;
		}
		
		
		// Now print quantity and item names
		String itemStatus = "x%s: %s.";
		
		int itemQuantity;
		String itemKey;
		for (int i = 0; i < itemCount.length; i++) {
			itemQuantity = itemCount[i];
			itemKey = itemKeys[i];
			
			System.out.println(String.format(itemStatus, itemQuantity, itemKey));
			
		}
		
		
		System.out.println("test");
		
	}
	
	
	
	/*
	 * 
	 */
	public void browseInventory()
	{
//		String itemNavigation = "%s: %s";
//		
//		Item item;
//		for (int i = 0; i < items.size(); i++) {
//			item = items.get(i);
//			
//			System.out.println();
//			
//			
//			
//		}
		
		
	}
	
	
	
	/*
//	 * Get a item object selected by player
//	 * 
//	 * @return			Item selected by the player
//	 */
//	public Item getItem()
//	{
//		
//		return items.get();
//	}
	
	
	
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
		
//		Farmer fer = new Farmer();
//		Farm f = new Farm(fer);
				
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
