package controller;

import gui.ChooseLevel;
import gui.MainScreen;
import tic_tac_toe.Agent;
import tic_tac_toe.Board;
import tic_tac_toe.GameMaster;
import util.Evaluation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Class providing the <b>controller</b> for the processes related to the <b>main screen</b>
 * of the system (that is, the tic-tac-toe board together with the pertinent details
 * and statistics)
 */
public class MainScreenController implements ActionListener, WindowListener {
    /* Graphical user interface for the main screen */
    private MainScreen scr;
    /* Central class providing access to all the methods necessary to run the system */
    private GameMaster game;

    /* Front-end token of the tic-tac-toe-playing agent */
    private char computerGUIToken;
    /* Front-end token of the human player */
    private char humanGUIToken;

    /* Start time of the human player's decision-making */
    private long humanStartTime;
    /* End time of the human player's decision-making */
    private long humanEndTime;

    /**
     * Creates a controller object with the GUI for the main screen and the game master
     * as parameters
     *
     * @param scr graphical user interface for the main screen
     * @param game game master (providing access to all the methods necessary to run the system)
     */
    public MainScreenController(MainScreen scr, GameMaster game) {
        this.scr = scr;
        this.game = game;

        scr.setVisible(true);
        scr.setActionListener(this);
        scr.setWindowListener(this);

        /* Per the machine project specifications, the first player to move always uses the
        token 'X' and the other player always uses the token 'O'.
         */
        if (game.getIsAgentFirst()) {
            computerGUIToken = 'X';
            humanGUIToken = 'O';

            /* The tic-tac-toe-playing agent makes the first move. */
            moveComputer();
        } else {
            computerGUIToken = 'O';
            humanGUIToken = 'X';
        }

        /* Set the agent description and the headers for the move evaluation on the GUI. */
        switch (game.getIntelligence()) {
            /* Levels 0 and 1 do not perform any move evaluation. */
            case 0:
                scr.setAgentDescription("Level 0: Random");
                scr.updateAgentEvaluation("N/A");
                break;
            case 1:
                scr.setAgentDescription("Level 1: Hard-coded table of moves");
                scr.updateAgentEvaluation("N/A");
                break;
            case 2:
                scr.setAgentDescription("Level 2: Regular minimax (complete adversarial search)");
                scr.updateAgentEvaluation("Computer:\nHuman:");
                break;
            case 3:
                scr.setAgentDescription("Level 3: Regular minimax with alpha-beta pruning");
                scr.updateAgentEvaluation("Computer:\nHuman:");
                break;
            case 4:
                scr.setAgentDescription("Level 4: Depth-sensitive minimax (complete adversarial search)");
                scr.updateAgentEvaluation("Computer:\nHuman:");
                break;
            case 5:
                scr.setAgentDescription("Level 5: Depth-sensitive minimax with alpha-beta pruning");
                scr.updateAgentEvaluation("Computer:\nHuman:");
                break;
        }
    }

    /**
     * Invoked when the user attempts to close the window from the window's system menu
     *
     * @param e window event indicative of a change in status
     */
    @Override
    public void windowClosing(WindowEvent e) {
        int confirm;            // response to the confirmation dialog
        confirm = JOptionPane.showConfirmDialog(scr, "Are you sure you want to exit?",
                "Quit", JOptionPane.YES_NO_OPTION);

        /* Exit system only if user response is affirmative. */
        switch(confirm) {
            case JOptionPane.YES_OPTION:
                scr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                break;
            case JOptionPane.NO_OPTION:
                scr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                break;
        }
    }

    /**
     * Invoked when the window is set to be the active window
     *
     * @param e window event indicative of a change in status
     */
    @Override
    public void windowActivated(WindowEvent e) {

    }

    /**
     * Invoked when a window has been closed as the result of calling dispose on the window
     *
     * @param e window event indicative of a change in status
     */
    @Override
    public void windowClosed(WindowEvent e) {

    }

    /**
     * Invoked when a window is no longer the active window
     *
     * @param e window event indicative of a change in status
     */
    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    /**
     * Invoked when a window is changed from a minimized to a normal state
     *
     * @param e window event indicative of a change in status
     */
    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    /**
     * Invoked when a window is changed from a normal to a minimized state
     *
     * @param e window event indicative of a change in status
     */
    @Override
    public void windowIconified(WindowEvent e) {

    }

    /**
     * Invoked when a window is made visible
     *
     * @param e window event indicative of a change in status
     */
    @Override
    public void windowOpened(WindowEvent e) {

    }

