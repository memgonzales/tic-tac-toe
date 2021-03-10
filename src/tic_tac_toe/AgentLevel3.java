package tic_tac_toe;

import util.Coordinates;
import util.Evaluation;

import java.util.ArrayList;

/**
 * Class implementing <b>level 3 of the tic-tac-toe-playing agent</b>, which employs
 * the <b>regular minimax algorithm</b> (a depth-first search strategy for adversarial
 * games) and features a reduced search space resulting from <b>alpha-beta pruning</b>
 *
 * <p>A technical description and analysis of this agent is given in the problem formulation
 * report accompanying the source code.</p>
 */
public class AgentLevel3 extends Agent {
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
     * Creates the level 3 of the tic-tac-toe-playing agent, which employs the regular minimax algorithm
     * and features a reduced search space resulting from alpha-beta pruning
     */
    public AgentLevel3() {
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
     * Returns a move evaluation following the minimax algorithm for adversarial, two-player,
     * zero-sum games with alpha-beta pruning
     *
     * <p>This level follows the standard minimax implementation. The utility values of each
     * leaf nodes are as follows: 100 for a win, -100 for a loss, and 0 for a draw. The minimax
     * values are then backed up the game tree via recursion. In order to reduce the number of
     * nodes that have to be generated and evaluated, alpha-beta pruning is employed. </p>
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
                    bestScore = evalScore;
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
                    bestScore = evalScore;
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
