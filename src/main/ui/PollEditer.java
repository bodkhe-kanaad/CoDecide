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
        int choice = 1;
        while (choice != 2) {
            InputPrompts.addoptionInput(numChoices);
            numChoices++;
            String option = CoDecideApp.INPUT.next();
            PollAction.addingUserToPoll(option, currentPoll);

            InputPrompts.optionInputs();
            choice = CoDecideApp.INPUT.nextInt();

            while (choice != 1 && choice != 2) {
                ErrorMessages.optionInputs();
                choice = CoDecideApp.INPUT.nextInt();
            }
        }
    }

    // MODIFIES Poll created by the user in the App
    // EFFECTS Adds User to the poll from user input.

    public static void userAdder(Poll currentPoll) {
        InputPrompts.userInputs();
        int choice = CoDecideApp.INPUT.nextInt();

        while (choice != 0 && choice != 1) {
            ErrorMessages.userInputs();
            choice = CoDecideApp.INPUT.nextInt();
        }

        while (choice == 1) {
            InputPrompts.adduserInput();
            String username = CoDecideApp.INPUT.next();
            boolean status = PollAction.addingUserToPoll(username, currentPoll);
            if (!status) {
                ErrorMessages.noUserExists();
            }
            InputPrompts.userInputs();
            choice = CoDecideApp.INPUT.nextInt();
        }
    }
}
