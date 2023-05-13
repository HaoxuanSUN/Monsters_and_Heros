/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * Spell class extends from AbstractItem
 * class for Spell special
 */


public class Spell extends AbstractItem  {

    private int damage;
    private int manaCost;
    private String spellType;
	
	
	
    public Spell(String spellType, String name, int price, int level, int damage, int manaCost) {
        super(name, price, level);
        this.damage = damage;
        this.manaCost = manaCost;
        this.spellType = spellType;
	}

	public int getDamage() {
        return this.damage;
    }
    
    
    public int getManaCost() {
        return this.manaCost;
    }
    
    public String getSpellType() {
        return spellType;
    }
    
	public void printInfo() {
		System.out.println("Type: "+ spellType
						 + "Spell: "+ getName() 
						 + "  Price: " + getPrice() 
						 + "   Min_Level: " + getMinLevel() 
						 + "   Damage: " + damage
						 + "   Mana_Cost: " + manaCost);
	}

}
