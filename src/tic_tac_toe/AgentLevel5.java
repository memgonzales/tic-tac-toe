package tic_tac_toe;

import util.Coordinates;
import util.Evaluation;

import java.util.ArrayList;

/**
 * Class implementing <b>level 5 of the tic-tac-toe-playing agent</b>, which employs a
 * <b>depth-sensitive minimax algorithm</b> (a depth-first search strategy for adversarial
 * games) and features a reduced search space resulting from <b>alpha-beta pruning</b>
 *
 * <p>This depth-sensitive variant of the minimax algorithm ensures that the agent places
 * priority on moves that immediately win the game. A technical description and analysis
 * of this agent is given in the problem formulation report accompanying the source code.</p>
 */
public class AgentLevel5 extends Agent {
    /**
     * Negative infinity (-&infin;) is set to be the smallest value that the integer
     * data type can accommodate
     */
    public static final int NEG_INFTY = Integer.MIN_VALUE;
    /**
     * Positive infinity (+&infin;) is set to be the largest value that the integer
     * data type can accommodate
     */
    public static final int POS_INFTY = Integer.MAX_VALUE;

    /**
     * Creates the level 5 of the tic-tac-toe-playing agent, which employs a depth-sensitive minimax
     * algorithm and features a reduced search space resulting from alpha-beta pruning
     */
    public AgentLevel5() {
        super();
    }

    /**
     * Returns the best move given the current board state, alongside this agent's numerical
     * evaluation of this move
     *
     * @param b current board state
     * @return best move, alongside this agent's numerical evaluation of this move
     */
    @Override
    public Evaluation evalBestMove(Board b) {
        return evalBestMove(b, true, 0, NEG_INFTY, POS_INFTY);
    }

    /**
     * Returns a move evaluation following a depth-sensitive minimax algorithm for adversarial, two-player,
     * zero-sum games
     *
     * <p>This method slightly deviates from the standard minimax implementation. Typically, if the current
     * evaluation is greater than the interim maximum (or less than the interim minimum), this evaluation
     * is set to be the new maximum (or minimum). However, this variant sets the <b>new interim maximum</b>
     * as the <b>difference of the evaluation and depth of the leaf node</b> (analogously, the <b>new interim
     * minimum</b> is the <b>sum of the evaluation and depth of the leaf node</b>). </p>
     *
     * <p>This technique guarantees that the agent prioritizes moves that immediately win the game.
     * Moreover, to reduce the number of nodes that have to be generated and evaluated, alpha-beta
     * pruning is employed. </p>
     *
     * @param b current board state
     * @param maximizing <code>true</code> if it is the turn of the maximizing player (agent); <code>false</code>,
     *                   otherwise (that is, the turn of the minimizing player [human])
     * @param depth depth of the game tree
     * @param alpha &alpha; parameter in alpha-beta pruning
     * @param beta &beta; parameter in alpha-beta pruning
     * @return move evaluation following the minimax algorithm
     */
    public Evaluation evalBestMove(Board b, boolean maximizing, int depth, int alpha, int beta) {
        int bestScore;                      // interim minimax value
        Coordinates bestMove;               // interim best move

        /* BASE CASE: A leaf node of the game tree is reached.
        Since a leaf node is reached, the game is at its terminal state; thus, there are no valid moves left.
         */
        bestMove = new Coordinates(-1, -1);
        if (b.isGameOver()) {
            if (b.isWin(Board.HUMAN_TOKEN)) {
                bestScore = LOSS_UTIL;
            } else if (b.isWin(Board.COMPUTER_TOKEN)) {
                bestScore = WIN_UTIL;
            } else {
                bestScore = DRAW_UTIL;
            }

            Evaluation eval;                // final move evaluation
            eval = new Evaluation(bestScore, bestMove);

            /* Update and return the latest move evaluation of this agent. */
            setLatestEval(eval);
            return eval;
        }

        /* Identify the selection of all possible moves given the current board state. */
        ArrayList<Coordinates> possibleMoves;
        possibleMoves = b.getPossibleMoves();

        /* Turn of the maximizing player (agent) */
        if (maximizing) {
            /* The miniMAX is initialized to negative infinity. */
            bestScore = NEG_INFTY;

            /* Evaluate all the possible moves given the current board state, following row-major order. */
            for (int i = 0; i < possibleMoves.size(); i++) {
                Coordinates currMove;       // current move being evaluated
                currMove = possibleMoves.get(i);

                /* Update the board state to reflect the current move being evaluated. */
                b.makeMove(currMove.getRow(), currMove.getCol(), Board.COMPUTER_TOKEN);

                int evalScore;              // numerical evaluation of the current move

                /* Switch to the turn of the minimizing player (MINImax), and increase the depth of the game tree. */
                evalScore = evalBestMove(b, false, depth + 1, alpha, beta).getEvalScore();

                /* Revert the board state to its original. */
                b.makeMove(currMove.getRow(), currMove.getCol(), Board.EMPTY_TOKEN);

                /* If the numerical evaluation is greater than the interim miniMAX value, update the value
                of the latter, as well as the best move.
                 */
                if (evalScore > bestScore) {
                    /* Take the depth into consideration to give priority to moves that immediately win the game. */
                    bestScore = evalScore - depth;
                    bestMove.setRowCol(currMove.getRow(), currMove.getCol());

                    /* The alpha parameter is related to the maximum value. */
                    alpha = Math.max(alpha, bestScore);

                    /* Prune if the alpha parameter is greater than or equal to the beta parameter. */
                    if (alpha >= beta) {
                        break;
                    }
                }
            }

        } else {    /* Turn of the minimizing player (human) */
            /* The MINImax is initialized to positive infinity. */
            bestScore = POS_INFTY;

            /* Evaluate all the possible moves given the current board state, following row-major order. */
            for (int i = 0; i < possibleMoves.size(); i++) {
                Coordinates currMove;       // current move being evaluated
                currMove = possibleMoves.get(i);

                /* Update the board state to reflect the current move being evaluated. */
                b.makeMove(currMove.getRow(), currMove.getCol(), Board.HUMAN_TOKEN);

                int evalScore;              // numerical evaluation of the current move

                /* Switch to the turn of the maximizing player (miniMAX), and increase the depth of the game tree. */
                evalScore = evalBestMove(b, true, depth + 1, alpha, beta).getEvalScore();

                /* Revert the board state to its original. */
                b.makeMove(currMove.getRow(), currMove.getCol(), Board.EMPTY_TOKEN);

                /* If the numerical evaluation is less than the interim MINImax value, update the value of the latter,
                as well as the best move
                 */
                if (evalScore < bestScore) {
                    /* Take the depth into consideration to give priority to moves that immediately win the game. */
                    bestScore = evalScore + depth;
                    bestMove.setRowCol(currMove.getRow(), currMove.getCol());

                    /* The beta parameter is related to the minimum value. */
                    beta = Math.min(beta, bestScore);

                    /* Prune if the alpha parameter is greater than or equal to the beta parameter. */
                    if (alpha >= beta) {
                        break;
                    }
                }
            }
        }

        Evaluation eval;                    // final move evaluation
        eval = new Evaluation(bestScore, bestMove);

        /* Update and return the latest move evaluation of this agent. */
        setLatestEval(eval);
        return eval;
    }
}
