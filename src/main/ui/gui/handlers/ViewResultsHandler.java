package ui.gui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.poll.Poll;
import model.user.User;
import ui.gui.CoDecideAppGUI;
import ui.gui.PollServicesGUI;
import ui.gui.screens.ResultLoginScreen;
import ui.gui.screens.ViewResultsScreen;

/*
 * Handler to view result for current poll or past polls
 */

public class ViewResultsHandler implements ActionListener {

    private User currentUserLoggedIn = CoDecideAppGUI.getSession().getCurrentUserLoggedIn();
    private JFrame currentFrame;

    // REQUIRES currentFrame is not null
    // EFFECTS Constructor to handle the see the Results or current of Past Poll
    public ViewResultsHandler(JFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    // EFFECTS Triggers methods to the see the Results or current of Past Poll
    @Override
    public void actionPerformed(ActionEvent click) {
        String action = click.getActionCommand();

        switch (action) {
            case "RESULTS":
                currentFrame.dispose();
                Poll currentPoll = PollServicesGUI.getCurrentPoll();
                User owner = currentPoll.getOwner();
                if (currentUserLoggedIn.equals(owner)) {
                    PollServicesGUI.calculateResult();
                    new ViewResultsScreen();
                } else {
                    new ResultLoginScreen(owner);
                }
                break;

            case "PAST RESULTS":
                currentFrame.dispose();
                User currentUser = CoDecideAppGUI.getSession().getCurrentUserLoggedIn();
                PollServicesGUI.pastResults(currentUser);
                break;
        }
    }

}
