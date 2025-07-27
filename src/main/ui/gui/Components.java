package ui.gui;

import javax.swing.*;

import ui.gui.screens.LoginScreen;
import ui.gui.screens.SignupScreen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Components {

    // TODO
    public static JLabel largeLogo() {
        JLabel logo = new JLabel("🗳️", SwingConstants.CENTER);
        logo.setFont(new Font("SansSerif", Font.PLAIN, 60));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        return logo;
    }

    // TODO
    public static JLabel smallLogo() {
        JLabel logo = new JLabel("🗳️");
        logo.setFont(new Font("SansSerif", Font.PLAIN, 30));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        return logo;
    }

    // TODO
    public static JLabel largeTitle() {
        JLabel title = new JLabel("Welcome to CoDecide " + Constants.versionNumber());
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        return title;
    }

    // TODO
    public static JLabel largeSubTitle() {
        JLabel subtitle = new JLabel("The Smarter Way To Find Common Ground");
        subtitle.setFont(new Font("SansSerif", Font.ITALIC, 16));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        return subtitle;
    }

    // TODO
    public static JLabel smallSubtitle() {
        JLabel label = new JLabel("The Smarter Way To Find Common Ground");
        label.setFont(new Font("SansSerif", Font.ITALIC, 10));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    // TODO
    public static void styleChoiceButton(JButton button) {
        button.setFocusPainted(false);
        button.setFocusable(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(120, 40));
        button.setFont(new Font("SansSerif", Font.PLAIN, 14));
        button.setMargin(new Insets(8, 16, 8, 16));
        button.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
    }

    // TODO
    public static JButton loginChoiceButton(JFrame currentFrame) {
        JButton loginButton = new JButton("Login");
        styleChoiceButton(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
                new LoginScreen();
            }
        });
        return loginButton;
    }

    // TODO
    public static JButton loginButton() {
        JButton loginButton = new JButton("Login");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        return loginButton;
    }

    // TODO
    public static JButton signupChoiceButton(JFrame currentFrame) {
        JButton signupButton = new JButton("Sign Up");
        styleChoiceButton(signupButton);
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
                new SignupScreen();
            }
        });
        return signupButton;
    }

    // TODO
    public static JButton signupButton() {
        JButton signupButton = new JButton("Sign Up");
        signupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        return signupButton;
    }

    // TODO
    public static JButton createPollButton() {
        JButton createPollButton = new JButton("Create A Poll");
        createPollButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        return createPollButton;
    }

    // TODO
    public static JButton viewPastResultsButton() {
        JButton pastResultsButton = new JButton("Past Results");
        pastResultsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        return pastResultsButton;
    }

    // TODO
    public static JButton quitApplicationButton() {
        JButton quitApp = new JButton("Quit");
        quitApp.setAlignmentX(Component.CENTER_ALIGNMENT);
        return quitApp;
    }

    // TODO
    public static JButton signOutButton() {
        JButton signOut = new JButton("Sign Out");
        signOut.setAlignmentX(Component.CENTER_ALIGNMENT);
        return signOut;
    }

    // TODO
    public static JLabel usernameLabel() {
        JLabel usernameLabel = new JLabel("Username :");
        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return usernameLabel;
    }

    // TODO
    public static JTextField usernameField() {
        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(200, 25));
        usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        return usernameField;
    }

    // TODO
    public static JLabel passwordLabel() {
        JLabel passwordLabel = new JLabel("Password :");
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        return passwordLabel;
    }

    // TODO
    public static JPasswordField passwordField() {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 25));
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);

        return passwordField;
    }

    // TODO
    public static JLabel firstnameLabel() {
        JLabel firstnameLabel = new JLabel("Firstname :");
        firstnameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return firstnameLabel;
    }

    // TODO
    public static JTextField firstnameField() {
        JTextField firstnameField = new JTextField();
        firstnameField.setPreferredSize(new Dimension(200, 25));
        firstnameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        return firstnameField;
    }

    // TODO
    public static JLabel lastnameLabel() {
        JLabel lastnameLabel = new JLabel("Lastname :");
        lastnameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return lastnameLabel;
    }

    // TODO
    public static JTextField lastnameField() {
        JTextField lastnameField = new JTextField();
        lastnameField.setPreferredSize(new Dimension(200, 25));
        lastnameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        return lastnameField;
    }

    // REQUIRES: JFrame currentFrame is not null
    // EFFECTS: Returns a button that switches from Signup to Login screen
    public static JButton switchToLoginButton(JFrame currentFrame) {
        JButton loginButton = new JButton("Already have an account?");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
                new LoginScreen();
            }
        });

        return loginButton;
    }

    // REQUIRES: JFrame currentFrame is not null
    // EFFECTS: Returns a button that switches from Login to Signup screen
    public static JButton switchToSignupButton(JFrame currentFrame) {
        JButton signupButton = new JButton("Would you like to Signup ?");
        signupButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
                new LoginScreen();
            }
        });

        return signupButton;
    }

}
