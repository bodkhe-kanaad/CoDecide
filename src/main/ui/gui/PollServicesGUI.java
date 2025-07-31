package ui.gui;

import javax.swing.DefaultListModel;

import model.Option;
import model.poll.Poll;
import model.poll.PollAction;
import model.user.User;
import ui.gui.screens.VotingLoginScreen;

public class PollServicesGUI {

    private static Poll currentPoll;
    private static User currentUser = CoDecideAppGUI.getSession().getCurrentUserLoggedIn();
    private static String result = "";

    // TODO
    public static void createPollWithCurrentUser(User currentUser) {
        setCurrentPoll(Poll.createPoll(currentUser));
    }

    // TODO
    public static void addOptionToPoll(String optionValue) {
        PollAction.addingOptionToPoll(optionValue, currentPoll);
    }

    public static void calculateResult() {
        setResult(PollAction.calculateResult(currentPoll));
    }

    // TODO
    public static boolean addUserToPoll(String username) {
        return PollAction.addingUserToPoll(username, currentPoll);
    }

    // TODO

    public static void castVote(Option o, int voteValue) {
        PollAction.castVote(currentUser, o, voteValue);
    }

    // TODO
    public static User getNextVoter() {
        int index = currentPoll.getUsers().indexOf(currentUser);
        index++;
        if (index < currentPoll.getUsers().size()) {
            return currentPoll.getUsers().get(index);
        } else {
            return null;
        }
    }

    // TODO
    public static void hasVoted() {
        currentPoll.getHasVoted().add(currentUser);
        User nextVoter = getNextVoter();
        if (nextVoter != null) {
            relogin(nextVoter);
        }
    }

    // TODO
    public static void relogin(User nextVoter) {
        CoDecideAppGUI.setSession(null);
        new VotingLoginScreen(nextVoter);
    }

    // TODO
    public static DefaultListModel<String> getOptionValues() {
        DefaultListModel<String> optionValues = new DefaultListModel<>();
        for (Option o : currentPoll.getOptions()) {
            optionValues.addElement(o.getValue());
        }

        return optionValues;
    }

    // TODO
    public static Poll getCurrentPoll() {
        return currentPoll;
    }

    // TODO
    public static void setCurrentPoll(Poll currentPoll) {
        PollServicesGUI.currentPoll = currentPoll;
    }

    public static String getResult() {
        return result;
    }

    public static void setResult(String result) {
        PollServicesGUI.result = result;
    }
}
