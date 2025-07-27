package ui.cli;

import java.util.List;

import model.poll.Poll;
import model.poll.PollAction;
import model.user.User;
import ui.cli.messages.*;

/*
 * This class has methods related to Poll and its inputs
 */

public class PollServicesCLI {

    // MODIFIES Poll created by the user in the App
    // EFFECTS Adds options to the poll from user input
    public static void optionAdder(Poll currentPoll) {
        int numChoices = 1;
        int choice = 1;
        while (choice != 2) {
            InputPrompts.addoptionInput(numChoices);
            numChoices++;
            String option = CoDecideAppCLI.INPUT.next();
            PollAction.addingOptionToPoll(option, currentPoll);

            InputPrompts.optionInputs();
            choice = CoDecideAppCLI.INPUT.nextInt();

            while (choice != 1 && choice != 2) {
                ErrorMessages.optionInputs();
                choice = CoDecideAppCLI.INPUT.nextInt();
            }
        }
    }

    // MODIFIES Poll created by the user in the App
    // EFFECTS Adds User to the poll from user input.
    public static void userAdder(Poll currentPoll) {
        InputPrompts.userInputs();
        int choice = CoDecideAppCLI.INPUT.nextInt();

        while (choice != 0 && choice != 1) {
            ErrorMessages.userInputs();
            choice = CoDecideAppCLI.INPUT.nextInt();
        }

        while (choice == 1) {
            InputPrompts.adduserInput();
            String username = CoDecideAppCLI.INPUT.next();
            boolean status = PollAction.addingUserToPoll(username, currentPoll);
            if (!status) {
                ErrorMessages.noOrDuplicateUser();
            }
            InputPrompts.userInputs();
            choice = CoDecideAppCLI.INPUT.nextInt();
        }
    }

    // REQUIRES User currentUser is not Null
    // EFFECTS It returns the Polls that need to be printed as a String
    public static String showResultsForUser(User currentUser) {
        List<Poll> ownerForPolls = PollAction.ownershipForPollsAndCompleted(currentUser); // Helper method to get all
                                                                                          // the Polls for
        // which current User is the owner
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
