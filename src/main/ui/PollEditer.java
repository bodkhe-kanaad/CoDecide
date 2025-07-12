package ui;

import model.*;

public class PollEditer {

    public static void optionAdder(Poll currentPoll) {
        int numChoices = 0;
        for (int choiceOptionInput = 1; choiceOptionInput != 0; numChoices++) {
            System.out.println("What should be Option" + numChoices);
            String option = CoDecideApp.INPUT.next();
            currentPoll.addOptionToPoll(option);
            InputPromts.optionInputs();
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

    public static void userAdder(Poll currentPoll) {
        int numUsers = 1;
        for (int choiceUserInput = 1; choiceUserInput != 0; numUsers++) {
            System.out.println("Please give the Username for user number" + numUsers);
            String newUserUsername = CoDecideApp.INPUT.next();
            // Check for if the Username exists later !!! no CLI
            currentPoll.addUserToPoll(CoDecideApp.cliVersionUser);
            InputPromts.userInputs();
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
