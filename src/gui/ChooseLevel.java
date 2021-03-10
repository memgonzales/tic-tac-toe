package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Class implementing a window for the <b>selection of the intelligence level
 * of the agent </b>
 */
public class ChooseLevel extends JFrame {

    /* Player prompt */
    private JLabel lblPrompt;

    /* Button and label for the first intelligence level (level 0) */
    private JButton btnZero;
    private JLabel lblZero;

    /* Button and label for the second intelligence level (level 1) */
    private JButton btnOne;
    private JLabel lblOne;

    /* Button and label for the third intelligence level (level 2) */
    private JButton btnTwo;
    private JLabel lblTwo;

    /* Button and label for the fourth intelligence level (level 3) */
    private JButton btnThree;
    private JLabel lblThree;

    /* Button and label for the fifth intelligence level (level 4) */
    private JButton btnFour;
    private JLabel lblFour;

    /* Button and label for the sixth intelligence level (level 5) */
    private JButton btnFive;
    private JLabel lblFive;

    /**
     * Creates a window for the selection of the intelligence level of the agent
     */
    public ChooseLevel() {

        /* Some formatting methods for the window are executed */
        setUndecorated(true);
        getRootPane().setBorder(BorderFactory.createLineBorder(new Color(139, 0, 139), 8));
        setLayout(new BorderLayout());

        /* init() is called to initialize the elements of the window */
        init();

        /* Additional formatting methods for the window are executed */
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(500, 220);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Initializes the elements comprising this window
     */
    private void init() {
        /* Panels used to arrange the window elements */
        JPanel pMain;
        JPanel pChoices;
        JPanel pButtons;
        JPanel pLabels;

        /* The pMain panel is formatted */
        pMain = new JPanel();
        pMain.setLayout(new BorderLayout());
        pMain.setBackground(new Color(142, 229, 238));

        /* The user prompt for choosing the intelligence level is formatted and added to the window */
        lblPrompt = new JLabel("      Select the intelligence level of the artificial intelligence (computer): ");
        lblPrompt.setBorder(new EmptyBorder(10, 5, 5, 5));
        pMain.add (lblPrompt, BorderLayout.NORTH);

        /* The pBox panel is formatted */
        pChoices = new JPanel();
        pChoices.setLayout(new BoxLayout(pChoices, BoxLayout.X_AXIS));
        pChoices.setBorder(new EmptyBorder(0, 20, 0, 10));
        pChoices.setOpaque(false);

        /* The pButtons panel is formatted */
        pButtons = new JPanel();
        pButtons.setLayout(new BoxLayout(pButtons, BoxLayout.Y_AXIS));
        pButtons.setOpaque(false);

        /* The buttons for the six intelligence levels are instantiated and added
        to pButtons; pButtons is then added to pChoices
        */
        btnZero = new JButton("Level 0");
        pButtons.add(btnZero);
        btnOne = new JButton("Level 1");
        pButtons.add(btnOne);
        btnTwo = new JButton("Level 2");
        pButtons.add(btnTwo);
        btnThree = new JButton("Level 3");
        pButtons.add(btnThree);
        btnFour = new JButton("Level 4");
        pButtons.add(btnFour);
        btnFive = new JButton("Level 5");
        pButtons.add(btnFive);
        pChoices.add(pButtons);

        /* The pLabels panel is formatted */
        pLabels = new JPanel();
        pLabels.setLayout(new BoxLayout(pLabels, BoxLayout.Y_AXIS));
        pLabels.setOpaque(false);

        /* The labels for the six intelligence levels are instantiated, formatted,
        and added to pLabels; pLabels is then added to pChoices
        */
        lblZero = new JLabel("Random");
        lblZero.setBorder(new EmptyBorder(5, 5, 5, 5));
        pLabels.add(lblZero);
        lblOne = new JLabel("Hard-coded table of moves");
        lblOne.setBorder(new EmptyBorder(5, 5, 5, 5));
        pLabels.add(lblOne);
        lblTwo = new JLabel("Regular minimax (complete adversarial search)");
        lblTwo.setBorder(new EmptyBorder(5, 5, 5, 5));
        pLabels.add(lblTwo);
        lblThree = new JLabel("Regular minimax with alpha-beta pruning");
        lblThree.setBorder(new EmptyBorder(5, 5, 5, 5));
        pLabels.add(lblThree);
        lblFour = new JLabel("Depth-sensitive minimax (complete adversarial search)");
        lblFour.setBorder(new EmptyBorder(5, 5, 5, 5));
        pLabels.add(lblFour);
        lblFive = new JLabel("Depth-sensitive minimax with alpha-beta pruning");
        lblFive.setBorder(new EmptyBorder(5, 5, 5, 5));
        pLabels.add(lblFive);
        pChoices.add(pLabels);

        /* pChoices is added to pMain, and pMain is added to the window */
        pMain.add(pChoices, BorderLayout.CENTER);

        add (pMain, BorderLayout.CENTER);
    }

    /**
     * Sets the action listener for this graphical user interface
     *
     * @param listener action listener receiving action events
     */
    public void setActionListener(ActionListener listener) {
        /* Action listeners for the six buttons are added */
        btnZero.addActionListener(listener);
        btnOne.addActionListener(listener);
        btnTwo.addActionListener(listener);
        btnThree.addActionListener(listener);
        btnFour.addActionListener(listener);
        btnFive.addActionListener(listener);
    }
}
