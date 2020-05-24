package JUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Animal.Animal;
import Animal.Cow;
import Animal.Horse;
import Animal.Rabbit;
import Farm.Farm;

class FarmTest {

	private Farm farm;
	
	@BeforeEach
	void setUp() throws Exception {
		Cow c1 = new Cow();
		Rabbit r1= new Rabbit();
		Horse h1 = new Horse();
		
		farm = new Farm(null, null);
		farm.addAnimal(c1);
		farm.addAnimal(r1);
		farm.addAnimal(h1);
	}

	@Test
	void reduceHappiness()
	{
		
		for (int i=0; i<5; i++) {
			int numAnimals = farm.getNumAnimals();
			
			
			int randIndex;
			int maxIterCount = numAnimals/2 - 1;
			int listCount = 0;
			
			ArrayList<Integer> randIndexs = new ArrayList<Integer>();
			while (listCount < maxIterCount) {
				randIndex = ThreadLocalRandom.current().nextInt(0, numAnimals);	// get random index from animals array list
				
				if (!Arrays.asList(randIndexs).contains(randIndex) ) {	// If random index is not already in array
					randIndexs.add(randIndex);
					listCount++;
					
				}
				
			}
			
			Iterator<Integer> iter = randIndexs.iterator(); 
			
			Animal animal;
			int animalIndex;
			while (iter.hasNext()) {
				animalIndex = iter.next();
				animal = farm.getAnimal(animalIndex);
				
				farm.removeAnimal(animal);;
				
			}
			
			if (randIndexs.size() > 0) {
				System.out.println("" + randIndexs.size() + " animals escaped while the fence was broken.");
				System.out.println("The remaining animals on the farm lost some happiness.");
			}
			
			
			// Reduce the happiness of remaining animals on the farm
			ArrayList<Animal> remainingAnimals = farm.getAllAnimal();
			Iterator<Animal> remainIter = remainingAnimals.iterator();
			int reduceHappinessAmount = 20;
			
			while (remainIter.hasNext()) {
				animal = remainIter.next();
				
				animal.reduceHappiness(reduceHappinessAmount);
				System.out.println("test");
				// Check if animal dies from 0 happiness
				if (animal.getHappiness() == 0) {
					farm.removeAnimal(animal);
					System.out.println(animal.getName() + " died from unhappiness.");
				}
				
			}
			
			
		}
	}
}
