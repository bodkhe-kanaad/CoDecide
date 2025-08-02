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

public class ViewResultsHandler implements ActionListener {

    private User currentUserLoggedIn = CoDecideAppGUI.getSession().getCurrentUserLoggedIn();
    private JFrame currentFrame;

    public ViewResultsHandler(JFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    @Override
    public void actionPerformed(ActionEvent click) {
        String action = click.getActionCommand();

        switch (action) {
            case "RESULTS":
                Poll currentPoll = PollServicesGUI.getCurrentPoll();
                User owner = currentPoll.getOwner();
                if (currentUserLoggedIn.equals(owner)) {
                    PollServicesGUI.calculateResult();
                    currentFrame.dispose();
                    new ViewResultsScreen();
                } else {
                    new ResultLoginScreen(owner);
                }
                break;

            case "PAST RESULTS":
                User currentUser = CoDecideAppGUI.getSession().getCurrentUserLoggedIn();
                PollServicesGUI.pastResults(currentUser);
                break;
        }
    }

}
