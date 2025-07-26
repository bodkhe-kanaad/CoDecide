package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.user.UserAction;

public class UserActionTest {

    @Test
    public void testsignUp() {
        UserAction.getAllUsersMap().clear();
        int originalMapSize = UserAction.getAllUsersMap().size();
        UserAction.signUp("John", "Doe", "doe.john", "Testpassword@1234");
        assertEquals("doe.john", UserAction.getAllUsersMap().get("doe.john").getUsername());
        assertEquals(originalMapSize + 1, UserAction.getAllUsersMap().size());
    }

    @Test
    public void testloginCorrect() {
        UserAction.getAllUsersMap().clear();
        UserAction.signUp("John", "Doe", "doe.john", "Testpassword@1234");
        Session session = UserAction.login("doe.john", "Testpassword@1234");
        assertNotNull(session);
        assertEquals("doe.john", session.getCurrentUserLoggedIn().getUsername());
    }

    @Test
    public void testLoginBothIncorrect() {
        UserAction.getAllUsersMap().clear();
        UserAction.signUp("John", "Doe", "doe.john", "Testpassword@1234");
        Session session = UserAction.login("doe.johnny", "Testpassword@123");
        assertNull(session);
    }

    @Test
    public void testloginIncorrectPassword() {
        UserAction.getAllUsersMap().clear();
        UserAction.signUp("John", "Doe", "doe.john", "Testpassword@1234");
        Session session = UserAction.login("doe.john", "Testpassword@123");
        assertNull(session);
    }

    @Test
    public void testloginIncorrectUsername() {
        UserAction.getAllUsersMap().clear();
        UserAction.signUp("John", "Doe", "doe.john", "Testpassword@1234");
        Session session = UserAction.login("doe.johnny", "Testpassword@123");
        assertNull(session);
    }

    @Test
    public void testisUsernameExists() {
        UserAction.getAllUsersMap().clear();
        UserAction.signUp("Adam", "Eve", "adam.eve", "Testpassword@1234");
        assertTrue(UserAction.getAllUsersMap().containsKey("adam.eve")); // Added this user to the all users in test
                                                                         // before this
        assertFalse(UserAction.getAllUsersMap().containsKey("Test 1234"));
    }

    @Test
    public void testAllUsersMap() {
        UserAction.getAllUsersMap().clear();
        UserAction.signUp("John", "Doe", "doe.john", "Testpassword@1234");
        assertEquals(1, UserAction.getAllUsersMap().size());
                                                             
    }

    @Test
    public void testLoginWithNonexistentUsername() {
        UserAction.getAllUsersMap().clear();
        Session session = UserAction.login("ghost.user", "irrelevantPassword");
        assertNull(session);
    }

    @Test
    public void testNextUserLoginAuthentication() {

    }

}
