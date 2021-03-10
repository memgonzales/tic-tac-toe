import controller.ChooseLevelController;
import gui.ChooseLevel;
import tic_tac_toe.GameMaster;

/**
 * Class for activating the <b>tic-tac-toe</b> game, which features six levels
 * of gameplay against an intelligent system
 */
public class TicTacToe {
    /**
     * Empty constructor
     */
    public TicTacToe() {

    }

    /**
     * Activates the tic-tac-toe game
     *
     * @param args array of command-line arguments
     */
    public static void main(String[] args) {
        GameMaster g;
        ChooseLevel scr;
        ChooseLevelController ctrl;

        g = new GameMaster();
        scr = new ChooseLevel();
        ctrl = new ChooseLevelController(scr, g);
    }
}