    /**
     * Invoked when an action occurs
     *
     * @param e semantic event indicative that a component-defined action occurred
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand;       // command associated with the button pressed
        actionCommand = e.getActionCommand();

        if (actionCommand.equals("Play Again")) {
            /* Play a new game, reverting the board and evaluation back to their initial
            states but retaining the match statistics.
             */
            newGame();

        } else if (actionCommand.equals("New Level")) {
            /* Close the current main screen. */
            scr.setVisible(false);

            /* Display the screen for the selection of the intelligence level of the agent,
            create a new game master for this new level, and activate the controller.
             */
            GameMaster g;
            ChooseLevel scr;
            ChooseLevelController ctrl;

            g = new GameMaster();
            scr = new ChooseLevel();
            ctrl = new ChooseLevelController(scr, g);

        } else {
            /* Since the human player has clicked on a tile, stop the timer recording his/her
            decision time.
             */
            humanEndTime = System.nanoTime();

            int row;        // row-coordinate of the human player's move
            int col;        // column-coordinate of the human player's move

            /* The last and second-to-the-last characters of the associated action command
            pertains to the column- and row-coordinates, respectively.
             */
            row = Character.getNumericValue(actionCommand.charAt(5));
            col = Character.getNumericValue(actionCommand.charAt(6));

            /* Update the board state (both back- and front-ends). */
            moveHuman(row, col);

            /* If the game remains inconclusive, then it is the computer's turn to move. */
            if (!game.isGameOver()) {
                moveComputer();
            } else {
                /* Update the front-end evaluation to reflect that a drawn configuration
                has been reached (only for levels 4 and 5 since they show the number of moves
                towards the terminal state assuming perfect play).
                 */
                if (game.getIntelligence() == 4 || game.getIntelligence() == 5) {
                    if (game.isGameDraw()) {
                        scr.updateAgentEvaluation("Computer: 0 (Draw in 0 moves)\nHuman: 0");
                    }
                }

                /* Disable the selection of any tile until the player decides to have a new game. */
                scr.disableBoard();
                /* Update the match statistics. */
                updateMatchStats();
            }
        }
    }

    /**
     * Handles both front- and back-end processes related to a move by the human player
     *
     * @param row row-coordinate of the human player's move
     * @param col column-coordinate of the human player's move
     */
    public void moveHuman(int row, int col) {
        double evalTime;            // decision time of the human player

        /* Divide by 1e6 to convert nanoseconds to milliseconds. */
        evalTime = (humanEndTime - humanStartTime) / 1e6;

        /* Handle the back-end processes. */
        game.makeMove(row, col, Board.HUMAN_TOKEN);

        /* Handle the front-end updates. */
        scr.makeMove(row, col, humanGUIToken);
        scr.updateHumanTime(row, col, evalTime);
    }

    /**
     * Handles both front- and back-end processes related to a move by the tic-tac-toe-playing agent
     */
    public void moveComputer() {
        Evaluation bestMove;        // move evaluation by the tic-tac-toe-playing agent

        long startTime;             // start time of the agent's decision-making
        long stopTime;              // end time of the agent's decision-making
        double evalTime;            // decision time of the agent

        /* Measure the time taken by the agent to decide its next move. */
        startTime = System.nanoTime();
        bestMove = game.evalBestMove();
        stopTime = System.nanoTime();

        /* Divide by 1e6 to convert nanoseconds to milliseconds. */
        evalTime = (stopTime - startTime) / 1e6;

        /* Handle the back-end processes. */
        game.makeMove(bestMove.getCoor().getRow(), bestMove.getCoor().getCol(), Board.COMPUTER_TOKEN);

        /* Handle the front-end updates. */
        scr.makeMove(bestMove.getCoor().getRow(), bestMove.getCoor().getCol(), computerGUIToken);
        scr.updateAgentTime(bestMove.getCoor().getRow(), bestMove.getCoor().getCol(), evalTime);

        /* Update the most recent move evaluation (only for levels 2 to 5).

        Additionally, for levels 4 to 5, the number of moves towards the terminal state (assuming
        perfect play) is displayed.
         */
        switch (game.getIntelligence()) {
            case 2:
            case 3:
                displayNumEval(bestMove);
                break;
            case 4:
            case 5:
                displayNumEvalWithMoves(bestMove);
                break;
        }

        if (game.isGameOver()) {
            /* Disable the selection of any tile until the player decides to have a new game. */
            scr.disableBoard();
            /* Update the match statistics. */
            updateMatchStats();
        } else {
            /* Start the timer recording the decision time of the human player. */
            humanStartTime = System.nanoTime();
        }
    }

    /**
     * Displays the agent's numerical evaluation of the move it selected as its next move
     * (for levels 2 to 3)
     *
     * @param bestMove move that the agent selected as its next move
     */
    public void displayNumEval(Evaluation bestMove) {
        String ai;          // evaluation for the tic-tac-toe-playing agent
        String human;       // evaluation for the human player

        /* The sum of the numerical evaluations for both players should always be equal to 0
        (note that tic-tac-toe is a zero-sum game).
         */
        ai = "Computer: " + bestMove.getEvalScore() + "\n";
        human = "Human: " + (-bestMove.getEvalScore()) + "\n";

        /* Update the GUI display. */
        scr.updateAgentEvaluation(ai + human);
    }

    /**
     * Displays the agent's numerical evaluation of the move it selected as its next move,
     * alongside the number of moves towards the terminal state, assuming perfect play
     * (for levels 4 to 5)
     *
     * @param bestMove move that the agent selected as its next move
     */
    public void displayNumEvalWithMoves(Evaluation bestMove) {
        String ai;          // evaluation for the tic-tac-toe-playing agent
        String human;       // evaluation for the human player
        String moves;       // terminal state and the number of moves to reach it (assuming perfect play)

        int aiEval;         // normalized numerical evaluation of the agent
        int numMoves;       // number of moves to reach the terminal state (assuming perfect play)

        aiEval = bestMove.getEvalScore();

        /* Since levels 4 to 5 use a depth-sensitive minimax algorithm, the numerical evaluation
        displayed has to be adjusted to conform to the conventional 100 (in favor of the agent),
        -100 (in favor of the human player), and 0 (draw).

        The scheme used in the adjustment is a consequence of the depth-sensitive strategy
        explained in the documentation of AgentLevel4 and AgentLevel5. Technical details
        are supplied in the problem formulation report accompanying this source code.
         */
        if (aiEval <= Agent.LOSS_UTIL) {
            /* Theoretically, the agent is incapable of losing since the implementation of the
            minimax algorithm in this system avoids the horizon effect by not enforcing
            any depth cutoff.
             */
            numMoves = Math.abs(Agent.LOSS_UTIL - aiEval);
            aiEval = Agent.LOSS_UTIL;

            /* For a grammatically correct GUI display */
            if (numMoves == 1) {
                moves = "(Loss in \u2264" + numMoves + " move)";
            } else {
                moves = "(Loss in \u2264" + numMoves + " moves)";
            }

        } else if (Agent.WIN_UTIL - Board.DIMENSION * Board.DIMENSION <= aiEval
                && aiEval <= Agent.WIN_UTIL) {
            /* The condition above takes advantage of the fact a terminal state can be reached
            in at most 4 moves. In the interest of a more robust implementation, the margin
            in this condition is widened to 9 (the maximum depth of the game tree).
             */
            numMoves = Math.abs(Agent.WIN_UTIL - aiEval);
            aiEval = Agent.WIN_UTIL;

            /* For a grammatically correct GUI display */
            if (numMoves == 1) {
                moves = "(Win in \u2264" + numMoves + " move)";
            } else {
                moves = "(Win in \u2264" + numMoves + " moves)";
            }
        } else {
            numMoves = Math.abs(Agent.DRAW_UTIL - aiEval);
            aiEval = Agent.DRAW_UTIL;

            /* For a grammatically correct GUI display */
            if (numMoves == 1) {
                moves = "(Draw in \u2264" + numMoves + " move)";
            } else {
                moves = "(Draw in \u2264" + numMoves + " moves)";
            }
        }

        /* The sum of the numerical evaluations for both players should always be equal to 0
        (note that tic-tac-toe is a zero-sum game).
         */
        ai = "Computer: " + aiEval + " " + moves + "\n";
        human = "Human: " + (-aiEval) + "\n";

        /* Update the GUI display. */
        scr.updateAgentEvaluation(ai + human);
    }

    /**
     * Updates the match statistics (number of wins for the agent and the human player, as well as
     * the number of draws) at the conclusion of every game
     */
    public void updateMatchStats() {
        /* Handle the back-end updates. */
        if (game.isAgentWin()) {
            game.recordWin(Board.COMPUTER_TOKEN);
        } else if (game.isHumanWin()) {
            game.recordWin(Board.HUMAN_TOKEN);
        } else {
            game.recordDraw();
        }

        /* Handle the front-end updates. */
        scr.updateWins(game.getNumAgentWins(), game.getNumHumanWins(), game.getNumDraws());
    }

    /**
     * Initializes a new game by reverting the board and the move evaluation back to their initial
     * states but retaining the match statistics
     */
    public void newGame() {
        /* Handle the back-end processes. */
        game.clearBoard();

        /* Handle the front-end updates. */
        scr.reset(game.getIntelligence());
        scr.enableBoard();

        /* Alternate which player receives the first-move advantage. */
        if (game.getIsAgentFirst()) {
            /* The human player receives the first-move advantage in this new game. */
            game.setIsAgentFirst(false);

            computerGUIToken = 'O';
            humanGUIToken = 'X';
        } else {
            /* The tic-tac-toe-playing agent receives the first-move advantage in this new game. */
            game.setIsAgentFirst(true);

            computerGUIToken = 'X';
            humanGUIToken = 'O';

            moveComputer();
        }
    }
}
