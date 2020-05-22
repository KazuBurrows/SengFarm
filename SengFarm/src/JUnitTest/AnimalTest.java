package JUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Animal.Animal;
import Animal.Cow;
import Animal.Horse;
import Animal.Rabbit;

class AnimalTest {
	
	Cow cow = new Cow();
	Rabbit rabbit = new Rabbit();
	Horse horse = new Horse();
	

	@Test
	void getCowNameTest()
	{
		
		assertEquals("Cow", cow.getName());
	}
	
	
	@Test
	void getCowPriceTest()
	{
		
		assertEquals(80, cow.getPrice());
	}
	
	
	@Test
	void getCowProfitTest()
	{
		
		assertEquals(20, cow.getDailyProfit());
	}
	
	
	@Test
	void getCowHealthTest()
	{
		assertEquals(100, cow.getHealth());
		
		cow.reduceHealth(25);
		assertEquals(75, cow.getHealth());
		
		cow.reduceHealth(-50);
		assertEquals(75, cow.getHealth());
		
		cow.reduceHealth(120);
		assertEquals(0, cow.getHealth());
	}
	
	
	@Test
	void cowHealthDownTest()
	{
		cow.reduceHealth(25);
		assertEquals(75, cow.getHealth());
		
		cow.reduceHealth(-50);
		assertEquals(75, cow.getHealth());
		
		cow.reduceHealth(120);
		assertEquals(0, cow.getHealth());
		
	}
	
	
	
	
	@Test
	void getCowHappinessTest()
	{
		
		assertEquals(100, cow.getHappiness());
	}
	
	
	@Test
	void cowHappinessDownTest()
	{
		cow.reduceHappiness(25);
		assertEquals(75, cow.getHappiness());
	}
	
	
	
	
	
	
}
