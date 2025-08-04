package persistence;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import model.poll.Poll;
import model.user.User;

/*
 * Responsible for the loading and saving of data
 */

public class DataStore {
    private static final Map<String, User> ALL_USERS = new HashMap<>();
    private static final Map<Integer, Poll> ALL_POLLS  = new HashMap<>();
    public static final JsonReader READER = new JsonReader("data/users.json", "data/polls.json");

    public static Map<String, User> getAllUsers() {
        return ALL_USERS;
    }

    public static Map<Integer, Poll> getAllPolls() {
        return ALL_POLLS;
    }

    public static void loadState() {
        try {
            Map<String, User> users = READER.readUsers();
            Map<Integer, Poll> polls = READER.readPolls(users);

            DataStore.getAllUsers().clear();
            DataStore.getAllUsers().putAll(users);

            DataStore.getAllPolls().clear();
            DataStore.getAllPolls().putAll(polls);
        } catch (IOException e) {
            System.out.println("Failed to load data: " + e.getMessage());
        }
    }

    public static void saveState() {
        try {
            JsonWriter userWriter = new JsonWriter("data/users.json");
            JsonWriter pollWriter = new JsonWriter("data/polls.json");

            userWriter.open();
            userWriter.writeAllUsers(DataStore.getAllUsers());
            userWriter.close();

            pollWriter.open();
            pollWriter.writeAllPolls(DataStore.getAllPolls());
            pollWriter.close();
        } catch (IOException e) {
            System.out.println("Auto-save failed: " + e.getMessage());
        }
    }
    
}
