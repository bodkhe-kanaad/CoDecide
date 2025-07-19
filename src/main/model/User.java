package model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

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

    // Constants for the class
    private static final List<User> emptyUsers = new ArrayList<>(); // The empty user list
    private static final User testUser = createUser("John", "Doe", "doe.john", "Testpassword@1234");

    // Constructor for User
    public User(int userId, String firstName, String lastName, String username, String password,
            List<Poll> partOfPoll) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.partOfPoll = partOfPoll;
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

    public static List<User> getEmptyUserList() {
        return emptyUsers;
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

    // EFFECTS makes a new user initialized with autoincrementing userID and empty
    // list of polls the user is part of.
    private static User userInitalizer(String firstName, String lastName, String username, String password) {
        int userId = NEXT_USER_ID;
        NEXT_USER_ID++;
        List<Poll> partOfPoll = Poll.EMPTY_POLLS;
        return new User(userId, firstName, lastName, username, password, partOfPoll);
    }

    // EFFECTS It will create a new user
    public static User createUser(String firstName, String lastName, String username, String password) {
        return userInitalizer(firstName, lastName, username, password);
    }

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
}
