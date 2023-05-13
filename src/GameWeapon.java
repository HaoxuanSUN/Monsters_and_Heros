/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * GameWeapon class
 * used for init all weapon in the game, store all weapon with its info
 */

import java.util.*;


// list all heroes in the game 
public class GameWeapon {

	private static Map<String, WeaponModel> weaponMap;
	
	static {
		weaponMap = new HashMap<>();
		initWeapon();
	}
	 
	private static void initWeapon() {
		// init weapon
		addWeapon("Sword", 500, 1, 800, 1);
		addWeapon("Bow", 300, 2, 500, 2);
		addWeapon("Scythe", 1000, 6, 1100, 2);
		addWeapon("Axe", 550, 5, 850, 1);
		addWeapon("TSwords", 1400, 8, 1600, 2);
		addWeapon("Dagger", 200, 1, 250, 1);
	}

	// new and return weapon if userInput is valid for an weapon
	public static Weapon newAndRetrunWeapon (String userInput) {
        WeaponModel weaponModelName = weaponMap.get(userInput);
        if(weaponModelName == null) {
            return null;
        } else {
            return new Weapon(weaponModelName.getName(), weaponModelName.getPrice(), 
            		weaponModelName.getLevel(), weaponModelName.getDamage(),
            		weaponModelName.getHands());
        }
	}

	
    public static List<WeaponModel> getList() {
        return new ArrayList<>(weaponMap.values());
    }

	private static void addWeapon(String string, int i, int j, int k, int l) {
		weaponMap.put(string, new WeaponModel(string, i, j, k, l));
	}
}
