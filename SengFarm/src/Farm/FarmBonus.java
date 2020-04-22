package Farm;

public abstract class FarmBonus {

	private String bonus;
	
	
	/*
	 * Get the name of the bonus
	 * 
	 * @return		Name of bonus
	 */
	public String getBonus()
	{
		
		return bonus;
	}
	
	
	
	/*
	 * Set the name of the bonus
	 * 
	 * @param bonusName		Name of the bonus
	 */
	public void setBonusName(String bonusName)
	{
		bonus = bonusName;
		
	}
	
	
	
	/*
	 * Apply the farm bonus
	 */
	public abstract void applyBonus();
	
	
	
}
