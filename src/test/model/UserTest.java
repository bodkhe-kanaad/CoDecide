package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
    private User testUser;

    @Before
    public void runBefore() {
        testUser = new User(User.getNextUserID(), "John", "Doe", "doe.john", "Testpassword@1234",
                model.Poll.EMPTY_POLLS);
    }

    @Test
    /*
     * Since the createUser method uses the User() - Construtor; as a helper
     * function I do not need to test if the construtor is working as intended
     */
    public void testcreateUser() {
        User newUser = model.User.createUser("John", "Doe", "doe.john", "Testpassword@1234");
        assertEquals(newUser.getUserId(), User.getNextUserID() - 1);
        assertEquals(newUser.getFirstName(), "John");
        assertEquals(newUser.getLastName(), "Doe");
        assertEquals(newUser.getUsername(), "doe.john");
        assertEquals(newUser.getPassword(), "Testpassword@1234");
        assertEquals(newUser.getPartOfPoll(), Poll.EMPTY_POLLS);
    }
}

