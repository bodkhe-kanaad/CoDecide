package ui;

import model.Session;
import model.User.User;
import model.User.UserAction;
import ui.Messages.Messages;
import ui.Messages.ErrorMessages;
import ui.Messages.InputPrompts;


/*
 * This class will manage all the user services like
 * SignUp , Login , ChangePassword()
 */

public class UserServices {

    // EFFECTS checks the status of login making sure no one can use the app without logging in
    public static void loginStatus() {
        boolean status = promptLoginChoice();
        if (status == false) {
            ErrorMessages.userNotLoggedIn();
            promptLoginChoice();
        } else {
            Messages.userLoginSuccess();
        }
    }

    // EFFECTS prompting the user to login
    public static boolean promptLoginChoice() {
        InputPrompts.loginOptionsInputs();
        int choice = CoDecideApp.INPUT.nextInt();
        while (choice != 1 && choice != 2) {
            ErrorMessages.loginOptionsInputs();
            choice = CoDecideApp.INPUT.nextInt();
        }
        switch (choice) {
            case 1:
                return UserServices.login();
            case 2:
                return UserServices.signUp();
            default:
                ErrorMessages.failedLoginOptions();
                return false;
        }

    }

    // EFFECTS accepting inputs and passing them to Login UserAction
    public static boolean login() {
        InputPrompts.usernameInput();
        String username = CoDecideApp.INPUT.next();
        InputPrompts.passwordInput();
        String password = CoDecideApp.INPUT.next();
        Session session = UserAction.login(username, password);
        if (session != null) {
            CoDecideApp.setSession(session);
            return true;
        } else {
            return wrongCredentials();
        }
    }

    // EFFECTS accepting inputs and passing them to signup UserAction
    public static boolean signUp() {
        Messages.userSignupSelected();
        InputPrompts.firstNameInput();
        String firstName = CoDecideApp.INPUT.next();
        InputPrompts.lastNameInput();
        String lastName = CoDecideApp.INPUT.next();
        InputPrompts.signupUsernameInput();
        String userName = CoDecideApp.INPUT.next();
        boolean userNameCheck = UserAction.getAllUsersMap().containsKey(userName);
        while (userNameCheck) {
            ErrorMessages.takeUsername();
            userName = CoDecideApp.INPUT.next();
            userNameCheck = UserAction.getAllUsersMap().containsKey(userName);
        }
        InputPrompts.signUpPasswordInput();
        String password = CoDecideApp.INPUT.next();
        boolean status = UserAction.signUp(firstName, lastName, userName, password);
        if (status) {
            Messages.userSignUpSuccess();
            Messages.postSignUp();
            return login();
        } else {
            return signUp();
        }
    }

    //EFFECTS Helper method for login
    public static boolean wrongCredentials() {
        ErrorMessages.pleaseTryAgain();
        return login();
    }

    // REQUIRES nextUser is not null
    // EFFECTS checks if the next User logging in is the User we intended and not someone else with valid credentials 
    public static void nextUserLogin(User nextUser) {
        CoDecideApp.getSession().setRunning(false);
        while (true) {
            boolean loginSuccess = UserServices.login();
            if (!loginSuccess) {
                System.out.println("Login failed. Please try again.");
                continue;
            }
            User currentUser = CoDecideApp.getSession().getCurrentUserLoggedIn();
            if (currentUser.equals(nextUser)) {
                break;
            } else {
                System.out.println("Incorrect user " + nextUser.getFirstName() + " please proceed to login");
            }
        }
    }
}
