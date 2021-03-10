package tic_tac_toe;

import util.Evaluation;

/**
 * Abstract class providing a skeletal implementation of the <b>tic-tac-toe-playing agent </b>
 */
public abstract class Agent {
    /* Most recent move evaluation of this agent */
    private Evaluation latestEval;

    /**
     * Static utility value given to a win (set to 100)
     */
    public static final int WIN_UTIL = 100;
    /**
     * Static utility value given to a loss (set to -100)
     */
    public static final int LOSS_UTIL = -100;
    /**
     * Static utility value given to a draw (set to 0)
     */
    public static final int DRAW_UTIL = 0;

    /**
     * Constructor for a tic-tac-toe-playing agent
     */
    public Agent() {
        latestEval = null;
    }

    /**
     * Returns the best move given the current board state, alongside this agent's numerical
     * evaluation of this move
     *
     * <p>Note that the evaluation is material only if this agent employs the minimax algorithm
     * (that is, only for levels 2 to 5). Otherwise, the evaluation is always set to 0 regardless
     * of the actual optimality of the selected move. </p>
     *
     * @param b current board state
     * @return best move, alongside this agent's numerical evaluation of this move
     */
    public abstract Evaluation evalBestMove(Board b);

    /**
     * Updates the most recent move evaluation of this agent
     *
     * @param move most recent move evaluation of this agent
     */
    public void setLatestEval(Evaluation move) {
        latestEval = move;
    }

    /**
     * Returns a string representation of this agent
     *
     * <p>In particular, the string representation contains the most recent move evaluation
     * of this agent. </p>
     *
     * @return string representation of this agent
     */
    @Override
    public String toString() {
        return latestEval.toString();
    }
}
