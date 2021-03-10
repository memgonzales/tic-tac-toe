package util;

/**
 * Class implementing a <b>pair of coordinates</b> (row- and column-coordinates)
 * to describe the location of tiles in the 3&times;3 tic-tac-toe board
 *
 * <p>The coordinate system used in this program is zero-based. Therefore, the upper
 * left tile is referred to as (0,0), the tile below it is (1,0), and the tile beside
 * it is (0,1). <b>For simplicity, the move (<i>x</i>,<i>y</i>) is shorthand for placing a token on
 * the tile (<i>x</i>,<i>y</i>).</b> </p>
 *
 * <p>The special coordinate (-1,-1) is used to indicate that, as a result of the game
 * having reached its terminal state (that is, a win, loss, or draw), there are no valid
 * tiles left on which a player's token can be placed.</p>
 */
public class Coordinates {
    /* Row-coordinate */
    private int row;
    /* Column-coordinate */
    private int col;

    /**
     * Creates a pair of coordinates given the row- and column-coordinates
     *
     * <p>Since the program follows a zero-based coordinate system and features a 3&times;3 tic-tac-toe
     * board, the row- and column-coordinates can only assume the values 0, 1, and 2. </p>
     *
     * <p>The value -1 for both coordinates is reserved to indicate that, as a result of the game
     * having reached its terminal state (that is, a win, loss, or draw), there are no valid tiles
     * left on which a player's token can be placed.</p>
     *
     * @param row row-coordinate
     * @param col column-coordinate
     */
    public Coordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Returns the row-coordinate of this pair of coordinates
     *
     * @return row-coordinate of this pair of coordinates
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns the column-coordinate of this pair of coordinates
     *
     * @return column-coordinate of this pair of coordinates
     */
    public int getCol() {
        return col;
    }

    /**
     * Updates the row- and column-coordinates of this pair of coordinates
     *
     * <p>Since the program follows a zero-based coordinate system and features a 3&times;3 tic-tac-toe
     * board, the row- and column-coordinates can only assume the values 0, 1, and 2. </p>
     *
     * <p>The value -1 for both coordinates is reserved to indicate that, as a result of the game
     * having reached its terminal state (that is, a win, loss, or draw), there are no valid tiles
     * left on which a player's token can be placed.</p>
     *
     * @param row row-coordinate
     * @param col column-coordinate
     */
    public void setRowCol(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Returns a string representation of this pair of coordinates
     *
     * <p>In particular, the string representation contains the row- and column-coordinates
     * (in this order), separated by a single space. </p>
     *
     * @return string representation of this pair of coordinates
     */
    @Override
    public String toString() {
        return row + " " + col;
    }

    /**
     * Returns <code>true</code> if the row- and column-coordinates of this pair of coordinates
     * are equal to the row- and column-coordinates of the given object; <code>false</code>,
     * otherwise
     *
     * @param o object whose equality with this pair of coordinates is to be checked
     * @return <code>true</code> if the row- and column-coordinates of this pair of coordinates
     * are equal to the row- and column-coordinates of the given object; <code>false</code>,
     * otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        Coordinates c;
        c = (Coordinates) o;

        return c.getCol() == this.getCol() && c.getRow() == this.getRow();
    }
}
