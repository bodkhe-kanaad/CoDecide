package ui.gui.screens;


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.gui.Components;

public class WelcomeScreen extends JFrame {

    public WelcomeScreen() {
        setTitle("CoDecide");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        add(mainPanel(this));
        setVisible(true);
    }
    

    public JPanel mainPanel(JFrame currentFrame) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalStrut(30));
        panel.add(Components.largeLogo());
        panel.add(Box.createVerticalStrut(10));
        panel.add(Components.largeTitle());
        panel.add(Box.createVerticalStrut(5));
        panel.add(Components.largeSubTitle());
        panel.add(Box.createVerticalStrut(30));
        panel.add(Components.loginChoiceButton(currentFrame));
        panel.add(Box.createVerticalStrut(10));
        panel.add(Components.signupChoiceButton(currentFrame));

        return panel;
    }
}
