/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * GameSpell class
 * used for init all spell in the game, store all spell with its info
 */


import java.util.*;

// list all heroes in the game 
public class GameSpell {

	private static Map<String, SpellModel> SpellMap;
	
	static {
		SpellMap = new HashMap<>();
		initSpellFire();
		initSpellIce();
		initSpelLightning();
	}
	 
	private static void initSpellFire() {
		// init fire spell
		addSpellFire("Flame_Tornado", 700, 4, 850, 300);
		addSpellFire("Breath_of_Fire", 350, 1, 450, 100);
		addSpellFire("Heat_Wave", 450, 2, 600, 150);
		addSpellFire("Lava_Comet", 800, 7, 1000, 550);
		addSpellFire("Hell_Storm", 600, 3, 950, 600);
	}

	private static void initSpelLightning() {
		// init lightning spell
		addSpellLightning("Lightning_Dagger", 400, 1, 500, 150);
		addSpellLightning("Thunder_Blast", 750, 4, 950, 400);
		addSpellLightning("Electric_Arrows", 550, 5, 650, 200);
		addSpellLightning("Spark_Needles", 500, 2, 600, 200);
	}

	private static void initSpellIce() {
		// init ice spell
		addSpellIce("Snow_Cannon", 500, 2, 650, 250);
		addSpellIce("Ice_Blade", 250, 1, 450, 100);
		addSpellIce("Frost_Blizzard", 750, 5, 850, 350);
		addSpellIce("Arctic_Storm", 700, 6, 800, 300);
	}
	
	

	public static void printSpell() {
		System.out.println("\u001b[36m           Spell        Cost  Required_Level  Damage  Mana-Cost\u001b[0m");
		System.out.println("- - - - - - - - - - - - - - - - - - - \u001b[33mFire Spell\u001b[0m - - - - - - - - - - - - - - - - - - -");
        for (SpellModel spellModel : SpellMap.values()) {
        	if (spellModel.getSpellType().equalsIgnoreCase("Fire"))
        		spellModel.printInfo();
        }
        System.out.println("- - - - - - - - - - - - - - - - - - - \u001b[33mLightning Spell\u001b[0m - - - - - - - - - - - - - - - - - - -");
        for (SpellModel spellModel : SpellMap.values()) {
        	if (spellModel.getSpellType().equalsIgnoreCase("Lightning"))
        		spellModel.printInfo();
        }
        System.out.println("- - - - - - - - - - - - - - - - - - - \u001b[33mIce Spell\u001b[0m - - - - - - - - - - - - - - - - - - -");
        for (SpellModel spellModel : SpellMap.values()) {
        	if (spellModel.getSpellType().equalsIgnoreCase("Ice"))
        		spellModel.printInfo();
        }
    }
	
	// new and return spell if userInput is valid for an spell
	public static Spell newAndRetrunSpell (String userInput) {
      SpellModel spellModelName = SpellMap.get(userInput);
      if(spellModelName == null) {
          return null;
      } else {
          return new Spell(spellModelName.getSpellType(), spellModelName.getName(), 
        		  spellModelName.getPrice(), spellModelName.getLevel(), 
        		  spellModelName.getDamage(), spellModelName.getManaCost());
      }
	}

    public static List<SpellModel> getList() {
        return new ArrayList<>(SpellMap.values());
    }
    

	private static void addSpellFire(String string, int i, int j, int k, int l) {
		SpellMap.put(string, new SpellModel("Fire", string, i, j, k, l));
	}
	private static void addSpellLightning(String string, int i, int j, int k, int l) {
		SpellMap.put(string, new SpellModel("Lightning", string, i, j, k, l));
	}
	private static void addSpellIce(String string, int i, int j, int k, int l) {
		SpellMap.put(string, new SpellModel("Ice", string, i, j, k, l));
	}
}
