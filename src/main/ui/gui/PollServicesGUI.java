package ui.gui;


import javax.swing.DefaultListModel;

import model.Option;
import model.poll.Poll;
import model.poll.PollAction;
import model.user.User;

public class PollServicesGUI {

    private static Poll currentPoll;
    
    //TODO
    public static void createPollWithCurrentUser(User currentUser) {
        setCurrentPoll(Poll.createPoll(currentUser));
    }

    //TODO
    public static void addOptionToPoll(String optionValue) {
        PollAction.addingOptionToPoll(optionValue, currentPoll);
    }

    //TODO
    public static void addUserToPoll(String username) {
        PollAction.addingUserToPoll(username, currentPoll);
    }

    //TODO
    public static DefaultListModel<String> getOptionValues() {
        DefaultListModel<String> optionValues = new DefaultListModel<>();
        for (Option o : currentPoll.getOptions()) {
            optionValues.addElement(o.getValue());
        }

        return optionValues;
    }
    
    //TODO
    public static Poll getCurrentPoll() {
        return currentPoll;
    }

    //TODO
    public static void setCurrentPoll(Poll currentPoll) {
        PollServicesGUI.currentPoll = currentPoll;
    }
}
