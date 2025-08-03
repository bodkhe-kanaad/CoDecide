package ui.gui;

import java.util.List;

import javax.swing.DefaultListModel;

import model.Option;
import model.poll.Poll;
import model.poll.PollAction;
import model.user.User;
import ui.gui.screens.PastResultScreen;
import ui.gui.screens.VotingLoginScreen;

public class PollServicesGUI {

    private static Poll currentPoll;
    private static String result = "";

    // EFFECTS calls method to create poll with current user
    public static void createPollWithCurrentUser(User currentUser) {
        setCurrentPoll(Poll.createPoll(currentUser));
    }

    // EFFECTS calls method to add option to Poll
    public static void addOptionToPoll(String optionValue) {
        PollAction.addingOptionToPoll(optionValue, currentPoll);
    }

    // EFFECTS calls method to calculate result for the current poll
    public static void calculateResult() {
        setResult(PollAction.calculateResult(currentPoll));
    }

    // EFFECTS calls method to adding user to poll
    public static boolean addUserToPoll(String username) {
        return PollAction.addingUserToPoll(username, currentPoll);
    }

    // EFFECTS calls method to find polls for which current user has the ownership
    public static void pastResults(User currentUser) {
        List<Poll> polls = PollAction.ownershipForPollsAndCompleted(currentUser);
        new PastResultScreen(polls);

    }

    // EFFECTS calls method to create poll with current user
    public static void castVote(Option o, int voteValue) {
        User currentUser = CoDecideAppGUI.getSession().getCurrentUserLoggedIn();

        PollAction.castVote(currentUser, o, voteValue);
    }

    // EFFECTS returns the next voter or returns null
    public static User getNextVoter() {
        User currentUser = CoDecideAppGUI.getSession().getCurrentUserLoggedIn();

        int index = currentPoll.getUsers().indexOf(currentUser);
        int nextIndex = index++;
        nextIndex++;
        if (nextIndex < currentPoll.getUsers().size()) {
            return currentPoll.getUsers().get(nextIndex);
        } else {
            return null; // no more voters
        }
    }

    // EFFECTS adds the user to polls has voted 
    public static void hasVoted() {
        User currentUser = CoDecideAppGUI.getSession().getCurrentUserLoggedIn();

        currentPoll.getHasVoted().add(currentUser);
        User nextVoter = getNextVoter();
        if (nextVoter != null) {
            relogin(nextVoter);
        }
    }

    // EFFECTS prompts the relogin
    public static void relogin(User nextVoter) {
        CoDecideAppGUI.setSession(null);
        new VotingLoginScreen(nextVoter);
    }

    // EFFECTS gets the options names
    public static DefaultListModel<String> getOptionValues() {
        DefaultListModel<String> optionValues = new DefaultListModel<>();
        for (Option o : currentPoll.getOptions()) {
            optionValues.addElement(o.getValue());
        }

        return optionValues;
    }

    // EFFECTS getter
    public static Poll getCurrentPoll() {
        return currentPoll;
    }

    // EFFECTS setter
    public static void setCurrentPoll(Poll currentPoll) {
        PollServicesGUI.currentPoll = currentPoll;
    }

    // EFFECTS getter
    public static String getResult() {
        return result;
    }

    // EFFECTs setter
    public static void setResult(String result) {
        PollServicesGUI.result = result;
    }

}
