
/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * MarketCell class
 * extended from AbstractCell
 * implements reachable interface
 */


public class MarketCell extends AbstractCell implements Reachable {

    private Market market = new Market();
	
	@Override
	public boolean isInaccessible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMarket() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isNormal() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String printName() {
		return "\u001b[36m M \u001b[0m";
	}

	// enter market
	public void enterMarketCell() {
		market.enterMarket();
	}
	
	

}
