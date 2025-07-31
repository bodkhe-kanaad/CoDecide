package ui.gui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.poll.Poll;
import model.user.User;
import ui.gui.CoDecideAppGUI;
import ui.gui.PollServicesGUI;
import ui.gui.screens.ResultLoginScreen;

public class ViewResultsHandler implements ActionListener {
    private Poll currentPoll = PollServicesGUI.getCurrentPoll();
    private User owner = currentPoll.getOwner();
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
                if (currentUserLoggedIn.equals(owner)) {
                    PollServicesGUI.calculateResult();
                    currentFrame.dispose(); 
                    new ViewResultsScreen();
                } else {
                    new ResultLoginScreen(owner);
                }
                break;
        
            default:
                break;
        }
    }
    
}
