package ui;

import model.*;

/*
 * This class contains the methods for the user to register the vote
 */

public class Voting {

    public static void addingVote(Poll currentPoll) {
        for (User user : currentPoll.getUsers()) {
            System.out.println("Lets get started" + user.getFirstName());
            for (Option option : currentPoll.getOptions()) {
                InputPrompts.voteInputs(option);
                int vote = CoDecideApp.INPUT.nextInt();
                while (0 > vote || vote > 100) {
                    ErrorMessages.voteInputs();
                    vote = CoDecideApp.INPUT.nextInt();
                }
                option.addVote(vote);
            }
            Messages.afterEachUserVoting(user);
        }
    }

}
