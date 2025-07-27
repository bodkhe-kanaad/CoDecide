package model.user;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import model.poll.Poll;

/*
 * This class represents the Users
 * A user has authentication credentials and unique userId 
 * and details about themselves also what polls this user is a part of.
 */

public class User {
    private static int NEXT_USER_ID = 1;

    private int userId; // Unique UserId for each user
    private String firstName; // Users First Name
    private String lastName; // Users Last Name
    private String username; // Username for Login
    private String password; // Password for Login
    private List<Poll> partOfPoll; // This user is part of what Poll's
    private List<Integer> partOfPollId;

    // Constants for the class
    private static final User testUser = createUser("John", "Doe", "doe.john", "Testpassword@1234");

    // Constructor for User
    public User(int userId, String firstName, String lastName, String username, String password,
            List<Poll> partOfPoll, List<Integer> partOfPollId) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.partOfPoll = partOfPoll;
        this.partOfPollId = partOfPollId;
    }

    // Getters and Setters for User
    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Poll> getPartOfPoll() {
        return partOfPoll;
    }


    public static int getNextUserID() {
        return NEXT_USER_ID;
    }

    public static int resetNextUserID() {
        return NEXT_USER_ID = 1;
    }

    public static User getTestuser() {
        return testUser;
    }

    public List<Integer> getPartOfPollId() {
        return partOfPollId;
    }

    public void setPartOfPollId(List<Integer> partOfPollId) {
        this.partOfPollId = partOfPollId;
    }

    public static void setNextUserId(int userId) {
        NEXT_USER_ID = userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPartOfPoll(List<Poll> partOfPoll) {
        this.partOfPoll = partOfPoll;
    }

    // EFFECTS makes a new user initialized with autoincrementing userID and empty
    // list of polls the user is part of.
    private static User userInitalizer(String firstName, String lastName, String username, String password) {
        int userId = NEXT_USER_ID;
        NEXT_USER_ID++;
        List<Poll> partOfPoll = Poll.EMPTY_POLLS;
        List<Integer> partOfPollId = new ArrayList<>();
        return new User(userId, firstName, lastName, username, password, partOfPoll, partOfPollId);
    }

    // EFFECTS It will create a new user
    public static User createUser(String firstName, String lastName, String username, String password) {
        return userInitalizer(firstName, lastName, username, password);
    }

    // TODO test it
    // EFFECTS converts the User Object fields to format that can be stored in JSON
    public JSONObject toJson() {
        JSONObject userJson = new JSONObject();
        JSONArray partOfPollJson = new JSONArray();
        userJson.put("username", username);
        userJson.put("firstName", firstName);
        userJson.put("lastName", lastName);
        userJson.put("password", password);
        userJson.put("userId", userId);

        for (Poll p : partOfPoll) {
            partOfPollJson.put(p.getPollId());
        }
        userJson.put("partOfPolls", partOfPollJson);
        return userJson;
    }
 
     // EFFECTS converts the JSON format storied data to User Object
    public static User reconstructUser(JSONObject userJson) {
        int userId = userJson.getInt("userId");
        String username = userJson.getString("username");
        String firstName = userJson.getString("firstName");
        String lastName = userJson.getString("lastName");
        String password = userJson.getString("password");
        List<Integer> partOfPollIds = new ArrayList<>();

        JSONArray pollArray = userJson.getJSONArray("partOfPolls");

        for (int i = 0; i < pollArray.length(); i++) {
            partOfPollIds.add(pollArray.getInt(i));
        }

        return new User(userId, firstName, lastName, username, password, new ArrayList<>(), partOfPollIds);
    }

}
