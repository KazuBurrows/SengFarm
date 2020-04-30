package Crop;

public class Crop {

	private String name;
	private int price;
	private int harvestDay;
	private int growthRate;
	private int profit;
	
	
	
	/*
	 * Constructor
	 */
	public Crop(String cropName, int cropPrice, int cropHarvestDay, int cropGrowthRate, int cropProfit)
	{
		name = cropName;
		price = cropPrice;
		harvestDay = cropHarvestDay;
		growthRate = cropGrowthRate;
		profit = cropProfit;
		
	}
	
	
	
	/*
	 * Get the name of crop
	 * 
	 * @return		Name of crop
	 */
	public String getName()
	{
		
		return name;
	}
	
	
	
	public int getPrice()
	{
		
		return price;
	}
	
	
	
	public int getHarvestDay()
	{
		
		return harvestDay;
	}
	
	
	
	public void reduceHarvestDay(int days)
	{
		harvestDay = harvestDay - days;
		
	}
	
	
	
	public int getGrowthRate()
	{
		
		return growthRate;
	}
	
	
	
	public int getCropProfit()
	{
		
		return profit;
	}
	
}
