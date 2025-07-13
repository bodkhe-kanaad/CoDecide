package model;

/*
 * This class handles all the services for Poll triggered by user action
 * such as adding Users and adding Options
 */
public class PollServices {

    private PollServices() {

    }

    // REQURIES currentPoll is not null
    // MODIEIS currentPoll.users and User.partOfPoll
    // EFFECTS adds the user to the Poll in which this was triggered 
    // also then adds the Poll in which it was triggered to the user
    public static boolean addingUserToPoll(String username, Poll currentPoll) {
        if (UserServices.getAllUsersMap().containsKey(username)) {
            currentPoll.addUserToPoll(UserServices.getAllUsersMap().get(username));
            UserServices.getAllUsersMap().get(username).getPartOfPoll().add(currentPoll);
            return true;
        } else {
            return false;
        }
    }
    
    // REQURIES currentPoll is not null
    // MODIEIS currentPoll.users and User.partOfPoll
    // EFFECTS adds the option to the Poll in which this was triggered
    public static void addingOptionToPoll(String option, Poll currentPoll) {
        currentPoll.addOptionToPoll(option);
    }
}
