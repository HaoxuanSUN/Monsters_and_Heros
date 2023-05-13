/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * AbstractItem  abstract class 
 * an abstract class of items, such as weapon, armor, spell and potion 
 * implements interface Sale 
 */



public abstract class AbstractItem implements Sale {

    private String name;
    private int price;
    private int minLevel;
	
	public AbstractItem (String name, int price, int minLevel) {
        this.name = name;
        this.price = price;
        this.minLevel = minLevel;
    }

	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}

	public int getMinLevel() {
        return minLevel;
    }
	
	public abstract void printInfo();
	
}
