package ui.gui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import persistence.DataStore;

public class QuitApplicationHandler implements ActionListener {
    private JFrame currentFrame;

    public QuitApplicationHandler(JFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    @Override
    public void actionPerformed(ActionEvent click) {
        DataStore.saveState();
        currentFrame.dispose();
        System.exit(0);
    }
   
    
}
