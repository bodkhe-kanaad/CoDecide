package ui.gui.screens;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ui.gui.Buttons;
import ui.gui.Components;
import ui.gui.HeaderPanel;
import ui.gui.handlers.LoginHandler;
import ui.gui.handlers.UserServiceHandler;

public class LoginScreen extends JFrame {

    private static JButton loginButton = Buttons.loginButton();
    private static JLabel usernameLabel = Components.usernameLabel();
    private static JTextField usernameField = Components.usernameField();
    private static JLabel passwordLabel = Components.passwordLabel();
    private static JPasswordField passwordField = Components.passwordField();
    private static JLabel statusLabel = Components.statusLabel();

    // EFFECTS Constructor to make the screen for logging in the User
    public LoginScreen() {
        setTitle("Login !!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        add(mainPanel(this));
        setVisible(true);

    }

    // EFFECTS makes the panel with other components of the screen
    private JPanel mainPanel(JFrame loginFrame) {
        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(new HeaderPanel());
        mainPanel.add(Box.createVerticalStrut(30));
        mainPanel.add(loginForm(loginFrame));

        return mainPanel;
    }

    // EFFECTS makes a panel to with username, password, login button and status
    // label.
    private JPanel loginForm(JFrame loginFrame) {
        JPanel loginFormPanel = new JPanel();
        JButton switchToSignupButton = Buttons.switchToSignupButton(loginFrame);

        loginFormPanel.setLayout(new BoxLayout(loginFormPanel, BoxLayout.Y_AXIS));
        loginFormPanel.setBorder(BorderFactory.createEmptyBorder(20, 60, 10, 60));

        usernameField.setMaximumSize(new Dimension(300, 30));
        passwordField.setMaximumSize(new Dimension(300, 30));

        loginButton.addActionListener(new LoginHandler(usernameField, passwordField, statusLabel, loginFrame));
        switchToSignupButton.addActionListener(new UserServiceHandler(loginFrame));

        loginFormPanel.add(usernameLabel);
        loginFormPanel.add(usernameField);
        loginFormPanel.add(Box.createVerticalStrut(10));
        loginFormPanel.add(passwordLabel);
        loginFormPanel.add(passwordField);
        loginFormPanel.add(Box.createVerticalStrut(10));
        loginFormPanel.add(loginButton);
        loginFormPanel.add(Box.createVerticalStrut(10));
        loginFormPanel.add(switchToSignupButton);
        loginFormPanel.add(Box.createVerticalStrut(10));
        loginFormPanel.add(statusLabel);

        return loginFormPanel;
    }

}
