package Farm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Crop.Apple;
import Crop.Corn;
import Crop.Crop;
import InputHandler.InputHandler;
import Item.FavouriteFood;
import Item.Fertilizer;
import Item.Food;
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
		money = 1000;
		
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
	 * Crop name harvest day.
	 */
	public void printCrops(int currentDay)
	{
		
		if (crops.size() > 0) {
			Iterator<Crop> itr = crops.iterator();
			String msg = "%s will be ready to be harvested in %s days.";
			
			Crop crop;
			String cName;
			int cHarvestReady;
			while (itr.hasNext()) {
				crop = itr.next();
				
				cName = crop.getName();
				cHarvestReady = Math.max(0, crop.getHarvestDay() - currentDay);
				
				System.out.println(String.format(msg, cName, cHarvestReady));
				
			}
			
		} else {
			System.out.println("The farm has no crops growing. Go to the store to purchace crops.");
			
		}
		
	}

	
	
	
	/*
	 * 
	 */
	public void browseCrops(int currentDay)
	{
		if (crops.size() <= 0) {
			System.out.println("The farm has no crops growing. Go to the store to purchace crops.");
			
			return;
		}
		
		
		String msg = "%s: %s can be harvested in %s days.";
		
		Crop crop;
		String cName;
		int cHarvestReady;
		
		for (int i = 0; i < crops.size(); i++) {
			crop = crops.get(i);
			
			cName = crop.getName();
			cHarvestReady = Math.max(0, crop.getHarvestDay() - currentDay);
			
			
			System.out.println(String.format(msg, i, cName, cHarvestReady));
			
		}
		
		
		
		
	}
	
	
	
	
	
	public int getNumCrops()
	{
		
		return crops.size();
	}
	
	
	
	/*
	 * Get a crop object using index
	 * 
	 * @param  index	Crop object index in crops arraylist
	 * @return			Crop selected by the player
	 */
	public Crop getCrop(int index)
	{
		

		return crops.get(index);
		
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
	
	
	
	public void harvestCrop(Crop crop, int currentDay)
	{
		String msg;
		if (crop.getHarvestDay() > currentDay) {
			msg = "%s is not ready for harvest.";
			System.out.println(String.format(msg, crop.getName()));
			
			return;
		}
		
		
		int amount = crop.getCropProfit();
		addMoney(amount);
		removeCrop(crop);
		
		msg = "%s has been harvested and $%s has been added to the farm's money.";
		System.out.println(String.format(msg, crop.getName(), amount));
		
	}
	
	
	public int getNumItems()
	{
		
		return items.size();
	}
	
	
	
	
	
	/*
	 * Get the quantity and type of items are in the farm's inventory
	 */
	public void printItems()
	{
		
		if (items.size() > 0) {
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
				
				if (itemQuantity > 0) {
					System.out.println(String.format(itemStatus, itemQuantity, itemKey));
					
				}
				
				
			}
		
		} else {
			
			System.out.println("Inventory is empty. Go to the store to purchace items.");
			
		}
		
	}
	
	
	
	/*
	 * 
	 * 
	 * param browseType					To only return usable items for request e.g tend to crops, return on fertilizer
	 */
	public ArrayList<Item> browseInventory(String browseType)
	{
//		String[] itemKeys = {"Fertilizer", "Animal food", "Animal's favourite food", "Animal toy", "Extra game action", "Store Coupon"};
		ArrayList<String> itemKeys = new ArrayList<String>(); ;
		String itemNavigation = "%s: %s";
		
		ArrayList<Item> navOptionList = new ArrayList<Item>();
		
		switch(browseType) {
		case "tend crop":
			itemKeys.add("Fertilizer");
			
			
			Item item;
			for (int i=0; i<items.size(); i++) {
				item = items.get(i);
				
				if (itemKeys.contains(item.getName())) {
					navOptionList.add(item);
				}
			}
			
			break;
		
		
		}
		
		
		return navOptionList;
	}
	
	
	
	
	
	
//	/*
//	 /* Get a item object selected by player
//	 * 
//	 * @return			Item selected by the player
//	 */
//	public Item getItem()
//	{
//		
//		return items.get();
//	}
//	
	
	
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
		
		Farmer farmer = new Farmer();
		Farm farm = new Farm(farmer);
		
		
		Fertilizer f = new Fertilizer();
		farm.addItem(f);
		
		Food food = new Food();
		farm.addItem(food);
		
		FavouriteFood fav_food = new FavouriteFood();
		farm.addItem(fav_food);
		
		ArrayList<Item> browse_item = farm.browseInventory("tend crop");
		
		for (int i=0; i<browse_item.size(); i++) {
			System.out.println(browse_item.get(i).getName());
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
