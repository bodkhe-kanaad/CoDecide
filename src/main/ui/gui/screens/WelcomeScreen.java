package ui.gui.screens;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ui.gui.Buttons;
import ui.gui.Components;

// Welcome screen 

public class WelcomeScreen extends JFrame {

    // EFFECTS Makes the Welcome Screen
    public WelcomeScreen() {
        setTitle("CoDecide " + Components.versionNumber());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        add(mainPanel(this));
        setVisible(true);
    }

    // EFFECTS makes a main panel with other components
    public JPanel mainPanel(JFrame currentFrame) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        ImageIcon icon = new ImageIcon("data/Logo.png");
        Image scaledImage = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledImage), SwingConstants.CENTER);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panel.add(Box.createVerticalStrut(10));
        panel.add(logoLabel);
        panel.add(Components.largeLogo());
        panel.add(Box.createVerticalStrut(10));
        panel.add(Components.largeTitle());
        panel.add(Box.createVerticalStrut(5));
        panel.add(Components.largeSubTitle());
        panel.add(Box.createVerticalStrut(30));
        panel.add(Buttons.loginChoiceButton(currentFrame));
        panel.add(Box.createVerticalStrut(10));
        panel.add(Buttons.signupChoiceButton(currentFrame));

        return panel;
    }
}
