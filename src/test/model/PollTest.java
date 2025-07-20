package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        assertEquals(1, testPoll.getOptions().size());
        testPoll.addOptionToPoll("Test String 2");
        assertEquals(2, testPoll.getOptions().size());
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
        String result;
        testPoll.addOptionToPoll("Test String 1");
        testPoll.getOptions().get(0).addVote(99);
        result = testPoll.pollResults();
        assertEquals(result, testPoll.getOptions().get(0).getValue());

        testPoll.addOptionToPoll("Test 2");
        testPoll.getOptions().get(1).addVote(100);
        result = testPoll.pollResults();
        assertEquals(result, testPoll.getOptions().get(1).getValue());

        testPoll.addOptionToPoll("Test 3");
        testPoll.getOptions().get(1).addVote(50);
        result = testPoll.pollResults();
        assertEquals(result, testPoll.getOptions().get(1).getValue());
    }

    @Test
    public void testToJson() {
        testPoll.addOptionToPoll("Test 1");
        testPoll.getHasVoted().add(testUser);
        JSONObject pollJson = testPoll.toJson();
        JSONArray optionListJson;
        JSONArray usersListJson;
        JSONArray usersVotedListJson;

        assertEquals(testPoll.getPollId(), pollJson.getInt("pollId"));
        assertEquals(testPoll.getOwner().getUsername(), pollJson.getString("owner"));
        assertEquals(testPoll.isCompleted(), pollJson.getBoolean("isCompleted"));

        optionListJson = pollJson.getJSONArray("optionsList");
        assertEquals(testPoll.getOptions().size(), optionListJson.length());
        assertEquals("Test 1", optionListJson.getJSONObject(0).get("value"));

        usersListJson = pollJson.getJSONArray("usersList");
        assertEquals(testPoll.getUsers().size(), usersListJson.length());

        usersVotedListJson = pollJson.getJSONArray("usersVotedList");
        assertEquals(testPoll.getHasVoted().size(), usersVotedListJson.length());
        assertEquals("doe.john", usersVotedListJson.getString(0));
    }

    @Test
    public void testReconstructPoll() {
        User u1 = User.createUser("John", "Doe", "doe.john", "Test@123");
        User u2 = User.createUser("Jane", "Smith", "smith.jane", "Pass@123");
        Map<String, User> allUsers = new HashMap<>();
        allUsers.put(u1.getUsername(), u1);
        allUsers.put(u2.getUsername(), u2);

        JSONObject pollJson = new JSONObject();
        pollJson.put("pollId", 101);
        pollJson.put("owner", "doe.john");
        pollJson.put("isCompleted", false);

        JSONArray usersList = new JSONArray();
        usersList.put("doe.john");
        usersList.put("smith.jane");

        JSONArray usersVotedList = new JSONArray();
        usersVotedList.put("smith.jane");

        JSONArray optionsList = new JSONArray();
        JSONObject option1 = new JSONObject();
        option1.put("optionId", 1);
        option1.put("value", "Option A");
        option1.put("voteTotal", 3);
        optionsList.put(option1);

        pollJson.put("usersList", usersList);
        pollJson.put("usersVotedList", usersVotedList);
        pollJson.put("optionsList", optionsList);

        Poll reconstructed = Poll.reconstructPoll(pollJson, allUsers);

        assertEquals(101, reconstructed.getPollId());
        assertEquals(u1, reconstructed.getOwner());
        assertFalse(reconstructed.isCompleted());
        assertEquals(2, reconstructed.getUsers().size());
        assertEquals(1, reconstructed.getHasVoted().size());
        assertEquals("smith.jane", reconstructed.getHasVoted().get(0).getUsername());

        assertEquals(1, reconstructed.getOptions().size());
        assertEquals("Option A", reconstructed.getOptions().get(0).getValue());
        assertEquals(3, reconstructed.getOptions().get(0).getVoteTotal());
    }

    @Test
    public void testReconstructPollWithMissingUser() {
        JSONObject fakePollJson = new JSONObject();
        fakePollJson.put("pollId", 99);
        fakePollJson.put("owner", "ownerUser"); 
        fakePollJson.put("isCompleted", false);

       
        JSONArray usersList = new JSONArray();
        usersList.put("ownerUser"); 
        usersList.put("ghostUser"); 
        fakePollJson.put("usersList", usersList);

        
        JSONArray hasVotedList = new JSONArray();
        hasVotedList.put("ghostUser");
        fakePollJson.put("usersVotedList", hasVotedList);

        
        fakePollJson.put("optionsList", new JSONArray());

        
        User owner = User.createUser("Owner", "User", "ownerUser", "pass");
        Map<String, User> allUsers = new HashMap<>();
        allUsers.put("ownerUser", owner);

        Poll reconstructed = Poll.reconstructPoll(fakePollJson, allUsers);

        assertEquals(99, reconstructed.getPollId());
        assertEquals(owner, reconstructed.getOwner());

        
        assertEquals(1, reconstructed.getUsers().size());
        assertTrue(reconstructed.getUsers().contains(owner));

        
        assertEquals(0, reconstructed.getHasVoted().size());

        assertEquals(0, reconstructed.getOptions().size());
    }

}
