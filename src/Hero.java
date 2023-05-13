/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * Hero  interface 
 * an interface that all hero shares methods and features in common
 */


public interface Hero {
	
	String getName();
	int getMana();
	int getStrength();
    int getDexterity();
    int getAgility();
	int getMoney();
	int getExperience();
    void printName();
    void printInfo();
	void buy(AbstractItem item, String string);
	Bag getBag();






}
