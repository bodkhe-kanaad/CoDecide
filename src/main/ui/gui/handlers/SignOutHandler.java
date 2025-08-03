package ui.gui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import ui.gui.screens.WelcomeScreen;

public class SignOutHandler implements ActionListener {
    private JFrame currentFrame;

    // REQUIES currentFrame is not null
    // EFFECTS Constructor to handle the signing out of a user
    public SignOutHandler(JFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    // EFFECTS signs out the User and opens the welcome screen again
    @Override
    public void actionPerformed(ActionEvent click) {
        currentFrame.dispose();
        new WelcomeScreen();
    }
}
