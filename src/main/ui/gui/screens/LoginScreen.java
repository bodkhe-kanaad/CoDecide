package ui.gui.screens;

import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ui.gui.Components;
import ui.gui.Constants;
import ui.gui.HeaderPanel;
import ui.gui.handlers.LoginHandler;

public class LoginScreen extends JFrame {

    public LoginScreen() {
        setTitle("Log Into Your Account");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        add(mainPanel(this));
        setVisible(true);

    }

    private JPanel mainPanel(JFrame loginFrame) {
        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(new HeaderPanel());
        mainPanel.add(Box.createVerticalStrut(30));
        mainPanel.add(loginForm(loginFrame));

        return mainPanel;
    }

    private JPanel loginForm(JFrame loginFrame) {
        JPanel loginFormPanel = new JPanel();
        JButton loginButton = Components.loginButton(loginFrame);
        JButton switchToSignupButton = Components.signupButton(loginFrame);
        JLabel usernameLabel = Components.usernameLabel();
        JTextField usernameField = Components.usernameField();
        JLabel passwordLabel = Components.passwordLabel();
        JPasswordField passwordField = Components.passwordField();

        loginFormPanel.setLayout(new BoxLayout(loginFormPanel, BoxLayout.Y_AXIS));
        loginFormPanel.setBorder(BorderFactory.createEmptyBorder(20, 60, 20, 60));

        JLabel statusLabel = new JLabel(" ");
        statusLabel.setForeground(Constants.statusColor());
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginButton.addActionListener(new LoginHandler(usernameField, passwordField, statusLabel, loginFrame));

        loginFormPanel.add(usernameLabel);
        loginFormPanel.add(usernameField);
        loginFormPanel.add(Box.createVerticalStrut(10));
        loginFormPanel.add(passwordLabel);
        loginFormPanel.add(passwordField);
        loginFormPanel.add(Box.createVerticalStrut(15));
        loginFormPanel.add(loginButton);
        loginFormPanel.add(Box.createVerticalStrut(10));
        loginFormPanel.add(statusLabel);
        loginFormPanel.add(Box.createVerticalStrut(10));
        loginFormPanel.add(switchToSignupButton);

        return loginFormPanel;
    }

}
