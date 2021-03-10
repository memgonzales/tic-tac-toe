package controller;

import gui.ChooseFirst;
import gui.ChooseLevel;
import tic_tac_toe.GameMaster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class providing the <b>controller</b> for the processes related to the <b>selection
 * of the intelligence level</b> of the tic-tac-toe-playing agent
 */
public class ChooseLevelController implements ActionListener {
    /* Graphical user interface for the selection of the intelligence level of the agent */
    private ChooseLevel scr;
    /* Central class providing access to all the methods necessary to run the system */
    private GameMaster game;

    /**
     * Creates a controller object with the GUI for the selection of the intelligence level
     * of the agent and the game master as parameters
     *
     * @param scr graphical user interface for the selection of the intelligence level of the agent
     * @param game game master (providing access to all the methods necessary to run the system)
     */
    public ChooseLevelController(ChooseLevel scr, GameMaster game) {
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
        /* There are 6 levels of intelligence (numbered from 0 to 5), with the rationality
        of the tic-tac-toe-playing agent increasing commensurate with the level number.
         */
        if (e.getActionCommand().equals("Level 0")) {
            game.setAgent(0);
            scr.setVisible(false);

            /* Launch the screen for the selection of the first player to move. */
            ChooseFirst chooseScr;
            ChooseFirstController ctrl;

            chooseScr = new ChooseFirst();
            ctrl = new ChooseFirstController(chooseScr, game);

        } else if (e.getActionCommand().equals("Level 1")) {
            game.setAgent(1);
            scr.setVisible(false);

            /* Launch the screen for the selection of the first player to move. */
            ChooseFirst chooseScr;
            ChooseFirstController ctrl;

            chooseScr = new ChooseFirst();
            ctrl = new ChooseFirstController(chooseScr, game);

        } else if (e.getActionCommand().equals("Level 2")) {
            game.setAgent(2);
            scr.setVisible(false);

            /* Launch the screen for the selection of the first player to move. */
            ChooseFirst chooseScr;
            ChooseFirstController ctrl;

            chooseScr = new ChooseFirst();
            ctrl = new ChooseFirstController(chooseScr, game);

        } else if (e.getActionCommand().equals("Level 3")) {
            game.setAgent(3);
            scr.setVisible(false);

            /* Launch the screen for the selection of the first player to move. */
            ChooseFirst chooseScr;
            ChooseFirstController ctrl;

            chooseScr = new ChooseFirst();
            ctrl = new ChooseFirstController(chooseScr, game);

        } else if (e.getActionCommand().equals("Level 4")) {
            game.setAgent(4);
            scr.setVisible(false);

            /* Launch the screen for the selection of the first player to move. */
            ChooseFirst chooseScr;
            ChooseFirstController ctrl;

            chooseScr = new ChooseFirst();
            ctrl = new ChooseFirstController(chooseScr, game);

        } else if (e.getActionCommand().equals("Level 5")) {
            game.setAgent(5);
            scr.setVisible(false);

            /* Launch the screen for the selection of the first player to move. */
            ChooseFirst chooseScr;
            ChooseFirstController ctrl;

            chooseScr = new ChooseFirst();
            ctrl = new ChooseFirstController(chooseScr, game);
        }
    }
}
