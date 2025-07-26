package model;

import model.User.User;

/*
 * This class represents a Session and will be used 
 * for data persistence so that each user can come back 
 * to their version of the app when they relogin.
 * After each user logs out the Session ends and new one starts
 * with the user logging in as the currentUserLoggedIn
 */
public class Session {
    private static int NEXT_SESSION_ID = 1;

    private model.User.User currentUserLoggedIn;
    private int sessionID;
    private boolean isRunning;

    // Getters and Setters for Session
    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public model.User.User getCurrentUserLoggedIn() {
        return currentUserLoggedIn;
    }

    public void setCurrentUserLoggedIn(model.User.User currentUserLoggedIn) {
        this.currentUserLoggedIn = currentUserLoggedIn;
    }

    // Constructor for Session
    public Session(User currentUserLoggedIn, int sessionID, boolean isRunning) {
        this.currentUserLoggedIn = currentUserLoggedIn;
        this.sessionID = sessionID;
        this.isRunning = isRunning;
    }
    // REQUIRES currentUserLoggedIn is not null
    // EFFECTS It makes a new poll with auto incrementing next session id
    
    public static Session sessionInitializer(User currentUserLoggedIn) {
        int sessionID = NEXT_SESSION_ID;
        NEXT_SESSION_ID++;
        boolean isRunning = true;
        return new Session(currentUserLoggedIn, sessionID, isRunning);
    }

}
