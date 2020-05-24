package Animal;

import Item.Item;

public class Animal {
	
	
	private String name;
	private int price;
	private int health;
	private int happiness;
	private int dailyProfit;
	
	
	public Animal(String param_name, int param_price, int param_profit)
	{
		name = param_name;
		price = param_price;
		health = 100;
		happiness = 100;
		dailyProfit = param_profit;
	}
	
	
	
	
	public String getName()
	{
		
		return name;
	}
	
	
	
	public int getPrice()
	{
		
		return price;
	}
	
	
	
	public int getHealth()
	{
		
		return health;
	}
	
	
	
	public void addHealth(int amount, String farmType)
	{
		if (amount < 0) {
			System.out.println("addHealth amount param is " + amount);
			System.out.println("No change was made to animals health.");
			return;
			
		}
		
		if (farmType == "animal") {
			health = Math.min(150, health + amount);
			
		} else {
			health = Math.min(100, health + amount);
			
		}
		
		
		
//		String msg = "%s's health is now %s.";
//		System.out.println(String.format(msg, name, health));
		
	}
	
	
	
	public void reduceHealth(int amount)
	{
		if (amount < 0) {
			System.out.println("reduceHealth amount param is " + amount);
			System.out.println("No change was made to animals health.");
			return;
			
		}
		
		health = Math.max(0, health - amount);
		
//		String msg = "%s's health is now %s.";
//		System.out.println(String.format(msg, name, health));
		
	}
	
	
	
	
	public int getHappiness()
	{
		
		return happiness;
	}
	
	
	
	public void addHappiness(int amount, String farmType)
	{
		if (amount < 0) {
			System.out.println("addHappiness amount param is " + amount);
			System.out.println("No change was made to animals happiness.");
			return;
			
		}
		
		
		if (farmType == "animal") {
			happiness = Math.min(150, happiness + amount);
			
		} else {
			happiness = Math.min(100, happiness + amount);
			
		}
		
//		String msg = "%s's happiness is now %s.";
//		System.out.println(String.format(msg, name, happiness));
		
	}
	
	
	
	public void reduceHappiness(int amount)
	{
		if (amount < 0) {
			System.out.println("reduceHappiness amount param is " + amount);
			System.out.println("No change was made to animals happiness.");
			return;
			
		}
		
		happiness = Math.max(0, happiness - amount);
//		System.out.println(name + " " + happiness);
//		String msg = "%s's happiness is now %s.";
//		System.out.println(String.format(msg, name, happiness));
		
		
	}
	
	
	
	
	public void playAnimal(int health_amount, int happiness_amount, String farmType)
	{
		addHealth(health_amount, farmType);
		addHappiness(happiness_amount, farmType);
		
		//String msg = "%s's health is now %s and happiness is now %s.";
		//System.out.println(String.format(msg, name, health, happiness));
		
	}
	
	
	
	public void feedAnimal(int health_amount, int happiness_amount, String farmType)
	{
		addHealth(health_amount, farmType);
		addHappiness(happiness_amount, farmType);
		
		String msg = "%s has %s health and %s happiness.";
		System.out.println(String.format(msg, name, health, happiness));
		
	}
	
	
	
	public int getDailyProfit()
	{
		return dailyProfit;
	}
	
	
	public void increaseDailyProfit()
	{
		dailyProfit += 10;
	}
	
	
}








