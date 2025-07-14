package model;

import java.util.Map;

/*
 * This class handles all the methods triggered by user action in the Poll 
 * such as adding Users and adding Options or casting vote
 */
public class PollAction {

    private PollAction() {

    }

    // REQURIES currentPoll is not null
    // MODIEIS currentPoll.users and User.partOfPoll
    // EFFECTS adds the user to the Poll in which this was triggered
    // also then adds the Poll in which it was triggered to the user
    public static boolean addingUserToPoll(String username, Poll currentPoll) {
        Map<String, User> allUsers = UserAction.getAllUsersMap();
        if (allUsers.containsKey(username)) {
            User user = allUsers.get(username);
        if (!currentPoll.getUsers().contains(user)) {
                currentPoll.addUserToPoll(user);
                user.getPartOfPoll().add(currentPoll);
                return true;
            }
        }
        return false;

    }

    // REQURIES currentPoll is not null
    // MODIEIS currentPoll.users and User.partOfPoll
    // EFFECTS adds the option to the Poll in which this was triggered
    public static void addingOptionToPoll(String option, Poll currentPoll) {
        currentPoll.addOptionToPoll(option);
    }

    // REQUIRES User and Option is not null
    // MODIFIES option.voteTotal
    // EFFECTS adds the vote on the scale of 0-100 to the voteTotal of that option
    public static boolean castVote(User user, Option option, int vote) {
        while (vote < 0 || vote > 100) {
            return false;
        }
        option.addVote(vote);
        return true;
    }

    public static String calculateResult(Poll currentPoll) {
        return currentPoll.pollResults();
    }
}
