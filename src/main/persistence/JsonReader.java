package persistence;

import org.json.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import model.*;

public class JsonReader {
    private String userFile;
    private String pollFile;

    public JsonReader(String userFile, String pollFile) {
        this.userFile = userFile;
        this.pollFile = pollFile;
    }

    public static JsonReader jsonReaderUser(String userFile) {
        return new JsonReader(userFile, "");
    }

    public static JsonReader jsonReaderPoll(String pollFile) {
        return new JsonReader("", pollFile);
    }

    public Map<String, User> readUsers() {

    }

    public Map<Integer, Poll> readPolls(Map<String, User> allUsers) {

    }
}
