package ui.gui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ui.gui.CoDecideAppGUI;
import ui.gui.PollServicesGUI;
import ui.gui.screens.AddOptionsToPollScreen;

/*
 * Handler for actions regarding creating a poll
 */

public class LaunchCreatePollHandler implements ActionListener {
    private JFrame currentFrame;

    // REQUIRES currentFrame is not null
    // EFFECTS Constructor
    public LaunchCreatePollHandler(JFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    // EFFECTS it makes a new Poll and moves on to the next step in the poll which
    // is adding options
    @Override
    public void actionPerformed(ActionEvent click) {
        new AddOptionsToPollScreen();
        currentFrame.dispose();
        PollServicesGUI.createPollWithCurrentUser(CoDecideAppGUI.getSession().getCurrentUserLoggedIn());
    }
}
