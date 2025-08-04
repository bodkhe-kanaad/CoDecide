package model.poll;

import model.Event;
import model.EventLog;
import model.Option;
import model.user.User;
import model.user.UserAction;

import java.util.*;
import persistence.DataStore;

/*
 * This class handles all the methods triggered by user action related to Poll 
 * such as adding Users and adding Options or casting votes
 */
public class PollAction {

    private static Map<Integer, Poll> ALL_POLLS = DataStore.getAllPolls();

    // REQURIES currentPoll is not null
    // MODIEIS currentPoll.users and User.partOfPoll
    // EFFECTS adds the user to the Poll in which this was triggered
    // also then adds the Poll in which it was triggered to the user
    public static boolean addingUserToPoll(String username, Poll currentPoll) {
        Map<String, User> allUsers = UserAction.getAllUsersMap(); // The global User details
        if (allUsers.containsKey(username)) {
            User user = allUsers.get(username);
            if (!currentPoll.getUsers().contains(user)) { // Checks if user is already a part
                currentPoll.addUserToPoll(user);
                user.getPartOfPoll().add(currentPoll);
                EventLog.getInstance().logEvent(
                        new Event("User : " + user.getFirstName() + " added to Poll: " + currentPoll.getPollId()));
                return true;
            }
        }
        return false;

    }

    // REQURIES currentPoll is not null
    // MODIEIS currentPoll.users and User.partOfPoll
    // EFFECTS adds the option to the Poll in which this was triggered
    public static void addingOptionToPoll(String option, Poll currentPoll) {
        EventLog.getInstance()
                .logEvent(new Event("New option: " + option + " " + "added to PollId: " + currentPoll.getPollId()));
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
        EventLog.getInstance().logEvent(new Event("User " + user.getUsername()
                + " voted " + vote + " for option: " + option.getValue()));
        return true;
    }

    // REQUIRES Poll currentPoll is not Null
    // EFFECTS It returns the string which is the result for that Poll
    public static String calculateResult(Poll currentPoll) {
        return currentPoll.pollResults();
    }

    // REQUIRES User currentUser is not Null
    // EFFECTS It returns the List<Poll> for which the given user is the Owner and
    // Is Completed
    public static List<Poll> ownershipForPollsAndCompleted(User currentUser) {
        List<Poll> ownershipPolls = new ArrayList<>();

        for (Poll p : ALL_POLLS.values()) {
            if (p.getOwner().equals(currentUser) && p.isCompleted()) {
                ownershipPolls.add(p);
            }
        }
        return ownershipPolls;
    }

    public static Map<Integer, Poll> getAllPolls() {
        return ALL_POLLS;
    }
}
