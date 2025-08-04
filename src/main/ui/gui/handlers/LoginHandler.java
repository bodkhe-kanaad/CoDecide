package ui.gui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Session;
import model.user.User;
import persistence.DataStore;
import ui.gui.UserServicesGUI;
import ui.gui.screens.PostLoginScreen;
import ui.gui.screens.ViewResultsScreen;
import ui.gui.screens.VotingScreen;
import ui.gui.screens.WelcomeScreen;

/*
 * Handler for login for the User
 */

public class LoginHandler implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel statusLabel;
    private JFrame currentFrame;
    private User currentUser;

    // REQUIRES usernameField, passwordField, statusLavel, loginFrame is not null
    // EFFECTS Construtor
    public LoginHandler(JTextField usernameField, JPasswordField passwordField, JLabel statusLabel,
            JFrame loginFrame) {
        this.usernameField = usernameField;
        this.passwordField = passwordField;
        this.statusLabel = statusLabel;
        this.currentFrame = loginFrame;
        this.currentUser = null;
    }

    // REQUIRES usernameField, passwordField, statusLavel, loginFrame. nextVoter is
    // not null
    // EFFECTS Construtor
    public LoginHandler(JTextField usernameField, JPasswordField passwordField, JLabel statusLabel,
            JFrame loginFrame, User nextVoter) {
        this.usernameField = usernameField;
        this.passwordField = passwordField;
        this.statusLabel = statusLabel;
        this.currentFrame = loginFrame;
        this.currentUser = nextVoter;
    }

    // REQUIRES currentFrame is not null
    // EFFECTS Constructor
    public LoginHandler(JFrame currentFrame) {
        this.usernameField = null;
        this.passwordField = null;
        this.statusLabel = null;
        this.currentFrame = currentFrame;
        this.currentUser = null;
    }

    // EFFECTS it triggers the method to login or logout the user in different
    // scenarios like during voting or seeing the results.
    @Override
    public void actionPerformed(ActionEvent click) {
        String username;
        String password; 
        String action = click.getActionCommand();

        switch (action) {
            case "LOGIN":
                username = usernameField.getText().trim();
                password = new String(passwordField.getPassword()).trim();
                if (emptyLogin(username, password)) {
                    return;
                }
                login(username, password);
                break;

            case "VOTING LOGIN":
                username = usernameField.getText().trim();
                password = new String(passwordField.getPassword()).trim();
                votingLogin(username, password);
                break;

            case "RESULT LOGIN":
                username = usernameField.getText().trim();
                password = new String(passwordField.getPassword()).trim();
                resultLogin(username, password);
                break;

            case "LOGOUT":
                DataStore.saveState();
                currentFrame.dispose();
                new WelcomeScreen();
                break;

        }
    }

    // EFFECTS logs in the user with given username fields
    private void login(String username, String password) {
        Session session = UserServicesGUI.login(username, password);
        if (session != null) {
            currentFrame.dispose();
            JOptionPane.showMessageDialog(null, "Login succssful!");
            new PostLoginScreen();
        } else {
            statusLabel.setText("Incorrect Username or Password.");
        }
    }

    // EFFECTS logs in the user with given fields
    private boolean emptyLogin(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            statusLabel.setText("Please enter both Username and Password");
            return true;
        } else {
            return false;
        }
    }

    // EFFECTS logs in the user with given fields during voting phase of the poll
    private void votingLogin(String username, String password) {
        if (emptyLogin(username, password)) {
            return;
        }
        if (!username.equals(currentUser.getUsername())) {
            statusLabel.setText(currentUser.getFirstName() + " please login");
            return;
        }

        Session session = UserServicesGUI.login(username, password);

        if (session != null) {
            currentFrame.dispose();
            JOptionPane.showMessageDialog(null, "Login succssful!");
            new VotingScreen();
        } else {
            statusLabel.setText("Incorrect Username or Password.");
        }
    }

    // EFFECTS logs in the user with given fields during results phase of the poll
    private void resultLogin(String username, String password) {
        if (emptyLogin(username, password)) {
            return;
        }
        if (!username.equals(currentUser.getUsername())) {
            statusLabel.setText(currentUser.getFirstName() + " please login");
            return;
        }

        Session session = UserServicesGUI.login(username, password);

        if (session != null) {
            currentFrame.dispose();
            new ViewResultsScreen();
        } else {
            statusLabel.setText("Incorrect Username or Password.");
        }
    }
}
