package persistence;

import java.util.HashMap;
import java.util.Map;

import model.Poll.Poll;
import model.User.User;

public class DataStore {
    private static final Map<String, User> allUsers = new HashMap<>();
    private static final Map<Integer, Poll> allPolls  = new HashMap<>();


    public static Map<String, User> getAllUsers() {
        return allUsers;
    }

    public static Map<Integer, Poll> getAllPolls() {
        return allPolls;
    }

    
}
