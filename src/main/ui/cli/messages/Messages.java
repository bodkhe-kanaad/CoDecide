package ui.cli.messages;

import model.user.User;

public class Messages {

    public static void welcomeMessage() {
        System.out.println("Welcome to CoDecide "
                + ui.cli.CoDecideAppCLI.CURRENT_VERSION_NUMBER);
        System.out.println("The smarter way to find common ground");
    }

    public static void postAddingOptions() {
        System.out.println("Thank you for adding the options");
        System.out.println("Lets get started with adding desired users to the Poll");
    }

    public static void postAddingUsers() {
        System.out.println("Thank you for adding the User's");
        System.out.println("lets get to Voting");
    }

    public static void postAddingVotes() {
        System.out.println("Thank you all for giving your votes");
    }

    public static void results(String resultOption) {
        System.out.println(resultOption);
    }

    public static void afterEachUserVoting(User user) {
        System.out.println("Thank you " + user.getFirstName());
    }

    public static void userLoginSuccess() {
        System.out.println("Login Successful");
    }
    
    public static void userLoginSelected() {
        System.out.println("Thank you for choosing to Login");
    }

    public static void userSignupSelected() {
        System.out.println("Thank you for choosing to SignUp");
    }

    public static void userSignUpSuccess() {
        System.out.println("SignUp Succesful");
    }

    public static void postSignUp() {
        System.out.println("Please proceed to login");
    }

    public static void postLogin() {
        System.out.println("Thank you for Logging in");
        System.out.println("Lets get started with making the Poll");
    }

    public static void nextLogin(User user) {
        System.out.println("You " + user.getFirstName() + " are up next");
        System.out.println("Please proceed to login");
    }

    public static void printAllPollResults(String allPolls) {
        System.out.println(allPolls);
    }

}

