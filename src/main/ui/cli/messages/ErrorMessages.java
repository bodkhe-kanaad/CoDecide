package ui.cli.messages;

/* 
 * This class is all Messages printed for Errors or invalid inputs
*/
public class ErrorMessages {

    public static void optionInputs() {
        System.out.println("Invalid input Press (1) to add other option Or (0) To move on");
    }

    public static void userInputs() {
        System.out.println("Invalid input Press (1) to add other option Or (0) To move on");
    }

    public static void voteInputs() {
        System.out.println("Invalid input, choose a number from 0 to 100");
    }

    public static void loginOptionsInputs() {
        System.out.println("Invalid input choose (1) Login or (2) Signup");
    }

    public static void failedLoginOptions() {
        System.out.println("Login/Signup Failed Rerun App");
    }

    public static void userNotLoggedIn() {
        System.out.println("Please proceed with login");
    }

    public static void passwordInput() {
        System.out.println("The Password is Incorrect");
    }

    public static void takeUsername() {
        System.out.println("This username is taken choose another");
    }

    public static void wrongUserName() {
        System.out.println("This Username is incorrect");
    }
    
    public static void pleaseTryAgain() {
        System.out.println("Please try again");
    }

    public static void noOrDuplicateUser()   {
        System.out.println("There is no User with this Username");
        System.out.println("Or User is already a part of the Poll");
    }
}