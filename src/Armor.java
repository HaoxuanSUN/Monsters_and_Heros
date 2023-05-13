/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * Armor class extends from AbstractItem
 * class for armor special
 */

public class Armor extends AbstractItem {

	private int damageReduction;
	
	public Armor(String name, int price, int level, int damageReduction) {
        super(name, price, level);
		this.damageReduction = damageReduction;
	}

	public void printInfo() {
		System.out.println("Armor: "+ getName() 
		                 + "  Price: " + getPrice() 
		                 + "   Min_Level: " + getMinLevel() 
		                 + "   Damage_Reduction: " + damageReduction);
	}
	
	

}
