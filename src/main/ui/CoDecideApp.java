package ui;

import java.util.Scanner;
import model.*;
/*
 * This is the class that has the App and its details
 * about session and if the instance of the app is running.
 */

public class CoDecideApp {
    public static final Scanner INPUT = new Scanner(System.in);
    public static final double CURRENT_VERSION_NUMBER = 1.50;

    private static Session session;

    public static Session getSession() {
        return session;
    }

    private boolean isRunning; // True if the App is still running, False if the App has been closed.

    public CoDecideApp() {
        this.isRunning = true;
    }

    // EFFECTS This runs the App after a call from the User.
    public void run() {
        while (isRunning) {
            Messages.welcomeMessage(); // Welcome messages
            UserLoginServices.loginStatus(); // User Authentication
            Messages.postLogin(); // Post Login Messages
            // TODO Change this to have a ALL_POLLS Map
            Poll currentPoll = model.Poll.createPoll(session.getCurrentUserLoggedIn()); // Creation of the Poll with
                                                                                        // with current user as Owner
            PollEditer.optionAdder(currentPoll); // Adding options to the Poll
            Messages.postAddingOptions(); // Post adding options messages
            PollEditer.userAdder(currentPoll); // Adding other users to the Poll if needed
            Messages.postAddingUsers(); // Post adding users messages
            Voting.addingVote(currentPoll); // Casting votes to the Poll
            Messages.postAddingVotes(); // Post voting
            Messages.results(Voting.calculateResult(currentPoll)); // Option to view the result or quit Poll
            isRunning = false; // Condition to stop App for CLI no rerunning app for another Poll
        }
    }

    public static void setSession(Session s) {
        session = s;
    }
}
