package ui.gui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JSlider;

import model.Option;
import model.poll.Poll;
import model.user.User;
import ui.cli.CoDecideAppCLI;
import ui.gui.CoDecideAppGUI;
import ui.gui.PollServicesGUI;
import ui.gui.screens.PostVotingScreen;

public class VotingHandler implements ActionListener {
    private Map<Option, JSlider> sliderMap;
    private Poll currentPoll;
    private JFrame currentFrame;

    public VotingHandler(Map<Option, JSlider> sliderMap, Poll currentPoll, JFrame currentFrame) {
        this.sliderMap = sliderMap;
        this.currentPoll = currentPoll;
        this.currentFrame = currentFrame;

    }

    @Override
    public void actionPerformed(ActionEvent click) {
        User justVotedUser = CoDecideAppGUI.getSession().getCurrentUserLoggedIn();
    
        for (Option o : sliderMap.keySet()) {
            int voteValue = sliderMap.get(o).getValue();
            PollServicesGUI.castVote(o, voteValue);
        }
    
        currentPoll.getHasVoted().add(justVotedUser);
        currentFrame.dispose();
    
        if (currentPoll.getHasVoted().containsAll(currentPoll.getUsers())) {
            new PostVotingScreen();
        } else {
            User next = PollServicesGUI.getNextVoter();
            if (next != null) {
                PollServicesGUI.relogin(next); 
            }
        }
    }
}
