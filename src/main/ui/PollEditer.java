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
        for (int choiceOptionInput = 1; choiceOptionInput != 2; numChoices++) {
            InputPrompts.addoptionInput(numChoices);
            String option = CoDecideApp.INPUT.next();
            currentPoll.addOptionToPoll(option);
            InputPrompts.optionInputs();
            int choice = CoDecideApp.INPUT.nextInt();
            while (choice != 2 && choice != 1) { 
                ErrorMessages.optionInputs();
                choice = CoDecideApp.INPUT.nextInt();
            }
            switch (choice) {
                case 1:
                    choiceOptionInput = 1;
                    break;
                case 2:
                    choiceOptionInput = 2;
                    break;
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
            currentPoll.addUserToPoll(UserServices.getAllUsersMap().get(username));
            InputPrompts.userInputs();
            choice = CoDecideApp.INPUT.nextInt(); 
        }
    }
}
