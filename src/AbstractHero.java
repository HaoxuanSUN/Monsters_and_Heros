/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * AbstractHero  astract class
 * an abstract class for hero, defines hero's attributes and methods
 * implements Hero interface
 */


public abstract class AbstractHero implements Hero {

    private String name;
    private int mana;
    private int strength;
    private int dexterity;
    private int agility;
    private int money;
    private int experience;
    private int level = 1;
    private int hp = level * 100;
    private int defense = 0;
    private Bag bag = new Bag(this);
    
    private Weapon weapon;
    private Armor armor;
    
	
	public AbstractHero (String name, int mana, int strength, int dexterity, int agility, int money, int experience) {
        this.name = name;
        this.mana = mana;
        this.strength = strength;
        this.dexterity = dexterity;
        this.agility = agility;
        this.money = money;
        this.experience = experience;
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

    public int getDexterity() {
        return dexterity;
    }

    public int getAgility() {
        return agility;
    }
    
	public int getMoney() {
		return money;
	}

	public int getExperience() {
	    return experience;
	}

    public void printName() {
        System.out.println(name);
    }
    
    public void printInfo() {
    	System.out.println();
    	String nameContent = String.format("%19s", name);
    	String manaContent = String.format("%4d", mana);
    	System.out.println("\u001b[36m         Name       Level  HP  Mana  Strength  Agility  Dexterity  Defence  Money$  Experience\u001b[0m");
    	System.out.println("\u001b[33m" + nameContent + "\u001b[0m   " + level 
    			+ "   " + hp + " " + manaContent
        		+ "     " + strength + "      " + agility + "        " + dexterity 
        		+ "        " + defense + "      " + money + "       " + experience);
        if (weapon != null) {
            weapon.printInfo();
        } else {
            System.out.println("\u001b[31mWeapon Empty!\u001b[0m");
        }
        if (armor != null) {
            armor.printInfo();
        } else {
            System.out.println("\u001b[31mArmor Empty!\u001b[0m");
        }
        bag.printInfo();
    }
    
    // hero could buy items from market
    public void buy(AbstractItem item, String type) {
        if (type.equalsIgnoreCase("Weapon")) {
            bag.addWeapon((Weapon)item);
        } else if (type.equalsIgnoreCase("Spell")) {
            bag.addSpell((Spell) item);
        } else if (type.equalsIgnoreCase("Potion")) {
            bag.addPotion((Potion) item);
        } else if (type.equalsIgnoreCase("Armor")) {
            bag.addArmor((Armor) item);
        }
        this.money -= item.getPrice();
    }

    // return hero's bag
    public Bag getBag() {
        return bag;
    }
	
}
