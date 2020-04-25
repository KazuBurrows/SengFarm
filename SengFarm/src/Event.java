
public class Event {

	private final static double DROUGHT_PROBABILITY = 0.05;
	private final static double BROKEN_FENCE_PROBABILITY = 0.10;
	private final static double COUNTY_FAIR_PROBABILITY = 0.08;
	
	
	
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
		
		if (isDrought) {
			// Farm loses half of its growing crops. The exact number is determined randomly.
			
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
	
	
	
//	public static void main(String[] args) {
//		
//		Event e = new Event();
//		
//		e.checkForEvent();
//		
//	}
	
	
}
