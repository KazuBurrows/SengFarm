package Item;

import java.util.ArrayList;

public class test {

	
	public static void main(String[] args) {
		
		ArrayList<Item> items = new ArrayList<Item>();						// Growing crops on farm

		
		Food f = new Food();
		Fertilizer fert = new Fertilizer();

		items.add(f);
		items.add(fert);

		System.out.println(items);
		
		
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i).getName());
//			items.get(i).applyItemBonus();
			
		}
		
		
		
	}
	
	
}
