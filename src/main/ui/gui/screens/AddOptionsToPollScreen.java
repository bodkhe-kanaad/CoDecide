package ui.gui.screens;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import ui.gui.Buttons;
import ui.gui.Components;
import ui.gui.HeaderPanel;
import ui.gui.handlers.AddOptionsToPollHandler;
 
/*
 * Screen to add options to Poll
 */

public class AddOptionsToPollScreen extends JFrame {

    private DefaultListModel<String> optionListModel = new DefaultListModel<>();

    // EFFECTS Constructor to make the screen to add options to Poll
    public AddOptionsToPollScreen() {
        setTitle("Create Poll");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        add(mainPanel(this));
        setVisible(true);
    }

    // EFFECTS makes the main panel which has other components of the screen
    private JPanel mainPanel(JFrame currentFrame) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(new HeaderPanel());
        mainPanel.add(Box.createVerticalStrut(30));
        mainPanel.add(addOptionPanel(currentFrame));
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(addedOptionsPanel(currentFrame));
        mainPanel.add(Box.createVerticalStrut(200));
        return mainPanel;
    }

    // EFFECTS makes the panel with field, label and button to add the option
    private JPanel addOptionPanel(JFrame currentFrame) {
        JPanel addOptionPanel = new JPanel();
        addOptionPanel.setLayout(new BoxLayout(addOptionPanel, BoxLayout.Y_AXIS));
        JPanel statusRow = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel optionInputRow = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel addOptionLabel = Components.addOptionLabel();
        JTextField addOptionField = Components.addOptionField();
        JButton addOptionButton = Buttons.addOptionButton();

        JLabel statusLabel = Components.statusLabel();

        addOptionButton.addActionListener(
                new AddOptionsToPollHandler(addOptionField, statusLabel, optionListModel, currentFrame));

        statusRow.add(statusLabel);

        optionInputRow.add(addOptionLabel);
        optionInputRow.add(addOptionField);
        optionInputRow.add(addOptionButton);

        addOptionPanel.add(statusLabel);
        addOptionPanel.add(optionInputRow);

        return addOptionPanel;
    }

    // EFFECTS makes the panel with a scroll pane to display added options
    private JPanel addedOptionsPanel(JFrame currentFrame) {
        JPanel addedOptionsPanel = new JPanel();
        JLabel title = new JLabel("Added Options");
        JButton nextButton = Buttons.nextButton();

        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        addedOptionsPanel.setLayout(new BoxLayout(addedOptionsPanel, BoxLayout.Y_AXIS));
        addedOptionsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        nextButton.addActionListener(new AddOptionsToPollHandler(currentFrame));

        JList<String> optionList = new JList<>(optionListModel);
        optionList.setVisibleRowCount(4);
        optionList.setFixedCellHeight(20);
        optionList.setEnabled(false);

        JScrollPane scrollPane = new JScrollPane(optionList);
        scrollPane.setPreferredSize(new Dimension(50, 100));
        scrollPane.setMaximumSize(new Dimension(100, 100));
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);

        addedOptionsPanel.setMaximumSize(new Dimension(320, 110));
        addedOptionsPanel.add(title);
        addedOptionsPanel.add(scrollPane);
        addedOptionsPanel.add(Box.createVerticalStrut(60));
        addedOptionsPanel.add(nextButton);

        return addedOptionsPanel;
    }
}
