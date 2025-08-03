package ui.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class HeaderPanel extends JPanel {
    private Color backgroundColor = Components.backgroundColor();

    // EFFECTS makes the header panel 
    public HeaderPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(backgroundColor);
        setBorder(BorderFactory.createEmptyBorder(10,20,10,20));

        JLabel logo = Components.smallLogo();

        JLabel subtitle = Components.smallSubtitle();

        JSeparator line = new JSeparator();
        line.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        line.setForeground(backgroundColor);

        add(logo);
        add(Box.createVerticalStrut(5));
        add(subtitle);
        add(Box.createVerticalStrut(10));
        add(line);

    }
    
}
