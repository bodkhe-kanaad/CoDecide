package ui;

import model.*;

public class Voting {

    public static void addingVote(Poll currentPoll) {
        for (User user : currentPoll.getUsers()) {
            System.out.println("Lets get started" + user.getFirstName());
            for (Option option : currentPoll.getOptions()) {
                InputPromts.voteInputs(option);
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

    public static void calculateVotes(Poll currentPoll) {
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
