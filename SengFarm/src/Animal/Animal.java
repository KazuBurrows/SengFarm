package Animal;

import Item.Item;

public class Animal {
	
	
	private String name;
	private int price;
	private int health;
	private int happiness;
	
	
	public Animal(String param_name, int param_price)
	{
		name = param_name;
		price = param_price;
		health = 100;
		happiness = 100;
		
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
	
	
	
	public void addHealth(int amount)
	{
		if (amount < 0) {
			System.out.println("addHealth amount param is " + amount);
			System.out.println("No change was made to animals health.");
			return;
			
		}
		
		health = Math.min(100, health + amount);
		
		String msg = "%s's health is now %s.";
		System.out.println(String.format(msg, name, health));
		
	}
	
	
	
	public void reduceHealth(int amount)
	{
		if (amount < 0) {
			System.out.println("reduceHealth amount param is " + amount);
			System.out.println("No change was made to animals health.");
			return;
			
		}
		
		health = Math.max(0, health - amount);
		
		String msg = "%s's health is now %s.";
		System.out.println(String.format(msg, name, health));
		
	}
	
	
	
	
	public int getHappiness()
	{
		
		return happiness;
	}
	
	
	
	public void addHappiness(int amount)
	{
		if (amount < 0) {
			System.out.println("addHappiness amount param is " + amount);
			System.out.println("No change was made to animals happiness.");
			return;
			
		}
		
		happiness = Math.min(100, happiness + amount);
		
		String msg = "%s's happiness is now %s.";
		System.out.println(String.format(msg, name, happiness));
		
	}
	
	
	
	public void reduceHappiness(int amount)
	{
		if (amount < 0) {
			System.out.println("reduceHappiness amount param is " + amount);
			System.out.println("No change was made to animals happiness.");
			return;
			
		}
		
		happiness = Math.max(0, happiness - amount);
		
		String msg = "%s's happiness is now %s.";
		System.out.println(String.format(msg, name, happiness));
		
		
	}
	
	
	
	
	public void playAnimal(int health_amount, int happiness_amount)
	{
		addHealth(health_amount);
		addHappiness(happiness_amount);
		
		//String msg = "%s's health is now %s and happiness is now %s.";
		//System.out.println(String.format(msg, name, health, happiness));
		
	}
	
	
	
	public void feedAnimal(int health_amount, int happiness_amount)
	{
		addHealth(health_amount);
		addHappiness(happiness_amount);
		
		String msg = "%s has %s health and %s happiness.";
		System.out.println(String.format(msg, name, health, happiness));
		
	}
	
	
	
	
	
}








