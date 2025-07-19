package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.json.JSONArray;
import org.json.JSONObject;

public class PollTest {
    Poll testPoll;
    User testUser = User.createUser("John", "Doe", "doe.john", "Testpassword@1234");
    List<Option> testOptionList = Option.testOptionList();

    @BeforeEach
    public void runBefore() {
        Poll.resetNextPollId();
        User.resetNextUserID();
        testPoll = Poll.createPoll(testUser);
        
    }

    @Test
    /*
     * Compare all the fields between testPoll and newPoll if they match then the
     * method works as intended
     */
    public void testcreatePoll() {
        assertEquals(testPoll.getPollId(), Poll.getNextPollId() - 1);
        assertEquals(testUser, testPoll.getOwner());
        assertEquals(1, testPoll.getUsers().size());
        assertEquals(0, testPoll.getOptions().size());
        assertEquals(0, testPoll.getHasVoted().size());
        assertFalse(testPoll.isCompleted());
    }

    @Test
    /*
     * Compare the size list since there was 2 option in originally the test option
     * Since the method add's one option we added another one making a total of 3.
     */
    public void testaddOptionToPoll() {
        testPoll.addOptionToPoll("Test String 1");
        assertEquals(1,testPoll.getOptions().size());
        testPoll.addOptionToPoll("Test String 2");
        assertEquals(2,testPoll.getOptions().size());
    }

    @Test
    /*
     * Compare the size list since there was 1 option in originally the owner
     * Since the method add's one option we added another one making a total of 2.
     */
    public void testaddUserToPoll() {
        assertEquals(1, testPoll.getUsers().size());
        testPoll.addUserToPoll(testUser);
        assertEquals(2, testPoll.getUsers().size());
    }

    @Test
    public void testisCompleted() {
        testPoll.setCompleted(true);
        assertEquals(testPoll.isCompleted(), true);
        assertNotEquals(testPoll.isCompleted(), false);
    }

    @Test
    public void pollResults() {
        testPoll.addOptionToPoll("Test String 1");
        testPoll.getOptions().get(0).addVote(100);
        String result = testPoll.pollResults();
        assertEquals(result, testPoll.getOptions().get(0).getValue());
    }

    @Test
    public void testToJson() {
        JSONObject pollJson = testPoll.toJson();
        JSONArray optionListJson;
        JSONArray usersListJson;
        JSONArray usersVotedListJson;

        assertEquals(testPoll.getPollId(), pollJson.getInt("pollId"));
        assertEquals(testPoll.getOwner().getUsername(), pollJson.getString("owner"));
        assertEquals(testPoll.isCompleted(), pollJson.getBoolean("isCompleted"));

        optionListJson = pollJson.getJSONArray("optionsList");
        assertEquals(testPoll.getOptions().size(), optionListJson.length());

        usersListJson = pollJson.getJSONArray("usersList");
        assertEquals(testPoll.getUsers().size(), usersListJson.length());

        usersVotedListJson = pollJson.getJSONArray("usersVotedList");
        assertEquals(testPoll.getHasVoted().size(), usersVotedListJson.length());

    }
}
