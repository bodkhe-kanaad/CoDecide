package ui.gui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import ui.gui.screens.WelcomeScreen;

public class SignOutHandler implements ActionListener {
    private JFrame currentFrame;

    //TODO
    public SignOutHandler(JFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    //TODO
    @Override
    public void actionPerformed(ActionEvent click) {
        currentFrame.dispose();
        new WelcomeScreen();
    }
}
