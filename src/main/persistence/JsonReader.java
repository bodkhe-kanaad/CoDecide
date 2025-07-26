package persistence;

import org.json.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import model.Poll.Poll;
import model.User.User;

public class JsonReader {
    private String userSourceFile;
    private String pollSourceFile;

    // EFFECTS Constructor for the JsonReader
    public JsonReader(String userFile, String pollFile) {
        this.userSourceFile = userFile;
        this.pollSourceFile = pollFile;
    }

    // EFFECTS Constructor for the JsonReader
    public static JsonReader jsonReaderUser(String userFile) {
        return new JsonReader(userFile, "");
    }

    // EFFECTS Constructor for the JsonReader
    public static JsonReader jsonReaderPoll(String pollFile) {
        return new JsonReader("", pollFile);
    }

    // REQUIRES: source must be a valid path to an existing file.
    // EFFECTS: Reads all bytes from the given file and returns its content as a
    // String.
    // Throws IOException if the file cannot be read.

    public static String readFile(String source) throws IOException {
        return new String(Files.readAllBytes(Paths.get(source)));
    }

    // REQUIRES: userSourceFile must exist and contain valid user data.
    // EFFECTS: Reads user data from file, reconstructs User objects, and returns a
    // map of usernames to Users.
    // Throws IOException if file read fails.

    public Map<String, User> readUsers() throws IOException {
        String data = readFile(userSourceFile);
        JSONObject root = new JSONObject(data);
        JSONArray usersArray = root.getJSONArray("users");

        Map<String, User> readUsersMap = new HashMap<>();
        for (Object obj : usersArray) {
            JSONObject userJson = (JSONObject) obj;
            User user = User.reconstructUser(userJson);
            readUsersMap.put(user.getUsername(), user);
        }

        return readUsersMap;

    }

    // REQUIRES: pollSourceFile must exist and contain valid poll data. allUsers
    // must not be null.
    // MODIFIES: allUsers (updates each user's partOfPoll list).
    // EFFECTS: Reconstructs Polls, links them to Users
    // and returns a map of poll ID to Poll.
    // Throws IOException if file read fails.
    public Map<Integer, Poll> readPolls(Map<String, User> allUsers) throws IOException {
        String data = readFile(pollSourceFile);
        JSONObject root = new JSONObject(data);
        JSONArray pollsArray = root.getJSONArray("polls");

        Map<Integer, Poll> readPollsMap = new HashMap<>();
        for (Object obj : pollsArray) {
            JSONObject pollJson = (JSONObject) obj;
            Poll poll = Poll.reconstructPoll(pollJson, allUsers);
            readPollsMap.put(poll.getPollId(), poll);
        }
        
        // Linking Users to Polls after reconstruction of Poll
        for (User u : allUsers.values()) {                     
            List<Poll> partOfPolls = new ArrayList<>();
            for (Integer pollId : u.getPartOfPollId()) {
                Poll poll = readPollsMap.get(pollId);
                if (poll != null) {
                    partOfPolls.add(poll);
                }
            }

            u.setPartOfPoll(partOfPolls);
        }
        return readPollsMap;
    }
}
