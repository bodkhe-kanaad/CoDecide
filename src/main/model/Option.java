package model;

import java.util.ArrayList;
import java.util.List;

/*
 * This class represents a single option in the poll
 * It can hold any type of value for example it can be string or int
 */
public class Option {
    private int nextOptionId = 1;
    private static final int DEFAULT_VOTE_TOTAL = 0;

    private final int optionID; // Unique id for each option made
    private int voteTotal; // This is the aggregated value that this option has received from all users.
    private String value; // Using Java generics to accept any data type

    public Option(int optionID, int voteValue, String value) {
        this.optionID = optionID;
        this.voteTotal = voteValue;
        this.value = value;
    }

    // To make a new Option that can be added.
    // It is different from the constructor because it automatically increments the
    // values for optionId everytime Option is created.
    // It assigned the voteTotal to be 0 since for a new Option no one will have
    // voted it
    public Option(String value) {
        this.optionID = nextOptionId;
        nextOptionId++;
        this.voteTotal = DEFAULT_VOTE_TOTAL;
        this.value = value;
    }

    public int getOptionID() {
        return optionID;
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

    // REQUIRES You to specify the option is of which data type
    // EFFECTS It creates a new option that can be added to the poll when the user
    // specifies its value
    public static Option createOption(String option) {
        return new Option(option);
    }

    // The constraints on how much vote can be passed to this parameter will be handled 
    // by the method that calls this one
    // MODIFIES this
    // EFFECT It adds the vote from this user for this option to this options aggregate vote.
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

    // 
    public static final List<Option> testOptionList() {
        List<Option> testOptionList = new ArrayList<>();
        Option testOption = new Option("Test");
        testOptionList.add(testOption);
        return testOptionList;
    }


}
