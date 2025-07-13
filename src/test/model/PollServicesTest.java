package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class PollServicesTest {

    @Test
    public void testAddingUserToPoll() {
        UserServices.getAllUsersMap().clear();
        Poll poll = Poll.createPoll(User.getTestuser());
        poll.getUsers().clear();

        UserServices.signUp("John", "Doe", "doe.john", "Testpassword@123");
        boolean result = PollServices.addingUserToPoll("doe.john", poll);
        assertTrue(result);
        assertEquals(1, poll.getUsers().size());
        assertEquals("doe.john", poll.getUsers().get(0).getUsername());
        assertTrue(UserServices.getAllUsersMap().get("doe.john").getPartOfPoll().contains(poll));
    }

    @Test
    public void testAddingUserToPollFailure() {
        UserServices.getAllUsersMap().clear();
        Poll poll = Poll.createPoll(User.getTestuser());
        poll.getUsers().clear();
        boolean result = PollServices.addingUserToPoll("non.signedup", poll);
        assertFalse(result);
        assertTrue(poll.getUsers().isEmpty());
        assertFalse(UserServices.getAllUsersMap().containsKey("non.signedup"));
    }

    @Test
    public void testAddingOptionToPoll() {
        Poll poll =  Poll.createPoll(User.getTestuser());
        poll.getOptions().clear();
        PollServices.addingOptionToPoll("Test 1", poll);
        assertEquals(1,poll.getOptions().size());
    }

}
