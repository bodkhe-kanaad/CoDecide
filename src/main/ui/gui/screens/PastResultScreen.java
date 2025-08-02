package ui.gui.screens;

import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.poll.Poll;
import ui.gui.Constants;
import ui.gui.HeaderPanel;

public class PastResultScreen extends JFrame {
    private List<Poll> polls;

    PastResultScreen(List<Poll> polls) {
        this.polls = polls;
        setTitle("Past Results");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        add(mainPanel());
        setVisible(true);
    }

    private JPanel mainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(new HeaderPanel());
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(results());
        return mainPanel;
    }

    private JPanel results() {
        JPanel results = new JPanel();
        results.setLayout(new BoxLayout(results, BoxLayout.Y_AXIS));

        return results;
    }


}
