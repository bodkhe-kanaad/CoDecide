package ui.gui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import ui.gui.PollServicesGUI;
import ui.gui.screens.VotingScreen;

public class AddUsersToPollHandler implements ActionListener {
    private JTextField inputField;
    private JLabel statusLabel;
    private final DefaultListModel<String> listModel;

    // TODO
    public AddUsersToPollHandler(JTextField inputField, JLabel statusLabel, DefaultListModel<String> listModel) {
        this.inputField = inputField;
        this.statusLabel = statusLabel;
        this.listModel = listModel;
    }

    // TODO
    @Override
    public void actionPerformed(ActionEvent click) {
        String action = click.getActionCommand();

        switch (action) {
            case "ADD USER":
                String input = inputField.getText().trim();
                if (!input.isEmpty()) {
                    PollServicesGUI.addUserToPoll(input);
                    listModel.addElement(input);
                    statusLabel.setText("User Added : " + input);
                    inputField.setText("");
                } else {
                    statusLabel.setText("Please enter an Username");
                }
                break;

            case "NEXT":
                new VotingScreen();
                break;
        }

    }
}
