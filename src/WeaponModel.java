/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * WeaponModel class
 * Create weapon and get weapon's initial attribute value
 */

public class WeaponModel {
	
    private String name;
    private int price;
    private int level;
    private int damage;
    private int hands;
    
    public WeaponModel(String name, int price, int level, int damage, int hands) {
        this.name = name;
        this.price = price;
        this.level = level;
        this.damage = damage;
    }
    
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getLevel() {
        return level;
    }

    public int getDamage() {
        return damage;
    }
    
    public int getHands() {
        return hands;
    }
    
    public void printWeaponInfo() {
    	String nameContent = String.format("%10s", name);
    	String PriceContent = String.format("%4d", price);
    	String LevelContent = String.format("%2d", level);
    	String DamageReductionContent = String.format("%4d", damage);
        System.out.println("\u001b[33m" + nameContent + "\u001b[0m   " + PriceContent 
        		+ "          " + LevelContent + "          " + DamageReductionContent
        		+ "          " + hands);
    }
    
}
