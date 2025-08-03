package ui.gui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import persistence.DataStore;

public class QuitApplicationHandler implements ActionListener {
    private JFrame currentFrame;

    // REQUIRES currentFrame is not null
    // EFFECTS constructor to act as the handler for Quitting the application
    public QuitApplicationHandler(JFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    // EFFECTS It saves the state and closes the app. 
    @Override
    public void actionPerformed(ActionEvent click) {
        DataStore.saveState();
        currentFrame.dispose();
        System.exit(0);
    }
   
    
}
