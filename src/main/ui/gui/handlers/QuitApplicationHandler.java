package ui.gui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.Event;
import model.EventLog;
import persistence.DataStore;

/*
 * Handler for quiting the application
 */

public class QuitApplicationHandler implements ActionListener {
    private JFrame currentFrame;

    // REQUIRES currentFrame is not null
    // EFFECTS constructor to act as the handler for Quitting the application
    public QuitApplicationHandler(JFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    // EFFECTS It saves the state and closes the app and prints the event log.
    @Override
    public void actionPerformed(ActionEvent click) {
        DataStore.saveState();

        for (Event event : EventLog.getInstance()) {
            System.out.println(event.toString());
        }
        
        currentFrame.dispose();
        System.exit(0);
    }

}
