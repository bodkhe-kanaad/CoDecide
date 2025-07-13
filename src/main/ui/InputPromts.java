package ui;

import model.*;

public class InputPromts {

    public static final void optionInputs() {
        System.out.println("Press (1) to add other option Or (0) To move on");
    }

    public static final void userInputs() {
        System.out.println("Press (1) to add other user Or (0) To move on");
    }

    public static final void voteInputs(Option option) {
        System.out.println("Please select a value on a scale from 0 to 100");
        System.out.println("where 0 means least wanted and 100 means most wanted.");
        System.out.println("For the Option " + option.getValue());
    }
}
