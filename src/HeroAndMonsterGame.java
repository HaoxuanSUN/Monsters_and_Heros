/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * HeroAndMonsterGame class
 * Main part of the game, consists all processes and operation in game
 * game parameter: board size, probability of inaccessible cell/market cell/battle
 */

import java.util.*;


public class HeroAndMonsterGame {

	
	private int heroNum = -1; 
	private int boardSize = 8;
	double inaccessibleProb = 0.20;
	double marketProb = 0.30;
	double battleProb = 0.5;
    private Board board = new Board(boardSize, inaccessibleProb, marketProb, battleProb);
    private boolean isGameOver = false;
    private HeroTeam heroTeam;
	
	
	
	// init game
	public void init() {
		System.out.println("\u001b[31;46m        Welcome to Legends: Monsters and Heroes       \u001b[0m");
		System.out.println("");
		updateHeroNumber();
		chooseHero();
		startGame();
		GameOver();
	}



	// handle game over
	private void GameOver() {
		printGameOver();
		while (true) {
			System.out.println("Do you want to play again? (y/n)");
			String userInput = new Scanner(System.in).nextLine();
		    if (userInput.equalsIgnoreCase("n")) {
		    	break;
		    }
		    if (userInput.equalsIgnoreCase("y")) {
				new HeroAndMonsterGame().init();
		    	break;
		    }
		}
	}


	// keep playing game until game over
	private void startGame() {
		printGameStart();
		while(!isGameOver) {
			board.printBoardAndInstruction();
			getUserInput();
		}
	}



	// get user input. valid input: w/a/s/d/q/i/m/b
	private void getUserInput() {
		while(true) {
		    String userInput = new Scanner(System.in).nextLine();
		    if (userInput.equalsIgnoreCase("q")) {
		    	isGameOver = true;
		    	break;
		    }
		    if (userInput.equalsIgnoreCase("w") ||
		    	userInput.equalsIgnoreCase("a") ||
		    	userInput.equalsIgnoreCase("s") ||
		    	userInput.equalsIgnoreCase("d") ||
		    	userInput.equalsIgnoreCase("m")) {
		    		board.userInput(userInput);
		    } else if (userInput.equalsIgnoreCase("i")) {
		    	heroTeam.printInfo();
		    } else if  (userInput.equalsIgnoreCase("b")) {
		    	heroTeam.printInfo();
		        System.out.print("Choose a hero to check bag:");
		        Hero hero = HeroTeam.returnHero();
		        Bag bag = hero.getBag();
		        bag.printInfo();
		    } else {
		    	System.out.println("Plese follow the instructions to input");
		    }
		    board.printBoardAndInstruction();
		}
	}

	// choose a hero 
	private void chooseHero() {
		heroTeam = new HeroTeam(heroNum);
		heroTeam.chooseHero();
	}

	// get hero number based on user input
	private void updateHeroNumber() {
		while (heroNum < 1 || heroNum > 3) { 
			System.out.print("How many heroes you want to play? (1-3): ");
			int heroNumber = new Scanner(System.in).nextInt();
			heroNum = heroNumber;
		}
	}





	











