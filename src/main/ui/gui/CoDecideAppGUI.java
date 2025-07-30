package ui.gui;


import model.Session;
import persistence.DataStore;
import ui.gui.screens.WelcomeScreen;

public class CoDecideAppGUI {
    
    private static Session session;

    //TODO
    public CoDecideAppGUI() {
        DataStore.loadState();
    }

    // EFFECTS This runs the App after a call from the User.
    public void run() {
        new WelcomeScreen();
    }

    // REQUIRES Session s is not Null
    // MODIFIES this
    // EFFECTS After login changes the state of the App by setting new session
    public static void setSession(Session s) {
        session = s;
        DataStore.saveState();
    }

    public static Session getSession() {
        return session;
    }
    
}
