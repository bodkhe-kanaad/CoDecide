package ui.cli;

import java.util.List;

import model.*;
import model.poll.Poll;
import model.poll.PollAction;
import model.user.User;
import ui.cli.messages.*;


/*
 * This class contains the method for the user to register the vote
 */

public class VotingCLI {

    // REQUIRES curretPoll is not Null
    // MODIFIES the poll
    // EFFECTS It adds the vote to Poll's vote total
    public static void addingVote(Poll currentPoll) {
        List<User> pollUsers = currentPoll.getUsers();
        int totalUsers = pollUsers.size();
        for (int i = 0; i < totalUsers; i++) {
            User user = pollUsers.get(i);
            System.out.println("Let's get started " + user.getFirstName());
            for (Option option : currentPoll.getOptions()) {
                handleVoteInput(user, option);
            }
            afterUserVoted(user, currentPoll);
            if (i + 1 < totalUsers) {
                User nextUser = pollUsers.get(i + 1);
                System.out.println(
                        "Let's get started " + nextUser.getFirstName() + " please proceed to login");
                UserServicesCLI.nextUserLogin(nextUser);
            } else {
                CoDecideAppCLI.getSession().setRunning(false);
            }
        }
    }


    // EFFECTS helper method for addingVote
    public static void afterUserVoted(User currentUser, Poll currentPoll) {
        Messages.afterEachUserVoting(currentUser);
        currentPoll.getHasVoted().add(currentUser);
    }

    
    // EFFECTS helper method for addingVote handles the input for vote.
    private static void handleVoteInput(User user, Option option) {
        boolean status = false;
        while (!status) {
            InputPrompts.voteInputs(option);
            int vote = CoDecideAppCLI.INPUT.nextInt();
            status = PollAction.castVote(user, option, vote);
            if (!status) {
                ErrorMessages.voteInputs();
            }
        }
    }

    // MODIFIES the Option
    // EFFECTS On the basis of the input adds the vote to total
    public static boolean userVote(Option option, User currentUser) {
        InputPrompts.voteInputs(option);
        int vote = CoDecideAppCLI.INPUT.nextInt();
        return PollAction.castVote(currentUser, option, vote);
    }

    // EFFECTS calculates the result of the Poll but highest aggregate votes received.
    public static String calculateResult(Poll currentPoll) {
        InputPrompts.resultOption();
        int choice = CoDecideAppCLI.INPUT.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Only the poll owner can view results.");
                System.out.println("Please proceed to login:");
                boolean isLoggedIn = UserServicesCLI.login();
                User loggedInUser = CoDecideAppCLI.getSession().getCurrentUserLoggedIn();
                User owner = currentPoll.getOwner();
                if (isLoggedIn && loggedInUser.equals(owner)) {
                    return "You should all go with " + PollAction.calculateResult(currentPoll);
                } else if (!isLoggedIn) {
                    return "Login failed. Access denied.";
                } else {
                    return "Access denied. Only the poll owner can view results.";
                }
            case 2:
                currentPoll.setCompleted(true);
                //CoDecideApp.getSession().setRunning(false);
                return "Thank you for using the App";
            default:
                return "Failed to load result";
        }
    }
}
