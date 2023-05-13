/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * InaccessibleCell class
 * extended from abstractCell
 */


public class InaccessibleCell extends AbstractCell {

	@Override
	public boolean isInaccessible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isMarket() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNormal() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String printName() {
		return "\u001b[31m X \u001b[0m";
	}

}
