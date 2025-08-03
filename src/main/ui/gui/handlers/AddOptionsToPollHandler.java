package ui.gui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ui.gui.PollServicesGUI;
import ui.gui.screens.AddUsersToPollScreen;

public class AddOptionsToPollHandler implements ActionListener {
    private JTextField inputField;
    private JLabel statusLabel;
    private final DefaultListModel<String> listModel;
    private JFrame currentFrame;

    // REQUIRES inputField, statusLabel, listModel
    // EFFECTS Constructor
    // CITATION https://stackoverflow.com/questions/2893052/java-jlist-model
    public AddOptionsToPollHandler(JTextField inputField, JLabel statusLabel, DefaultListModel<String> listModel,
            JFrame currentFrame) {
        this.inputField = inputField;
        this.statusLabel = statusLabel;
        this.listModel = listModel;
        this.currentFrame = currentFrame;
    }

    // EFFECTS Constructor
    public AddOptionsToPollHandler(JFrame currentFrame) {
        this.inputField = null;
        this.statusLabel = null;
        this.listModel = null;
        this.currentFrame = currentFrame;
    }

    // EFFECTS It triggers the method to add options to the Poll or trigger the
    // method to move on to the next step
    @Override
    public void actionPerformed(ActionEvent click) {
        String action = click.getActionCommand();
        switch (action) {
            case "ADD OPTION":
                String input = inputField.getText().trim();
                if (!input.isEmpty()) {
                    PollServicesGUI.addOptionToPoll(input);
                    listModel.addElement(input);
                    statusLabel.setText("Option Added : " + input);
                    inputField.setText("");
                } else {
                    statusLabel.setText("Please enter an option");
                }
                break;

            case "NEXT":
                currentFrame.dispose();
                new AddUsersToPollScreen();
                break;
        }
    }

}
