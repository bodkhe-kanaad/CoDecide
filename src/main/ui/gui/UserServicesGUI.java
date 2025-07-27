package ui.gui;

import model.Session;
import model.user.User;
import model.user.UserAction;
import ui.cli.CoDecideAppCLI;
import ui.cli.messages.ErrorMessages;
import ui.cli.messages.InputPrompts;

/*
* This class will manage all the user services like
* SignUp , Login , ChangePassword()
 */

public class UserServicesGUI {

    // TODO
    public static Session login(String username, String password) {
        Session session = UserAction.login(username, password);
        if (session != null) {
            CoDecideAppGUI.setSession(session);
            return session;
        } else {
            return null;
        }
    }

    //TODO
    public static boolean signup(String firstName, String lastName, String userName, String password) {
        return UserAction.signUp(firstName, lastName, userName, password);
    }

    // public class UserServicesCLI {
    // public static void loginStatus() {
    // boolean status = promptLoginChoice();
    // if (status == false) {
    // ErrorMessages.userNotLoggedIn();
    // promptLoginChoice();
    // } else {
    // Messages.userLoginSuccess();
    // }
    // }

    // // EFFECTS prompting the user to login
    // public static boolean promptLoginChoice() {
    // InputPrompts.loginOptionsInputs();
    // int choice = CoDecideAppCLI.INPUT.nextInt();
    // while (choice != 1 && choice != 2) {
    // ErrorMessages.loginOptionsInputs();
    // choice = CoDecideAppCLI.INPUT.nextInt();
    // }
    // switch (choice) {
    // case 1:
    // return UserServicesCLI.login();
    // case 2:
    // return UserServicesCLI.signUp();
    // default:
    // ErrorMessages.failedLoginOptions();
    // return false;
    // }

    // }

    // // EFFECTS accepting inputs and passing them to Login UserAction
    // public static boolean login() {
    // InputPrompts.usernameInput();
    // String username = CoDecideAppCLI.INPUT.next();
    // InputPrompts.passwordInput();
    // String password = CoDecideAppCLI.INPUT.next();
    // Session session = UserAction.login(username, password);
    // if (session != null) {
    // CoDecideAppCLI.setSession(session);
    // return true;
    // } else {
    // return wrongCredentials();
    // }
    // }

    // // EFFECTS accepting inputs and passing them to signup UserAction
    // public static boolean signUp() {
    // Messages.userSignupSelected();
    // InputPrompts.firstNameInput();
    // String firstName = CoDecideAppCLI.INPUT.next();
    // InputPrompts.lastNameInput();
    // String lastName = CoDecideAppCLI.INPUT.next();
    // InputPrompts.signupUsernameInput();
    // String userName = CoDecideAppCLI.INPUT.next();
    // boolean userNameCheck = UserAction.getAllUsersMap().containsKey(userName);
    // while (userNameCheck) {
    // ErrorMessages.takeUsername();
    // userName = CoDecideAppCLI.INPUT.next();
    // userNameCheck = UserAction.getAllUsersMap().containsKey(userName);
    // }
    // InputPrompts.signUpPasswordInput();
    // String password = CoDecideAppCLI.INPUT.next();
    // boolean status = UserAction.signUp(firstName, lastName, userName, password);
    // if (status) {
    // Messages.userSignUpSuccess();
    // Messages.postSignUp();
    // return login();
    // } else {
    // return signUp();
    // }
    // }

    // // EFFECTS Helper method for login
    // public static boolean wrongCredentials() {
    // ErrorMessages.pleaseTryAgain();
    // return login();
    // }

    // // REQUIRES nextUser is not null
    // // EFFECTS checks if the next User logging in is the User we intended and not
    // // someone else with valid credentials
    // public static void nextUserLogin(User nextUser) {
    // CoDecideAppCLI.getSession().setRunning(false);
    // while (true) {
    // boolean loginSuccess = UserServicesCLI.login();
    // if (!loginSuccess) {
    // System.out.println("Login failed. Please try again.");
    // continue;
    // }
    // User currentUser = CoDecideAppCLI.getSession().getCurrentUserLoggedIn();
    // if (currentUser.equals(nextUser)) {
    // break;
    // } else {
    // System.out.println("Incorrect user " + nextUser.getFirstName() + " please
    // proceed to login");
    // }
    // }
    // }
    // }

}
