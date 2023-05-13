/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * GameArmor class
 * used for init all armor in the game, store all armor with its info
 */


import java.util.*;

// list all heroes in the game 
public class GameArmor {

	private static Map<String, ArmorModel> armorMap;
	
	static {
		armorMap = new HashMap<>();
		initArmor();
	}
	 
	private static void initArmor() {
		// init armor
		addArmor("Platinum_Shield", 150, 1, 200);
		addArmor("Breastplate", 350, 3, 600);
		addArmor("Full_Body_Armor", 1000, 8, 1100);
		addArmor("Wizard_Shield",1200, 10, 1500);
		addArmor("Guardian_Angel", 1000, 10, 1000);
	}

	private static void addArmor(String string, int i, int j, int k) {
		armorMap.put(string, new ArmorModel(string, i, j, k));
	}


	// new and return armor if userInput is valid for an armor
	public static Armor newAndRetrunArmor (String userInput) {
        ArmorModel armorModelName = armorMap.get(userInput);
        if(armorModelName == null) {
            return null;
        } else {
            return new Armor(armorModelName.getName(), armorModelName.getPrice(), 
            		armorModelName.getLevel(), armorModelName.getDamageReduction());
        }
	}

    public static List<ArmorModel> getList() {
        return new ArrayList<>(armorMap.values());
    }
	
}
