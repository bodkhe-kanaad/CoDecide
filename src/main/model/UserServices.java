package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServices {
    private static Map<String, User> ALL_USERS = new HashMap<>();

    // EFFECTS checks if the username exists for multiple purposes like non duplication and existence. 
    public static boolean isUsernameExists(String username) {
        return ALL_USERS.containsKey(username);
    }

    // MODIFIES UserLogin.loginStatus set to true or false 
    // EFFECTS creates an user using the User.createUser() method and adds it to the Map of ALL_USERS
    public static boolean signUp(String firstName, String lastName, String userName, String password) {
        User newUser = User.createUser(firstName, lastName, userName, password);
        ALL_USERS.put(userName, newUser);
        return true;
    }

    // EFFECTS checks for the username and password if correct then creates a new Session with the
    // MODIFIES Session.currentUserLoggedIn
    // user logging in as the currentUserLoggedIn.
    public static String login(String userName, String password) {
        if (ALL_USERS.containsKey(userName) == false) {
            return "Wrong Username";
        }
        if (ALL_USERS.containsKey(userName) && ALL_USERS.get(userName).getPassword().contentEquals(password)) {
            Session session = Session.sessionInitializer(ALL_USERS.get(userName));
            return "Successfull";
        } else {
            return "Password is incorrect";
        } 
    }

    public static Map<String, User> getAllUsersMap() {
        return ALL_USERS;
    }

}
