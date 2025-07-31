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

    public AddUsersToPollHandler() {
        this.inputField = null;
        this.statusLabel = null;
        this.listModel = null;
    }
    
    // TODO
    @Override
    public void actionPerformed(ActionEvent click) {
        String action = click.getActionCommand();

        switch (action) {
            case "ADD USER":
                String input = inputField.getText().trim();
                if (!input.isEmpty()) {
                    if (PollServicesGUI.addUserToPoll(input)) {
                        listModel.addElement(input);
                        statusLabel.setText("User Added : " + input);
                        inputField.setText("");
                    } else {
                        statusLabel.setText("User " + input + "not added try again or check Username");
                    }
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
