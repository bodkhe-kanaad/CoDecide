package ui.gui;

import model.Session;
import model.user.User;
import model.user.UserAction;
import ui.cli.CoDecideAppCLI;
import ui.cli.messages.ErrorMessages;
import ui.cli.messages.InputPrompts;

/*
* This class will manage all the user services like
* SignUp , Login , ChangePassword()
 */

public class UserServicesGUI {

    // TODO
    public static Session login(String username, String password) {
        Session session = UserAction.login(username, password);
        if (session != null) {
            CoDecideAppGUI.setSession(session);
            return session;
        } else {
            return null;
        }
    }

    //TODO
    public static boolean signup(String firstName, String lastName, String userName, String password) {
        return UserAction.signUp(firstName, lastName, userName, password);
    }

}
