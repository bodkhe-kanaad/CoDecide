package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class UserTest {
    private User newUser;
    private User testUser;
    private Poll p1;
    private Poll p2;

    @Test
    public void testcreateUser() {
        newUser = model.User.createUser("John", "Doe", "doe.john", "Testpassword@1234");
        p1 = Poll.createPoll(newUser);
        p2 = Poll.createPoll(newUser);
        assertEquals(newUser.getUserId(), User.getNextUserID() - 1);
        assertEquals(newUser.getFirstName(), "John");
        assertEquals(newUser.getLastName(), "Doe");
        assertEquals(newUser.getUsername(), "doe.john");
        assertEquals(newUser.getPassword(), "Testpassword@1234");
        assertEquals(newUser.getPartOfPoll(), Poll.EMPTY_POLLS);
    }

    @Test
    public void testToJson() {
        testUser = model.User.createUser("John", "Doe", "doe.john", "Testpassword@1234");
        p1 = Poll.createPoll(testUser);
        p2 = Poll.createPoll(testUser);

        Poll.resetNextPollId();
        User.resetNextUserID();
        JSONObject userJson = testUser.toJson();

        assertEquals("doe.john", userJson.getString("username"));
        assertEquals("John", userJson.getString("firstName"));
        assertEquals("Doe", userJson.getString("lastName"));
        assertEquals("Testpassword@1234", userJson.getString("password"));
        assertEquals(testUser.getUserId(), userJson.getInt("userId"));

        JSONArray pollIds = userJson.getJSONArray("partOfPolls");
        assertTrue(pollIds.length() == 2);
    }

    @Test
    public void testgetTestuser() {
        assertNotNull(User.getTestuser());
    }

    @Test
    public void testReconstructUserWithoutPartOfPolls() {
        JSONObject userJson = new JSONObject();
        userJson.put("userId", 1);
        userJson.put("username", "doe.john");
        userJson.put("firstName", "John");
        userJson.put("lastName", "Doe");
        userJson.put("password", "Test@123");

        JSONArray partOfPolls = new JSONArray();
        partOfPolls.put(101);
        partOfPolls.put(102);
        userJson.put("partOfPolls", partOfPolls);

        User reconstructed = User.reconstructUser(userJson);

        assertEquals("doe.john", reconstructed.getUsername());
        assertEquals("John", reconstructed.getFirstName());
        assertEquals("Doe", reconstructed.getLastName());
        assertEquals("Test@123", reconstructed.getPassword());
        assertEquals(1, reconstructed.getUserId());
        assertEquals(0, reconstructed.getPartOfPoll().size());
    }

}
