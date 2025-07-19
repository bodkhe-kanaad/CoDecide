
package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

/*
 * This class represents a Poll 
 * it can be started by a user and 
 * has specific users as its members and a uniqueId for each poll
 */
public class Poll {
    private static int NEXT_POLL_ID = 1;

    private int pollId; // Unique ID for each Poll
    private User owner; // The User who initialized the Poll
    private List<User> users; // The users which are participating in this poll
    private List<Option> options; // The list of all options that will be voted upon
    private boolean isCompleted; // Indicates if this poll has been completed
    private List<User> hasVoted; // Tells us which users have voted already.

    // Constants for the class
    public static final List<Poll> EMPTY_POLLS = new ArrayList<>(); // This is an empty list of Poll

    // Constructor for Poll
    public Poll(int pollId, User owner, List<User> users, List<Option> options, boolean isCompleted,
            List<User> hasVoted) {
        this.pollId = pollId;
        this.owner = owner;
        users.add(owner);
        this.users = users;
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
        boolean isCompleted = false;
        List<User> hasVoted = User.getEmptyUserList();
        List<Option> options = new ArrayList<>();
        Poll newPoll = new Poll(pollId, owner, users, options, isCompleted, hasVoted);
        owner.getPartOfPoll().add(newPoll);
        return newPoll; 
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

    public static int getNextPollId() {
        return NEXT_POLL_ID;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public List<User> getHasVoted() {
        return hasVoted;
    }

    // EFFECTS It will create a new poll with certain default inital fields.
    public static Poll createPoll(User owner) {
        return pollInitializer(owner);

    }

    // MODIFIES this
    // EFFECTS It adds a new option to the Poll
    // This method calls the helper method from Option class to make the actual
    // Option
    // Object since the user will give the string of the option needed to be added
    // not the Object Option itself.

    public void addOptionToPoll(String newOptionValue) {
        Option newOption = Option.createOption(newOptionValue);
        this.getOptions().add(newOption);
    }

    // MODIFIES this
    // EFFECTS It adds a new User to the Poll
    // This method calls does not call helper method User to make the actual User
    // Object since the user will input the details of which User they wish to add
    // in
    // the poll and this user will already be a part of the global user map.
    public void addUserToPoll(User u1) {
        this.getUsers().add(u1);
    }

    // EFFECTS it calculates the votes and gives result of the Poll
    public String pollResults() {
        int highestSoFar = 0;
        String resultOption = "";
        for (Option option : this.getOptions()) {
            if (option.getVoteTotal() > highestSoFar) {
                highestSoFar = option.getVoteTotal();
                resultOption = option.getValue();
            }
        }
        return resultOption;
    }

    public JSONObject toJson() {
        // TODO Auto-generated method stub
        JSONObject pollJson = new JSONObject();
        JSONArray optionsListJson = new JSONArray();
        JSONArray usersListJson = new JSONArray();
        JSONArray usersVotedListJson = new JSONArray();

        pollJson.put("pollId", pollId);
        pollJson.put("owner", owner.getUsername());
        pollJson.put("isCompleted", isCompleted);

        for (User u : users) {
            usersListJson.put(u.getUsername());
        }

        for (Option o : options) {
            optionsListJson.put(o.toJson());
        }

        for (User u : hasVoted) {
            usersVotedListJson.put(u.getUsername());
        }

        pollJson.put("usersList", usersVotedListJson);
        pollJson.put("usersVotedList", usersVotedListJson);
        pollJson.put("optionsList", optionsListJson);

        return pollJson;

    }

}
