package Main;
import Animal.Animal;
import Crop.Apple;
import Crop.Corn;
import Crop.Crop;
import Crop.Sunflower;
import Crop.Wheat;
import Item.AnimalToy;
import Item.ExtraAction;
import Item.FavouriteFood;
import Item.Fertilizer;
import Item.Food;
import Item.Item;
import Item.StoreCoupon;

public class Store {

	
	/*
	 * index 0 : Fertilizer
	 * index 1 : Food
	 * index 2 : FavouriteFood
	 * index 3 : AnimalToy
	 * index 4 : StoreCoupon
	 * index 5 : ExtraAction
	 */
	private int[] itemInventory = {0, 0, 0, 0, 0, 0};
	private String[] itemInventoryKeys = {"Fertilizer", "Food", "Favourite food", "Animals toy", "Store coupon", "Extra action card"};
	private int[] itemInventoryKeysCost = {20, 10, 16, 30, 50, 400};
	
	
	private int[] cropInventory = {0, 0, 0, 0};
	private String[] cropInventoryKeys = {"Apple", "Corn", "Sunflower", "Wheat"};
	private int[] cropInventoryKeysCost = {50, 30, 20, 40};
	
	
	
	private int[] animalInventory = {0, 0, 0, 0};
	private String[] animalInventoryKeys = {"Cow", "Rabbit", "Horse"};
	private int[] animalInventoryKeysCost = {80, 30, 30};
	
	
	
	/*
	 * Constructor. Populates the itemInventory on initialization.
	 */
	public Store()
	{
		
		populateInventory();
		
	}
	
	
	
	
	/*
	 * Prints to the user the quantities of each item in the itemInventory and how to select the item.
	 */
	public void printItemInventory()
	{
		String message = "%d: %s. Price is $%d. %d in stock.";
		String itemName;
		int itemQuantity;
		int itemPrice;
		
		for (int i=0; i < itemInventoryKeys.length; i++) {
			itemName = itemInventoryKeys[i];
			itemQuantity = itemInventory[i];
			itemPrice = itemInventoryKeysCost[i];
			
			System.out.println(String.format(message, i, itemName, itemPrice, itemQuantity));
			
		}
	}
	
	
	public void printCropInventory()
	{
		String message = "%d: %s. Price is $%d. %d in stock.";
		String cropName;
		int cropQuantity;
		int cropPrice;
		
		for (int i=0; i < cropInventoryKeys.length; i++) {
			cropName = cropInventoryKeys[i];
			cropQuantity = cropInventory[i];
			cropPrice = cropInventoryKeysCost[i];
			
			System.out.println(String.format(message, i, cropName, cropPrice, cropQuantity));
			
		}
	}
	
	
	
	public void printAnimalInventory()
	{
		String message = "%d: %s. Price is $%d. %d in stock.";
		String animal_name;
		int animal_quantity;
		int animal_price;
		
		for (int i=0; i < animalInventoryKeysCost.length; i++) {
			animal_name = animalInventoryKeys[i];
			animal_quantity = animalInventory[i];
			animal_price = animalInventoryKeysCost[i];
			
			System.out.println(String.format(message, i, animal_name, animal_price, animal_quantity));
			
		}
	}
	
	
	
	
	
	
	// Maybe, just create an interface type to return instead of Item. Otherwise I only return item and not sub-class.
	// Unless I find another way, like successful purchase, and unsuccessful purchase. Then some validation.
	
