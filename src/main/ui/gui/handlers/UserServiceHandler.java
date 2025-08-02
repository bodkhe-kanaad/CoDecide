package ui.gui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ui.gui.screens.PostLoginScreen;

public class UserServiceHandler implements ActionListener {
    private JFrame currentFrame;

    public UserServiceHandler(JFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    @Override
    public void actionPerformed(ActionEvent click) {
        String action = click.getActionCommand();

        switch (action) {
            case "RETURN TO HOME":
                new PostLoginScreen();
                break;
        }

    }
    
}
