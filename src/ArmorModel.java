/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * ArmorModel class
 * Create armor and get armor's initial attribute value
 */



public class ArmorModel {
	
    private String name;
    private int price;
    private int level;
    private int damageReduction;
    
    public ArmorModel(String name, int price, int level, int damageReduction) {
        this.name = name;
        this.price = price;
        this.level = level;
        this.damageReduction = damageReduction;
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

    public int getDamageReduction() {
        return damageReduction;
    }
    
    public void printArmorInfo() {
    	String nameContent = String.format("%19s", name);
    	String PriceContent = String.format("%4d", price);
    	String LevelContent = String.format("%4d", level);
    	String DamageReductionContent = String.format("%4d", damageReduction);
        System.out.println("\u001b[33m" + nameContent + "\u001b[0m   " + PriceContent 
        		+ "          " + LevelContent + "          " + DamageReductionContent);
    }
    
}
