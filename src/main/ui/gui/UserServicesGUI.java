package ui.gui;

import model.Session;
import model.user.UserAction;

/*
* This class will manage all the user services like
* SignUp , Login , ChangePassword()
 */

public class UserServicesGUI {

    // EFFECTS logs in the user with given field inputs 
    public static Session login(String username, String password) {
        Session session = UserAction.login(username, password);
        if (session != null) {
            CoDecideAppGUI.setSession(session);
            return session;
        } else {
            return null;
        }
    }

    // EFFECTS calls method to signup the user with their fields 
    public static boolean signup(String firstName, String lastName, String userName, String password) {
        return UserAction.signUp(firstName, lastName, userName, password);
    }

}
