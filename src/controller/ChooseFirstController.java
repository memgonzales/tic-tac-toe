package controller;

import gui.ChooseFirst;
import gui.MainScreen;
import tic_tac_toe.GameMaster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class providing the <b>controller</b> for the processes related to the <b>selection
 * of the first player to move</b>
 */
public class ChooseFirstController implements ActionListener {
    /* Graphical user interface for the selection of the first player to move */
    private ChooseFirst scr;
    /* Central class providing access to all the methods necessary to run the system */
    private GameMaster game;

    /**
     * Creates a controller object with the GUI for the selection of the first player to move
     * and the game master as parameters
     *
     * @param scr graphical user interface for the selection of the first player to move
     * @param game game master (providing access to all the methods necessary to run the system)
     */
    public ChooseFirstController(ChooseFirst scr, GameMaster game) {
        this.scr = scr;
        this.game = game;

        scr.setVisible(true);
        scr.setActionListener(this);
    }

    /**
     * Invoked when an action occurs
     *
     * @param e semantic event indicative that a component-defined action occurred
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        /* The first player to move can either be the human ["Player"] or the tic-tac-toe-playing
        agent ["AI (Computer)"].
         */
        if (e.getActionCommand().equals("Player")) {
            game.setIsAgentFirst(false);
            scr.setVisible(false);

            /* Launch the main screen (tic-tac-toe game per se). */
            MainScreen mainScr;
            MainScreenController ctrl;

            mainScr = new MainScreen();
            ctrl = new MainScreenController(mainScr, game);

        } else if (e.getActionCommand().equals("AI (Computer)")) {
            game.setIsAgentFirst(true);
            scr.setVisible(false);

            /* Launch the main screen (tic-tac-toe game per se). */
            MainScreen mainScr;
            MainScreenController ctrl;

            mainScr = new MainScreen();
            ctrl = new MainScreenController(mainScr, game);
        }
    }
}
