/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * Market class
 * All operations in market, including browsing, buying, selling
 */


import java.util.Scanner;

public class Market {
	
    
    // enter market
	public void enterMarket() {
		System.out.println();
		System.out.println("\u001b[36m- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\u001b[0m");
		System.out.println("\u001b[36m                       WELCOME to MARKET                       \u001b[0m");
		System.out.println("\u001b[36m- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\u001b[0m");
		System.out.println();
		
		// System.out.println("\u001b[36mPick a hero to buy items for:\u001b[0m"); // move to HeroTeam.returnHero()
		Hero hero = HeroTeam.returnHero();
		
		hero.printInfo();
		
		// hero can but items 
		buyitems(hero);
		
	}

	// hero can buy items in market
	private void buyitems(Hero hero) {
		while (true) {
			System.out.println("\u001b[36mWhat do you want to buy for" + hero.getName() + " ?\u001b[0m");
			System.out.println("weapon(W/w)");
	        System.out.println("armor(A/a)");
	        System.out.println("potion(P/p)");
	        System.out.println("spell(S/s)");
	        System.out.println("quit(Q/q)");
	        String userInput = new Scanner(System.in).nextLine();
	        if (userInput.equalsIgnoreCase("q")) {
	        // quit
	        	break;
	        } else if (userInput.equalsIgnoreCase("w")) {
	        // browse weapon menu
	        	while(true) {
		        	System.out.println("   Weapon   Cost  Required_Level  Damage_Reduction  Hands_Required");
		        	for (WeaponModel eachWeaponModel : GameWeapon.getList()) {
		        		eachWeaponModel.printWeaponInfo();
		            }
		        	System.out.println("Type name of weapon you want to buy. quit(Q/q)");
		        	String userInput2 = new Scanner(System.in).nextLine();
		        	if (userInput2.equalsIgnoreCase("q")) {
		                break;
		        	}
		        	AbstractItem item = GameWeapon.newAndRetrunWeapon(userInput2);
		        	// get weapon object and add into hero's bag
		        	if (item!=null) {
		        		hero.buy(item, "Weapon");
		        		System.out.println(item.getName() + "in bag. Money: " + hero.getMoney());
		        	} else {
		        		System.out.println("\u001b[31mInvalid weapon name\u001b[0m");
		        	}
	        	}
	        } else if (userInput.equalsIgnoreCase("a")) {
		    // browse armor menu
	        	while(true) {
		        	System.out.println("          Armor      Cost  Required_Level  Damage_Reduction");
		        	for (ArmorModel eachArmorModel : GameArmor.getList()) {
		        		eachArmorModel.printArmorInfo();
		            }
		        	System.out.println("Type name of armor you want to buy. quit(Q/q)");
		        	String userInput2 = new Scanner(System.in).nextLine();
		        	if (userInput2.equalsIgnoreCase("q")) {
		                break;
		        	}
		        	AbstractItem item = GameArmor.newAndRetrunArmor(userInput2);
		        	// get armor object and add into hero's bag
		        	if (item!=null) {
		        		hero.buy(item, "Armor");
		        		System.out.println(item.getName() + "in bag. Money: " + hero.getMoney());
		        	} else {
		        		System.out.println("\u001b[31mInvalid armor name\u001b[0m");
		        	}
	        	}
	        } else if (userInput.equalsIgnoreCase("p")) {
		    // browse potion menu
	        	while(true) {
		        	System.out.println("          Potion      Cost  Required_Level  Attribute_Increase  Attribute_Affected");
		        	for (PotionModel eachPotionModel : GamePotion.getList()) {
		        		eachPotionModel.printPotionInfo();
		            }
		        	System.out.println("Type name of Potion you want to buy. quit(Q/q)");
		        	String userInput2 = new Scanner(System.in).nextLine();
		        	if (userInput2.equalsIgnoreCase("q")) {
		                break;
		        	}
		        	AbstractItem item = GamePotion.newAndRetrunPotion(userInput2);
		        	// get potion object and add into hero's bag
		        	if (item!=null) {
		        		hero.buy(item, "Potion");
		        		System.out.println(item.getName() + "in bag. Money: " + hero.getMoney());
		        	} else {
		        		System.out.println("\u001b[31mInvalid Potion name\u001b[0m");
		        	}
	        	}
	        } else if (userInput.equalsIgnoreCase("s")) {
		    // browse spell menu
	        	while(true) {
		       		GameSpell.printSpell();
			       	System.out.println("Type name of Spell you want to buy. quit(Q/q)");
			       	String userInput2 = new Scanner(System.in).nextLine();
			       	if (userInput2.equalsIgnoreCase("q")) {
		                break;
		        	}
		        	AbstractItem item = GameSpell.newAndRetrunSpell(userInput2);
		        	// get spell object and add into hero's bag
			        if (item!=null) {
			       		hero.buy(item, "Spell");
		        		System.out.println(item.getName() + "in bag. Money: " + hero.getMoney());
			       	} else {
			       		System.out.println("\u001b[31mInvalid Spell name\u001b[0m");
			       	}
		       	}
	        }
		}
		
	}

}
