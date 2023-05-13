/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * Board class
 * All operations related to move on board are in this class 
 */

public class Board {
	int boardSize;
	double inaccessibleProb;
	double marketProb;
	double battleProb;
    private Cell[][] cells;
    int currentPositionX=0;
	int currentPositionY=0;
	
	public Board(int size, double inaccessible, double market, double battle) {
		boardSize = size;
		inaccessibleProb = inaccessible;
		marketProb = market;
		battleProb = battle;
        cells = new Cell[boardSize][boardSize];
    	// init the board with inaccessible cells / market cells
        initBoard();
	}

	// print cell info , used for debug
	void printCells() {
		for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
            	  System.out.println(cells[i][j]);
            }
        }
	}
	
	// init the board with inaccessible cells / market cells
    private void initBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
            	// make (0,0) as born cell and normal cell
            	if (i==0 && j==0) {
            		this.setNormalCell(i, j);
            	} else if (i==0 && j==1) {
            		// make (1,1) as market cell
            		this.setMarketCell(i, j);
            	} else {
            		// assign cell type randomly
                    double random = Math.random();
                    //System.out.println(random);
                    if (random < inaccessibleProb) {
                    	this.setInaccessibleCell(i, j);
                    } else if (random < (marketProb + inaccessibleProb)) {
                        this.setMarketCell(i, j);
                    } else {
                    	this.setNormalCell(i, j);
                    }
            	}
            }
        }
	}

    // set this cell as inaccessible cell
	private void setInaccessibleCell(int i, int j) {
        this.cells[i][j] = new InaccessibleCell();
    }
    // set this cell as market cell
	private void setMarketCell(int i, int j) {
        this.cells[i][j] = new MarketCell();
    }
    // set this cell as normal cell
	private void setNormalCell(int i, int j) {
        this.cells[i][j] = new NormalCell();
    }
	
    //print board and instructions
    public void printBoardAndInstruction() {
    	printBoard();
    	printInstruction();
    }

	//print board and each cell's name as well as hero team's location
    private void printBoard() {
		System.out.println("");
        System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
		String hLine = "";
		for (int i = 0; i < boardSize; i++) {
			hLine += "+-----";
		}
		hLine += "+";
		for (int i = 0; i < boardSize; i++) {
            String vline = "";
            for (int j = 0; j < boardSize; j++) {
            	vline += "|";
                if (i == currentPositionX && j == currentPositionY) {// && !board[i][j].equals("")) {
                	vline += "  ";
                	vline += "\u001b[33m*\u001b[0m ";
                	vline += " ";
                } else {
                    //vline += String.format("%3d", cells[i][j].printName())  + " ";
                	vline += " ";
                	vline += cells[i][j].printName();
                	vline += " ";
                }
            }
            vline += "|";
            System.out.println(hLine);
            System.out.println(vline);
        }
        System.out.println(hLine);
        System.out.print("\u001b[33m* your location\u001b[0m");
        System.out.print("\u001b[36m   M market\u001b[0m");
        System.out.println("\u001b[31m   X inaccessible cell\u001b[0m");
	}
	
    public void printInstruction() {
    	if (cells[currentPositionX][currentPositionY].isMarket()) {
            System.out.println("\u001b[36mYou are at a market. Enter market(M/m)\u001b[0m");
        }
    	System.out.println("move up/down/left/right (w/s/a/d)");
        System.out.println("quit game(Q/q)");
        System.out.println("show information(I/i)");
        System.out.println("show bag(B/b)");
	}
        

	public void userInput(String userInput) {
		// at normal cell now
		if(cells[currentPositionX][currentPositionY].isNormal()) {
			if(userInput.equalsIgnoreCase("m")) {
			// user tries to enter "m" at a normal cell	
				System.out.println("\u001b[31mThis is a normal cell, cannot enter market!\u001b[0m");
			} else {
			// user enter wasd at a normal cell
				move(userInput);
			}
		} else if (cells[currentPositionX][currentPositionY].isMarket()) {
		// at market cell now
			if(userInput.equalsIgnoreCase("m")) {
			// user enter "m" at a market cell, enter market
				((MarketCell) cells[currentPositionX][currentPositionY]).enterMarketCell();
			} else {
			// user enter wasd at a market cell
				move(userInput);
			}
		}
	}
	
	// team tries to move to a new cell
	public void move(String str) {
		// get team's new (X,Y) position if moves 
		Integer newX = newPositionX(str, currentPositionX);
		Integer newY = newPositionY(str, currentPositionY);
		if(newX == null || newY == null) {
		// move out of map size
			System.out.println("\u001b[31mCannot move due to map size\u001b[0m");
        } else if (cells[newX][newY].isInaccessible()) {
        // move to an inaccessible cell
        	System.out.println("\u001b[31mCannot move to an inaccessible cell\u001b[0m");
        } else {
        // move to a movable cell (either normal cell or market cell)
        	//update new team location
        	currentPositionX = newX;
        	currentPositionY = newY;
        	System.out.println("Current location (" + currentPositionX + "," + currentPositionY+ ")");
        	if (cells[newX][newY].isMarket()) {
        	// move to a market cell
        		// print instructions
        		//printBoardAndInstruction();
        	} else {
        	// move to a normal cell
        		if(newBattle()) {
                // new a battle
                	System.out.println("\u001b[35mOh no! Monsters are here! Get Ready to Fight!\u001b[0m");
                	System.out.println("\u001b[35mBattle part still under developing\u001b[0m");
                	
                	
                	
                	
                	
                } else {
                // no new battle happen
               		System.out.println("\u001b[32mYou are lucky! No monsters here\u001b[0m");
                }	
        	}        	
        }		
	}

	// decide whether a new battle happens when move to a new normal cell
	private boolean newBattle() {
		double random = Math.random();
        //System.out.println(random);
        if (random < battleProb) {
        	return true;
        }
        return false;
	}

	// get team's new X position if moves 
	private Integer newPositionX(String str, int currentX) {
		int tempNewX = currentX;
		if (str.equalsIgnoreCase("w")) {
			tempNewX--;
		} else if (str.equalsIgnoreCase("s")) {
			tempNewX++;
	    }
	    if (tempNewX < 0 || tempNewX >= boardSize) {
	    	return null;
	    }
	    return tempNewX;
	}
	
	// get team's new Y position if moves 
	private Integer newPositionY(String str, int currentY) {
		int tempNewY = currentY;
		if (str.equalsIgnoreCase("a")) {
			tempNewY--;
		} else if (str.equalsIgnoreCase("d")) {
			tempNewY++;
	    }
	    if (tempNewY < 0 || tempNewY >= boardSize) {
	    	return null;
	    }
	    return tempNewY;
	}

	
	
	
	
	
	
}
