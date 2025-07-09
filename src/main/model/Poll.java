
package model;

import java.util.ArrayList;
import java.util.List;

/*
 * This class is a poll 
 * it can be started by a user and 
 * has specific users as its members and a uniqueId for each poll
 * Uses java generics so that a poll can be any data type
 * 
 */
public class Poll<A> {
    private static int NEXT_POLL_ID = 1;

    private final int pollId;
    private List<User> users; // The users which are participating in this poll
    private List<Option<A>> options; // Uses the generic A which can be any primitve data-type or object
    private boolean isCompleted; // Indicates if this poll has been completed
    private List<User> hasVoted; // Tells us which users have voted already.

    // Constants for the class
    public static final List<Poll<?>> EMPTY_POLLS = new ArrayList<>(); // This is an empty list of Poll , ? means that
                                                                       // it can be any data type.

    // Constructor for Poll
    public Poll(int pollId, List<User> users, List<Option<A>> options, boolean isCompleted, List<User> hasVoted) {
        this.pollId = pollId;
        this.users = users;
        this.options = options;
        this.isCompleted = isCompleted;
        this.hasVoted = hasVoted;
    }

    // The constructor to initialize a new Poll
    // Automatically increments the values for pollId everytime new poll is created.
    // It assigned the hasVoted to be empty since in a new Poll no one will have
    // voted already.
    public Poll(List<User> users, List<Option<A>> options, boolean isCompleted) {
        this.pollId = NEXT_POLL_ID;
        NEXT_POLL_ID++;
        this.users = users;
        this.options = options;
        this.isCompleted = isCompleted;
        this.hasVoted = User.EMPTY_USERS;
    }

    // Getters and Setters for Poll
    public int getPollId() {
        return pollId;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Option<A>> getOptions() {
        return options;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setOptions(List<Option<A>> options) {
        this.options = options;
    }

    public void isCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public static int getNEXT_POLL_ID() {
        return NEXT_POLL_ID;
    }

    public static void setNEXT_POLL_ID(int nextId) {
        Poll.NEXT_POLL_ID = nextId;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public List<User> getHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(List<User> hasVoted) {
        this.hasVoted = hasVoted;
    }

    // REQUIRES You have to specify which data type will be used in the options of
    // this poll
    // EFFECTS It will create a new poll that the user has requested
    public static <A> Poll<A> createPoll(List<User> users, List<Option<A>> options, boolean isCompleted) {
        return new Poll<A>(users, options, isCompleted);
    }

    // REQUIRES new option to be the same data type as the old ones previously in
    // the list
    // MODIFIES this
    // EFFECTS It adds a new option to the Poll
    // This method calls the helper method from Option to make the actual Option
    // Object since the user will give the value of the option needed to be added
    // not an Object Option.

    public static <A> void addOptionToPoll(Poll<A> p1, A newOptionValue) {
        Option<A> newOption = Option.createOption(newOptionValue);
        List<Option<A>> currentList = p1.getOptions();
        currentList.add(newOption);
    }

    // MODIFIES this
    // EFFECTS It adds a new User to the Poll
    // This method calls does not call helper method User to make the actual User
    // Object since the user will impu the details of which User they wish to add in the poll

    public static <A> void addUserToPoll(Poll<A> p1, User u1) {
        List<User> currentUsersInPoll = p1.getUsers();
        currentUsersInPoll.add(u1);
    }

}
