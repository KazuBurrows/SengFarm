
public class Event {

	private final static double DROUGHT_PROBABILITY = 0.05;
	private final static double BROKEN_FENCE_PROBABILITY = 0.10;
	private final static double COUNTY_FAIR_PROBABILITY = 0.08;
	
	
	
	/*
	 * Calls random events that have a static probability of occurring
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
			//do something
			
		}
		
	}
	
	
	
	
	private void brokenFence()
	{
		boolean isBrokenFence = Math.random() < BROKEN_FENCE_PROBABILITY;
		
		if (isBrokenFence) {
			//do something
			
		}
		
	}
	
	
	
	private void countyFair()
	{
		boolean wonCountyFair = Math.random() < COUNTY_FAIR_PROBABILITY;
		
		if (wonCountyFair) {
			//do something
			
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
