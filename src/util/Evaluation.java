package util;

/**
 * Class implementing a <b>move evaluation</b> of the agent, consisting of both the move
 * and the numerical evaluation of this move
 *
 * <p>The numerical evaluation is material only if the minimax algorithm is employed
 * (that is, only for levels 2 to 5). Otherwise, the evaluation is always set to 0
 * regardless of the actual optimality of the selected move. </p>
 */
public class Evaluation {
    /* Numerical evaluation of the move */
    private int evalScore;
    /* Move evaluated by the agent */
    private Coordinates coor;

    /**
     * Creates a move evaluation given the move and the agent's numerical evaluation of this move
     *
     * <p>The numerical evaluation is material only if the minimax algorithm is employed
     * (that is, only for levels 2 to 5). Otherwise, the evaluation is always set to 0
     * regardless of the actual optimality of the selected move. </p>
     *
     * @param evalScore numerical evaluation of the move
     * @param coor move evaluated by the agent
     */
    public Evaluation(int evalScore, Coordinates coor) {
        this.evalScore = evalScore;
        this.coor = coor;
    }

    /**
     * Returns the agent's numerical evaluation of the move
     *
     * @return agent's numerical evaluation of the move
     */
    public int getEvalScore() {
        return evalScore;
    }

    /**
     * Returns the move evaluated by the agent
     *
     * @return move evaluated by the agent
     */
    public Coordinates getCoor() {
        return coor;
    }

    /**
     * Returns a string representation of this move evaluation
     *
     * <p>In particular, the string representation contains the following details:</p>
     * <ul>
     *     <li>Numerical evaluation of the move ("Score")</li>
     *     <li>Evaluated move ("Move")</li>
     * </ul>
     *
     * @return string representation of this move evaluation
     */
    @Override
    public String toString() {
        return "Score: " + evalScore + " " + "Move: " + coor.toString() + "\n";
    }
}
