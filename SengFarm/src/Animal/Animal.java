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
			
		} else if ((health + amount) > 100) {
			health = 100;
			
		} else {
			health += amount;
					
		}
		
		String msg = "%s's health is now %s.";
		System.out.println(String.format(msg, name, health));
		
	}
	
	
	
	public void reduceHealth(int amount)
	{
		if (amount < 0) {
			System.out.println("reduceHealth amount param is " + amount);
			System.out.println("No change was made to animals health.");
			return;
			
		} else if ((health - amount) < 0) {
			health = 0;
			
		} else {
			health -= amount;
					
		}
		
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
			
		} else if ((happiness + amount) > 100) {
			happiness = 100;
			
		} else {
			happiness += happiness;
					
		}
		
		String msg = "%s's happiness is now %s.";
		System.out.println(String.format(msg, name, happiness));
		
	}
	
	
	
	public void reduceHappiness(int amount)
	{
		if (amount < 0) {
			System.out.println("reduceHappiness amount param is " + amount);
			System.out.println("No change was made to animals happiness.");
			return;
			
		} else if ((happiness - amount) < 0) {
			happiness = 0;
			
		} else {
			happiness -= amount;
					
		}
		
		String msg = "%s's happiness is now %s.";
		System.out.println(String.format(msg, name, happiness));
		
		
	}
	
	
	
	
	public void tendAnimal()
	{
		
		
	}
	
	
	
	public void feedAnimal(Item item)
	{
		
		
	}
	
	
	
	
	
}








