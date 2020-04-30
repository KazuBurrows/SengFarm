package Main;
import Item.AnimalToy;
import Item.ExtraAction;
import Item.FavouriteFood;
import Item.Fertilizer;
import Item.Food;
import Item.Listable;
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
	public void getItems()
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
	public Listable purchaseItem(int itemIndex)
	{
		//need to check quantity of item
		// then reduce quantity of item to one less.
		
		//Give options when item is selected, e.g get item description, or cancel purchase.
		
		switch (itemIndex) { 
        case 0:
            Fertilizer fertilizer = new Fertilizer();
            return fertilizer;
        	
        case 1:
        	Food food = new Food();
            return food;
            
        case 2:
        	FavouriteFood fav_food = new FavouriteFood();
            return fav_food;
            
        case 3:
        	AnimalToy toy = new AnimalToy();
            return toy;
            
        case 4:
        	StoreCoupon coupon = new StoreCoupon();
            return coupon;
            
        case 5:
        	ExtraAction extra_action = new ExtraAction();
            return extra_action;
            
        }
		
		
		return null;
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
