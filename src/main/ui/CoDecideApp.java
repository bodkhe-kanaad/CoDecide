package ui;

import java.util.Scanner;
import model.*;

public class CoDecideApp {
    public static final Scanner INPUT = new Scanner(System.in);
    public static final double CURRENT_VERSION_NUMBER = 1.0;

    private Session currentSession;
    private boolean isRunning;

    public CoDecideApp() {
        Session currentSession = Session.getCliVersionSession();
        this.currentSession = currentSession;
        this.isRunning = true;
    }


    public static model.User cliVersionUser = model.User.getTestuser();

    public void run() {
        while (isRunning) {
            Messages.welcomeMessage();
            Poll currentPoll = model.Poll.createPoll(cliVersionUser);
            PollEditer.optionAdder(currentPoll);
            Messages.postAddingOptions();
            PollEditer.userAdder(currentPoll);
            Messages.postAddingUsers();
            Voting.addingVote(currentPoll);
            Messages.postAddingVotes();
            Voting.calculateVotes(currentPoll);
        }
    }
}
