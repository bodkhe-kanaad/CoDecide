package model;

import static org.junit.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class UserTest {
    private User newUser;
    private Poll p1;
    private Poll p2;

    @BeforeEach
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

    public void testToJson() {
        JSONObject userJson = newUser.toJson();

        assertEquals("doe.john", userJson.getString("username"));
        assertEquals("John", userJson.getString("firstName"));
        assertEquals("Doe", userJson.getString("lastName"));
        assertEquals("Testpassword@1234", userJson.getString("password"));
        assertEquals(newUser.getUserId(), userJson.getInt("userId"));

        JSONArray pollIds = userJson.getJSONArray("partOfPoll");
        assertEquals(2, pollIds.length());
        assertEquals(p1.getPollId(), pollIds.get(0));
        assertEquals(p2.getPollId(), pollIds.get(1));
    }

}

