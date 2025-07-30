package ui.gui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import ui.gui.UserServicesGUI;
import ui.gui.screens.LoginScreen;

public class SignupHandler implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField firstnameField;
    private JTextField lastnameField;
    private JFrame currentFrame;
    private JLabel statusLabel;

    //TODO
    public SignupHandler(JTextField usernameField, JPasswordField passwordField, JTextField firstnameField,
            JTextField lastnameField, JLabel statusLabel, JFrame currentFrame) {
        this.usernameField = usernameField;
        this.passwordField = passwordField;
        this.firstnameField = firstnameField;
        this.lastnameField = lastnameField;
        this.currentFrame = currentFrame;
        this.statusLabel = statusLabel;
    }

    //TODO
    @Override
    public void actionPerformed(ActionEvent click) {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
        String firstname = firstnameField.getText().trim();
        String lastname = lastnameField.getText().trim();

        if (username.isEmpty() || password.isEmpty() || firstname.isEmpty() || lastname.isEmpty()) {
            statusLabel.setText("Please enter all the fields");
            return;
        }

        boolean status = UserServicesGUI.signup(firstname, lastname, username, password);

        if (status) {
            JOptionPane.showMessageDialog(
                    currentFrame,
                    "Sign-up successful! You can now log in.");
            currentFrame.dispose();
            new LoginScreen();
        } else {
            statusLabel.setText("This username is already taken try a different one");
        }
    }
}
