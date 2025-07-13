package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.Test;

public class PollActionTest {

    @Test
    public void testAddingUserToPoll() {
        UserAction.getAllUsersMap().clear();
        Poll poll = Poll.createPoll(User.getTestuser());
        poll.getUsers().clear();

        UserAction.signUp("John", "Doe", "doe.john", "Testpassword@123");
        boolean result = PollAction.addingUserToPoll("doe.john", poll);
        assertTrue(result);
        assertEquals(1, poll.getUsers().size());
        assertEquals("doe.john", poll.getUsers().get(0).getUsername());
        assertTrue(UserAction.getAllUsersMap().get("doe.john").getPartOfPoll().contains(poll));
    }

    @Test
    public void testAddingUserToPollFailure() {
        UserAction.getAllUsersMap().clear();
        Poll poll = Poll.createPoll(User.getTestuser());
        poll.getUsers().clear();
        boolean result = PollAction.addingUserToPoll("non.signedup", poll);
        assertFalse(result);
        assertTrue(poll.getUsers().isEmpty());
        assertFalse(UserAction.getAllUsersMap().containsKey("non.signedup"));
    }

    @Test
    public void testAddingOptionToPoll() {
        Poll poll =  Poll.createPoll(User.getTestuser());
        poll.getOptions().clear();
        PollAction.addingOptionToPoll("Test 1", poll);
        assertEquals(1,poll.getOptions().size());
    }

    @Test
    public void testcaseVoteSuccess() {
        User testUser = User.getTestuser();
        Option option = Option.testOptionList().getFirst();
        option.setVoteTotal(0);
        boolean result = PollAction.casteVote(testUser, option, 20);
        assertTrue(result);
        assertEquals(75, option.getVoteTotal());
    }

    public void testcaseVoteFaliure() {
        User testUser = User.getTestuser();
        Option option = Option.testOptionList().getFirst();
        option.setVoteTotal(0);
        boolean result = PollAction.casteVote(testUser, option, 200);
        assertFalse(result);
    }

}
