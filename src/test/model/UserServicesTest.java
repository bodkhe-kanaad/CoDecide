package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UserServicesTest {

    @Test
    public void testsignUp() {
        int originalMapSize = UserServices.getAllUsersMap().size();
        UserServices.signUp("John", "Doe", "doe.john", "Testpassword@1234");
        assertEquals(originalMapSize + 1, UserServices.getAllUsersMap().size());
    }

    @Test
    public void testlogin() {
        String result = UserServices.login("doe.john", "Testpassword@1234");
        assertEquals(result, "Successfull");
    }

    @Test
    public void testisUsernameExists() {
        UserServices.signUp("Adam", "Eve", "adam.eve", "Testpassword@1234");
        assertTrue(UserServices.isUsernameExists("adam.eve")); // Added this user to the all users in test before this
        assertFalse(UserServices.isUsernameExists("Test 1234"));
    }

}
