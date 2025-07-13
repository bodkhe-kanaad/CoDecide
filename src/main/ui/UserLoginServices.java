package ui;

import model.Session;
import model.UserAction;

/*
 * This class will manage all the user services like
 * SignUp , Login , ChangePassword()
 */

public class UserLoginServices {

    public static void loginStatus() {
        boolean status = promptLoginChoice();
        if (status == false) {
            ErrorMessages.userNotLoggedIn();
            promptLoginChoice();
        } else {
            Messages.userLoginSuccess();
        }
    }

    public static boolean promptLoginChoice() {
        InputPrompts.loginOptionsInputs();
        int choice = CoDecideApp.INPUT.nextInt();
        while (choice != 1 && choice != 2) {
            ErrorMessages.loginOptionsInputs();
            choice = CoDecideApp.INPUT.nextInt();
        }
        switch (choice) {
            case 1:
                return UserLoginServices.login();
            case 2:
                return UserLoginServices.signUp();
            default:
                ErrorMessages.failedLoginOptions();
                return false;
        }

    }

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

    public static boolean wrongCredentials() {
        ErrorMessages.pleaseTryAgain();
        return login();
    }
}
