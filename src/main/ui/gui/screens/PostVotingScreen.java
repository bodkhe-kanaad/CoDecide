package ui.gui.screens;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.gui.Buttons;
import ui.gui.Components;
import ui.gui.HeaderPanel;
import ui.gui.handlers.LoginHandler;
import ui.gui.handlers.QuitApplicationHandler;
import ui.gui.handlers.UserServiceHandler;
import ui.gui.handlers.ViewResultsHandler;

// After voting screen

public class PostVotingScreen extends JFrame {

    // EFFECTS makes a Screen with options to quit, relogin, go back to homescreen,
    // view the results for this poll buttons
    public PostVotingScreen() {
        setTitle("CoDecide " + Components.versionNumber());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        add(mainPanel(this));
        setVisible(true);
    }

    // EFFECTS makes a panel with quit, relogin, go back to homescreen,
    // view the results for this poll buttons
    private JPanel mainPanel(JFrame currentFrame) {
        JPanel mainPanel = new JPanel();
        JButton viewResultsButton = Buttons.viewResultsButton();
        JButton returnToHomeScreenButton = Buttons.returnToHomeScreenButton();
        JButton logOutButton = Buttons.logoutButton();
        JButton quitButton = Buttons.quitApplicationButton();

        mainPanel.add(new HeaderPanel());
        mainPanel.add(Box.createVerticalStrut(30));
        mainPanel.add(viewResultsButton);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(returnToHomeScreenButton);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(logOutButton);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(quitButton);
        mainPanel.add(Box.createVerticalStrut(10));

        viewResultsButton.addActionListener(new ViewResultsHandler(currentFrame));
        returnToHomeScreenButton.addActionListener(new UserServiceHandler(currentFrame));
        logOutButton.addActionListener(new LoginHandler(currentFrame));
        quitButton.addActionListener(new QuitApplicationHandler(currentFrame));

        return mainPanel;
    }

}
