package Main;
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
	private int[] inventory = {0, 0, 0, 0, 0, 0};
	private String[] inventoryKeys = {"Fertilizer", "Food", "Favourite food", "Animals toy", "Store coupon", "Extra action card"};
	
	
	
	/*
	 * Constructor. Populates the inventory on initialization.
	 */
	public Store()
	{
		
		populateInventory();
		
	}
	
	
	
	
	/*
	 * Prints to the user the quantities of each item in the inventory and how to select the item.
	 */
	public void printInventory()
	{
		String message = "%d : %s. %d in stock.";
		String itemName;
		int itemQuantity;
		
		for (int i=0; i < 6; i++) {
			itemName = inventoryKeys[i];
			itemQuantity = inventory[i];
			
			System.out.println(String.format(message, i, itemName, itemQuantity));
			
		}
	}
	
	
	
	// Maybe, just create an interface type to return instead of Item. Otherwise I only return item and not sub-class.
	// Unless I find another way, like successful purchase, and unsuccessful purchase. Then some validation.
	
	/*
	 * Verify input, then reduces the quantity of an item in the inventory by one.
	 */
	public Item purchaseItem(int itemIndex, int playerMoney)
	{
		//Give options when item is selected, e.g get item description, or cancel purchase.
		
		switch (itemIndex) { 
        case 0:
            Fertilizer fertilizer = new Fertilizer();
            
            if (canPurchase(itemIndex, fertilizer, playerMoney)) {
            	inventory[itemIndex]--;
            	
            	return fertilizer;
            }
            
            return null;
        	
        case 1:
        	Food food = new Food();
        	
        	if (canPurchase(itemIndex, food, playerMoney)) {
            	inventory[itemIndex]--;
            	
            	return food;
            }
        	
            return null;
            
        case 2:
        	FavouriteFood fav_food = new FavouriteFood();
        	
        	if (canPurchase(itemIndex, fav_food, playerMoney)) {
            	inventory[itemIndex]--;
            	
            	return fav_food;
            }
        	
            return null;
            
        case 3:
        	AnimalToy toy = new AnimalToy();
        	
        	if (canPurchase(itemIndex, toy, playerMoney)) {
            	inventory[itemIndex]--;
            	
            	return toy;
            }
        	
            return null;
            
        case 4:
        	StoreCoupon coupon = new StoreCoupon();
            return coupon;
            
        case 5:
        	ExtraAction extra_action = new ExtraAction();
        	
        	if (canPurchase(itemIndex, extra_action, playerMoney)) {
            	inventory[itemIndex]--;
            	
            	return extra_action;
            }
        	
            return null;
            
        }
		
		
		return null;
	}
	
	
	
	
	private boolean canPurchase(int itemIndex, Item item, int playerMoney)
	{
		if (inventory[itemIndex] < 0) {
			return false;
		}
		
		if (item.getPrice() > playerMoney) {
			return false;
		}
		
		
		return true;
	}
	
	
	
	
	/*
	 * Populates the inventory by a random quantity for each item.
	 */
	private void populateInventory()
	{
		int itemQuantity;
		
		for (int i=0; i < 6; i++) {
			itemQuantity = (int)(Math.random()*6);
			
			inventory[i] = itemQuantity;
			
		}	
	}
	
	
	
	
//	public static void main(String[] args) {
//		
////		System.out.println((Math.random()*10));
////		Store s = new Store();
//		
////		s.getItems();
//		
//		Fertilizer t = new Fertilizer();
//		t.testMethod();
//		
//	}
//	
	
	
}
