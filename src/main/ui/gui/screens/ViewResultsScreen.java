package ui.gui.screens;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.gui.Buttons;
import ui.gui.Components;
import ui.gui.HeaderPanel;
import ui.gui.handlers.LoginHandler;
import ui.gui.handlers.QuitApplicationHandler;
import ui.gui.handlers.UserServiceHandler;

// Viewing results for the Current Poll screen

public class ViewResultsScreen extends JFrame {

    // EFFECTS Makes the screen to view results of that poll
    public ViewResultsScreen() {
        setTitle("Results");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        add(mainPanel(this));
        setVisible(true);
    }

    // EFFECTS makes the main panel with other components
    public JPanel mainPanel(JFrame currentFrame) {

        JPanel mainPanel = new JPanel();
        JLabel resultLabel = Components.resultLabel();
        JButton returnToHomeScreenButton = Buttons.returnToHomeScreenButton();
        JButton logOutButton = Buttons.logoutButton();
        JButton quitButton = Buttons.quitApplicationButton();

        mainPanel.add(new HeaderPanel());
        mainPanel.add(Box.createVerticalStrut(60));
        mainPanel.add(resultLabel);
        mainPanel.add(Box.createVerticalStrut(30));
        mainPanel.add(returnToHomeScreenButton);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(logOutButton);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(quitButton);
        mainPanel.add(Box.createVerticalStrut(10));

        returnToHomeScreenButton.addActionListener(new UserServiceHandler(currentFrame));
        logOutButton.addActionListener(new LoginHandler(currentFrame));
        quitButton.addActionListener(new QuitApplicationHandler(currentFrame));

        return mainPanel;
    }

}
