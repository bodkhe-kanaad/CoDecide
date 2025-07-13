package ui;

import java.util.Scanner;
import model.*;
/*
 * This is the class that has the App and its detailsw
 * about session and if the instance of the app is running.
 */

public class CoDecideApp {
    public static final Scanner INPUT = new Scanner(System.in);
    public static final double CURRENT_VERSION_NUMBER = 1.0;

    private static Session session;    
    private boolean isRunning; // True if the App is still running, False if the App has been closed.

    public CoDecideApp() {
        this.isRunning = true;
    }

    // EFFECTS This runs the App after a call from the User.
    public void run() {
        while (isRunning) {
            Messages.welcomeMessage();              // Welcome messages
            UserLoginServices.loginStatus();                // User Authentication 
            Messages.postLogin();               
            Poll currentPoll = model.Poll.createPoll(session.getCurrentUserLoggedIn());
            PollEditer.optionAdder(currentPoll);
            Messages.postAddingOptions();
            PollEditer.userAdder(currentPoll);
            Messages.postAddingUsers();
            Voting.addingVote(currentPoll);
            Messages.postAddingVotes();
            String result = currentPoll.pollResults();
            Messages.results(result);
            isRunning = false;
        }
    }

    public static  void setSession(Session s) {
        session = s;
    }
}
