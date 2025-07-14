package ui;

import java.util.List;

import model.*;

/*
 * This class contains the method for the user to register the vote
 */

public class Voting {

    public static void addingVote(Poll currentPoll) {
        List<User> pollUsers = currentPoll.getUsers();
        int totalUsers = pollUsers.size();

        for (int index = 0; index < totalUsers; index++) {
            User currentUser = pollUsers.get(index);
            System.out.println("Let's get started " + currentUser.getFirstName());
            for (Option option : currentPoll.getOptions()) {
                boolean status = userVote(option, currentUser);
                while (!status) {
                    ErrorMessages.voteInputs();
                    int vote = CoDecideApp.INPUT.nextInt();
                    status = PollAction.castVote(currentUser, option, vote);
                }
            }

            userChange(currentUser, currentPoll);

            if (index + 1 < currentPoll.getUsers().size()) {
                CoDecideApp.getSession().setRunning(false);

                User nextUser = pollUsers.get(index + 1);
                Messages.nextLogin(nextUser);
                UserLoginServices.login();
            } else {
                CoDecideApp.getSession().setRunning(false);
            }
        }
    }

    public static void userChange(User currentUser, Poll currentPoll) {
        Messages.afterEachUserVoting(currentUser);
        currentPoll.getHasVoted().add(currentUser);
    }

    public static boolean userVote(Option option, User currentUser) {
        InputPrompts.voteInputs(option);
        int vote = CoDecideApp.INPUT.nextInt();
        return PollAction.castVote(currentUser, option, vote);
    }

    public static String calculateResult(Poll currentPoll) {
        InputPrompts.resultOption();
        int choice = CoDecideApp.INPUT.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Only the poll owner can view results.");
                System.out.println("Please proceed to login:");
                boolean isLoggedIn = UserLoginServices.login();
                User loggedInUser = CoDecideApp.getSession().getCurrentUserLoggedIn();
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
                CoDecideApp.getSession().setRunning(false);
                return "Thank you for using the App";
            default:
                return "Failed to load result";
        }
    }
}
