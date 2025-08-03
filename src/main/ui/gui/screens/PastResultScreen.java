package ui.gui.screens;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.poll.Poll;
import ui.gui.Buttons;
import ui.gui.Components;
import ui.gui.HeaderPanel;
import ui.gui.handlers.LoginHandler;
import ui.gui.handlers.QuitApplicationHandler;
import ui.gui.handlers.UserServiceHandler;

public class PastResultScreen extends JFrame {
    private List<Poll> polls;

    // EFFECTS Constructs a screen to see the Past Results
    public PastResultScreen(List<Poll> polls) {
        this.polls = polls;
        setTitle("Past Results");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        add(mainPanel(this));
        setVisible(true);
    }

    // EFFECTS makes the main panel which has other components
    private JPanel mainPanel(JFrame currentFrame) {
        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(new HeaderPanel());
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(results(currentFrame));
        return mainPanel;
    }

    // EFFECTS makes a scroll pane with all results for the polls which handler sends in 
    private JScrollPane results(JFrame currentFrame) {
        JPanel results = new JPanel();
        JButton quitButton = Buttons.quitApplicationButton();
        JButton returnToHomeButton = Buttons.returnToHomeScreenButton();
        JButton logOutButton = Buttons.logoutButton();
        results.setLayout(new BoxLayout(results, BoxLayout.Y_AXIS));

        quitButton.addActionListener(new QuitApplicationHandler(currentFrame));
        returnToHomeButton.addActionListener(new UserServiceHandler(currentFrame));
        logOutButton.addActionListener(new LoginHandler(currentFrame));

        results.add(resultsMaker());
        results.add(Box.createVerticalStrut(30));
        results.add(returnToHomeButton);
        results.add(Box.createVerticalStrut(10));
        results.add(logOutButton);
        results.add(Box.createVerticalStrut(10));
        results.add(quitButton);

        JScrollPane resultsPane = new JScrollPane(results);

        return resultsPane;
    }

    // EFFECTS makes a row with that polls result and poll Id
    private JPanel resultRow(Poll p) {
        JPanel resultRow = new JPanel();
        resultRow.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel pollId = Components.pollIdLabel(p.getPollId());
        JLabel pollResult = Components.pollResultLabel(p.pollResults());

        resultRow.add(pollId);
        resultRow.add(pollResult);

        return resultRow;
    }

    // EFFECTS makes the panel with all the results 
    private JPanel resultsMaker() {
        JPanel resultsMaker = new JPanel();
        resultsMaker.setLayout(new BoxLayout(resultsMaker, BoxLayout.Y_AXIS));
        JLabel noResultsLabel = Components.noResultsLabel();

        if (!polls.isEmpty()) {
            for (Poll p : polls) {
                resultsMaker.add(resultRow(p));
            }
        } else {
            resultsMaker.add(Box.createVerticalStrut(30));
            resultsMaker.add(noResultsLabel);
        }

        return resultsMaker;
    }

}
