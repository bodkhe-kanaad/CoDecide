package ui;

import model.UserServices;

/*
 * This class will manage all the user services like
 * SignUp , Login , ChangePassword()
 */

public class UserLogin {

    public static void loginStatus() {
        boolean status = userlogin();
        if (status == false) {
            ErrorMessages.userNotLoggedIn();
            userlogin();
        } else {
            Messages.userLoginSuccess();
        }
    }

    public static boolean userlogin() {
        InputPrompts.loginOptionsInputs();
        int choice = CoDecideApp.INPUT.nextInt();
        while (choice != 1 && choice != 2) {
            ErrorMessages.loginOptionsInputs();
            choice = CoDecideApp.INPUT.nextInt();
        }
        switch (choice) {
            case 1:
                return UserLogin.login();
            case 2:
                return UserLogin.signUp();
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
        String status = UserServices.login(username, password);
        switch (status) {
            case "Wrong Username":
                return wrongUserName();
            case "Successfull":
                return true;
            case "Password is incorrect":
                ErrorMessages.passwordInput();
                ErrorMessages.pleaseTryAgain();
                return UserLogin.login();
            default:
                return false;
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
        boolean userNameCheck = UserServices.isUsernameExists(userName);
        while (userNameCheck) {
            ErrorMessages.takeUsername();
            userName = CoDecideApp.INPUT.next();
            userNameCheck = UserServices.isUsernameExists(userName);
        }
        InputPrompts.signUpPasswordInput();
        String password = CoDecideApp.INPUT.next();
        boolean status = UserServices.signUp(firstName, lastName, userName, password);
        if (status) {
            Messages.userSignUpSuccess();
            Messages.postSignUp();
            return login();
        } else {
            return signUp();
        }
    }

    public static boolean wrongUserName() {
        ErrorMessages.wrongUserName();
        ErrorMessages.pleaseTryAgain();
        return login();
    }
}
