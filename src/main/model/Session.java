package model;

/*
 * This class represents a session and will be used 
 * for data persistence so that each user can come back 
 * to their version of the app when they relogin
 */
public class Session {
    private static int NEXT_SESSION_ID = 1;

    private model.User currentUserLoggedIn;
    private int sessionID;

    public model.User getCurrentUserLoggedIn() {
        return currentUserLoggedIn;
    }

    public void setCurrentUserLoggedIn(model.User currentUserLoggedIn) {
        this.currentUserLoggedIn = currentUserLoggedIn;
    }


    public Session(User currentUserLoggedIn, int sessionID) {
        this.currentUserLoggedIn = currentUserLoggedIn;
        this.sessionID = sessionID;
    }

    public static Session sessionInitializer(User currentUserLoggedIn) {
        int sessionID = NEXT_SESSION_ID;
        NEXT_SESSION_ID++;
        return new Session(currentUserLoggedIn, sessionID);
    }

}
