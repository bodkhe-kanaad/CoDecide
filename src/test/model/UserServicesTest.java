package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UserServicesTest {

    @Test
    public void testsignUp() {
        UserServices.getAllUsersMap().clear();
        int originalMapSize = UserServices.getAllUsersMap().size();
        UserServices.signUp("John", "Doe", "doe.john", "Testpassword@1234");
        assertEquals("doe.john", UserServices.getAllUsersMap().get("doe.john").getUsername());
        assertEquals(originalMapSize + 1, UserServices.getAllUsersMap().size());
    }

    @Test
    public void testloginCorrect() {
        UserServices.getAllUsersMap().clear();
        UserServices.signUp("John", "Doe", "doe.john", "Testpassword@1234");
        Session session = UserServices.login("doe.john", "Testpassword@1234");
        assertNotNull(session);
        assertEquals("doe.john", session.getCurrentUserLoggedIn().getUsername());
    }

    @Test
    public void testLoginBothIncorrect() {
        UserServices.getAllUsersMap().clear();
        UserServices.signUp("John", "Doe", "doe.john", "Testpassword@1234");
        Session session = UserServices.login("doe.johnny", "Testpassword@123");
        assertNull(session);
    }

    @Test
    public void testloginIncorrectPassword() {
        UserServices.getAllUsersMap().clear();
        UserServices.signUp("John", "Doe", "doe.john", "Testpassword@1234");
        Session session = UserServices.login("doe.john", "Testpassword@123");
        assertNull(session);
    }

    @Test
    public void testloginIncorrectUsername() {
        UserServices.getAllUsersMap().clear();
        UserServices.signUp("John", "Doe", "doe.john", "Testpassword@1234");
        Session session = UserServices.login("doe.johnny", "Testpassword@123");
        assertNull(session);
    }

    @Test
    public void testisUsernameExists() {
        UserServices.getAllUsersMap().clear();
        UserServices.signUp("Adam", "Eve", "adam.eve", "Testpassword@1234");
        assertTrue(UserServices.getAllUsersMap().containsKey("adam.eve")); // Added this user to the all users in test
                                                                           // before this
        assertFalse(UserServices.getAllUsersMap().containsKey("Test 1234"));
    }

    @Test
    public void testAllUsersMap() {
        UserServices.getAllUsersMap().clear();
        UserServices.signUp("Rick", "Grimes", "rick.grimes", "ZombieKill");
        assertEquals(1, UserServices.getAllUsersMap().size());
    }

    @Test
    public void testLoginWithNonexistentUsername() {
        UserServices.getAllUsersMap().clear();
        Session session = UserServices.login("ghost.user", "irrelevantPassword");
        assertNull(session);
    }

}
