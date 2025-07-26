package persistence;

import model.poll.Poll;
import model.user.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest {
    private static final String USERS_FILE = "./data/testUsers.json";
    private static final String POLLS_FILE = "./data/testPolls.json";

    private Map<String, User> testUsers;
    private Map<Integer, Poll> testPolls;

    private User u1;
    private User u2;
    private Poll p1;
    private Poll p2;

    @BeforeEach
    void runBefore() {
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
    }

    @Test
    void testWriteAllUsers() {
        JsonWriter writer = new JsonWriter(USERS_FILE);
        try {
            writer.open();
            writer.writeAllUsers(testUsers);
            writer.close();

            File f = new File(USERS_FILE);
            assertTrue(f.exists());
            assertTrue(f.length() > 0);
        } catch (FileNotFoundException e) {
            fail("File not found");
        }
    }

    @Test
    void testWriteAllPolls() {
        JsonWriter writer = new JsonWriter(POLLS_FILE);
        try {
            writer.open();
            writer.writeAllPolls(testPolls);
            writer.close();

            File f = new File(POLLS_FILE);
            assertTrue(f.exists());
            assertTrue(f.length() > 0);
        } catch (FileNotFoundException e) {
            fail("File not found");
        }
    }

}
