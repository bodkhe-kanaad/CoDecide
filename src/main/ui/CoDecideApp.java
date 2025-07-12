package ui;

import java.util.Scanner;
import model.*;

public class CoDecideApp {
    private static final Scanner INPUT = new Scanner(System.in);
    private static final double CURRENT_VERSION_NUMBER = 1.0;

    private Session currentSession;
    private boolean isRunning;

    public CoDecideApp(Session currentSession) {
        this.currentSession = currentSession;
        this.isRunning = true;
    }

    private model.User cliVersionUser = model.User.getTestuser();

    public void run() {
        while (isRunning) {
            System.out.println("Welcome to CoDecide"
                    + ui.CoDecideApp.CURRENT_VERSION_NUMBER + "The The smarter way to find common ground");
            System.out.println("Let's proceed with making a Poll");
            Poll currentPoll = model.Poll.createPoll(cliVersionUser);
            int numChoices = 0;
            for (int choiceOptionInput = 1; choiceOptionInput != 0; numChoices++) {
                System.out.println("What should be Option" + numChoices);
                String option = INPUT.next();
                currentPoll.addOptionToPoll(option);
                System.out.println("Press (1) to add other option Or (0) To move on");
                int choice = INPUT.nextInt();
                while (choice != 0 && choice != 1) {            // Later make this into throw an exception
                    System.out.println("Invalid input Press (1) to add other option Or (0) To move on");
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
            System.out.println("Thank you for adding the options");
            System.out.println("Lets get started with adding desired users to the Poll");
            int numUsers = 1;
            for (int choiceUserInput = 1; choiceUserInput != 0; numUsers++) {
                System.out.println("Please give the Username for user number" + numUsers);
                String newUserUsername = INPUT.next();
                // Check for if the Username exists later !!! no CLI
                currentPoll.addUserToPoll(cliVersionUser);
                System.out.println("Press (1) to add other Users Or (0) To move on");
                int choice = INPUT.nextInt();
                while (choice != 0 && choice != 1) {            // Later make this into throw an exception
                    System.out.println("Invalid input Press (1) to add other option Or (0) To move on");
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
                System.out.println("Thank you for adding the User's lets get to Voting");
                for (User user : currentPoll.getUsers()) {
                    System.out.println("Lets get started" + user.getFirstName());
                    for (Option option : currentPoll.getOptions()) {
                        System.out.println("Please select a value on a scale from 1 to 100");
                        System.out.println("where 1 means least wanted and 100 means most wanted.");
                        System.out.println("For the Option" + option.getValue());
                        int vote = INPUT.nextInt();                                 
                        while (0 < vote && vote >= 100) {           // Later make this into throw an exception
                            option.addVote(vote);
                        }
                    }
                    System.out.println("Thank you" + user.getFirstName());
                }
                System.out.println("Thank you all for giving your votes");
                int highestSoFar = 0;
                String resultOption = "";
                for (Option option : currentPoll.getOptions()) {
                    if (option.getVoteTotal() > highestSoFar) {
                        highestSoFar = option.getVoteTotal();
                        resultOption = option.getValue();
                    }
                }
                System.out.println("You all should go with" + resultOption);
            }
        }
    }
}
