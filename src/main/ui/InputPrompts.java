package ui;

/*
 * Class for all input prompts
 */

import model.*;
public class InputPrompts {

    public static final void optionInputs() {
        System.out.println("Press (1) to add other option Or (2) To move on");
    }

    public static final void userInputs() {
        System.out.println("Press (1) to add other user Or (2) To move on");
    }

    public static final void adduserInput() {
        System.out.println("Please give the Username for the User to be added");
    }

    public static final void addoptionInput(int numChoices) {
        System.out.println("What should be Option" + " " + numChoices);
    }

    public static final void voteInputs(Option option) {
        System.out.println("Please select a value on a scale from 0 to 100");
        System.out.println("where 0 means 'least preferred' and 100 means 'most preferred'.");
        System.out.println("For the Option " + option.getValue());
    }

    public static final void loginOptionsInputs() {
        System.out.println("Press (1) Login or (2) Signup");
    }

    public static final void usernameInput() {
        System.out.println("What is your Username");
    }

    public static final void passwordInput() {
        System.out.println("What is your Password");
    }

    public static final void firstNameInput() {
        System.out.println("What is your First Name");
    }

    public static final void lastNameInput() {
        System.out.println("What is your Last Name");
    }

    public static final void signupUsernameInput() {
        System.out.println("What would you like as your Username");
    }

    public static final void signUpPasswordInput() {
        System.out.println("What would you like as your Password");
    }

    public static final void reEnterUsername() {
        System.out.println("Please enter your Username Again");
    }

    public static final void resultOption() {
        System.out.println("Do you want to calculate the result");
        System.out.println("Press (1) Calculate or (2) Quit Poll ");
    }

}
