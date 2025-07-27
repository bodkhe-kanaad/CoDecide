package ui.gui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ui.gui.PollServicesGUI;

public class AddOptionsToPollHandler implements ActionListener {
    private JTextField inputField;
    private JLabel statusLabel;
    private final DefaultListModel<String> listModel;

    public AddOptionsToPollHandler(JTextField inputField, JLabel statusLabel, DefaultListModel<String> listModel) {
        this.inputField = inputField;
        this.statusLabel = statusLabel;
        this.listModel = listModel;
    }

    public void actionPerformed(ActionEvent click) {
        String input = inputField.getText().trim();
        if (!input.isEmpty()) {
            PollServicesGUI.addOptionToPoll(input);
            listModel.addElement(input);
            statusLabel.setText("Option Added : " + input);
            inputField.setText("");
        } else {
            statusLabel.setText("Please enter an option");
        }
    }

}
