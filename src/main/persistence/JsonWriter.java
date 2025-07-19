package persistence;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Map;
import java.io.File;

import org.json.*;

import model.Poll;
import model.User;

public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructor for the writer to write to destination files
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES this
    // EFFECTS: Opens the writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES this
    // EFFECTS writes the saved fields as strings to file
    private void saveToFile(String jsonString) {
        writer.print(jsonString);
    }

    // MODIFIES this
    // EFFECTS closes the writer
    public void close() {
        writer.close();
    }

    // REQUIRES: writer has been opened using open()
    // MODIFIES: this
    // EFFECTS: writes all users in the given map to destination file in JSON format
    public void writeAllUsers(Map<String, User> users) {
        JSONObject root = new JSONObject();
        JSONArray usersArray = new JSONArray();

        for (User u : users.values()) {
            usersArray.put(u.toJson());
        }
        root.put("users", usersArray);
        saveToFile(root.toString(TAB));
    }

    // REQUIRES : writer has opened using open()
    // MODIFIES : this
    // EFFECTS : writes all polls in the given map to destination file in JSON format
    public void writeAllPolls(Map<Integer, Poll> polls) {
        JSONObject root = new JSONObject();
        JSONArray pollsArray = new JSONArray();

        for (Poll p : polls.values()) {
            pollsArray.put(p.toJson());
        }
        root.put("polls", pollsArray);
        saveToFile(root.toString(TAB));
    }
    
}
