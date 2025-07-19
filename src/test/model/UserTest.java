package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class UserTest {
    private User newUser;
    private Poll p1;
    private Poll p2;

    @Before
    public void runBefore() {
        newUser = model.User.createUser("John", "Doe", "doe.john", "Testpassword@1234");
        p1 = Poll.createPoll(newUser);
        p2 = Poll.createPoll(newUser);
    }

    @Test
    public void testcreateUser() {
        assertEquals(newUser.getUserId(), User.getNextUserID() - 1);
        assertEquals(newUser.getFirstName(), "John");
        assertEquals(newUser.getLastName(), "Doe");
        assertEquals(newUser.getUsername(), "doe.john");
        assertEquals(newUser.getPassword(), "Testpassword@1234");
        assertEquals(newUser.getPartOfPoll(), Poll.EMPTY_POLLS);
    }

    @Test
    public void testToJson() {
        Poll.resetNextPollId();
        User.resetNextUserID();
        JSONObject userJson = newUser.toJson();

        assertEquals("doe.john", userJson.getString("username"));
        assertEquals("John", userJson.getString("firstName"));
        assertEquals("Doe", userJson.getString("lastName"));
        assertEquals("Testpassword@1234", userJson.getString("password"));
        assertEquals(newUser.getUserId(), userJson.getInt("userId"));

        JSONArray pollIds = userJson.getJSONArray("partOfPolls");
        assertEquals(p1.getPollId(), pollIds.getInt(0));
        assertEquals(p2.getPollId(), pollIds.getInt(1));
    }

    @Test
    public void testgetTestuser() {
        assertNotNull(User.getTestuser());
    }

}
