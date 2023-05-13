
/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * NormalCell class
 * extended from abstractCell
 * implements reachable interface
 */

public class NormalCell extends AbstractCell implements Reachable {

	@Override
	public boolean isInaccessible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMarket() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNormal() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String printName() {
		return "   ";
	}

}
