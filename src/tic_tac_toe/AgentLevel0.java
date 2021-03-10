package tic_tac_toe;

import util.Coordinates;
import util.Evaluation;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class implementing <b>level 0 of the tic-tac-toe-playing agent</b>, which uses a
 * <b>random number generator</b> to choose random valid moves for the agent
 *
 * <p>A technical description and analysis of this agent is given in the problem formulation
 * report accompanying the source code.</p>
 */
public class AgentLevel0 extends Agent {

    /**
     * Creates the level 0 of the tic-tac-toe-playing agent, which which uses a
     * random number generator to choose random valid moves for the agent
     */
    public AgentLevel0() {
        super();
    }

    /**
     * Returns a random move given the current board state, alongside this agent's numerical
     * evaluation of this move (set to a sentinel value of 0 for level 0, as no heuristics
     * or search algorithms were used)
     *
     * @param b current board state
     * @return random move, alongside this agent's numerical evaluation of this move
     */
    @Override
    public Evaluation evalBestMove(Board b) {

        ArrayList<Coordinates> possibleMoves;       // list of valid moves
        Coordinates currMove;                       // current move of the agent
        int currMoveIndex;                          // index of the current move of the agent
        Evaluation eval;                            // final move evaluation

        /* If the game has been completed, the sentinel coordinates (-1,-1) are set as
        the current move.
        */
        if (b.isGameOver()) {
            currMove = new Coordinates(-1, -1);
        } else {
        /* Otherwise, the agent's possible moves are stored in a list and a random number
        generator is used to pick a valid index; the agent uses the move stored at this
        index as its current move.
        */
            possibleMoves = b.getPossibleMoves();
            currMoveIndex = getRandom(possibleMoves.size());
            currMove = possibleMoves.get(currMoveIndex);
        }

        eval = new Evaluation(0, currMove);

        /* Update and return the latest move evaluation of this agent. */
        setLatestEval(eval);
        return eval;
    }

    /**
     * Returns a random integer from 0 (inclusive) to the set upper bound (exclusive)
     * for use in the random move generation of the level 0 agent
     *
     * <p>Technically, the integer generated is pseudorandom since the library used
     * for its generation is Java's <code>ThreadLocalRandom</code>. Nevertheless,
     * this is sufficient for the purposes of this system. </p>
     *
     * @param hi exclusive upper bound
     * @return random integer from 0 (inclusive) to the set upper bound (exclusive)
     */
    public int getRandom(int hi) {
        return ThreadLocalRandom.current().nextInt(0, hi);
    }
}
