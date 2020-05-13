package Item;

import Farm.Farm;

public abstract class ItemBonus {
	
	private String itemBonus;
	
	
	/*
	 * Get the bonus attribute of item
	 * 
	 * @return		Item bonus attribute
	 */
	public String getItemBonusName()
	{
		
		return itemBonus;
	}
	
	
	
	/*
	 * Set the itemBonus
	 * 
	 * @param bonus			Name of item's bonus attribute
	 */
	public void setItemBonusName(String bonus)
	{
		
		itemBonus = bonus;
	}
	
	
	
	/*
	 * Apply a special attribute when item is used
	 */
	public abstract void useItem(Object object);
	
	
}
