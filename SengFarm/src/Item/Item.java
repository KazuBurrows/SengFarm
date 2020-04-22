package Item;

public class Item extends ItemBonus implements Listable {
	
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
	 * Only for sub-classes to override
	 */
	@Override
	public void applyItemBonus() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
