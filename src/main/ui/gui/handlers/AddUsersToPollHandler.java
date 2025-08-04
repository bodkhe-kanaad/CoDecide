package ui.gui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import ui.gui.PollServicesGUI;
import ui.gui.screens.VotingScreen;

/*
  * Handler for all actions regarding adding users to poll 
 */

public class AddUsersToPollHandler implements ActionListener {
    private JTextField inputField;
    private JLabel statusLabel;
    private DefaultListModel<String> listModel;
    private JFrame currentFrame;

    // REQUIRES inputField, statusLabel, listModel
    // EFFECTS Constructor
    // CITATION https://stackoverflow.com/questions/2893052/java-jlist-model
    public AddUsersToPollHandler(JTextField inputField, JLabel statusLabel, DefaultListModel<String> listModel,
            JFrame currentFrame) {
        this.inputField = inputField;
        this.statusLabel = statusLabel;
        this.listModel = listModel;
        this.currentFrame = currentFrame;
    }

    public AddUsersToPollHandler(JTextField inputField, JLabel statusLabel, DefaultListModel<String> listModel) {
        this.inputField = inputField;
        this.statusLabel = statusLabel;
        this.listModel = listModel;
        this.currentFrame = null;
    }

    // EFFECTS Constructor
    public AddUsersToPollHandler(JFrame currentFrame) {
        this.inputField = null;
        this.statusLabel = null;
        this.listModel = null;
        this.currentFrame = currentFrame;
    }

    // EFFECTS Triggersthe methods to add user to the poll or move on to the next
    // step in the poll.
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
                currentFrame.dispose();
                new VotingScreen();
                break;
        }

    }
}