	private void printGameOver() {
		System.out.println();
		System.out.println("   GGGGG          A         MMMMM    EEEEEEEEEEE           O      VVV     VVV EEEEEEEEEEE   RRRRRR   ");
		System.out.println("  GGGGGGG        AAA        MMMMM    EEEEEEEEEEE         OOOOO    VVV     VVV EEEEEEEEEEE RRRRRRRRRR ");
		System.out.println(" GGGG GGGG       AAA       MMMMMMM   EEE               OOOOOOOOO  VVV     VVV EEE         RRRRRRRRRR ");
		System.out.println("GGGG   GGGG     AAAAA 	   MMMMMMM   EEE              OOOO   OOOO  VV     VV  EEE         RRR     RRR");
		System.out.println("GGG     GGG     AAAAA 	  MMMMMMMMM  EEE              OOO     OOO  VVV   VVV  EEE         RRR     RRR");
		System.out.println("GGG            AAA AAA 	  MMMMMMMMM  EEEEEEEEEEE      OOO     OOO   VV   VV   EEEEEEEEEEE RRRRRRRRRR ");
		System.out.println("GGG            AA   AA 	 MMM MMM MMM EEEEEEEEEEE      OOO     OOO   VVV VVV   EEEEEEEEEEE RRRRRRR    ");
		System.out.println("GGG    GGGG    AA   AA 	 MMM MMM MMM EEEEEEEEEEE      OOO     OOO   VVV VVV   EEEEEEEEEEE RRRRRRR    ");
		System.out.println("GGG    GGGG   AAAAAAAAA  MMM MMM MMM EEE              OOO     OOO    VVVVV    EEE         RRR RRRR   ");
		System.out.println("GGGG    GGG   AAAAAAAAA  MMM  M  MMM EEE              OOOO   OOOO    VVVVV    EEE         RRR  RRR   ");
		System.out.println(" GGGG  GGGG   AAA   AAA  MMM  M  MMM EEE               OOOOOOOOO      VVV     EEE         RRR   RRR  ");
		System.out.println("   GGGGG GG  AAAA   AAAA MMM     MMM EEEEEEEEEEE         OOOOO        VVV     EEEEEEEEEEE RRR    RRR ");
		System.out.println("    GGG  GG  AAA     AAA MMM     MMM EEEEEEEEEEE           O           V      EEEEEEEEEEE RRR     RRR");	
	}

	private void printGameStart() {
		System.out.println();
		System.out.println("   GGGGG          A         MMMMM    EEEEEEEEEEE        SSSSSSS   TTTTTTTTTTT      A        RRRRRR    TTTTTTTTTTT");
		System.out.println("  GGGGGGG        AAA        MMMMM    EEEEEEEEEEE       SSSSSSSSS  TTTTTTTTTTT     AAA     RRRRRRRRRR  TTTTTTTTTTT");
		System.out.println(" GGGG GGGG       AAA       MMMMMMM   EEE              SSSS   SSSS TTTTTTTTTTT     AAA     RRRRRRRRRR  TTTTTTTTTTT");
		System.out.println("GGGG   GGGG     AAAAA 	   MMMMMMM   EEE              SSSS    SSS     TTT        AAAAA 	  RRR     RRR     TTT    ");
		System.out.println("GGG     GGG     AAAAA 	  MMMMMMMMM  EEE              SSSSS           TTT        AAAAA    RRR     RRR     TTT    ");
		System.out.println("GGG            AAA AAA 	  MMMMMMMMM  EEEEEEEEEEE       SSSSSS         TTT       AAA AAA   RRRRRRRRRR      TTT    ");
		System.out.println("GGG            AA   AA 	 MMM MMM MMM EEEEEEEEEEE        SSSSSSS       TTT       AA   AA   RRRRRRR         TTT    ");
		System.out.println("GGG    GGGG    AA   AA 	 MMM MMM MMM EEEEEEEEEEE          SSSSSS      TTT       AA   AA   RRRRRRR         TTT    ");
		System.out.println("GGG    GGGG   AAAAAAAAA  MMM MMM MMM EEE                    SSSSS     TTT      AAAAAAAAA  RRR RRRR        TTT    ");
		System.out.println("GGGG    GGG   AAAAAAAAA  MMM  M  MMM EEE              SSS    SSSS     TTT      AAAAAAAAA  RRR  RRR        TTT    ");
		System.out.println(" GGGG  GGGG   AAA   AAA  MMM  M  MMM EEE              SSSS   SSSS     TTT      AAA   AAA  RRR   RRR       TTT    ");
		System.out.println("   GGGGG GG  AAAA   AAAA MMM     MMM EEEEEEEEEEE       SSSSSSSSS      TTT     AAAA   AAAA RRR    RRR      TTT    ");
		System.out.println("    GGG  GG  AAA     AAA MMM     MMM EEEEEEEEEEE        SSSSSSS       TTT     AAA     AAA RRR     RRR     TTT    ");	
	}

}
