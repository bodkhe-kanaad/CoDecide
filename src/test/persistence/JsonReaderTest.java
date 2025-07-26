package persistence;

import model.Poll.Poll;
import model.User.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest {
    private static final String USERS_FILE = "./data/testUsers.json";
    private static final String POLLS_FILE = "./data/testPolls.json";

    private JsonReader reader;
    private Map<String, User> testUsers;
    private Map<Integer, Poll> testPolls;
    private User u1;
    private User u2;
    private Poll p1;
    private Poll p2;

    @BeforeEach
    public void runBefore() {
        reader = new JsonReader(USERS_FILE, POLLS_FILE);
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
            assertEquals(2, u1.getPartOfPoll().size());

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
            assertEquals(u1.getUsername(), readP1.getOwner().getUsername());
            assertEquals(2, readP1.getOptions().size());
            assertEquals(2, readP1.getUsers().size());
            assertEquals(u1, readP1.getUsers().get(0));
            assertEquals(p1.getOptions().get(0).getOptionId(), readP1.getOptions().get(0).getOptionId());
            assertEquals("A", readP1.getOptions().get(0).getValue());
            assertEquals(0, readP1.getOptions().get(0).getVoteTotal());

        } catch (IOException e) {
            fail("Reading Failed" + e.getMessage());
        }
    }

    @Test
    public void testJsonReaderUser() {
        assertNotNull(JsonReader.jsonReaderUser(USERS_FILE));
    }

    @Test
    public void testJsonReaderPoll() {
        assertNotNull(JsonReader.jsonReaderPoll(POLLS_FILE));
    }

    @Test
    public void testUserPolllinkingAfterRead() {
        try {
            Map<String, User> users = reader.readUsers();
            Map<Integer, Poll> polls = reader.readPolls(users);

            User readU1 = users.get("doe.john");
            User readU2 = users.get("eve.adam");

            List<Poll> pollsForU1 = readU1.getPartOfPoll();
            assertEquals(2, pollsForU1.size());
            assertTrue(pollsForU1.stream().anyMatch(p -> p.getPollId() == p2.getPollId()));

            List<Poll> pollsForU2 = readU2.getPartOfPoll();
            assertEquals(2, pollsForU2.size());
            assertTrue(pollsForU2.stream().anyMatch(p -> p.getPollId() == p1.getPollId()));

            readU2.getPartOfPollId().add(1000);
            assertEquals(2, pollsForU2.size());
            assertTrue(pollsForU2.stream().anyMatch(p -> p.getPollId() == p1.getPollId()));

        } catch (IOException e) {
            fail("Failed: " + e.getMessage());
        }
    }

}
