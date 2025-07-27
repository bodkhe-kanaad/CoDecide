package ui.gui.screens;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.gui.Components;
import ui.gui.Constants;
import ui.gui.HeaderPanel;

public class PostLoginScreen extends JFrame {

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
        JButton signOutButton = Components.signOutButton();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(new HeaderPanel());
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(appFunctionButtonPanel(currentFrame));

        return mainPanel;

    }

    // TODO
    private JPanel appFunctionButtonPanel(JFrame currentFrame) {
        JPanel appFunctionButtonPanel = new JPanel();
        JButton createPollButton = Components.createPollButton();
        JButton viewPastResultsButton = Components.viewPastResultsButton();
        JButton quitApplicationButton = Components.quitApplicationButton();

        return appFunctionButtonPanel;
    }




}
