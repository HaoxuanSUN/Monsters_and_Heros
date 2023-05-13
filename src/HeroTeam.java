/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * HeroTeam class
 * Represents the team that player is playing, size 1~3
 */

import java.util.*;


public class HeroTeam {
	
	private int heroNum;
	private static ArrayList<Hero> heroList;
	
	public HeroTeam(int heroNumber) {
		heroNum = heroNumber;
		heroList = new ArrayList<>(heroNumber);
	}

	// choose heroes form library when game start, size:1~3
	public void chooseHero() {
		for (int i = 0; i < this.heroNum; i++) {
            while (true) {
            	System.out.println();
                System.out.println("Please choose hero No." + (i+1) +" (Enter hero's name):");
                // print all hero info for choose
                GameHero.printHero();
                // get user input hero's name
                String userInput = new Scanner(System.in).nextLine();
                //get the hero object just created
                Hero hero = GameHero.newAndRetrunHero(userInput);

                if (hero == null) {
                //invalid hero name
                	System.out.println("\u001b[31mInvalid hero name\u001b[0m");
                } else {
                // valid hero name
                    if (!heroExist(hero)) {
                    // not in list, valid 
                    	heroList.add(hero);
                        System.out.println("Hero \u001b[32m" + hero.getName() + "\u001b[0m is ready for fight");
                        break;
                    } else {
                    // invalid, already in list
                    	System.out.println("\u001b[31mHero already choosen\u001b[0m");
                    }
                }
            }
        }
		
	}

	// check whether a hero is already in team
	private boolean heroExist(Hero chosenHero) {
        for(Hero heroInList: heroList){
            if(heroInList.getName().equals(chosenHero.getName())){
                return true;
            }
        }
        return false;
	}
	
	// print hero list
    public static void printHeroList() {
        System.out.println("\u001b[36mHero Team List: \u001b[0m");
        for(Hero heroInList: heroList){
        	heroInList.printName();
        }
    }
    
    // check whether user is tying a valid hero, if yes return the hero object
    public static Hero checkAndReturnHero(String chosenHeroName) {
        for(Hero heroInList: heroList){
            if(heroInList.getName().equals(chosenHeroName)){
                return heroInList;
            }
        }
        return null;
    }
    
    // return hero to buy items for 
	public static Hero returnHero() {
		while (true) {
			printHeroList();
			System.out.print("\u001b[36mPick a hero to buy items for: \u001b[0m");
            String userInput = new Scanner(System.in).nextLine();
            Hero hero = checkAndReturnHero(userInput);
            if (hero == null) {
                System.out.println("\u001b[31mHero " + userInput.toUpperCase() + " is not in Team\u001b[0m");
            } else {
                return hero;
            }
        }
	}
	
    public void printInfo() {
        for(Hero hero: heroList){
            hero.printInfo();
        }
    }

}
