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

    }

    // MODIFIES this
    // EFFECTS: Opens the writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {

    }

    // MODIFIES this
    // EFFECTS writes the saved fields as strings to file
    private void saveToFile(String jsonString) {

    }

    // MODIFIES this
    // EFFECTS closes the writer
    public void close() {

    }

    // REQUIRES: writer has been opened using open()
    // MODIFIES: this
    // EFFECTS: writes all users in the given map to destination file in JSON format
    public void writeAllUsers(Map<String, User> users) {
 
    }

    // REQUIRES : writer has opened using open()
    // MODIFIES : this
    // EFFECTS : writes all polls in the given map to destination file in JSON format
    public void writeAllPolls(Map<Integer, Poll> polls) {

    }
    
}
