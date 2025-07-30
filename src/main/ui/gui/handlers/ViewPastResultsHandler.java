package ui.gui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class ViewPastResultsHandler implements ActionListener {
    private JFrame currentFrame;

    //TODO
    public ViewPastResultsHandler(JFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    //TODO
    @Override
    public void actionPerformed(ActionEvent click) {
        currentFrame.dispose();
        //new ViewPastResultsScreen();
    }
}
