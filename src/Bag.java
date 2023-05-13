/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * Bag class
 * each hero has a bag, stores hero's items
 */

import java.util.*;

public class Bag {

    private Hero hero;
    private List<Weapon> weaponList;
    private List<Armor> armorList;
    private List<Potion> potionList;
    private List<Spell> spellList;
    
    
    
	public Bag(Hero hero) {
        weaponList = new ArrayList<>();
        armorList = new ArrayList<>();
        potionList = new ArrayList<>();
        spellList = new ArrayList<>();
    }
	
    public void printInfo() {
    	// print weapon list in bag 
    	if (!weaponList.isEmpty()) {
            System.out.println("----------- Weapon -----------");
            for (Weapon weapon : weaponList) {
            	weapon.printInfo();
            }
        }
    	// print armor list in bag 
		if (!armorList.isEmpty()) {
            System.out.println("----------- Armor -----------");
            for (Armor armor : armorList) {
            	armor.printInfo();
            }
        }
    	// print potion list in bag 
		if (!potionList.isEmpty()) {
			System.out.println("----------- Potion -----------");
			for (Potion potion : potionList) {
				potion.printInfo();
			}
		}
    	// print spell list in bag 
		if (!spellList.isEmpty()) {
			System.out.println("----------- Spell -----------");
			for (Spell spell : spellList) {
				spell.printInfo();
			}
		}
    }

    // add a weapon to hero's bag
	public void addWeapon(Weapon weapon) {
        weaponList.add(weapon);
    }

    // add a armor to hero's bag
    public void addArmor(Armor armor) {
        armorList.add(armor);
    }
    
    // add a potion to hero's bag
    public void addPotion(Potion potion) {
        potionList.add(potion);
    }

    // add a spell to hero's bag
    public void addSpell(Spell spell) {
        spellList.add(spell);
    }
	
    
    
    
}
