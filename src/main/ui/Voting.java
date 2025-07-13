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
            // for (User user : currentPoll.getUsers()) {
            // System.out.println("Lets get started " + user.getFirstName());
            // System.out.println("DEBUG: Options size = " +
            // currentPoll.getOptions().size());

            for (Option option : currentPoll.getOptions()) {
                InputPrompts.voteInputs(option);
                int vote = CoDecideApp.INPUT.nextInt();
                boolean status = PollAction.castVote(currentUser, option, vote);

                while (!status) {
                    ErrorMessages.voteInputs();
                    vote = CoDecideApp.INPUT.nextInt();
                    status = PollAction.castVote(currentUser, option, vote);
                }
            }

            Messages.afterEachUserVoting(currentUser);
            currentPoll.getHasVoted().add(currentUser);
            if (index + 1 < currentPoll.getUsers().size()) {
                User nextUser = pollUsers.get(index + 1);
                Messages.nextLogin(nextUser);
                UserLoginServices.login();
            }
        }
    }
}
