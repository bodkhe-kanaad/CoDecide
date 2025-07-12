
package model;

import java.util.ArrayList;
import java.util.List;

/*
 * This class is a poll 
 * it can be started by a user and 
 * has specific users as its members and a uniqueId for each poll
 * Uses java generics so that a poll can be any data type
 */
public class Poll {
    private static int NEXT_POLL_ID = 1;

    private int pollId; // Unique ID for each Poll
    private User owner; // The User who initated the Poll
    private List<User> users; // The users which are participating in this poll
    private List<Option> options; // Uses the generic A which can be any primitve data-type or object
    private boolean isCompleted; // Indicates if this poll has been completed
    private List<User> hasVoted; // Tells us which users have voted already.

    // Constants for the class
    public static final List<Poll> EMPTY_POLLS = new ArrayList<>(); // This is an empty list of Poll , ? means that
                                                                    // it can be any data type.

    // Constructor for Poll
    public Poll(int pollId, User owner, List<User> users, List<Option> options, boolean isCompleted,
            List<User> hasVoted) {
        this.pollId = pollId;
        this.owner = owner;
        this.users = users;
        this.users.add(owner);
        this.options = options;
        this.isCompleted = isCompleted;
        this.hasVoted = hasVoted;
    }

    // The constructor to initialize a new Poll
    // Automatically increments the values for pollId everytime new poll is created.
    // It assigned the hasVoted to be empty since in a new Poll no one will have
    // voted already.
    private static Poll pollInitializer(User owner) {
        int pollId = NEXT_POLL_ID;
        NEXT_POLL_ID++;
        List<User> users = User.getEmptyUserList();
        users.add(owner);
        boolean isCompleted = false;
        List<User> hasVoted = User.getEmptyUserList();
        List<Option> options = new ArrayList<>();
        return new Poll(pollId, owner, users, options, isCompleted, hasVoted);
    }

    // Getters and Setters for Poll
    public int getPollId() {
        return pollId;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Option> getOptions() {
        return options;
    }

    public User getOwner() {
        return owner;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public void isCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public static int getNEXT_POLL_ID() {
        return NEXT_POLL_ID;
    }

    public void setNEXT_POLL_ID(int nextId) {
        NEXT_POLL_ID = nextId;
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

    // EFFECTS It will create a new poll with certain default inital fields.
    public static Poll createPoll(User owner) {
        return pollInitializer(owner);
    }

    // MODIFIES this
    // EFFECTS It adds a new option to the Poll
    // This method calls the helper method from Option to make the actual Option
    // Object since the user will give the value of the option needed to be added
    // not an Object Option.

    public void addOptionToPoll(String newOptionValue) {
        Option newOption = Option.createOption(newOptionValue);
         this.getOptions().add(newOption);
    }

    // MODIFIES this
    // EFFECTS It adds a new User to the Poll
    // This method calls does not call helper method User to make the actual User
    // Object since the user will impu the details of which User they wish to add in
    // the poll

    public void addUserToPoll(User u1) {
         this.getUsers().add(u1);
    }

}
