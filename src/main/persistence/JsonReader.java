package persistence;

import org.json.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import model.*;

public class JsonReader {
    private String userSourceFile;
    private String pollSourceFile;



    public JsonReader(String userFile, String pollFile) {
        this.userSourceFile = userFile;
        this.pollSourceFile = pollFile;
    }

    public static JsonReader jsonReaderUser(String userFile) {
        return new JsonReader(userFile, "");
    }

    public static JsonReader jsonReaderPoll(String pollFile) {
        return new JsonReader("", pollFile);
    }

    public static String readFile(String source) throws IOException {
        return new String(Files.readAllBytes(Paths.get(source)));
    }

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
