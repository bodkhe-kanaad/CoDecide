package persistence;

import model.Poll;
import model.User;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest {
    private static final String USERS_FILE = "./data/test_users.json";
    private static final String POLLS_FILE = "./data/test_polls.json";

    private JsonReader reader;
    private Map<String, User> testUsers;
    private Map<Integer, Poll> testPolls;
    private User u1, u2;
    private Poll p1, p2;

    @BeforeEach
    public void runBefore() {
        reader = JsonReader.jsonReaderUser(USERS_FILE);
        testUsers = new HashMap<>();
        testPolls = new HashMap<>();

        u1 = User.createUser("John", "Doe", "doe.john", "T");
        u2 = User.createUser("Adam", "Eve", "eve.adam", "T");

        testUsers.put(u1.getUsername(), u1);
        testUsers.put(u2.getUsername(), u2);

        p1 = Poll.createPoll(u1);
        p1.addOptionToPoll("A");
        p1.addOptionToPoll("B");
        p1.addUserToPoll(u2);

        p2 = Poll.createPoll(u2);
        p2.addOptionToPoll("A");
        p2.addOptionToPoll("B");
        p2.addUserToPoll(u1);

        testPolls.put(p1.getPollId(), p1);
        testPolls.put(p2.getPollId(), p2);

        // Step 2: Write to JSON using JsonWriter
        JsonWriter userWriter = new JsonWriter(USERS_FILE);
        JsonWriter pollWriter = new JsonWriter(POLLS_FILE);

        try {
            userWriter.open();
            userWriter.writeAllUsers(testUsers);
            userWriter.close();

            pollWriter.open();
            pollWriter.writeAllPolls(testPolls);
            pollWriter.close();
        } catch (IOException e) {
            fail("Couldn't write to test file: " + e.getMessage());
        }
    }

    @Test
    public void testReadUsers() {
        try {
            Map<String, User> users = reader.readUsers();

            assertEquals(2, users.size());
            assertTrue(users.containsKey("doe.john"));
            assertTrue(users.containsKey("eve.adam"));

            User readU1 = users.get("doe.john");
            assertEquals("John", readU1.getFirstName());
            assertEquals("Doe", readU1.getLastName());
            assertEquals("T", readU1.getPassword());
            assertEquals(u1.getUserId(), readU1.getUserId());

        } catch (IOException e) {
            fail("Reading Failed");
        }
    }

    @Test
    public void testReadPolls() {
        try {
            Map<Integer, Poll> polls = reader.readPolls(testUsers);

            assertEquals(2, polls.size());
            assertTrue(polls.containsKey(p1.getPollId()));
            assertTrue(polls.containsKey(p2.getPollId()));

            Poll readP1 = polls.get(p1.getPollId());
            assertEquals(u1.getUsername(),p1.getOwner().getUsername());
            assertEquals(2, readP1.getOptions().size());
            assertEquals(2, readP1.getUsers().size());
            assertEquals(u1, readP1.getUsers().get(0));
            assertEquals(p1.getOptions().get(0).getOptionId(), readP1.getOptions().get(0).getOptionId());
            assertEquals("A", readP1.getOptions().get(0).getValue());
            assertEquals(0, readP1.getOptions().get(0).getVoteTotal());
            
        } catch (IOException e) {
            fail("Reading Failed");
        }

    }

}
