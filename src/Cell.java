/**
 * # CS611 - Assignment 3
 * ## Legends: Monsters and Heroes
 * <Student Name:  Haoxuan Sun   >
 * <Student Email: hs4379@bu.edu >
 * <Student BUID:  U58198360     >
 *
 * CEll interface
 * A board is consists of cells. Here list methods that cell shares in common
 */

public interface Cell {
    boolean isInaccessible();
    boolean isMarket();
    boolean isNormal();
    String printName();
}
