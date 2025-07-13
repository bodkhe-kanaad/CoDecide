package ui;

import model.*;

/*
 * This class contains the method for the user to register the vote
 */

public class Voting {

    public static void addingVote(Poll currentPoll) {
        int userIndex = 0;
        for (User user : currentPoll.getUsers()) {
            System.out.println("Lets get started" + user.getFirstName());
            userIndex++;
            for (Option option : currentPoll.getOptions()) {
                InputPrompts.voteInputs(option);
                int vote = CoDecideApp.INPUT.nextInt();
                boolean status = PollAction.castVote(user, option, vote);
                while (status == false) {
                    ErrorMessages.voteInputs();
                    vote = CoDecideApp.INPUT.nextInt();
                    status = PollAction.castVote(user, option, vote);
                }
                ErrorMessages.voteInputs();
                vote = CoDecideApp.INPUT.nextInt();
            }
            Messages.afterEachUserVoting(user);
            if (userIndex < currentPoll.getUsers().size()) {
                Messages.nextLogin(currentPoll.getUsers().get(userIndex));
                UserLoginServices.login();
            }
        }
    }

}
