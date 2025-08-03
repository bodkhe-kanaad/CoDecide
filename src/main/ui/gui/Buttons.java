package ui.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

import ui.gui.screens.LoginScreen;
import ui.gui.screens.SignupScreen;

public class Buttons {

    // EFFECTS edits the button to look same
    public static void styleChoiceButton(JButton button) {
        button.setFocusPainted(false);
        button.setFocusable(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(120, 40));
        button.setFont(new Font("SansSerif", Font.PLAIN, 14));
        button.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
    }

    // EFFECTS makes the button to move to the login screen
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

    // EFFECTS makes the button to login the user
    public static JButton loginButton() {
        JButton loginButton = new JButton("Login");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setActionCommand("LOGIN");
        return loginButton;
    }

    // EFFECTS makes the button to login the user during voting prompting to correct
    // user to login
    public static JButton votingLoginButton() {
        JButton votingloginButton = new JButton("Login");
        votingloginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        votingloginButton.setActionCommand("VOTING LOGIN");
        return votingloginButton;
    }

    // EFFECTS makes the button to login the user after voting prompting to correct
    // user to login
    public static JButton resultLoginButton() {
        JButton resultLoginButton = new JButton("Login");
        resultLoginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultLoginButton.setActionCommand("RESULT LOGIN");
        return resultLoginButton;
    }

    // EFFECTS makes the button to move to the signup screen
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

    // EFFECTS makes the button to signup the screen
    public static JButton signupButton() {
        JButton signupButton = new JButton("Sign Up");
        signupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        signupButton.setMaximumSize(new Dimension(160, 30));
        return signupButton;
    }

    // EFFECTS makes the button to trigger the screen to make a poll
    public static JButton createPollButton() {
        JButton createPollButton = new JButton("Create A Poll");
        createPollButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        return createPollButton;
    }

    // EFFECTS makes the button to trigger the screen to view the polls
    public static JButton viewPastResultsButton() {
        JButton pastResultsButton = new JButton("Past Results");
        pastResultsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pastResultsButton.setActionCommand("PAST RESULTS");
        return pastResultsButton;
    }

    // EFFECTS makes the button to trigger the methods to quit the button
    public static JButton quitApplicationButton() {
        JButton quitApp = new JButton("Quit");
        quitApp.setAlignmentX(Component.CENTER_ALIGNMENT);
        return quitApp;
    }

    // EFFECTS makes the button to signout
    public static JButton signOutButton() {
        JButton signOut = new JButton("Sign Out");
        signOut.setAlignmentX(Component.CENTER_ALIGNMENT);
        return signOut;
    }

    // EFFECTS makes the button to add option
    public static JButton addOptionButton() {
        JButton addOption = new JButton("Add Option");
        addOption.setAlignmentX(Component.CENTER_ALIGNMENT);
        addOption.setActionCommand("ADD OPTION");
        return addOption;
    }

    // EFFECTS makes the button to add User
    public static JButton addUserButton() {
        JButton userButton = new JButton("Add User");
        userButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        userButton.setActionCommand("ADD USER");
        return userButton;
    }

    // EFFECTS makes the button to move towards next step of the poll
    public static JButton nextButton() {
        JButton nextButton = new JButton("Next Step");
        nextButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        nextButton.setActionCommand("NEXT");
        return nextButton;
    }

    // EFFECTS makes the button to submit the votes
    public static JButton submitButton() {
        JButton submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.setActionCommand("SUBMIT");
        return submitButton;
    }

    // EFFECTS makes the button to view results of the poll
    public static JButton viewResultsButton() {
        JButton viewResultsButton = new JButton("View Results");
        viewResultsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewResultsButton.setActionCommand("RESULTS");
        return viewResultsButton;
    }

    // EFFECTS makes the button to open the post login screen keeping the same
    // logged in user
    public static JButton returnToHomeScreenButton() {
        JButton returnToHomeScreenButton = new JButton("Home Screen");
        returnToHomeScreenButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        returnToHomeScreenButton.setActionCommand("RETURN TO HOME");
        return returnToHomeScreenButton;
    }

    // EFFECTS makes the button to log out
    public static JButton logoutButton() {
        JButton logoutButton = new JButton("LogOut");
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutButton.setActionCommand("LOGOUT");
        return logoutButton;
    }

    // EFFECTS: Returns a button that switches from Signup to Login screen
    public static JButton switchToLoginButton(JFrame currentFrame) {
        JButton switchToLoginButton = new JButton("Already have an account?");
        switchToLoginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        switchToLoginButton.setMaximumSize(new Dimension(220, 30));
        switchToLoginButton.setActionCommand("SWITCH TO LOGIN");

        return switchToLoginButton;
    }

    // EFFECTS: Returns a button that switches from Login to Signup screen
    public static JButton switchToSignupButton(JFrame currentFrame) {
        JButton switchToSignupButton = new JButton("Do not have an account ?");
        switchToSignupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        switchToSignupButton.setActionCommand("SWITCH TO SIGNUP");

        return switchToSignupButton;
    }

}
