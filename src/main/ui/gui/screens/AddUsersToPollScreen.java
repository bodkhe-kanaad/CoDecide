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
import ui.gui.handlers.AddUsersToPollHandler;

/*
 * Screen to add users to Poll
 */

public class AddUsersToPollScreen extends JFrame {

    private DefaultListModel<String> usersListModel = new DefaultListModel<>();
    private JPanel statusRow;
    private JPanel userInputRow;
    private JLabel addUserLabel;
    private JTextField addUserField;
    private JButton addUserButton;

    // EFFECTS Constructor to make the screen to add users to Poll
    public AddUsersToPollScreen() {
        setTitle("Create Poll");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        add(mainPanel());
        setVisible(true);
    }

    // EFFECTS makes the main panel which has other components of the screen
    private JPanel mainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(new HeaderPanel());
        mainPanel.add(Box.createVerticalStrut(30));
        mainPanel.add(addUserPanel());
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(addedUsersPanel());
        mainPanel.add(Box.createVerticalStrut(200));
        return mainPanel;
    }

    // EFFECTS makes the panel with field, label and button to add the usernames
    // which will further add user
    private JPanel addUserPanel() {
        JPanel addUserPanel = new JPanel();
        addUserPanel.setLayout(new BoxLayout(addUserPanel, BoxLayout.Y_AXIS));
        JPanel statusRow = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel userInputRow = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel addUserLabel = Components.addUserLabel();
        JTextField addUserField = Components.addUserField();
        JButton addUserButton = Buttons.addUserButton();

        JLabel statusLabel = Components.statusLabel();

        addUserButton.addActionListener(new AddUsersToPollHandler(addUserField, statusLabel, usersListModel));

        statusRow.add(statusLabel);

        userInputRow.add(addUserLabel);
        userInputRow.add(addUserField);
        userInputRow.add(addUserButton);

        addUserPanel.add(statusLabel);
        addUserPanel.add(userInputRow);

        return addUserPanel;
    }

    // EFFECTS makes the panel with a scroll pane to display added usernames
    private JPanel addedUsersPanel() {
        JPanel addedUsersPanel = new JPanel();
        JLabel title = new JLabel("Added Users");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton nextButton = Buttons.nextButton();

        nextButton.addActionListener(new AddUsersToPollHandler());

        nextButton.addActionListener(new AddUsersToPollHandler(null, title, usersListModel));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        addedUsersPanel.setLayout(new BoxLayout(addedUsersPanel, BoxLayout.Y_AXIS));
        addedUsersPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JList<String> usersList = new JList<>(usersListModel);
        usersList.setVisibleRowCount(4);
        usersList.setFixedCellHeight(20);
        usersList.setEnabled(false);

        JScrollPane scrollPane = new JScrollPane(usersList);
        scrollPane.setPreferredSize(new Dimension(50, 100));
        scrollPane.setMaximumSize(new Dimension(100, 100));
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);

        addedUsersPanel.setMaximumSize(new Dimension(320, 110));
        addedUsersPanel.add(title);
        addedUsersPanel.add(scrollPane);
        addedUsersPanel.add(Box.createVerticalStrut(60));
        addedUsersPanel.add(nextButton);

        return addedUsersPanel;
    }

}
