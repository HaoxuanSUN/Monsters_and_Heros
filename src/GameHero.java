/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * GameHero class
 * used for init all hero in the game, store all hero with its info
 */

import java.util.*;

// list all heroes in the game 
public class GameHero {

	private static Map<String, HeroModel> heroMap;
	
	static {
		heroMap = new HashMap<>();
		// init Warrior Hero
		initWarriorHero();
		// init Sorcerer Hero
		initSorcererHero();		
		// init Paladin Hero
		initPaladinHero();	
	}
	
	// init Paladin Hero   Name/mana/strength/agility/dexterity/starting money/starting experience
	private static void initPaladinHero() {
		addPaladinHero("Solonor_Thelandira", 300, 750, 650, 700, 2500, 7);
		addPaladinHero("Sehanine_Moonbow", 300, 750, 700, 700, 2500, 7);
		addPaladinHero("Skoraeus_Stonebones", 250, 650, 600, 350, 2500, 4);
		addPaladinHero("Garl_Glittergold", 100, 600, 500, 400, 2500, 5);
		addPaladinHero("Amaryllis_Astra", 500, 500, 500, 500, 2500, 5);
		addPaladinHero("Caliber_Heist", 400, 400, 400, 400, 2500, 2);
	}

	// init Sorcerer Hero   Name/mana/strength/agility/dexterity/starting money/starting experience
	private static void initSorcererHero() {
		addSorcererHero("Rillifane_Rallathil", 1300, 750, 450, 500, 2500, 9);
		addSorcererHero("Segojan_Earthcaller", 900, 800, 500, 650, 2500, 5);
		addSorcererHero("Reign_Havoc", 800, 800, 800, 800, 2500, 8);
		addSorcererHero("Reverie_Ashels",  900, 800, 700, 400, 2500, 7);
		addSorcererHero("Radiant_Ash", 800, 850, 400, 600, 2500, 6);
		addSorcererHero("Skye_Soar", 1000, 700, 400, 500, 2500, 5);
	}


	// init Warrior Hero   Name/mana/strength/agility/dexterity/starting money/starting experience
	private static void initWarriorHero() {
		addWarriorHero("Gaerdal_Ironhand", 100, 700, 500, 600, 1354, 7);
		addWarriorHero("Sehanine_Monnbow", 600, 700, 800, 500, 2500, 8);
		addWarriorHero("Muamman_Duathall", 300, 900, 500, 750, 2546, 6);
		addWarriorHero("Flandal_Steelskin", 200, 750, 650, 700, 2500, 7);
		addWarriorHero("Undefeated_Yoj", 400, 800, 400, 700, 2500, 7);
		addWarriorHero("Eunoia_Cyn", 400, 700, 800, 600, 2500, 6);
	}

	public static void printHero() {
		System.out.println("\u001b[36m          Name        Mana  Strength  Agility  Dexterity  Start_$  Start_Experience\u001b[0m");
		System.out.println("- - - - - - - - - - - - - - - - - - - \u001b[33mWARRIOR\u001b[0m - - - - - - - - - - - - - - - - - - -");
        for (HeroModel heroModel : heroMap.values()) {
        	if (heroModel.getHeroType().equalsIgnoreCase("warrior"))
        		heroModel.printHeroInfo();
        }
        System.out.println("- - - - - - - - - - - - - - - - - - - \u001b[33mSORCERER\u001b[0m - - - - - - - - - - - - - - - - - - -");
        for (HeroModel heroModel : heroMap.values()) {
        	if (heroModel.getHeroType().equalsIgnoreCase("sorcerer"))
        		heroModel.printHeroInfo();
        }
        System.out.println("- - - - - - - - - - - - - - - - - - - \u001b[33mPALADIN\u001b[0m - - - - - - - - - - - - - - - - - - -");
        for (HeroModel heroModel : heroMap.values()) {
        	if (heroModel.getHeroType().equalsIgnoreCase("paladin"))
        		heroModel.printHeroInfo();
        }
    }

	// new and return hero if userInput is valid for an hero
	public static Hero newAndRetrunHero (String userInput) {
        HeroModel heroModelName = heroMap.get(userInput);
        if(heroModelName == null) {
            return null;
        }
        if (heroModelName.getHeroType().equals("warrior")) {
            return new HeroWarrior(heroModelName.getName(), heroModelName.getMana(), 
            		heroModelName.getStrength(), heroModelName.getDexterity(), 
            		heroModelName.getAgility(), heroModelName.getStartingMoney(), 
            		heroModelName.getStartingExperience());
        } else if (heroModelName.getHeroType().equals("sorcerer")) {
            return new HeroSorcerer(heroModelName.getName(), heroModelName.getMana(), 
            		heroModelName.getStrength(), heroModelName.getDexterity(), 
            		heroModelName.getAgility(), heroModelName.getStartingMoney(),
            		heroModelName.getStartingExperience());
        } else if (heroModelName.getHeroType().equals("paladin")) {
            return new HeroPaladin(heroModelName.getName(), heroModelName.getMana(), 
            		heroModelName.getStrength(), heroModelName.getDexterity(), 
            		heroModelName.getAgility(), heroModelName.getStartingMoney(), 
                    heroModelName.getStartingExperience());
        }
        return null;
	}



	private static void addPaladinHero(String string, int i, int j, int k, int l, int m, int n) {
		heroMap.put(string, new HeroModel(string, i, j, k, l, m, n, "paladin"));
	}
	private static void addSorcererHero(String string, int i, int j, int k, int l, int m, int n) {
		heroMap.put(string, new HeroModel(string, i, j, k, l, m, n, "sorcerer"));
	}
	private static void addWarriorHero(String string, int i, int j, int k, int l, int m, int n) {
		heroMap.put(string, new HeroModel(string, i, j, k, l, m, n, "warrior"));
	}
}
