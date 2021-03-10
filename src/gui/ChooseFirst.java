package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Class implementing a window for <b>selecting whether the player or the agent
 * goes first </b>
 */
public class ChooseFirst extends JFrame {

    /* Player prompt */
    private JLabel lblPrompt;

    /* Button for the player */
    private JButton btnPlayer;

    /* Button for the agent */
    private JButton btnAI;

    /**
     * Creates a window for selecting whether the player or the agent goes first
     */
    public ChooseFirst() {

        /* Some formatting methods for the window are executed */
        setUndecorated(true);
        getRootPane().setBorder(BorderFactory.createLineBorder(new Color(139, 0, 139), 8));
        setLayout(new BorderLayout());

        /* init() is called to initialize the elements of the window */
        init();

        /* Additional formatting methods for the window are executed */
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(false);
    }

    /**
     * Initializes the elements comprising this window
     */
    private void init() {
        /* Panels used to arrange the window elements */
        JPanel pMain;
        JPanel pGrid;
        JPanel pSouth;

        /* The pMain panel is formatted */
        pMain = new JPanel();
        pMain.setLayout(new BorderLayout());
        pMain.setBackground(new Color(142, 229, 238));

        /* The user prompt for choosing who goes first is formatted and added to the window */
        lblPrompt = new JLabel("      Select the first player: ");
        lblPrompt.setBorder(new EmptyBorder(10, 5, 5, 5));
        pMain.add (lblPrompt, BorderLayout.NORTH);

        /* The pGrid panel is formatted */
        pGrid = new JPanel();
        pGrid.setLayout(new GridLayout(1, 2));
        pGrid.setOpaque(false);

        /* Images for the player and the agent are added to pGrid, and pGrid is added
        to pMain
         */
        pGrid.add(setImage("assets/player.png"));
        pGrid.add(setImage("assets/bot.png"));
        pMain.add(pGrid, BorderLayout.CENTER);

        /* The pSouth panel is formatted */
        pSouth = new JPanel();
        pSouth.setLayout(new GridLayout(1, 2));

        /* The buttons for the player and agent are added to the window */
        btnPlayer = new JButton("Player");
        pSouth.add(btnPlayer);

        btnAI = new JButton("AI (Computer)");
        pSouth.add(btnAI);

        /* pSouth is added to pMain, and pMain is added to the window */
        pMain.add(pSouth, BorderLayout.SOUTH);

        add (pMain, BorderLayout.CENTER);
    }

    /**
     * Returns a scaled version of an image given its path
     *
     * @param imagePath path to the image to be scaled
     * @return scaled version of the image as a label
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
        imageScaled = imageOrig.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT);

        /* The scaled image is converted to a JLabel, further formatted, and returned */
        lblImage = new JLabel(new ImageIcon(imageScaled));
        lblImage.setBackground(Color.white);
        lblImage.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        lblImage.setBorder(new EmptyBorder(5, 5, 5, 5));

        return lblImage;
    }

    /**
     * Sets the action listener for this graphical user interface
     *
     * @param listener action listener receiving action events
     */
    public void setActionListener(ActionListener listener) {
        /* Action listeners for the two buttons are added */
        btnPlayer.addActionListener(listener);
        btnAI.addActionListener(listener);
    }
}
