package model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PollTest {
    Poll testPoll;
    User testUser = User.createUser("John", "Doe", "doe.john", "Testpassword@1234");
    List<Option> testOptionList = Option.testOptionList();

    @Before
    public void runBefore() {
        testPoll = new Poll(Poll.getNEXT_POLL_ID(), testUser, User.getEmptyUserList(),testOptionList, false,
                User.getEmptyUserList());
    }

    @Test
    /*
     * Compare all the fields between testPoll and newPoll if they match then the
     * method works as intended
     */
    public void testcreatePoll() {
        Poll newPoll = Poll.createPoll(testUser);
        assertEquals(newPoll.getPollId(), testPoll.getPollId());
        assertEquals(newPoll.getOwner(), testPoll.getOwner());
        assertEquals(newPoll.getUsers(), testPoll.getUsers());
        assertEquals(newPoll.getOptions().size() + 1, testPoll.getOptions().size());
        assertEquals(newPoll.isCompleted(), testPoll.isCompleted());
        assertEquals(newPoll.getHasVoted(), testPoll.getHasVoted());

    }

    @Test
    /*
     * Compare the size list since there was 1 option in originally the test option
     * Since the method add's one option we added another one making a total of 2.
     */
    public void testaddOptionToPoll() {
        testPoll.addOptionToPoll("Test String 2");
        assertEquals(testPoll.getOptions().size(), 2);
    }

    @Test
    /*
     * Compare the size list since there was 1 option in originally the owner
     * Since the method add's one option we added another one making a total of 2.
     */
    public void testaddUserToPoll() {
        testPoll.addUserToPoll(testUser);
        assertEquals(testPoll.getUsers().size(), 2);
    }

}
