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

}
