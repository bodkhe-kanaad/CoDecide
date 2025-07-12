package ui;

import model.User;

public class Messages {

    public static final void welcomeMessage() {
        System.out.println("Welcome to CoDecide"
                + ui.CoDecideApp.CURRENT_VERSION_NUMBER + "The The smarter way to find common ground");
        System.out.println("Let's proceed with making a Poll");
    }

    public static final void postAddingOptions() {
        System.out.println("Thank you for adding the options");
        System.out.println("Lets get started with adding desired users to the Poll");
    }

    public static final void postAddingUsers() {
        System.out.println("Thank you for adding the User's lets get to Voting");
    }

    public static final void postAddingVotes() {
        System.out.println("Thank you all for giving your votes");
    }

    public static final void results(String resultOption) {
        System.out.println("You all should go with" + resultOption);
    }

    public static final void afterEachUserVoting(User user) {
        System.out.println("Thank you" + user.getFirstName());
    }
}
