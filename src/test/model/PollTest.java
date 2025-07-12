package model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import model.*;




public class PollTest {
    private Poll testPoll;
    private User testUser = User.createUser("John", "Doe", "doe.john", "Testpassword@1234");
    private List<Option> testOptionList = Option.testOptionList();


    @Before
    public void runBefore() {
        testPoll = new Poll(Poll.getNEXT_POLL_ID(), testUser,User.getEmptyUserList(),testOptionList, false,
        User.getEmptyUserList());
    }

    @Test
    public void testcreatePoll() {
        Poll newPoll = Poll.createPoll(testUser, testOptionList);
        assertEquals(newPoll.getPollId(), testPoll.getPollId());
        assertEquals(newPoll.getOwner(), testPoll.getOwner());
        assertEquals(newPoll.getUsers(), testPoll.getUsers());
        assertEquals(newPoll.getOptions(), testPoll.getOptions());
        assertEquals(newPoll.isCompleted(), testPoll.isCompleted());
        assertEquals(newPoll.getHasVoted(), testPoll.getHasVoted());
    }

    
}
