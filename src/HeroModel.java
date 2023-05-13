/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * HeroModel class
 * Create hero and get hero's initial attribute value
 */


// Create hero and get hero's initial attribute value
public class HeroModel {
	
    private String name;
    private int mana;
    private int strength;
    private int agility;
    private int dexterity;
    private int startingMoney;
    private int startingExperience;
    private String heroType;
    
    public HeroModel(String name, int mana, int strength, int agility, int dexterity, int startingMoney, int startingExperience, String heroType) {
        this.name = name;
        this.mana = mana;
        this.strength = strength;
        this.agility = agility;
        this.dexterity = dexterity;
        this.startingMoney = startingMoney;
        this.startingExperience = startingExperience;
        this.heroType = heroType;
    }
    
    public String getName() {
        return name;
    }

    public int getMana() {
        return mana;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getStartingMoney() {
        return startingMoney;
    }

    public int getStartingExperience() {
        return startingExperience;
    }

    public String getHeroType() {
        return heroType;
    }
    
    public void printHeroInfo() {
    	String nameContent = String.format("%19s", name);
    	String manaContent = String.format("%4d", mana);
        System.out.println("\u001b[33m" + nameContent + "\u001b[0m   " + manaContent 
        		+ "     " + strength + "      " + agility + "       " + dexterity 
        		+ "      " + startingMoney + "           " + startingExperience);
    }
    
}
