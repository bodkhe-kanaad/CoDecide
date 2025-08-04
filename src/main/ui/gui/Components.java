package ui.gui;

import javax.swing.*;
import java.awt.*;

// Non button components used in the screen

public class Components {

    // EFFECTS background color of app
    public static Color backgroundColor() {
        return new Color(240, 240, 240);
    }

    // EFFECTS version number of the app
    public static String versionNumber() {
        return "3.0";
    }

    // EFFECTS color for the status labels
    public static Color statusColor() {
        return Color.RED;
    }

    // EFFECTS large logo for the welcome screen
    public static JLabel largeLogo() {
        JLabel logo = new JLabel("🗳️", SwingConstants.CENTER);
        logo.setFont(new Font("SansSerif", Font.PLAIN, 60));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        return logo;
    }

    // EFFECTS small logo for the header
    public static JLabel smallLogo() {
        JLabel logo = new JLabel("🗳️");
        logo.setFont(new Font("SansSerif", Font.PLAIN, 30));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        return logo;
    }

    // EFFECTS large title for the welcome screen
    public static JLabel largeTitle() {
        JLabel title = new JLabel("Welcome to CoDecide " + Components.versionNumber());
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        return title;
    }

    // EFFECTS large subtitle for the welcome screen
    public static JLabel largeSubTitle() {
        JLabel subtitle = new JLabel("The Smarter Way To Find Common Ground");
        subtitle.setFont(new Font("SansSerif", Font.ITALIC, 16));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        return subtitle;
    }

    // EFFECTS small subtitle for the header
    public static JLabel smallSubtitle() {
        JLabel label = new JLabel("The Smarter Way To Find Common Ground");
        label.setFont(new Font("SansSerif", Font.ITALIC, 10));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    // EFFECTS slider for the voting
    public static JSlider optionVotingSlider() {
        JSlider slider = new JSlider(0, 100, 0);
        slider.setMajorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        slider.setPreferredSize(new Dimension(500, 50));
        return slider;
    }

    // EFFECTS label for username
    public static JLabel usernameLabel() {
        JLabel usernameLabel = new JLabel("Username :");
        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return usernameLabel;
    }

    // EFFECTS title for the post login screen
    public static JLabel displayPostLogin() {
        JLabel displayMessage = new JLabel("What would you like to do today, "
                + CoDecideAppGUI.getSession().getCurrentUserLoggedIn().getFirstName()
                + "?");
        displayMessage.setFont(new Font("SansSerif", Font.PLAIN, 20));
        displayMessage.setAlignmentX(Component.CENTER_ALIGNMENT);

        return displayMessage;
    }

    // EFFECTS display for the result screen
    public static JLabel resultLabel(String result) {
        JLabel resultMessage = new JLabel("You all should go with the option " + "\n"
                + result);
        resultMessage.setFont(new Font("SansSerif", Font.PLAIN, 20));
        resultMessage.setAlignmentX(Component.CENTER_ALIGNMENT);

        return resultMessage;
    }

    // EFFECTS field for the username input
    public static JTextField usernameField() {
        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(200, 25));
        usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        return usernameField;
    }

    // EFFECTS label for the password
    public static JLabel passwordLabel() {
        JLabel passwordLabel = new JLabel("Password :");
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        return passwordLabel;
    }

    // EFFECTS field for the password input
    public static JPasswordField passwordField() {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 25));
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);

        return passwordField;
    }

    // EFFECTS label for the firstname
    public static JLabel firstnameLabel() {
        JLabel firstnameLabel = new JLabel("Firstname :");
        firstnameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return firstnameLabel;
    }

    // EFFECTS label for displaying the firstname or logged in user
    public static JLabel firstnameVotingDisplay(String firstname) {
        JLabel firstnameVotingDisplay = new JLabel("Please proceed to vote " + firstname);
        firstnameVotingDisplay.setAlignmentX(Component.CENTER_ALIGNMENT);
        return firstnameVotingDisplay;
    }

    // EFFECTS label for displaying the firstname or logged in user
    public static JLabel firstnameLoginDisplay(String firstname) {
        JLabel firstnameVotingDisplay = new JLabel("Please proceed to Login " + firstname);
        firstnameVotingDisplay.setAlignmentX(Component.CENTER_ALIGNMENT);
        return firstnameVotingDisplay;
    }

    // EFFECTS label for displaying the option value
    public static JLabel optionValueDisplayLabel(String value) {
        JLabel optionDisplay = new JLabel(value);
        optionDisplay.setAlignmentX(Component.CENTER_ALIGNMENT);
        return optionDisplay;
    }

    // EFFECTS field for inputing the firstname
    public static JTextField firstnameField() {
        JTextField firstnameField = new JTextField();
        firstnameField.setPreferredSize(new Dimension(200, 25));
        firstnameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        return firstnameField;
    }

    // EFFECTS label for lastname
    public static JLabel lastnameLabel() {
        JLabel lastnameLabel = new JLabel("Lastname :");
        lastnameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return lastnameLabel;
    }

    // EFFECTS label for the pollId
    public static JLabel pollIdLabel(int pollID) {
        JLabel pollIdLabel = new JLabel("Poll ID : " + pollID);
        pollIdLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return pollIdLabel;
    }

    // EFFECTS label for the polls result
    public static JLabel pollResultLabel(String result) {
        JLabel pollResultLabel = new JLabel("Result Option : " + result);
        pollResultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return pollResultLabel;
    }

    // EFFECTS label for when no polls are available
    public static JLabel noResultsLabel() {
        JLabel noResultsLabel = new JLabel("You are not the owner for any completed polls");
        noResultsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return noResultsLabel;
    }

    // EFFECTS field for lastname input
    public static JTextField lastnameField() {
        JTextField lastnameField = new JTextField();
        lastnameField.setPreferredSize(new Dimension(200, 25));
        lastnameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        return lastnameField;
    }

    // EFFECTS label for adding option
    public static JLabel addOptionLabel() {
        JLabel addOptionLabel = new JLabel("Option :");
        addOptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return addOptionLabel;
    }

    // EFFECT field for the option input
    public static JTextField addOptionField() {
        JTextField addOptionField = new JTextField();
        addOptionField.setPreferredSize(new Dimension(200, 25));
        addOptionField.setAlignmentX(Component.CENTER_ALIGNMENT);

        return addOptionField;
    }

    // EFFECTS label for username
    public static JLabel addUserLabel() {
        JLabel addUserLabel = new JLabel("Username :");
        addUserLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return addUserLabel;
    }

    // EFFECTS field for usernameInput
    public static JTextField addUserField() {
        JTextField addUserField = new JTextField();
        addUserField.setPreferredSize(new Dimension(200, 25));
        addUserField.setAlignmentX(Component.CENTER_ALIGNMENT);
        return addUserField;
    }

    // EFFECTS status label
    public static JLabel statusLabel() {
        JLabel statusLabel = new JLabel(" ");
        statusLabel.setForeground(Components.statusColor());
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        return statusLabel;
    }

}
