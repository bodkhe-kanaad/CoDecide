package ui.gui.screens;

import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;

import model.Option;
import model.poll.Poll;
import ui.gui.Buttons;
import ui.gui.CoDecideAppGUI;
import ui.gui.Components;
import ui.gui.HeaderPanel;
import ui.gui.PollServicesGUI;
import ui.gui.handlers.VotingHandler;

// Screen to vote for the options for each user

public class VotingScreen extends JFrame {
    private Poll currentPoll = PollServicesGUI.getCurrentPoll();
    private Map<Option, JSlider> sliderMap = new HashMap<>();

    // EFFECTS makes a screen with User voting on options
    public VotingScreen() {
        setTitle("Voting for Poll");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        add(mainPanel(this));
        setVisible(true);
    }

    // EFFECTS makes a main panel with other components
    private JPanel mainPanel(JFrame currentFrame) {
        JPanel mainPanel = new JPanel();
        JLabel firstnameDisplay = Components
                .firstnameVotingDisplay(CoDecideAppGUI.getSession().getCurrentUserLoggedIn().getFirstName());
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(new HeaderPanel());
        mainPanel.add(Box.createVerticalStrut(30));
        mainPanel.add(firstnameDisplay);
        mainPanel.add(Box.createVerticalStrut(30));
        mainPanel.add(optionsPanel(currentFrame));

        return mainPanel;
    }

    // EFFECTS makes a scrollpane with all the options added to it
    private JScrollPane optionsPanel(JFrame currentFrame) {
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        JButton submitButton = Buttons.submitButton();

        for (Option o : currentPoll.getOptions()) {
            optionsPanel.add(Box.createVerticalStrut(10));
            optionsPanel.add(optionRow(o));
        }

        submitButton.addActionListener(new VotingHandler(sliderMap, currentPoll,currentFrame));

        optionsPanel.add(submitButton);

        JScrollPane optionsPanelScroll = new JScrollPane(optionsPanel);

        return optionsPanelScroll;
    }

    // EFFECTS makes a row with options label and a slider to vote on it
    private JPanel optionRow(Option o) {
        JPanel optionRow = new JPanel();
        optionRow.setLayout(new FlowLayout(FlowLayout.LEFT));
        JSlider slider = Components.optionVotingSlider();
        sliderMap.put(o, slider);
        JLabel optionLabel = Components.optionValueDisplayLabel(o.getValue());

        optionRow.add(optionLabel);
        optionRow.add(slider);

        return optionRow;
    }

}
