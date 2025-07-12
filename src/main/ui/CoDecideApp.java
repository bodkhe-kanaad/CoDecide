package ui;

import java.util.Scanner;
import model.*;

public class CoDecideApp {
    private static final Scanner INPUT = new Scanner(System.in);
    public static final double CURRENT_VERSION_NUMBER = 1.0;

    private Session currentSession;
    private boolean isRunning;

    public CoDecideApp(Session currentSession) {
        this.currentSession = currentSession;
        this.isRunning = true;
    }

    private model.User cliVersionUser = model.User.getTestuser();

    public void run() {
        while (isRunning) {
            Messages.welcomeMessage();
            Poll currentPoll = model.Poll.createPoll(cliVersionUser);
            int numChoices = 0;
            for (int choiceOptionInput = 1; choiceOptionInput != 0; numChoices++) {
                System.out.println("What should be Option" + numChoices);
                String option = INPUT.next();
                currentPoll.addOptionToPoll(option);
                InputPromts.optionInputs();
                int choice = INPUT.nextInt();
                while (choice != 0 && choice != 1) { // Later make this into throw an exception
                    ErrorMessages.optionInputs();
                    choice = INPUT.nextInt();
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
            Messages.postAddingOptions();
            int numUsers = 1;
            for (int choiceUserInput = 1; choiceUserInput != 0; numUsers++) {
                System.out.println("Please give the Username for user number" + numUsers);
                String newUserUsername = INPUT.next();
                // Check for if the Username exists later !!! no CLI
                currentPoll.addUserToPoll(cliVersionUser);
                InputPromts.userInputs();
                int choice = INPUT.nextInt();
                while (choice != 0 && choice != 1) { // Later make this into throw an exception
                    ErrorMessages.userInputs();
                    choice = INPUT.nextInt();
                }
                switch (choice) {
                    case 1:
                        choiceUserInput = 1;
                        break;
                    case 0:
                        choiceUserInput = 0;
                        break;
                }
                Messages.postAddingUsers();
                for (User user : currentPoll.getUsers()) {
                    System.out.println("Lets get started" + user.getFirstName());
                    for (Option option : currentPoll.getOptions()) {
                        InputPromts.voteInputs(option);
                        int vote = INPUT.nextInt();
                        while (0 < vote && vote >= 100) { // Later make this into throw an exception
                            option.addVote(vote);
                        }
                    }
                    System.out.println("Thank you" + user.getFirstName());
                }
                Messages.postAddingVotes();
                int highestSoFar = 0;
                String resultOption = "";
                for (Option option : currentPoll.getOptions()) {
                    if (option.getVoteTotal() > highestSoFar) {
                        highestSoFar = option.getVoteTotal();
                        resultOption = option.getValue();
                    }
                }
                Messages.results(resultOption);
            }
        }
    }
}
