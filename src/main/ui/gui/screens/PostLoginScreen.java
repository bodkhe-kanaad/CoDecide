package ui.gui.screens;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.gui.CoDecideAppGUI;
import ui.gui.Components;
import ui.gui.Constants;
import ui.gui.HeaderPanel;
import ui.gui.handlers.LaunchCreatePollHandler;
import ui.gui.handlers.QuitApplicationHandler;
import ui.gui.handlers.SignOutHandler;
import ui.gui.handlers.ViewResultsHandler;

public class PostLoginScreen extends JFrame {

    //TODO
    public PostLoginScreen() {
        setTitle("CoDecide " + Constants.versionNumber());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        add(mainPanel(this));
        setVisible(true);
    }

    // TODO
    private JPanel mainPanel(JFrame currentFrame) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(topPanel(currentFrame), BorderLayout.NORTH);
        mainPanel.add(centerPanel(currentFrame), BorderLayout.CENTER);
        mainPanel.add(bottomPanel(currentFrame), BorderLayout.SOUTH);

        return mainPanel;

    }

    // TODO
    private JPanel centerPanel(JFrame currentFrame) {
        JPanel appFunctionButtonPanel = new JPanel();
        JButton createPollButton = Components.createPollButton();
        JButton viewPastResultsButton = Components.viewPastResultsButton();

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

    // TODO
    private JPanel topPanel(JFrame currentFrame) {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));


        topPanel.add(new HeaderPanel());
        topPanel.add(Box.createVerticalStrut(30));

        JLabel displayMessage = Components.displayPostLogin();
        topPanel.add(displayMessage);
        return topPanel;
    }

    // TODO
    private JPanel bottomPanel(JFrame currentFrame) {
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));

        JButton quitApplicationButton = Components.quitApplicationButton();
        JButton signOutButton = Components.signOutButton();

        signOutButton.setPreferredSize(new Dimension(100, 30));
        quitApplicationButton.setPreferredSize(new Dimension(100, 30));

        signOutButton.addActionListener(new SignOutHandler(currentFrame));
        quitApplicationButton.addActionListener(new QuitApplicationHandler(currentFrame));

        bottomPanel.add(signOutButton);
        bottomPanel.add(quitApplicationButton);

        return bottomPanel;
    }

}
