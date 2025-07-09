package model;

/*
 * This class represents a single option in the poll
 * It can hold any type of value for example it can be string or int
 */
public class Option<A> {
    private static int NEXT_OPTION_ID = 1;
    private static final int DEFAULT_VOTE_TOTAL = 0;

    private final int optionID; // Unique id for each option made
    private int voteTotal; // This is the aggregated value that this option has received from all users.
    private A value; // Using Java generics to accept any data type

    public Option(int optionID, int voteValue, A value) {
        this.optionID = optionID;
        this.voteTotal = voteValue;
        this.value = value;
    }

    // To make a new Option that can be added.
    // It is different from the constructor because it automatically increments the
    // values for optionId everytime Option is created.
    // It assigned the voteTotal to be 0 since for a new Option no one will have
    // voted it
    public Option(A value) {
        this.optionID = NEXT_OPTION_ID;
        NEXT_OPTION_ID++;
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

    public A getValue() {
        return value;
    }

    public void setValue(A value) {
        this.value = value;
    }

    // REQUIRES You to specify the option is of which data type
    // EFFECTS It creates a new option that can be added to the poll when the user
    // specifies its value
    public static <A> Option<A> createOption(A option) {
        return new Option<A>(option);
    }
}
