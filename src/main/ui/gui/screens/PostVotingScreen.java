package ui.gui.screens;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.gui.Components;
import ui.gui.Constants;
import ui.gui.HeaderPanel;
import ui.gui.handlers.LoginHandler;
import ui.gui.handlers.QuitApplicationHandler;
import ui.gui.handlers.UserServiceHandler;
import ui.gui.handlers.ViewResultsHandler;

public class PostVotingScreen extends JFrame {

    public PostVotingScreen() {
        setTitle("CoDecide " + Constants.versionNumber());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        add(mainPanel(this));
        setVisible(true);
    }

    private JPanel mainPanel(JFrame currentFrame) {
        JPanel mainPanel = new JPanel();
        JButton viewResultsButton = Components.viewResultsButton();
        JButton returnToHomeScreenButton = Components.returnToHomeScreenButton();
        JButton logOutButton = Components.logoutButton();
        JButton quitButton = Components.quitApplicationButton();

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
        returnToHomeScreenButton.addActionListener(new UserServiceHandler());
        logOutButton.addActionListener(new LoginHandler());
        quitButton.addActionListener(new QuitApplicationHandler(currentFrame));


        return mainPanel;
    }

}
