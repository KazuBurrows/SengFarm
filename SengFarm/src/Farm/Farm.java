package Farm;
import java.util.ArrayList;
import java.util.Iterator;

import Crop.Crop;
import Item.Item;
import Item.Listable;

public class Farm extends FarmBonus {
	
	private String name;
	private Farmer farmer;
	private int money;
	
	private ArrayList<Animal> animals = new ArrayList<Animal>();				// Animals on farm
	private ArrayList<Crop> crops = new ArrayList<Crop>();						// Growing crops on farm
	private ArrayList<Item> items = new ArrayList<Item>();				// 
	
	
	
	/*
	 * Constructor
	 * 
	 * @param farmName				Name of farm
	 * @param farmerCharacter		Farmer object
	 * @param initialMoney			Initial money for farm
	 */
	public Farm(String farmName, Farmer farmerCharacter, int initialMoney)
	{
		name = farmName;
		farmer = farmerCharacter;
		money = initialMoney;
		
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
	public void getCrops()
	{
		
		
		
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
	public void getItems()
	{
		
		
		
	}
	
	
	
	/*
	 * Append a new item to items arrayList
	 * 
	 * @param item		Item object being appended
	 */
	public void addItem(Item item)
	{
		
		
	}
	
	
	
	/*
	 * Pop an item off the items arrayList
	 * 
	 * @param item		Item object being removed
	 */
	public void removeItem(Item item)
	{
		
		
		
	}


	@Override
	public void applyBonus() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
}
