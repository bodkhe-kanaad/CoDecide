package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONObject;

/*
 * This class represents a option in the poll. 
 * It has details 
 */
public class Option {
    private int nextOptionId = 1;
    private static final int DEFAULT_VOTE_TOTAL = 0;

    private final int optionId; // Unique id for each option made
    private int voteTotal; // This is the aggregated value that this option has received from all users.
    private String value; //  This is the actual string value of that option.

    public Option(int optionID, int voteValue, String value) {
        this.optionId = optionID;
        this.voteTotal = voteValue;
        this.value = value;
    }

    // To make a new Option that can be added.
    // It is different from the constructor because it automatically increments the
    // values for optionId everytime Option is created.
    // It assigned the voteTotal to be 0 since for a new Option no one will have
    // voted it
    public Option(String value) {
        this.optionId = nextOptionId;
        nextOptionId++;
        this.voteTotal = DEFAULT_VOTE_TOTAL;
        this.value = value;
    }

    public int getOptionId() {
        return optionId;
    }

    public int getVoteTotal() {
        return voteTotal;
    }

    public void setVoteTotal(int voteValue) {
        this.voteTotal = voteValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // EFFECTS It creates a new option that can be added to the poll when the user
    // specifies its value
    public static Option createOption(String option) {
        return new Option(option);
    }

    // MODIFIES this
    // EFFECT It adds the vote from the user for this option to the option's total vote.
    public void addVote(int vote) {
        int currentVote = this.getVoteTotal();
        int newVote = currentVote + vote;
        this.setVoteTotal(newVote);  
    }
    
    // MODIFIES this
    // EFFECT changes the text for this option. 
    public void changeOption(String newText) {
        this.setValue(newText);
    }

    // Helper method for testing.
    public static final List<Option> testOptionList() {
        List<Option> testOptionList = new ArrayList<>();
        Option testOption = new Option("Test");
        testOptionList.add(testOption);
        testOptionList.add(testOption);
        return testOptionList;
    }

    public JSONObject toJson() {
        JSONObject optionJson = new JSONObject();
        optionJson.put("optionId", optionId);
        optionJson.put("voteTotal", voteTotal);
        optionJson.put("value", value);

        return optionJson;
    }



}
