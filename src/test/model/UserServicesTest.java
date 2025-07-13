package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import model.UserServices;

public class UserServicesTest {
    private User testUser;

    @Test
    public void testsignUp() {
        int originalMapSize = UserServices.getAllUsersMap().size();
        UserServices.signUp("John", "Doe", "doe.john", "Testpassword@1234");
        assertEquals(originalMapSize + 1, UserServices.getAllUsersMap().size());
    }

    @Test
    public void testlogin() {
        String result = UserServices.login("doe.john","Testpassword@1234");
        assertEquals(result,"Successfull");
    }

    @Test
    public void testisUsernameExists() {
        assertTrue(UserServices.isUsernameExists("doe.john")); // Added this user to the all users in test before this
        assertTrue(UserServices.isUsernameExists("Test 1234"));
    }


}