	/*
	 * Verify input, then reduces the quantity of an item in the itemInventory by one.
	 */
	public Item purchaseItem(int itemIndex, int playerMoney)
	{
		//Give options when item is selected, e.g get item description, or cancel purchase.
		String mode = "item";
		
		switch (itemIndex) { 
        case 0:
            Fertilizer fertilizer = new Fertilizer();
            
            if (canPurchase(itemIndex, fertilizer, playerMoney, mode)) {
            	itemInventory[itemIndex]--;
            	
            	return fertilizer;
            }
            
            return null;
        	
        case 1:
        	Food food = new Food();
        	
        	if (canPurchase(itemIndex, food, playerMoney, mode)) {
            	itemInventory[itemIndex]--;
            	
            	return food;
            }
        	
            return null;
            
        case 2:
        	FavouriteFood fav_food = new FavouriteFood();
        	
        	if (canPurchase(itemIndex, fav_food, playerMoney, mode)) {
            	itemInventory[itemIndex]--;
            	
            	return fav_food;
            }
        	
            return null;
            
        case 3:
        	AnimalToy toy = new AnimalToy();
        	
        	if (canPurchase(itemIndex, toy, playerMoney, mode)) {
            	itemInventory[itemIndex]--;
            	
            	return toy;
            }
        	
            return null;
            
        case 4:
        	StoreCoupon coupon = new StoreCoupon();
        	
        	if (canPurchase(itemIndex, coupon, playerMoney, mode)) {
            	itemInventory[itemIndex]--;
            	
            	return coupon;
            }
        	
            return null;
            
            
        case 5:
        	ExtraAction extra_action = new ExtraAction();
        	
        	if (canPurchase(itemIndex, extra_action, playerMoney, mode)) {
            	itemInventory[itemIndex]--;
            	
            	return extra_action;
            }
        	
            return null;
            
        }
		
		
		return null;
	}
	
	
	public Crop purchaseCrop(int cropIndex, int playerMoney, int currentDay)
	{
		//Give options when item is selected, e.g get item description, or cancel purchase.
		String mode = "crop";
		
		switch (cropIndex) { 
        case 0:
            Apple apple = new Apple(currentDay);
            
            if (canPurchase(cropIndex, apple, playerMoney, mode)) {
            	itemInventory[cropIndex]--;
            	
            	return apple;
            }
            
            return null;
        	
        case 1:
        	Corn corn = new Corn(currentDay);
        	
        	if (canPurchase(cropIndex, corn, playerMoney, mode)) {
            	itemInventory[cropIndex]--;
            	
            	return corn;
            }
            
            return null;
            
        case 2:
        	Sunflower sunflower = new Sunflower(currentDay);
        	
        	if (canPurchase(cropIndex, sunflower, playerMoney, mode)) {
            	itemInventory[cropIndex]--;
            	
            	return sunflower;
            }
            
            return null;
            
        case 3:
        	Wheat wheat = new Wheat(currentDay);
        	
        	if (canPurchase(cropIndex, wheat, playerMoney, mode)) {
            	itemInventory[cropIndex]--;
            	
            	return wheat;
            }
            
            return null;
            
            
        }
		
		
		return null;
	}
	
	
	
	
	
	
	public Animal purchaseAnimal()
	{
		
		
		
		
		return null;
	}
	
	
	
	
	private boolean canPurchase(int itemIndex, Object obj, int playerMoney, String purchaseType)
	{
		switch(purchaseType) {
		case "item":
			if (itemInventory[itemIndex] < 0) {
				return false;
			}
			
			if (((Item) obj).getPrice() > playerMoney) {
				return false;
			}
			
			break;
			
		case "crop":
			if (cropInventory[itemIndex] < 0) {
				return false;
			}
			
			if (((Crop) obj).getPrice() > playerMoney) {
				return false;
			}
			
			break;
			
			
		case "animal":
			if (animalInventory[itemIndex] < 0) {
				return false;
			}
			
			if (((Animal) obj).getPrice() > playerMoney) {
				return false;
			}
			
			break;
		}
		

		return true;
	}
	
	
	
	
	/*
	 * Populates the itemInventory by a random quantity for each item.
	 */
	private void populateInventory()
	{
		int itemQuantity;
		int cropQuantity;
		int animalQuantity;
		
		int minQuantity;
		int maxQuantity;
		
		
		minQuantity = 1;
		maxQuantity = 6 - minQuantity;
		for (int i=0; i < itemInventoryKeys.length; i++) {
			itemQuantity = minQuantity + (int)(Math.random() * maxQuantity);
			itemInventory[i] = itemQuantity;
			
		}
		
		
		maxQuantity = 20;
		for (int i=0; i < cropInventoryKeys.length; i++) {
			cropQuantity = (int)(Math.random() * maxQuantity);
			cropInventory[i] = cropQuantity;
			
		}
		
		
		minQuantity = 10;
		maxQuantity = 40 - minQuantity;
		for (int i=0; i < animalInventoryKeys.length; i++) {
			animalQuantity = minQuantity + (int)(Math.random() * maxQuantity);
			animalInventory[i] = animalQuantity;
			
		}
		
		
	}
	
	
	
	
//	public static void main(String[] args) {
		
//		System.out.println((int)(Math.random()* 11));
//		Store s = new Store();
		
//		s.getItems();
		
//		Fertilizer t = new Fertilizer();
//		t.testMethod();
		
//	}
	
	
	
}
