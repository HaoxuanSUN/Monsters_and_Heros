/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * PotionModel class
 * Create armor and get Potion's initial attribute value
 */

public class PotionModel {
	
    private String name;
    private int price;
    private int level;
    private String effectName;
    private int effectAmount;
    
    public PotionModel(String name, int price, int level, String effectName, int effectAmount) {
        this.name = name;
        this.price = price;
        this.level = level;
        this.effectName = effectName;
        this.effectAmount = effectAmount;
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
    
    public String getEffectName() {
        return effectName;
    }
    
    public int getEffectAmount() {
        return effectAmount;
    }
    
    public void printPotionInfo() {
    	String nameContent = String.format("%19s", name);
    	String PriceContent = String.format("%4d", price);
    	String LevelContent = String.format("%2d", level);
    	String EffectAmountContent = String.format("%4d", effectAmount);
        System.out.println("\u001b[33m" + nameContent + "\u001b[0m   " + PriceContent 
        		+ "          " + LevelContent + "          " + EffectAmountContent
        		+ "          " + effectName);
    }
    
}
