package tic_tac_toe;

import util.Evaluation;

/**
 * Class implementing the <b>game master of this tic-tac-toe program</b>, the central class
 * that provides access to all the methods necessary to run the system
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
public class GameMaster {
    /* Board on which the player place their tokens */
    private Board b;
    /* Tic-tac-toe-playing agent */
    private Agent a;

    /* true if the tic-tac-toe-playing agent is the first to move; false, otherwise */
    private boolean isAgentFirst;
    /* Level of intelligence of the agent */
    private int intelligence;

    /* Number of times the tic-tac-toe-playing agent has won */
    private int numAgentWins;
    /* Number of times the human-playing agent has won */
    private int numHumanWins;
    /* Number of times the game has ended in a draw */
    private int numDraws;

    /**
     * Creates a game master object
     *
     * <p>Since the initialization of certain attributes (such as those related to the agent,
     * the level of intelligence, and the first player to move) depend on choices made by the
     * user, it is deferred and delegated to the setters, particularly to <code>setAgent</code>
     * and <code>setIsAgentFirst</code>.
     */
    public GameMaster() {
        b = new Board();

        /* Initialize all the match statistics to 0. */
        numAgentWins = 0;
        numHumanWins = 0;
        numDraws = 0;
    }

    /**
     * Creates a game master object given a string that represents its initial state (or configuration)
     * of the board
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
    public GameMaster(String initConfig) {
        b = new Board(initConfig);
    }

    /**
     * Returns <code>true</code> if the tic-tac-toe-playing agent is the first to move;
     * <code>false</code>, otherwise
     *
     * @return <code>true</code> if the tic-tac-toe-playing agent is the first to move;
     * <code>false</code>, otherwise
     */
    public boolean getIsAgentFirst() {
        return isAgentFirst;
    }

    /**
     * Returns the number of times the tic-tac-toe-playing agent has won
     *
     * @return number of times the tic-tac-toe-playing agent has won
     */
    public int getNumAgentWins() {
        return numAgentWins;
    }

    /**
     * Returns the number of times the human player has won
     *
     * @return number of times the human player has won
     */
    public int getNumHumanWins() {
        return numHumanWins;
    }

    /**
     * Returns the number of times the game has ended in a draw
     *
     * @return number of times the game has ended in a draw
     */
    public int getNumDraws() {
        return numDraws;
    }

    /**
     * Returns the level of intelligence of the tic-tac-toe-playing agent (the rationality
     * of the agent increases commensurate to the level number)
     *
     * @return level of intelligence of the tic-tac-toe-playing agent
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * Initializes the tic-tac-toe-playing agent depending on the specified level of intelligence
     *
     * <p>This method also initializes the pertinent attribute related to the level of intelligence
     * of the agent.</p>
     *
     * @param intelligence level of intelligence of the tic-tac-toe-playing agent
     */
    public void setAgent(int intelligence) {
        /* Initialize the attribute related to the level of intelligence of the agent. */
        this.intelligence = intelligence;

        /* Initializes the tic-tac-toe-playing agent depending on the specified level of intelligence. */
        switch(intelligence) {
            case 0:
                a = new AgentLevel0();
                break;
            case 1:
                a = new AgentLevel1();
                break;
            case 2:
                a = new AgentLevel2();
                break;
            case 3:
                a = new AgentLevel3();
                break;
            case 4:
                a = new AgentLevel4();
                break;
            case 5:
                a = new AgentLevel5();
                break;
        }
    }

    /**
     * Updates the attribute related to which player is first to move
     *
     * @param isAgentFirst <code>true</code> if the tic-tac-toe-playing agent (computer) is first
     *                     to move; <code>false</code>, otherwise
     */
    public void setIsAgentFirst(boolean isAgentFirst) {
        this.isAgentFirst = isAgentFirst;
    }


    /**
     * Returns the best move given the current board state, alongside this agent's numerical
     * evaluation of this move
     *
     * <p>Note that the evaluation is material only if this agent employs the minimax algorithm
     * (that is, only for levels 2 to 5). Otherwise, the evaluation is always set to 0 regardless
     * of the actual optimality of the selected move. </p>
     *
     * @return best move, alongside this agent's numerical evaluation of this move
     */
    public Evaluation evalBestMove() {
        return a.evalBestMove(b);
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
        b.makeMove(row, col, token);
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
        return b.isGameOver();
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
    public boolean isGameDraw() {
        return b.isDraw();
    }

    /**
     * Returns <code>true</code> if a winning configuration is registered by the tic-tac-toe-
     * playing agent; <code>false</code>, otherwise
     *
     * <p>A winning configuration is defined as in classical tic-tac-toe: a three-in-a-lane
     * (horizontally, vertically, or diagonally).</p>
     *
     * @return <code>true</code> if a winning configuration is registered by the tic-tac-toe
     * playing agent; <code>false</code>, otherwise
     */
    public boolean isAgentWin() {
        return b.isWin(Board.COMPUTER_TOKEN);
    }

    /**
     * Returns <code>true</code> if a winning configuration is registered by the human player;
     * <code>false</code>, otherwise
     *
     * <p>A winning configuration is defined as in classical tic-tac-toe: a three-in-a-lane
     * (horizontally, vertically, or diagonally).</p>
     *
     * @return <code>true</code> if a winning configuration is registered by the human player;
     * <code>false</code>, otherwise
     */
    public boolean isHumanWin() {
        return b.isWin(Board.HUMAN_TOKEN);
    }

    /**
     * Update the match statistics related to the number of wins given the character code
     * of the pertinent player
     *
     * @param token character code of the pertinent player
     */
    public void recordWin(char token) {
        switch(token) {
            case Board.COMPUTER_TOKEN:
                numAgentWins++;
                break;
            case Board.HUMAN_TOKEN:
                numHumanWins++;
                break;
        }
    }

    /**
     * Update the match statistics related to a draw
     */
    public void recordDraw() {
        numDraws++;
    }

    /**
     * Configures this board back to its initial state, that is, 9 unoccupied tiles arranged
     * into 3 rows and 3 columns
     */
    public void clearBoard() {
        b.initBoard();
    }

    /**
     * Returns a string representation of this game master
     *
     * <p>The string representation contains the following details in order: </p>
     * <ul>
     *     <li>String representation of the board</li>
     *     <li>String representation of the agent (which includes the move evaluation)</li>
     *     <li>Match statistics (number of wins by the agent, number of wins by the human player,
     *     and number of draws &mdash; separated by a hyphen)</li>
     * </ul>
     *
     * @return string representation of this game master
     */
    @Override
    public String toString() {
        return b.toString() + "\n" + a.toString() + "\n"
                + numAgentWins + "-" + numHumanWins + "-" + numDraws + "\n";
    }
}
