/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * Weapon class extends from AbstractItem
 * class for Weapon special
 */


public class Weapon extends AbstractItem  {

    private int damage;
    private int hands;
	
	
	public Weapon(String name, int price, int level, int damage, int hands) {
        super(name, price, level);
        this.damage = damage;
        this.hands = hands;
	}
	
    public int getDamage() {
        return this.damage;
    }
    
    
    public int getHands() {
        return this.hands;
    }
    
	public void printInfo() {
		System.out.println("Weapon: "+ getName() 
						 + "  Price: " + getPrice() 
						 + "   Min_Level: " + getMinLevel() 
						 + "   Damage: " + damage
						 + "   Hands_Required: " + hands);
	}
}
