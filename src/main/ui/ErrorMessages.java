package ui;

public class ErrorMessages {

    public static final void optionInputs() {
        System.out.println("Invalid input Press (1) to add other option Or (0) To move on");
    }

    public static final void userInputs() {
        System.out.println("Invalid input Press (1) to add other option Or (0) To move on");
    }

    public static final void voteInputs() {
        System.out.println("Invalid input choose a number from 1 to 100");
    }

    public static final void loginOptionsInputs() {
        System.out.println("Invalid input choose (1) Login or (2) Signup");
    }

    public static final void failedLoginOptions() {
        System.out.println("Login/Signup Failed Rerun App");
    }

    public static final void userNotLoggedIn() {
        System.out.println("Please proceed with login");
    }

    public static final void passwordInput() {
        System.out.println("The Password is Incorrect");
    }

    public static final void takeUsername() {
        System.out.println("This username is taken choose another");
    }

    public static final void wrongUserName() {
        System.out.println("This Username is incorrect");
    }
    
    public static final void pleaseTryAgain() {
        System.out.println("Please try again");
    }

    public static final void noUserExists()   {
        System.out.println("There is no User with this Username");
    }
}