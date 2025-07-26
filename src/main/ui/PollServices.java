package ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.*;

/*
 * This class has methods related to Poll and its inputs
 */

public class PollServices {

    // MODIFIES Poll created by the user in the App
    // EFFECTS Adds options to the poll from user input
    public static void optionAdder(Poll currentPoll) {
        int numChoices = 1;
        int choice = 1;
        while (choice != 2) {
            InputPrompts.addoptionInput(numChoices);
            numChoices++;
            String option = CoDecideApp.INPUT.next();
            PollAction.addingOptionToPoll(option, currentPoll);

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
                ErrorMessages.noOrDuplicateUser();
            }
            InputPrompts.userInputs();
            choice = CoDecideApp.INPUT.nextInt();
        }
    }

    public static String showResultsForUser(User currentUser) {
        Map<Integer, String> pollResults = new HashMap<>();
        List<String> print = new ArrayList<>();
        List<Poll> ownerForPolls = PollAction.ownershipForPolls(currentUser);
        String allPollsPrint = "";
        if (!ownerForPolls.isEmpty()) {
            for (Poll p : ownerForPolls) {
                allPollsPrint += p.toPrintResult();
            }
        } else {
            return "You are not the owner for any Polls";
        }
        return "Here is the result for all your Past Polls :" + "\n" + allPollsPrint;
    }
}
