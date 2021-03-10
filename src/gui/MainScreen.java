package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;

/**
 * Class implementing the <b>main window</b> of the system, displaying the tic tac toe board
 * alongside some details regarding the game (such as the description of the intelligence
 * level, the decision time of the agent, the move sequence of the agent and player, and the
 * number of wins and draws of both parties)
 */
public class MainScreen extends JFrame {
    /* Graphical components related to the tic tac toe board */
    private JPanel pBoard;
    private JPanel[][] pSquares;
    private JButton[][] btnSquares;

    /* Panel holding the buttons on the side panel of the window */
    private JPanel pButtons;

    /* Graphical components related to the side panel displays */
    private JLabel lblInfo;
    private JTextArea taInfo;
    private JLabel lblEvaluation;
    private JTextArea taEvaluation;
    private JLabel lblTime;
    private JTextArea taTime;
    private JScrollPane scrTime;
    private JLabel lblWinsAndTurn;
    private JTextArea taWinsAndTurn;

    /* Button for playing a new game */
    private JButton btnNextGame;

    /* Button for changing the agent's intelligence level */
    private JButton btnNextLevel;

    /* Lists of labels holding the board icons */
    private ArrayList<JLabel> ex;
    private ArrayList<JLabel> oh;
    private ArrayList<JLabel> blank;

