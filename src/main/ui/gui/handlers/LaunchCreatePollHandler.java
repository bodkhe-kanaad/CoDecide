package ui.gui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ui.gui.CoDecideAppGUI;
import ui.gui.PollServicesGUI;
import ui.gui.screens.AddOptionsToPollScreen;

public class LaunchCreatePollHandler implements ActionListener {
    private JFrame currentFrame;

    public LaunchCreatePollHandler(JFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    @Override
    public void actionPerformed(ActionEvent click) {
        new AddOptionsToPollScreen();
        currentFrame.dispose();
        PollServicesGUI.createPollWithCurrentUser(CoDecideAppGUI.getSession().getCurrentUserLoggedIn());
    }
}
