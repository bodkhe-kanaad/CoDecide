package ui.gui.screens;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.gui.Buttons;
import ui.gui.Components;
import ui.gui.HeaderPanel;
import ui.gui.handlers.LaunchCreatePollHandler;
import ui.gui.handlers.QuitApplicationHandler;
import ui.gui.handlers.UserServiceHandler;
import ui.gui.handlers.ViewResultsHandler;

// Post login / Home screen

public class PostLoginScreen extends JFrame {

    // EFFECTS makes a screen with options to create a poll or view past results for
    // that user
    public PostLoginScreen() {
        setTitle("CoDecide " + Components.versionNumber());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        add(mainPanel(this));
        setVisible(true);
    }

    // EFFECTS makes a main panel with other components in it
    private JPanel mainPanel(JFrame currentFrame) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(topPanel(currentFrame), BorderLayout.NORTH);
        mainPanel.add(centerPanel(currentFrame), BorderLayout.CENTER);
        mainPanel.add(bottomPanel(currentFrame), BorderLayout.SOUTH);

        return mainPanel;

    }

    // EFFECTS makes a panel with buttons about creating a poll and viewing past
    // results
    private JPanel centerPanel(JFrame currentFrame) {
        JPanel appFunctionButtonPanel = new JPanel();
        JButton createPollButton = Buttons.createPollButton();
        JButton viewPastResultsButton = Buttons.viewPastResultsButton();

        appFunctionButtonPanel.setLayout(new BoxLayout(appFunctionButtonPanel, BoxLayout.Y_AXIS));
        appFunctionButtonPanel.setBorder(BorderFactory.createEmptyBorder(20, 60, 10, 60));

        createPollButton.addActionListener(new LaunchCreatePollHandler(currentFrame));
        viewPastResultsButton.addActionListener(new ViewResultsHandler(currentFrame));

        appFunctionButtonPanel.add(Box.createVerticalStrut(20));
        appFunctionButtonPanel.add(createPollButton);
        appFunctionButtonPanel.add(Box.createVerticalStrut(10));
        appFunctionButtonPanel.add(viewPastResultsButton);

        return appFunctionButtonPanel;
    }

    // EFFECTS makes a panel for the top of the screen
    private JPanel topPanel(JFrame currentFrame) {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        topPanel.add(new HeaderPanel());
        topPanel.add(Box.createVerticalStrut(30));

        JLabel displayMessage = Components.displayPostLogin();
        topPanel.add(displayMessage);
        return topPanel;
    }

   // EFFECTS makes a panel for the bottom of the screen
    private JPanel bottomPanel(JFrame currentFrame) {
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));

        JButton quitApplicationButton = Buttons.quitApplicationButton();
        JButton signOutButton = Buttons.signOutButton();

        signOutButton.setPreferredSize(new Dimension(100, 30));
        quitApplicationButton.setPreferredSize(new Dimension(100, 30));

        signOutButton.addActionListener(new UserServiceHandler(currentFrame));
        quitApplicationButton.addActionListener(new QuitApplicationHandler(currentFrame));

        bottomPanel.add(signOutButton);
        bottomPanel.add(quitApplicationButton);

        return bottomPanel;
    }

}
