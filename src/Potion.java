/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * Potion class extends from AbstractItem
 * class for Potion special
 */

public class Potion extends AbstractItem  {

    private String effectName;
    private int effectAmount;
	
	
	public Potion(String name, int price, int level, String effectName, int effectAmount) {
        super(name, price, level);
        this.effectName = effectName;
        this.effectAmount = effectAmount;
	}
	
    public String getEffectName() {
        return this.effectName;
    }
    
    
    public int getEffectAmount() {
        return this.effectAmount;
    }
    
	public void printInfo() {
		System.out.println("Potion: "+ getName() 
						 + "  Price: " + getPrice() 
						 + "   Min_Level: " + getMinLevel() 
						 + "   Attribute_Increase: " + effectAmount
						 + "   Attribute_Affected: " + effectName);
	}
}