    /**
     * Creates the main window of the system, displaying the tic tac toe board
     * alongside some details regarding the game
     */
    public MainScreen() {

        /* "Tic Tac Toe" is used as window title */
        super("Tic Tac Toe");

        /* Use Border layout */
        setLayout(new BorderLayout());

        /* init() is called to initialize the elements of the window */
        init();

        /* Additional formatting methods for the window are executed */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 550);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    /**
     * Initializes the elements comprising this window
     */
    private void init () {
        JPanel pCenter;         // panel holding the board
        JPanel pRight;          // panel holding the game details and the PLAY AGAIN and NEW LEVEL buttons
        JPanel pTextAreas;      // panel holding the text fields for the game details
        JPanel pInfoLbl;        // panel holding the label for the agent information
        JPanel pEvaluationLbl;  // panel holding the label for the agent evaluation
        JPanel pTimeLbl;        // panel holding the label for the move log and decision time
        JPanel pWinsAndTurnLbl; // panel holding the label for the match statistics

        /* The center panel is created with the Box layout */
        pCenter = new JPanel();
        pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.X_AXIS));

        /* The pBoard panel is created with the GridBag layout */
        pBoard = new JPanel();
        pBoard.setLayout(new GridBagLayout());
        pBoard.setBackground(new Color(142, 229, 238));

        /* initBoard() is called to initialize the elements of the board representation;
        pBoard is then added to pCenter
        */
        initBoard();
        pCenter.add(pBoard);

        /* The right panel is created with the Border layout */
        pRight = new JPanel();
        pRight.setLayout(new BorderLayout());

        /* The pTextAreas panel is created with the Box layout */
        pTextAreas = new JPanel();
        pTextAreas.setLayout(new BoxLayout(pTextAreas, BoxLayout.Y_AXIS));

        /* A label for the agent behavior information is formatted, added to the pInfoLbl panel,
        and added to the pTextAreas panel
        */
        lblInfo = new JLabel("Agent Behavior Information");
        lblInfo.setBorder(new EmptyBorder(5, 10, 0, 10));
        pInfoLbl = new JPanel();
        pInfoLbl.setLayout(new FlowLayout(FlowLayout.LEFT));
        pInfoLbl.add(lblInfo);
        pTextAreas.add(pInfoLbl);

        /* A text field for storing the agent behavior information is formatted and added to
        the pTextAreas panel
        */
        taInfo = new JTextArea();
        taInfo.setEditable(false);
        taInfo.setLineWrap(true);
        taInfo.setWrapStyleWord(true);
        taInfo.setBorder(new EmptyBorder(10, 10, 10, 10));
        taInfo.setPreferredSize(new Dimension(200, 50));
        pTextAreas.add(taInfo);

        /* A label for the agent evaluation is formatted, added to the pEvaluationLbl panel,
        and added to the pTextAreas panel
        */
        lblEvaluation = new JLabel("Agent Evaluation");
        lblEvaluation.setBorder(new EmptyBorder(5, 10, 0, 10));
        pEvaluationLbl = new JPanel();
        pEvaluationLbl.setLayout(new FlowLayout(FlowLayout.LEFT));
        pEvaluationLbl.add(lblEvaluation);
        pTextAreas.add(pEvaluationLbl);

        /* A text field for storing the agent evaluation is formatted and added to
        the pTextAreas panel
        */
        taEvaluation = new JTextArea();
        taEvaluation.setEditable(false);
        taEvaluation.setLineWrap(true);
        taEvaluation.setWrapStyleWord(true);
        taEvaluation.setBorder(new EmptyBorder(10, 10, 10, 10));
        taEvaluation.setPreferredSize(new Dimension(200, 50));
        pTextAreas.add(taEvaluation);

        /* A label for the move log and decision time is formatted, added to the pTimeLbl panel,
        and added to the pTextAreas panel
        */
        lblTime = new JLabel("Move Log & Decision Time (ms)");
        lblTime.setBorder(new EmptyBorder(5, 10, 0, 10));
        pTimeLbl = new JPanel();
        pTimeLbl.setLayout(new FlowLayout(FlowLayout.LEFT));
        pTimeLbl.add(lblTime);
        pTextAreas.add(pTimeLbl);

        /* A text field for storing the move log and decision time is formatted,
        added to a scroll pane, and added to the pTextAreas panel
        */
        taTime = new JTextArea();
        taTime.setEditable(false);
        taTime.setLineWrap(true);
        taTime.setWrapStyleWord(true);
        taTime.setBorder(new EmptyBorder(10, 10, 10, 10));
        scrTime = new JScrollPane(taTime);
        scrTime.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrTime.setPreferredSize(new Dimension(200, 150));
        pTextAreas.add(scrTime);

        /* A label for the match statistics is formatted, added to the pWinsAndTurnLbl panel,
        and added to the pTextAreas panel
        */
        lblWinsAndTurn = new JLabel("Match Statistics");
        lblWinsAndTurn.setBorder(new EmptyBorder(5, 10, 0, 10));
        pWinsAndTurnLbl = new JPanel();
        pWinsAndTurnLbl.setLayout(new FlowLayout(FlowLayout.LEFT));
        pWinsAndTurnLbl.add(lblWinsAndTurn);
        pTextAreas.add(pWinsAndTurnLbl);

        /* A text field for storing the match statistics is formatted
        and added to the pTextAreas panel
        */
        taWinsAndTurn = new JTextArea();
        taWinsAndTurn.setEditable(false);
        taWinsAndTurn.setLineWrap(true);
        taWinsAndTurn.setWrapStyleWord(true);
        taWinsAndTurn.setBorder(new EmptyBorder(10, 10, 10, 10));
        taWinsAndTurn.setPreferredSize(new Dimension(200, 75));
        pTextAreas.add(taWinsAndTurn);

        /* The pTextAreas panel is added to the right panel */
        pRight.add(pTextAreas, BorderLayout.CENTER);

        /* The pButtons panel is instantiated and added to the right panel */
        pButtons = new JPanel();
        pButtons.setLayout(new GridLayout(1, 2));
        pRight.add(pButtons, BorderLayout.SOUTH);

        /* The PLAY AGAIN button is added to pButtons */
        btnNextGame = new JButton("Play Again");
        pButtons.add(btnNextGame);

        /* The NEW LEVEL button is added to pButtons */
        btnNextLevel = new JButton("New Level");
        pButtons.add(btnNextLevel);

        /* The center and right panels are positioned on the Border layout of the window */
        add(pCenter, BorderLayout.CENTER);
        add(pRight, BorderLayout.EAST);
    }

    /**
     * Initializes the elements comprising the board
     */
    private void initBoard() {
        GridBagConstraints c; // GridBagConstraints object used to construct the board grid
        Dimension d;          // Dimension object storing the dimensions of each grid tile

        /* The lists holding the X, O, and blank images are instantiated */
        ex = new ArrayList<>();
        oh = new ArrayList<>();
        blank = new ArrayList<>();

        /* Counter variables for creating and formatting the board spaces */
        int i, j;

        /* The GridBagConstraints and Dimension objects are instantiated */
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        d = new Dimension (200, 200);

        /* The pSpaces panel for storing the board grid is instantiated */
        pSquares = new JPanel[3][3];
        btnSquares = new JButton[3][3];

        /* A two-dimensional array of panels is formatted and added to the pSpaces panel, corresponding
        to the size of the board
        */
        for (i = 0; i < pSquares.length; i++) {
            for (j = 0; j < pSquares[i].length; j++) {
                pSquares[i][j] = new JPanel(new BorderLayout());
                pSquares[i][j].setPreferredSize(d);
                pSquares[i][j].setBackground(new Color(1, 1, 1, 1));

                if (i == 0) {
                    if (j == 0) {
                        pSquares[i][j].setBorder(BorderFactory.createMatteBorder(6, 6, 3, 3, new Color(139, 0, 139)));
                    } else if (j == pSquares[i].length - 1) {
                        pSquares[i][j].setBorder(BorderFactory.createMatteBorder(6, 3, 3, 6, new Color(139, 0, 139)));
                    } else {
                        pSquares[i][j].setBorder(BorderFactory.createMatteBorder(6, 3, 3, 3, new Color(139, 0, 139)));
                    }
                } else if (i == pSquares.length - 1) {
                    if (j == 0) {
                        pSquares[i][j].setBorder(BorderFactory.createMatteBorder(3, 6, 6, 3, new Color(139, 0, 139)));
                    } else if (j == pSquares[i].length - 1) {
                        pSquares[i][j].setBorder(BorderFactory.createMatteBorder(3, 3, 6, 6, new Color(139, 0, 139)));
                    } else {
                        pSquares[i][j].setBorder(BorderFactory.createMatteBorder(3, 3, 6, 3, new Color(139, 0, 139)));
                    }
                } else {
                    if (j == 0) {
                        pSquares[i][j].setBorder(BorderFactory.createMatteBorder(3, 6, 3, 3, new Color(139, 0, 139)));
                    } else if (j == pSquares[i].length - 1) {
                        pSquares[i][j].setBorder(BorderFactory.createMatteBorder(3, 3, 3, 6, new Color(139, 0, 139)));
                    } else {
                        pSquares[i][j].setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(139, 0, 139)));
                    }
                }

                /* A PLACE button is added under each grid tile */
                btnSquares[i][j] = new JButton("Place");
                btnSquares[i][j].setActionCommand("Place" + i + j);

                pSquares[i][j].add(btnSquares[i][j], BorderLayout.SOUTH);
                pBoard.add(pSquares[i][j], c);

                c.gridx = c.gridx + 1;
            }

            c.gridx = 0;
            c.gridy = c.gridy + 1;
        }

        /* Nine instances of the X image are added to its corresponding list */
        for (i = 0; i < 9; i++) {
            ex.add(setImage("assets/x.png"));
        }

        /* Nine instances of the O image are added to its corresponding list */
        for (i = 0; i < 9; i++) {
            oh.add(setImage("assets/o.png"));
        }

        /* Nine instances of the blank image are added to its corresponding list */
        for (i = 0; i < 9; i++) {
            blank.add(setImage("assets/blank.png"));
        }

        /* The board is instantiated using the list of blank images */
        int k = 0;

        for (i = 0; i < pSquares.length; i++) {
            for (j = 0; j < pSquares[i].length; j++) {
                pSquares[i][j].add(blank.get(k), BorderLayout.CENTER);
                k++;
            }
        }
    }

    /**
     * Returns a scaled version of an image given its path
     *
     * @param imagePath path to the image to be scaled
     * @return scaled version of the image
     */
    private JLabel setImage (String imagePath) {
        /* Stores the original image */
        ImageIcon imageOrig;
        /* Stores a scaled version of the image */
        Image imageScaled;
        /* Stores a formatted version of the image to be displayed on the window */
        JLabel lblImage;

        /* The original image is retrieved and scaled */
        imageOrig = new ImageIcon(getClass().getResource(imagePath));
        imageScaled = imageOrig.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);

        /* The scaled image is converted to a JLabel, further formatted, and returned */
        lblImage = new JLabel(new ImageIcon(imageScaled));
        lblImage.setBackground(Color.white);
        lblImage.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        lblImage.setBorder(new EmptyBorder(1, 1, 1, 1));
        return lblImage;
    }

    /**
     * Enables or disables the button corresponding to one of the positions on the board
     *
     * @param row row index of the button
     * @param col column index of the button
     * @param isEnabled boolean value enabling or disabling the button
     */
    public void setBtnEnabled(int row, int col, boolean isEnabled) {
        /* The status of the button at the specified position is toggled using the
        isEnabled parameter
        */
        btnSquares[row][col].setEnabled(isEnabled);
    }

    /**
     * Disables all buttons on the board
     */
    public void disableBoard() {
        /* Each of the nine PLACE buttons on the board is disabled */
        for (int i = 0; i < btnSquares.length; i++) {
            for (int j = 0; j < btnSquares[0].length; j++) {
                setBtnEnabled(i, j, false);
            }
        }
    }

    /**
     * Disables all buttons on the board
     */
    public void enableBoard() {
        /* Each of the nine PLACE buttons on the board is enabled */
        for (int i = 0; i < btnSquares.length; i++) {
            for (int j = 0; j < btnSquares[0].length; j++) {
                setBtnEnabled(i, j, true);
            }
        }
    }

    /**
     * Returns the list index of a particular position
     *
     * @param row row index of the position
     * @param col column index of the position
     * @return list index of the position
     */
    public int getIndex(int row, int col) {
        int index;

        /* The list index of a position is equivalent to its row index multiplied by 3 and
        added to its column index, due to the row-major relationship between the board grid
        and the lists used for the images
        */
        index = (row * 3) + col;

        /* The computed list index is returned */
        return index;
    }

    /**
     * Updates the display to reflect a move by either the player or the agent
     *
     * @param row row index of the chosen move
     * @param col column index of the chosen move
     * @param guiToken token representing the player or agent (either X or O)
     */
    public void makeMove(int row, int col, char guiToken) {
        /* The blank image at the specified position is removed, the board is
        revalidated, and either an X or O image is added to the position depending
        on the passed guiToken
        */
        if (guiToken == 'X') {
            pSquares[row][col].remove(blank.get(getIndex(row, col)));
            pBoard.revalidate();
            pSquares[row][col].add(ex.get(getIndex(row, col)));
        } else if (guiToken == 'O') {
            pSquares[row][col].remove(blank.get(getIndex(row, col)));
            pBoard.revalidate();
            pSquares[row][col].add(oh.get(getIndex(row, col)));
        }

        /* Once the correct image is added, the board is repainted and the button
        corresponding to the specified position is disabled
        */
        pBoard.repaint();
        setBtnEnabled(row, col, false);
    }

    /**
     * Updates the move log and decision time text box with a move by the agent
     *
     * @param row row index of the chosen move
     * @param col column index of the chosen move
     * @param evalTime time it took the agent to choose a move
     */
    public void updateAgentTime(int row, int col, double evalTime) {
        /* The passed input values are formatted and added to the text box */
        taTime.append("AI Move: " + row + " " + col + "\n");
        taTime.append("Decision Time: " + evalTime + "\n\n");
    }

    /**
     * Updates the move log and decision time text box with a move by the player
     *
     * @param row row index of the chosen move
     * @param col column index of the chosen move
     * @param evalTime time it took the player to choose a move
     */
    public void updateHumanTime(int row, int col, double evalTime) {
        /* The passed input values are formatted and added to the text box */
        taTime.append("Human Move: " + row + " " + col + "\n");
        taTime.append("Decision Time: " + evalTime + "\n\n");
    }

    /**
     * Updates the match statistics text box
     *
     * @param numAgentWins number of wins of the agent
     * @param numHumanWins number of wins of the player
     * @param numDraws number of games that resulted in a draw
     */
    public void updateWins(int numAgentWins, int numHumanWins, int numDraws) {
        /* The passed input values are formatted and added to the text box */
        taWinsAndTurn.setText("Agent Wins: " + numAgentWins + "\n" +
                "Player Wins: " + numHumanWins + "\n" +
                "Draws: " + numDraws);
    }

    /**
     * Updates the agent behavior information text box
     *
     * @param description description of the agent's behavior
     */
    public void setAgentDescription(String description) {
        /* The passed input is added to the text box */
        taInfo.setText(description);
    }

    /**
     * Updates the agent evaluation text box
     *
     * @param evaluation the agent's evaluation of current state of the game
     */
    public void updateAgentEvaluation(String evaluation) {
        /* The passed input is added to the text box */
        taEvaluation.setText(evaluation);
    }

    /**
     * Resets the board and some of the text boxes in preparation for a new game
     *
     * @param intelligence the intelligence level of the agent to be faced in the new game
     */
    public void reset(int intelligence) {
        /* The contents of the move log and decision time text box are deleted */
        taTime.setText("");

        switch (intelligence) {
            /* For the first two intelligence levels, "N/A" is displayed on the
            agent evaluation text box */
            case 0:
            case 1:
                taEvaluation.setText("N/A");
                break;
            /* For the higher intelligence levels, an initially blank format is
            displayed on the agent evaluation text box */
            default:
                taEvaluation.setText("Computer:\nHuman:");
        }

        /* The X and O images are removed from each of the grid positions and
        replaced with the blank image
        */
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                pSquares[i][j].remove(ex.get(getIndex(i, j)));
                pSquares[i][j].remove(oh.get(getIndex(i, j)));
                pBoard.revalidate();
                pSquares[i][j].add(blank.get(getIndex(i, j)));
                pBoard.repaint();
            }
    }


    /**
     * Sets the action listener for this graphical user interface
     *
     * @param listener action listener receiving action events
     */
    public void setActionListener(ActionListener listener) {
        /* An action listener is added to each of the positions on the grid */
        for (int i = 0; i < btnSquares.length; i++) {
            for (int j = 0; j < btnSquares[0].length; j++) {
                btnSquares[i][j].addActionListener(listener);
            }
        }

        /* Action listeners are added for the PLAY AGAIN and NEW LEVEL buttons
        on the side panel
        */
        btnNextGame.addActionListener(listener);
        btnNextLevel.addActionListener(listener);
    }

    /**
     * Sets the window listener for this graphical user interface
     *
     * @param listener window listener receiving window events
     */
    public void setWindowListener(WindowListener listener) {
        addWindowListener(listener);
    }
}

