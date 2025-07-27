package ui.gui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Session;
import ui.gui.UserServicesGUI;

public class LoginHandler implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel statusLabel;
    private JFrame currentFrame;

    public LoginHandler(JTextField usernameField, JPasswordField passwordField, JLabel statusLabel,
            JFrame loginFrame) {
        this.usernameField = usernameField;
        this.passwordField = passwordField;
        this.statusLabel = statusLabel;
        this.currentFrame = loginFrame;
    }

    @Override
    public void actionPerformed(ActionEvent click) {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            statusLabel.setText("Please enter both Username and Password");
            return;
        }

        Session session = UserServicesGUI.login(username, password);

        if (session != null) {
            currentFrame.dispose();
            JOptionPane.showMessageDialog(null, "Login succssful!");
            // TODO open next
        } else {
            statusLabel.setText("Incorrect Username or Password.");
        }
    }

}
