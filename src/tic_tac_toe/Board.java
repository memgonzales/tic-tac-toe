package tic_tac_toe;

import util.Coordinates;

import java.util.ArrayList;

/**
 * Class implementing the <b>3&times;3 tic-tac-toe board</b> consisting of the tiles
 * on which the players place their tokens
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
public class Board {
    /* Board on which the player place their tokens */
    private char[][] board;

    /**
     * Length of this board (which is also equal to its width)
     */
    public static final int DIMENSION = 3;
    /**
     * Character code to denote that a tile is unoccupied
     */
    public static final char EMPTY_TOKEN = '*';
    /**
     * Character code to denote that a tile is occupied by the human player (also the character
     * code of the human player)
     */
    public static final char HUMAN_TOKEN = 'H';
    /**
     * Character code to denote that a tile is occupied by the tic-tac-toe-playing agent (also the
     * character code of the tic-tac-toe-playing agent/computer)
     */
    public static final char COMPUTER_TOKEN = 'C';

    /**
     * Creates a board object consisting of 9 unoccupied tiles arranged into 3 rows and 3 columns
     */
    public Board() {
        board = new char[DIMENSION][DIMENSION];
        initBoard();
    }

    /**
     * Creates a board object based on a string that represents its initial state (or configuration)
     *
     * <p>The string is of the form <code>%%%|%%%|%%%</code>, which is a flattened representation
     * of the board state following row-major order. Each <code>%</code> stands for a tile while
     * <code>|</code> is a mandatory delimiter to separate rows. Note that % can be any of the
     * following characters: </p>
     * <ul>
     *     <li>* (<code>EMPTY_TOKEN</code>) </li>
     *     <li>H (<code>HUMAN_TOKEN</code>)</li>
     *     <li>C (<code>COMPUTER_TOKEN</code>)</li>
     * </ul>
     *
     * <p>For example, a board with only a human token on the center is represented as
     * <code>***|*H*|***</code>.</p>
     *
     * @param initConfig string representation of the initial state (or configuration)
     */
    public Board(String initConfig) {
        board = new char[DIMENSION][DIMENSION];

        int k;          // index pertinent to the string representation of the initial state
        k = 0;

        /* Construct this board tile-by-tile, following row-major order. */
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                /* Increment k to advance to the next character in the string representation. */
                board[i][j] = initConfig.charAt(k++);
            }

            /* Skip the '|' character used to delimit rows. */
            k++;
        }
    }

    /**
     * Configures this board to its initial state, that is, 9 unoccupied tiles arranged into 3 rows
     * and 3 columns
     */
    public void initBoard() {
        /* Iterate through all the tiles of this board. */
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                board[i][j] = EMPTY_TOKEN;
            }
        }
    }

    /**
     * Updates the board state to reflect the most recent move given the row- and column-coordinates
     * of the move, and the character code of the pertinent player
     *
     * @param row row-coordinate of the player's move
     * @param col column-coordinate of the player's move
     * @param token character code of the player making the move
     */
    public void makeMove(int row, int col, char token) {
        board[row][col] = token;
    }

    /**
     * Returns <code>true</code> if a winning configuration is detected given the character
     * code of the pertinent player; <code>false</code>, otherwise
     *
     * <p>A winning configuration is defined as in classical tic-tac-toe: a three-in-a-lane
     * (horizontally, vertically, or diagonally).</p>
     *
     * @param token character code of the pertinent player
     * @return <code>true</code> if a winning configuration is detected; <code>false</code>,
     * otherwise
     */
    public boolean isWin(char token) {
        /* Check for a non-diagonal winning configuration. */
        for (int i = 0; i < DIMENSION; i++) {
            /* Check each row for a winning configuration. */
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][2] == token) {
                return true;
            }

            /* Check each column for a winning configuration. */
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[2][i] == token) {
                return true;
            }
        }

        /* Check each diagonal for a winning configuration. */
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == token
                || board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0] == token) {
            return true;
        }

        /* No winning configuration is detected. */
        return false;
    }

    /**
     * Returns <code>true</code> if a winning configuration is detected (regardless of which player
     * made the winning move); <code>false</code>, otherwise
     *
     * @return <code>true</code> if a winning configuration is detected; <code>false</code>,
     * otherwise
     */
    public boolean isWin() {
        return isWin(HUMAN_TOKEN) || isWin(COMPUTER_TOKEN);
    }

    /**
     * Returns <code>true</code> if a drawn configuration is detected; <code>false</code>, otherwise
     *
     * <p>Note that, for a configuration to be considered drawn, all 9 tiles must be occupied
     * without the presence of any of three-in-a-lane. Although it is possible to infer that a
     * position is drawn even before all tiles are occupied, these cases are deemed inconclusive
     * in the interest of simplicity. </p>
     *
     * @return <code>true</code> if a drawn configuration is detected; <code>false</code>,
     * otherwise
     */
    public boolean isDraw() {
        /* If this board already has a winning configuration, then the state is automatically
        not a draw.
         */
        if (isWin()) {
            return false;
        }

        /* Iterate through all the tiles of this board.

        Since it has already been determined that no winning configuration is present, it suffices
        to check whether all tiles are occupied. If all tiles are occupied, then a draw is declared;
        otherwise, the result is inconclusive (as explained in the method documentation).
         */
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (board[i][j] == EMPTY_TOKEN) {
                    return false;
                }
            }
        }

        /* A drawn configuration is detected. */
        return true;
    }

    /**
     * Returns <code>true</code> if either a winning or drawn configuration is detected (that is,
     * this board is at its terminal state); <code>false</code>, otherwise
     *
     * <p>Note that, for a configuration to be considered drawn, all 9 tiles must be occupied
     * without the presence of any of three-in-a-lane. Although it is possible to infer that a
     * position is drawn even before all tiles are occupied, these cases are deemed inconclusive
     * in the interest of simplicity. </p>
     *
     * @return <code>true</code> if either a winning or drawn configuration is detected;
     * <code>false</code>, otherwise
     */
    public boolean isGameOver() {
        return isDraw() || isWin();
    }

    /**
     * Returns <code>true</code> if all the 9 tiles are unoccupied (that is, this board is at its
     * initial state); <code>false</code>, otherwise
     *
     * @return <code>true</code> if all the 9 tiles are unoccupied; <code>false</code>, otherwise
     */
    public boolean isEmpty() {
        /* Iterate through all the tiles of this board. */
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                /* An occupied tile is detected. */
                if (board[i][j] != EMPTY_TOKEN) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Returns <code>true</code> if the specified tile (given the row- and column-coordinates)
     * is occupied; <code>false</code>, otherwise
     *
     * @param row row-coordinate of the tile
     * @param col column-coordinate of the tile
     * @return <code>true</code> of the specified tile is occupied; <code>false</code>, otherwise
     */
    public boolean isOccupied(int row, int col) {
        return board[row][col] == HUMAN_TOKEN || board[row][col] == COMPUTER_TOKEN;
    }

    /**
     * Returns a list of all the possible moves that a player can make given the current board
     * state (or configuration)
     *
     * <p>The possible moves are arranged in row-major order; this order dictates the evaluation
     * of moves if the agent employs the minimax algorithm in its decision-making. </p>
     *
     * @return list of all the possible moves that a player can make given the current board
     * state (or configuration)
     */
    public ArrayList<Coordinates> getPossibleMoves() {
        ArrayList<Coordinates> possibleMoves;       // list of possible moves given the current state
        possibleMoves = new ArrayList<Coordinates>(9);

        /* Iterate through all the tiles of the board to determine which tiles are unoccupied. */
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (!isOccupied(i, j)) {
                    possibleMoves.add(new Coordinates(i, j));
                }
            }
        }

        return possibleMoves;
    }

    /**
     * Returns a list of all the tiles currently occupied by the tic-tac-toe-playing agent (computer)
     *
     * @return list of all the tiles currently occupied by the tic-tac-toe-playing agent (computer)
     */
    public ArrayList<Coordinates> getOccupiedC() {
        ArrayList<Coordinates> occupiedC;       // tiles currently occupied by the computer
        occupiedC = new ArrayList<Coordinates>(DIMENSION * DIMENSION);

        /* Iterate through all the tiles of the board. */
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (board[i][j] == COMPUTER_TOKEN) {
                    occupiedC.add(new Coordinates(i, j));
                }
            }
        }

        return occupiedC;
    }

    /**
     * Returns a list of all the tiles currently occupied by the human player
     *
     * @return list of all the tiles currently occupied by the human player
     */
    public ArrayList<Coordinates> getOccupiedH() {
        ArrayList<Coordinates> occupiedH;       // tiles currently occupied by the human player
        occupiedH = new ArrayList<Coordinates>(DIMENSION * DIMENSION);

        /* Iterate through all the tiles of the board. */
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (board[i][j] == HUMAN_TOKEN) {
                    occupiedH.add(new Coordinates(i, j));
                }
            }
        }

        return occupiedH;
    }

    /**
     * Returns a string representation of this board
     *
     * <p>The string representation contains the following details in order: </p>
     * <ul>
     *     <li>Two-dimensional representation of the board</li>
     *     <li>Whether the game is won by the human player</li>
     *     <li>Whether the game is won by the tic-tac-toe-playing agent (computer)</li>
     *     <li>Whether the game is drawn</li>
     *     <li>Whether the game has reached its terminal state (game over)</li>
     *     <li>List of all the possible moves given the current board state</li>
     * </ul>
     *
     * @return string representation of this board
     */
    @Override
    public String toString() {
        String ret = "";            // string representation of this board
        String results = "";        // stores details regarding the current status of the game

        /* Construct the two-dimensional representation of the board. */
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                ret += board[i][j] + " ";
            }

            ret += "\n";
        }

        /* Include details regarding the current status of the game. */
        results += "Winner - H: " + isWin(HUMAN_TOKEN) + "\n";
        results += "Winner - C: " + isWin(COMPUTER_TOKEN) + "\n";
        results += "Draw: " + isDraw() + "\n";
        results += "Game Over: " + isGameOver() + "\n";

        /* Include the list of all the possible moves given the current board state. */
        ret += results + getPossibleMoves();

        return ret;
    }
}
