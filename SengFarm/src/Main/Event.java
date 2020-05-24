package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

import Animal.Animal;
import Crop.Crop;
import Farm.Farm;

public class Event {

	private final static double DROUGHT_PROBABILITY = 0.05;
	private final static double BROKEN_FENCE_PROBABILITY = 0.10;
	private final static double COUNTY_FAIR_PROBABILITY = 0.08;
	
	Farm farm;
	
	
	public Event(Farm param_farm)
	{
		farm = param_farm;
	}
	
	
	
	/*
	 * Calls random events that have a static probability of occurring  -  Rewrite this comment
	 */
	public void checkForEvent()
	{
		
		drought();
		brokenFence();
		countyFair();
		
	}
	
	
	
	private void drought()
	{
		boolean isDrought = Math.random() < DROUGHT_PROBABILITY;
//		boolean isDrought = Math.random() < 100;
		
		if (isDrought) {
			// Farm loses half of its growing crops. The exact number is determined randomly.
			System.out.println("The farm experienced a drought.");
			
			int numCrops = farm.getNumCrops();
			
			int randIndex;
			int maxIterCount = numCrops/2 - 1;
			int listCount = 0;
			
			ArrayList<Integer> randIndexs = new ArrayList<Integer>();
			
			while (listCount < maxIterCount) {
				randIndex = ThreadLocalRandom.current().nextInt(0, numCrops);	// get random index from crops array list
				
				if (!Arrays.asList(randIndexs).contains(randIndex) ) {	// If random index is not already in array
					randIndexs.add(randIndex);
					listCount++;
					
				}
				
			}
			
			Iterator<Integer> iter = randIndexs.iterator(); 
			
			Crop crop;
			int cropIndex;
			while (iter.hasNext()) {
				cropIndex = iter.next();
				crop = farm.getCrop(cropIndex);
				
				farm.removeCrop(crop);
				
			}
			
			if (randIndexs.size() > 0) {
				System.out.println("" + randIndexs.size() + " crops died in the drought.");
			}
			
			
			
			
		}
		
	}
	
	
	
	
	private void brokenFence()
	{
		boolean isBrokenFence = Math.random() < BROKEN_FENCE_PROBABILITY;
//		boolean isBrokenFence = Math.random() < 100;
		
		if (isBrokenFence) {
			// Farm loses one or more animals. The exact number is determined randomly.
			// Animals on Farm lose happiness
			
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
			
			
//			// Reduce the happiness of remaining animals on the farm
//			ArrayList<Animal> remainingAnimals = farm.getAllAnimal();
//			Iterator<Animal> remainIter = remainingAnimals.iterator();
//			int reduceHappinessAmount = 20;
//			
//			while (remainIter.hasNext()) {
//				animal = remainIter.next();
//				
//				animal.reduceHappiness(reduceHappinessAmount);
//				System.out.println("test");
//				// Check if animal dies from 0 happiness
//				if (animal.getHappiness() == 0) {
//					farm.removeAnimal(animal);
//					System.out.println(animal.getName() + " died from unhappiness.");
//				}
//				
//			}
			
			
		}
		
	}
	
	
	
	private void countyFair()
	{
		boolean wonCountyFair = Math.random() < COUNTY_FAIR_PROBABILITY;
		
		int singleCropPrizeMoney = 10;
		int singleCAnimalPrizeMoney = 20;
		int totalPrizeMoney = 0;
		
		if (wonCountyFair) {
			// Farm gains money. The amount of money is scaled by the number of growing crops and animals on the farm.
			System.out.println("The farm has won the county fair.");
			
			int numCrops = farm.getNumCrops();
			int numAnimals = farm.getNumAnimals();
			
			totalPrizeMoney += numCrops*singleCropPrizeMoney;
			totalPrizeMoney += numAnimals*singleCAnimalPrizeMoney;
			
			System.out.println("The farm won a total of " + totalPrizeMoney);
			
		}
		
	}
	
	
	
//	public static void main(String[] args) {
		
//		int half = 0 / 2;
//		System.out.println(half);
		
//		System.out.println(ThreadLocalRandom.current().nextInt(0, 1));	// get random index from animals array list

		
		
//		Event e = new Event();
//		
//		e.checkForEvent();
		
		
//		int numCrops = 5;
//		
//		int randIndex;
//		int maxIterCount = numCrops/2;
//		int listCount = 0;
//		
//		ArrayList<Integer> randIndexs = new ArrayList<Integer>();
//
//		while (listCount < maxIterCount) {
//			randIndex = ThreadLocalRandom.current().nextInt(0, numCrops);
//			
//			if (!Arrays.asList(randIndexs).contains(randIndex) ) {
//				randIndexs.add(randIndex);
//				listCount++;
//				
//			}
//			
//			
//		}
//		
//		
//		for (int i = 0; i < randIndexs.size(); i++) {
//			System.out.println(randIndexs.get(i));
//			
//			
//		}
		
//	}
	
	
}
