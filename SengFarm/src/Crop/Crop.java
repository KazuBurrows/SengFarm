package Crop;

public class Crop {

	private String name;
	private int price;
	private int harvestDay;
	private int growthRate;
	
	
	public Crop(String cropName, int cropPrice, int cropHarvestDay, int cropGrowthRate)
	{
		name = cropName;
		price = cropPrice;
		harvestDay = cropHarvestDay;
		growthRate = cropGrowthRate;
		
	}
	
	
	
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
	
	
}
