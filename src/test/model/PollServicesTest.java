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

        UserServices.signUp("John", "Doe", "doe.john", "Testpassword@123");
        boolean result = PollServices.addingUserToPoll("doe.john", poll);
        assertTrue(result);
        assertEquals(1, poll.getUsers().size());
        assertEquals("doe.john", poll.getUsers().get(0).getUsername());
        assertTrue(UserServices.getAllUsersMap().get("jane.doe").getPartOfPoll().contains(poll));
    }

    @Test
    public void testAddingUserToPollFailure() {
        UserServices.getAllUsersMap().clear();
        Poll poll = Poll.createPoll(User.getTestuser());
        boolean result = PollServices.addingUserToPoll("non.signedup", poll);
        assertFalse(result);
        assertTrue(poll.getUsers().isEmpty());
        assertFalse(UserServices.getAllUsersMap().containsKey("non.signedup"));
    }

}
