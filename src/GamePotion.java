/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * GamePotion class
 * used for init all potion in the game, store all potion with its info
 */

import java.util.*;

// list all heroes in the game 
public class GamePotion {

	private static Map<String, PotionModel> potionMap;
	
	static {
		potionMap = new HashMap<>();
		initPotion();
	}
	 
	// Name/cost/required level/attribute affected/attribute increase
	private static void initPotion() {
		// init Potion
		addPotion("Platinum_Shield", 250, 1, "Health", 100);
		addPotion("Strength_Potion", 200, 1, "Strength", 75);
		addPotion("Magic_Potion", 350, 2, "Mana", 100);
		addPotion("Luck_Elixir", 500, 4, "Agility", 65);
		addPotion("Mermaid_Tears", 850, 5, "Health/Mana/Strength/Agility", 100);
		addPotion("Ambrosia", 1000, 8, "All Health/Mana/Strength/Dexterity/Defense/Agility", 150);
	}


	// new and return potion if userInput is valid for an potion
	public static Potion newAndRetrunPotion (String userInput) {
		PotionModel potionModelName = potionMap.get(userInput);
        if(potionModelName == null) {
            return null;
        } else {
            return new Potion(potionModelName.getName(), potionModelName.getPrice(), 
            		potionModelName.getLevel(), potionModelName.getEffectName(),
            		potionModelName.getEffectAmount());
        }
	}

	
    public static List<PotionModel> getList() {
        return new ArrayList<>(potionMap.values());
    }

	private static void addPotion(String string, int i, int j, String string2, int k) {
		potionMap.put(string,new PotionModel(string, i, j, string2, k));
		
	}
}