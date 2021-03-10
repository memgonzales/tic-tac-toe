package tic_tac_toe;

import util.Coordinates;
import util.Evaluation;

import java.util.ArrayList;

/**
 * Class implementing <b>level 1 of the tic-tac-toe-playing agent</b>, which uses a
 * <b>hard-coded set of conditions</b> to choose the best move for the agent
 *
 * <p>A technical description and analysis of this agent is given in the problem formulation
 * report accompanying the source code.</p>
 */
public class AgentLevel1 extends Agent {

    /**
     * Creates the level 1 of the tic-tac-toe-playing agent, which which uses a
     * hard-coded set of conditions to choose the best move for the agent
     */
    public AgentLevel1() {
        super();
    }

    /**
     * Returns the best move given the current board state, alongside this agent's numerical
     * evaluation of this move (set to a sentinel value of 0 for level 1, as no heuristics
     * or search algorithms were used)
     *
     * @param b current board state
     * @return best move, alongside this agent's numerical evaluation of this move
     */
    @Override
    public Evaluation evalBestMove(Board b) {
        Coordinates bestMove;                   // best move of the agent
        ArrayList<Coordinates> occupiedX;       // list of positions occupied by the agent
        ArrayList<Coordinates> occupiedO;       // list of positions occupied by the player
        ArrayList<Coordinates> possibleMoves;   // list of possible moves

        /* The pertinent lists of positions are retrieved from the board */
        occupiedX = b.getOccupiedC();
        occupiedO = b.getOccupiedH();
        possibleMoves = b.getPossibleMoves();

        /* If the game has been completed, the sentinel coordinates (-1,-1) are set as
        the agent's move.
        */
        if (b.isGameOver()) {
            bestMove = new Coordinates(-1, -1);
        } else if (b.isEmpty()) {
        /* If the board is empty (signifying that the agent is the first player), the
        best move is a corner move; for this implementation, the agent always takes
        the position (0,0).
        */
            bestMove = new Coordinates(0, 0);
        } else {
        /* Otherwise, the agent evaluates the best move based on the current state of
        the board.

        First, the agent checks whether it has any positions that could lead to a win
        (i.e., three-in-a-lane), and takes the remaining position if available.
        */
            if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(1, 0)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(0, 1)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(2, 0);

            /* Next, the agent checks whether the opponent has sets of positions
            that can lead to a win in order to block them.
            */
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(1, 0)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(0, 1)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(2, 0);

            /* If the opponent has taken positions on opposite corners of the board,
            they may create an unblockable fork position during their next turn. Hence,
            before their next turn, the square beside one of these corner positions must
            be blocked.
            */
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(0, 1);

            /* The agent then checks whether it can create any fork positions, and
            if possible, completes the position.

            The following lines check for isomorphisms of the following fork type:
               X_X
               ___
               __X    */
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(2, 2);

            /* The following lines check for isomorphisms of the following fork type:
               XX_
               X__
               ___    */
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(1, 0)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(1, 0)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(0, 1)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(0, 1)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(1, 0)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(1, 0)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(1, 2);

            /* The following lines check for isomorphisms of the following fork type:
               X_X
               X__
               ___    */
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(1, 0)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(1, 0)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(1, 0)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(1, 0)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(0, 1)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(0, 1)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(2, 1);

            /* The following lines check for isomorphisms of the following fork type:
               X__
               X__
               __X    */
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(1, 0)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(1, 0)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(0, 1)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(2, 0);

            /* The following lines check for isomorphisms of the following fork type:
               X_X
               _X_
               ___    */
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(2, 2);

            /* The following lines check for isomorphisms of the following fork type:
               _X_
               _X_
               __X    */
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedX.contains(new Coordinates(0, 1)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedX.contains(new Coordinates(0, 2)) &&
                    occupiedX.contains(new Coordinates(1, 0)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedX.contains(new Coordinates(0, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(1, 2)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedX.contains(new Coordinates(1, 1)) &&
                    occupiedX.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(2, 0);

            /* The agent then checks whether the player can create any fork positions,
            and if possible, blocks the position.

            The following lines check for isomorphisms of the following fork type:
               X_X
               ___
               __X    */
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(2, 2);

           /* The following lines check for isomorphisms of the following fork type:
               XX_
               X__
               ___    */
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(1, 0)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(1, 0)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(0, 1)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(0, 1)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(1, 0)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(1, 0)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(1, 2);

            /* The following lines check for isomorphisms of the following fork type:
               X_X
               X__
               ___    */
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(1, 0)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(1, 0)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(1, 0)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(1, 0)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(0, 1)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(0, 1)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(2, 1);

            /* The following lines check for isomorphisms of the following fork type:
               X__
               X__
               __X    */
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(1, 0)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(1, 0)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(0, 1)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(2, 0);

            /* The following lines check for isomorphisms of the following fork type:
               X_X
               _X_
               ___    */
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(2, 2);

            /* The following lines check for isomorphisms of the following fork type:
               _X_
               _X_
               __X    */
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 1)) &&
                    occupiedO.contains(new Coordinates(0, 1)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 1)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(2, 1);
            else if (possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)) &&
                    occupiedO.contains(new Coordinates(0, 2)) &&
                    occupiedO.contains(new Coordinates(1, 0)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)) &&
                    occupiedO.contains(new Coordinates(0, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(1, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(2, 2);
            else if (possibleMoves.contains(new Coordinates(1, 1)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(1, 2)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(1, 1);
            else if (possibleMoves.contains(new Coordinates(1, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(1, 0)) &&
                    occupiedO.contains(new Coordinates(1, 1)) &&
                    occupiedO.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(2, 0);

            /* The agent takes the center position if it has not yet been
            occupied.
            */
            else if (possibleMoves.contains(new Coordinates(1, 1)))
                bestMove = new Coordinates(1, 1);

            /* The agent takes a corner opposite to one occupied by the player
            if the position has not yet been occupied.
            */
            else if (occupiedO.contains(new Coordinates(0, 0)) &&
                    possibleMoves.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 2);
            else if (occupiedO.contains(new Coordinates(2, 2)) &&
                    possibleMoves.contains(new Coordinates(0, 0)))
                bestMove = new Coordinates(0, 0);
            else if (occupiedO.contains(new Coordinates(0, 2)) &&
                    possibleMoves.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(2, 0);
            else if (occupiedO.contains(new Coordinates(2, 0)) &&
                    possibleMoves.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(0, 2);

            /* The agent takes an empty corner position. */
            else if (possibleMoves.contains(new Coordinates(0, 0)))
                bestMove = new Coordinates(0, 0);
            else if (possibleMoves.contains(new Coordinates(0, 2)))
                bestMove = new Coordinates(0, 2);
            else if (possibleMoves.contains(new Coordinates(2, 0)))
                bestMove = new Coordinates(2, 0);
            else if (possibleMoves.contains(new Coordinates(2, 2)))
                bestMove = new Coordinates(2, 2);

            /* The agent takes an empty side position. */
            else if (possibleMoves.contains(new Coordinates(0, 1)))
                bestMove = new Coordinates(0, 1);
            else if (possibleMoves.contains(new Coordinates(1, 0)))
                bestMove = new Coordinates(1, 0);
            else if (possibleMoves.contains(new Coordinates(1, 2)))
                bestMove = new Coordinates(1, 2);
            else if (possibleMoves.contains(new Coordinates(2, 1)))
                bestMove = new Coordinates(2, 1);

            /* As a catch-all, if none of the above conditional statements were
            satisfied, the agent chooses the first move from the list of possible
            moves.
            */
            else
                bestMove = possibleMoves.get(0);
        }

        /* As a secondary precaution, in case the assigned best move is already
        occupied (and is thus not in the list of possible moves), the agent chooses
        the first move from the remaining possible moves.
        */
        if (!possibleMoves.contains(bestMove))
            bestMove = possibleMoves.get(0);

        Evaluation eval;        // final move evaluation
        eval = new Evaluation(0, bestMove);

        /* Update and return the latest move evaluation of this agent. */
        setLatestEval(eval);
        return eval;
    }
}
