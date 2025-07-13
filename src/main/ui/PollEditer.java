package ui;

import model.*;

/*
 * This class has methods related to adding options and users to the poll
 */

public class PollEditer {

    // MODIFIES Poll created by the user in the App
    // EFFECTS Adds options to the poll from user input
    public static void optionAdder(Poll currentPoll) {
        int numChoices = 1;
        for (int choiceOptionInput = 1; choiceOptionInput != 0; numChoices++) {
            System.out.println("What should be Option" + " " + numChoices);
            String option = CoDecideApp.INPUT.next();
            currentPoll.addOptionToPoll(option);
            InputPrompts.optionInputs();
            int choice = CoDecideApp.INPUT.nextInt();
            while (choice != 0 && choice != 1) { // Later make this into throw an exception
                ErrorMessages.optionInputs();
                choice = CoDecideApp.INPUT.nextInt();
            }
            switch (choice) {
                case 1:
                    choiceOptionInput = 1;
                    break;
                case 0:
                    choiceOptionInput = 0;
                    break;
            }
        }
    }
    // MODIFIES Poll created by the user in the App
    // EFFECTS Adds User to the poll from user input.

    public static void userAdder(Poll currentPoll) {
        int numUsers = 1;
        for (int choiceUserInput = 1; choiceUserInput != 0; numUsers++) {
            System.out.println("Please give the Username for the number " + numUsers + " User");
            // String newUserUsername = CoDecideApp.INPUT.next();
            // Check for if the Username exists later !!! 
            currentPoll.addUserToPoll(User.getCliVersionUser());
            InputPrompts.userInputs();
            int choice = CoDecideApp.INPUT.nextInt();
            while (choice != 0 && choice != 1) { // Later make this into throw an exception
                ErrorMessages.userInputs();
                choice = CoDecideApp.INPUT.nextInt();
            }
            switch (choice) {
                case 1:
                    choiceUserInput = 1;
                    break;
                case 0:
                    choiceUserInput = 0;
                    break;
            }
        }
    }
    
}
