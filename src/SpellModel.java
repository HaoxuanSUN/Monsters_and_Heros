/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * SpellModel class
 * Create spell and get spell's initial attribute value
 */


public class SpellModel {
	
    private String type;
    private String name;
    private int price;
    private int level;
    private int damage;
    private int manaCost;
    
    public SpellModel(String type, String name, int price, int level, int damage, int manaCost) {
//        super(name, price, level, damage, manaCost);
    	this.type = type;
    	this.name = name;
        this.price = price;
        this.level = level;
        this.damage = damage;
        this.manaCost = manaCost;
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
    
    public int getManaCost() {
        return manaCost;
    }
    
    public String getSpellType() {
        return type;
    }
    
    public void printInfo() {
    	String nameContent = String.format("%19s", name);
    	String PriceContent = String.format("%4d", price);
    	String LevelContent = String.format("%2d", level);
    	String DamageContent = String.format("%4d", damage);
    	String ManaCostContent = String.format("%4d", manaCost);
        System.out.println("\u001b[33m" + nameContent + "\u001b[0m   " + PriceContent 
        		+ "   " + LevelContent + "   " + DamageContent
        		+ "   " + ManaCostContent);
    }
    
}
