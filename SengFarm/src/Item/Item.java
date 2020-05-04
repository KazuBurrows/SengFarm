package Item;

import Farm.Farm;

public class Item extends ItemBonus {
	
	private String name;
	private int price;
	private String description;
	
	/*
	 * Constructor
	 * 
	 * @param itemName 			Name of item
	 * @param itemPrice			Price of item
	 * @param itemDescription 	Description of an item
	 * @param itemBonusName		Item's attribute name
	 */
	public Item(String itemName, int itemPrice, String itemDescription, String itemBonusName)
	{
		name = itemName;
		price = itemPrice;
		description = itemDescription;
		
		setItemBonusName(itemBonusName);
	}
	
	
	
	/*
	 * Get the item name
	 * 
	 * @return 		Item name
	 */
	public String getName()
	{
		
		return name;
	}
	
	
	
	/*
	 * Get the item price
	 * 
	 * @return		Item price
	 */
	public int getPrice()
	{
		
		return price;
	}
	
	
	
	/*
	 * Get the description of item
	 * 
	 * @return		Item description
	 */
	public String getDescription()
	{
		
		return description;
	}
	

	
	/*
	 * 
	 */
	public static int itemInstanceOf(Item item) {
		
		if (item instanceof Fertilizer) {
			return 0;
		}
		else if (item instanceof Food) {
			return 1;
		}
		else if (item instanceof FavouriteFood) {
			return 2;
		}
		else if (item instanceof AnimalToy) {
			return 3;
		}
		else if (item instanceof ExtraAction) {
			return 4;
		}
		else if (item instanceof StoreCoupon) {
			return 5;
		}
		
		return 0;
	}
	
	
	
	
	
//	/*
//	 * Only for sub-classes to override
//	 */
//	@Override
//	public void useItem(Farm farm) {
//		// TODO Auto-generated method stub
//		
//	}
	
	
	
	
}
