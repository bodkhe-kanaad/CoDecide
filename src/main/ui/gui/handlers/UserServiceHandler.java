package ui.gui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ui.gui.screens.LoginScreen;
import ui.gui.screens.PostLoginScreen;
import ui.gui.screens.SignupScreen;
import ui.gui.screens.WelcomeScreen;

/*
 * Handler for user actions regarding signout out switching between login-signup or returning to home screen
 */
public class UserServiceHandler implements ActionListener {
    private JFrame currentFrame;

    // REQUIRES currentFrame is not null
    // EFFECTS Constructor to handle the Users methods
    public UserServiceHandler(JFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    // EFFECTS Moves on to the Home screen, or prompts to login or signup
    @Override
    public void actionPerformed(ActionEvent click) {
        String action = click.getActionCommand();

        switch (action) {
            case "RETURN TO HOME":
                new PostLoginScreen();
                break;
            case "SWITCH TO LOGIN":
                currentFrame.dispose();
                new LoginScreen();
                break;

            case "SWITCH TO SIGNUP":
                currentFrame.dispose();
                new SignupScreen();
                break;

            case "SIGN OUT":
                currentFrame.dispose();
                new WelcomeScreen();
                break;
        }

    }

}
