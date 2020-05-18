package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;


import Crop.Crop;
import Farm.Farm;

public class Event {

	private final static double DROUGHT_PROBABILITY = 0.05;
	private final static double BROKEN_FENCE_PROBABILITY = 0.10;
	private final static double COUNTY_FAIR_PROBABILITY = 0.08;
	
	Farm farm;
	
	/*
	 * Calls random events that have a static probability of occurring  -  Rewrite this comment
	 */
	public void checkForEvent(Farm f)
	{
		farm = f;
		
		drought();
		brokenFence();
		countyFair();
		
	}
	
	
	
	private void drought()
	{
		boolean isDrought = Math.random() < DROUGHT_PROBABILITY;
		
		if (isDrought) {
			// Farm loses half of its growing crops. The exact number is determined randomly.
			
			int numCrops = farm.getNumCrops();
			
			int randIndex;
			int maxIterCount = numCrops/2;
			int listCount = 0;
			
			ArrayList<Integer> randIndexs = new ArrayList<Integer>();

			while (listCount < maxIterCount) {
				randIndex = ThreadLocalRandom.current().nextInt(0, numCrops);
				
				if (!Arrays.asList(randIndexs).contains(randIndex) ) {
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
			
			
			
		}
		
	}
	
	
	
	
	private void brokenFence()
	{
		boolean isBrokenFence = Math.random() < BROKEN_FENCE_PROBABILITY;
		
		if (isBrokenFence) {
			// Farm loses one or more animals. The exact number is determined randomly.
			// Animals on Farm lose happiness
			
			
			
		}
		
	}
	
	
	
	private void countyFair()
	{
		boolean wonCountyFair = Math.random() < COUNTY_FAIR_PROBABILITY;
		
		if (wonCountyFair) {
			// Farm gains money. The amount of money is scaled by the number of growing crops and animals on the farm.
			
			
			
			
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
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
		
	}
	
	
}
