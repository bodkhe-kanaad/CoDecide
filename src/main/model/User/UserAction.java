package model.user;

import java.util.Map;

import model.Session;
import persistence.DataStore;

public class UserAction {
    private UserAction() {
    }

    // CLI Version constants for Easier testing since no data persistence.
    private static Map<String, User> ALL_USERS = DataStore.getAllUsers();

    // MODIFIES UserLogin.loginStatus set to true or false
    // EFFECTS creates an user using the User.createUser() method and adds it to the
    // Map of ALL_USERS
    public static boolean signUp(String firstName, String lastName, String userName, String password) {
        User newUser = User.createUser(firstName, lastName, userName, password);
        ALL_USERS.put(userName, newUser);
        return true;
    }

    // MODIFIES Creates new Session with Session.currentUserLoggedIn as the logging
    // in User
    // EFFECTS checks for the username and password if correct then creates a new
    // Session with the
    public static Session login(String userName, String password) {
        if (ALL_USERS.containsKey(userName) == false) {
            return null;
        }
        if (ALL_USERS.get(userName).getPassword().contentEquals(password)) {
            return Session.sessionInitializer(ALL_USERS.get(userName));
        } else {
            return null;
        }
    }

    // Getter for the global user map
    public static Map<String, User> getAllUsersMap() {
        return ALL_USERS;
    }
}
