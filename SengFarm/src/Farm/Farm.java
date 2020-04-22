package Farm;
import java.util.ArrayList;

public class Farm extends FarmBonus {
	
	private String name;
	private Farmer farmer;
	private int money;
	
	private ArrayList<Animal> animals = new ArrayList<Animal>();
	private ArrayList<Crop> crops = new ArrayList<Crop>();
	private ArrayList<Item> items = new ArrayList<Item>();
	
//	do I want a list of crops I have and list of crops I have planted
//	If crops are planted is there a max limit on how many there is planted.
	
	
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
		
		
	}
	
	
	
	/*
	 * Get the name of the farm
	 * 
	 * @return		Farm's name
	 */
	public String getName()
	{
		
		
	}
	
	
	
	/*
	 * Get total amount of money the farm has
	 * 
	 * @return		Farm's money
	 */
	public int getMoney()
	{
		
		
	}
	
	
	
	/*
	 * Add money to the farm's money
	 */
	public void addMoney(int amount)
	{
		
		
	}
	
	
	
	/*
	 * Subtract money from the farm's money
	 */
	public void subtractMoney(int amount)
	{
		
		
	}
	
	
	
	/*
	 * Get the number of animals on the farm
	 * 
	 * @return		Total number of animals
	 */
	public int getNumAnimals()
	{
		
		
	}
	
	
	
	/*
	 * Append a new animal to animals arrayList
	 * 
	 * @param animal		Animal object being appended
	 */
	public void addAnimal(Animal animal)
	{
		
		
		
	}
	
	
	
	/*
	 * Pop an animal off the animals arrayList
	 * 
	 * @param animal		Animal object being removed
	 */
	public void removeAnimal(Animal animal)
	{
		
		
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
		
	}
	
	
	
	/*
	 * Pop a crop off the animals arrayList
	 * 
	 * @param crop		Crop object being removed
	 */
	public void removeCrop(Crop crop)
	{
		
		
		
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
