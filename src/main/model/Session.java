package model;

/*
 * This class represents a session and will be used 
 * for data persistence so that each user can come back 
 * to their version of the app when they relogin
 */
public class Session {
    private static int NEXT_SESSION_ID = 1;

    private model.User sessionOwner;
    private int sessionID;

    public Session(User sessionOwner, int sessionID) {
        this.sessionOwner = sessionOwner;
        this.sessionID = sessionID;
    }

    private final Session cliVersionSession = new Session(model.User.getTestuser(), 1);

    public Session getCliVersionSession() {
        return cliVersionSession;
    }

}
