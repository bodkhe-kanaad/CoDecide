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
import ui.gui.CoDecideAppGUI;
import ui.gui.UserServicesGUI;
import ui.gui.screens.PostLoginScreen;
import ui.gui.screens.ViewResultsScreen;
import ui.gui.screens.VotingScreen;
import ui.gui.screens.WelcomeScreen;

public class LoginHandler implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel statusLabel;
    private JFrame currentFrame;
    private User currentUser;

    // TODO
    public LoginHandler(JTextField usernameField, JPasswordField passwordField, JLabel statusLabel,
            JFrame loginFrame) {
        this.usernameField = usernameField;
        this.passwordField = passwordField;
        this.statusLabel = statusLabel;
        this.currentFrame = loginFrame;
        this.currentUser = null;
    }

    // TODO
    public LoginHandler(JTextField usernameField, JPasswordField passwordField, JLabel statusLabel,
            JFrame loginFrame, User nextVoter) {
        this.usernameField = usernameField;
        this.passwordField = passwordField;
        this.statusLabel = statusLabel;
        this.currentFrame = loginFrame;
        this.currentUser = nextVoter;
    }

    // TODO
    public LoginHandler() {
        this.usernameField = null;
        this.passwordField = null;
        this.statusLabel = null;
        this.currentFrame = null;
        this.currentUser = null;
    }

    // TODO

    @Override
    public void actionPerformed(ActionEvent click) {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
        String action = click.getActionCommand();

        switch (action) {
            case "LOGIN":
                if (emptyLogin(username, password)) {
                    return;
                }
                login(username, password);
                break;

            case "VOTING LOGIN":
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
                break;

            case "RESULT LOGIN":
                if (emptyLogin(username, password)) {
                    return;
                }
                if (!username.equals(currentUser.getUsername())) {
                    statusLabel.setText(currentUser.getFirstName() + " please login");
                    return;
                }
                session = UserServicesGUI.login(username, password);
                if (session != null) {
                    currentFrame.dispose();
                    JOptionPane.showMessageDialog(null, "Login succssful!");
                    new ViewResultsScreen();
                } else {
                    statusLabel.setText("Incorrect Username or Password.");
                }
            case "LOGOUT":
                DataStore.saveState();
                currentFrame.dispose();
                new WelcomeScreen();
                break;

        }
    }

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

    private boolean emptyLogin(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            statusLabel.setText("Please enter both Username and Password");
            return true;
        } else {
            return false;
        }
    }

}
