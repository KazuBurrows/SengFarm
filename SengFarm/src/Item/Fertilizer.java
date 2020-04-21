package Item;

public class Fertilizer extends Item {

	public Fertilizer() {
		super("Fertilizer", 0, "Some description", "Something");
		
	}
	
	
	
	@Override
	public void applyItemBonus() {
		// Do something
		
	}
	
	
	
//	public static void main(String[] args) {
//		
//		Fertilizer f = new Fertilizer("test name", 41, "test bonus name");
//		
//		System.out.println(f.getName());
//		System.out.println(f.getPrice());
//		
//		System.out.println(f.getItemBonusName());
//		
////		f.applyItemBonus();
//		
//	}
	
	
}
