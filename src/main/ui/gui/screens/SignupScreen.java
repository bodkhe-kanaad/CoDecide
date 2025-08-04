package ui.gui.screens;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ui.gui.Buttons;
import ui.gui.Components;
import ui.gui.HeaderPanel;
import ui.gui.handlers.SignupHandler;
import ui.gui.handlers.UserServiceHandler;

// Signing up screen

public class SignupScreen extends JFrame {

    private static JLabel usernameLabel = Components.usernameLabel();
    private static JTextField usernameField = Components.usernameField();

    private static JLabel passwordLabel = Components.passwordLabel();
    private static JPasswordField passwordField = Components.passwordField();

    private static JLabel firstnameLabel = Components.firstnameLabel();
    private static JTextField firstnameField = Components.firstnameField();

    private static JLabel lastnameLabel = Components.lastnameLabel();
    private static JTextField lastnameField = Components.lastnameField();

    private static JButton signupButton = Buttons.signupButton();
    private static JLabel statusLabel = Components.statusLabel();

    // EFFECTS makes a screen for the user to signup
    public SignupScreen() {
        setTitle("Let's Sign-Up !!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        add(mainPanel(this));
        setVisible(true);
    }

    // EFFECTS makes a main panel with other components
    private JPanel mainPanel(JFrame signupFrame) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(new HeaderPanel());
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(signupForm(signupFrame));

        return mainPanel;
    }

    // EFFECTS makes the panel with fields and labels to sign up
    // CITATION https://www.youtube.com/watch?v=Gv1mANs_fCA
    private JPanel signupForm(JFrame signupFrame) {
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 20, 40));
        formPanel.setOpaque(false);

        JButton switchToLoginButton = Buttons.switchToLoginButton(signupFrame);
        JPanel buttonPanel = createButtonPanel(signupButton, switchToLoginButton);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 1);

        signupButton.addActionListener(new SignupHandler(usernameField, passwordField, firstnameField, lastnameField,
                statusLabel, signupFrame));
        switchToLoginButton.addActionListener(new UserServiceHandler(signupFrame));

        int row = 0;
        formRow(formPanel, gbc, row++, firstnameLabel, firstnameField);
        formRow(formPanel, gbc, row++, lastnameLabel, lastnameField);
        formRow(formPanel, gbc, row++, usernameLabel, usernameField);
        formRow(formPanel, gbc, row++, passwordLabel, passwordField);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        formPanel.add(buttonPanel, gbc);
        gbc.gridy++;
        formPanel.add(statusLabel, gbc);

        return formPanel;
    }

    // EFFECTS creates the buttons on the signup screen
    private JPanel createButtonPanel(JButton signupButton, JButton switchToLoginButton) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        signupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        switchToLoginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(signupButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(switchToLoginButton);
        return buttonPanel;
    }

    // EFFECTS makes rows of fields and labels needed for signup details
    private void formRow(JPanel panel, GridBagConstraints gbc, int row,
            JLabel label, JComponent field) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        panel.add(field, gbc);
    }
}