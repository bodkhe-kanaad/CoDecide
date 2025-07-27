package ui.gui;


import javax.swing.DefaultListModel;

import model.Option;
import model.poll.Poll;
import model.poll.PollAction;
import model.user.User;

public class PollServicesGUI {


    private static Poll currentPoll;
    
    public static void createPollWithCurrentUser(User currentUser) {
        setCurrentPoll(Poll.createPoll(currentUser));
    }

    public static void addOptionToPoll(String optionValue) {
        PollAction.addingOptionToPoll(optionValue, currentPoll);
    }

    public static DefaultListModel<String> getOptionValues() {
        DefaultListModel<String> optionValues = new DefaultListModel<>();
        for (Option o : currentPoll.getOptions()) {
            optionValues.addElement(o.getValue());
        }

        return optionValues;
    }
    
    public static Poll getCurrentPoll() {
        return currentPoll;
    }

    public static void setCurrentPoll(Poll currentPoll) {
        PollServicesGUI.currentPoll = currentPoll;
    }
}
