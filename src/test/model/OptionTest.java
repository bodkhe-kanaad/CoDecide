package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class OptionTest {
    private Option testOption;

    @Before
    public void runBefore() {
        testOption = new Option("Test Option");
    }

    @Test
    public void testCreateOption() {
        Option newOption = Option.createOption("Test Option");
        assertEquals(newOption.getValue(), testOption.getValue());
    }

    @Test
    public void testaddVote() {
        Option newOption = new Option("Test Option");
        newOption.addVote(15);
        assertEquals(newOption.getVoteTotal(),15);
        newOption.addVote(-15);
        assertEquals(newOption.getVoteTotal(),0);
        newOption.addVote(0);
        assertEquals(newOption.getVoteTotal(),0);
        newOption.addVote(100);
        assertEquals(newOption.getVoteTotal(),100);
    }

}
