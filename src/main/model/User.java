package model;

import java.util.ArrayList;
import java.util.List;

/*
 * This class represents the users of the app
 * A user has authentication credentials 
 * unique userId
 * details about its credentials and what polls this user is a part of 
 */

public class User {
    private static int NEXT_USER_ID = 1;

    private final int userId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private List<Poll<?>> partOfPoll;

    // Constants for the class
    public static List<User> EMPTY_USERS = new ArrayList<>();

    // To make a new User of the App
    // It automatically increments the values for userId when new User is made
    // It assigned the partOfPoll to be empty since a new user will not be part of
    // any poll
    public User(String firstName, String lastName, String username, String password) {
        this.userId = NEXT_USER_ID;
        NEXT_USER_ID++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.partOfPoll = Poll.EMPTY_POLLS;
    }

    // Constructor for User
    public User(int userId, String firstName, String lastName, String username, String password,
            List<Poll<?>> partOfPoll) {
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Poll<?>> getPartOfPoll() {
        return partOfPoll;
    }

    public void setPartOfPoll(List<Poll<?>> partOfPoll) {
        this.partOfPoll = partOfPoll;
    }

    public static List<User> getEMPTY_USERS() {
        return EMPTY_USERS;
    }

    public static void setEMPTY_USERS(List<User> emptyUsers) {
        User.EMPTY_USERS = emptyUsers;
    }

    // EFFECTS It will create a new user
    public static User createUser(String firstName, String lastName, String username, String password) {
        return new User(firstName, lastName, username, password);
    }
}
