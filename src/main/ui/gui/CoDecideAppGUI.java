package ui.gui;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import model.Session;
import model.poll.Poll;
import model.user.User;
import persistence.DataStore;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.cli.PollServicesCLI;
import ui.cli.UserServicesCLI;
import ui.cli.Voting;
import ui.cli.messages.InputPrompts;
import ui.cli.messages.Messages;
import ui.gui.screens.WelcomeScreen;

public class CoDecideAppGUI {
    public static final JsonReader reader = new JsonReader("data/users.json", "data/polls.json");
    private static Session session;
    private boolean sessionActive;

    private boolean isRunning; // True if the App is still running, False if the App has been closed.

    public CoDecideAppGUI() {
        loadState();
        this.isRunning = true;
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
        saveState();
    }

    // EFFECTS loads the App's past data after user relaunches the App
    private static void loadState() {
        try {
            Map<String, User> users = reader.readUsers();
            Map<Integer, Poll> polls = reader.readPolls(users);

            DataStore.getAllUsers().clear();
            DataStore.getAllUsers().putAll(users);

            DataStore.getAllPolls().clear();
            DataStore.getAllPolls().putAll(polls);
        } catch (IOException e) {
            System.out.println("Failed to load data: " + e.getMessage());
        }
    }

    // EFFECTS Saves the current state of the App and its details
    private static void saveState() {
        try {
            JsonWriter userWriter = new JsonWriter("data/users.json");
            JsonWriter pollWriter = new JsonWriter("data/polls.json");

            userWriter.open();
            userWriter.writeAllUsers(DataStore.getAllUsers());
            userWriter.close();

            pollWriter.open();
            pollWriter.writeAllPolls(DataStore.getAllPolls());
            pollWriter.close();
        } catch (IOException e) {
            System.out.println("Auto-save failed: " + e.getMessage());
        }
    }

    // EFFECTS creates a Poll by taking inputs and passing on to other methods
    private void choiceCreatePoll() {
        Poll currentPoll = model.poll.Poll.createPoll(session.getCurrentUserLoggedIn());
        PollServicesCLI.optionAdder(currentPoll); // Adding options to the Poll
        Messages.postAddingOptions(); // Post adding options messages
        PollServicesCLI.userAdder(currentPoll); // Adding other users to the Poll if needed
        Messages.postAddingUsers(); // Post adding users messages
        Voting.addingVote(currentPoll); // Casting votes to the Poll
        Messages.postAddingVotes(); // Post voting
        Messages.results(Voting.calculateResult(currentPoll)); // Option to view the result or quit Poll
        DataStore.getAllPolls().put(currentPoll.getPollId(), currentPoll);
        saveState();
    }

    // EFFECTS sets fields needed to quit the App
    private void quitApplcationChoice() {
        sessionActive = false;
        isRunning = false;
    }

    // EFFECTS The details about the App when someone starts it and logs them in.
    private void appStart() {
        Messages.welcomeMessage(); // Welcome messages
        UserServicesCLI.loginStatus(); // User Authentication
        Messages.postLogin(); // Post Login Messages
    }

    private void choicePastResult() {
        String allPollsToPrint;
        allPollsToPrint = PollServicesCLI.showResultsForUser(session.getCurrentUserLoggedIn());
        Messages.printAllPollResults(allPollsToPrint);
    }

    public static Session getSession() {
        return session;
    }
    
}
