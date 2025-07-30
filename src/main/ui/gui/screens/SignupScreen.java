package ui.gui.screens;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

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
import ui.gui.handlers.SignupHandler;

public class SignupScreen extends JFrame {

    //TODO
    public SignupScreen() {
        setTitle("Let's Sign-Up !!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        add(mainPanel(this));
        setVisible(true);
    }

    // TODO
    private JPanel mainPanel(JFrame signupFrame) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(new HeaderPanel());
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(signupForm(signupFrame));

        return mainPanel;
    }

    // TODO
    private JPanel signupForm(JFrame signupFrame) {
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 20, 40));
        formPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        // gbc.fill = GridBagConstraints.HORIZONTAL;
        // gbc.weightx = 1.0;

        JButton signupButton = Components.signupButton();
        JButton switchToLoginButton = Components.switchToLoginButton(signupFrame);
        signupButton.setMaximumSize(new Dimension(160, 30));
        switchToLoginButton.setMaximumSize(new Dimension(220, 30));
        signupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        switchToLoginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameLabel = Components.usernameLabel();
        JTextField usernameField = Components.usernameField();

        JLabel passwordLabel = Components.passwordLabel();
        JPasswordField passwordField = Components.passwordField();

        JLabel firstnameLabel = Components.firstnameLabel();
        JTextField firstnameField = Components.firstnameField();

        JLabel lastnameLabel = Components.lastnameLabel();
        JTextField lastnameField = Components.lastnameField();

        JLabel statusLabel = Components.statusLabel();

        signupButton.addActionListener(new SignupHandler(usernameField, passwordField, firstnameField, lastnameField,
                statusLabel, signupFrame));

        // Firstname
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(firstnameLabel, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        formPanel.add(firstnameField, gbc);

        // Lastname
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(lastnameLabel, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        formPanel.add(lastnameField, gbc);

        // Username
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        formPanel.add(usernameField, gbc);

        // Password
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        formPanel.add(passwordField, gbc);

        // Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        signupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        switchToLoginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(signupButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(switchToLoginButton);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        formPanel.add(buttonPanel, gbc);

        // Status message
        gbc.gridy++;
        formPanel.add(statusLabel, gbc);

        return formPanel;
    }
}