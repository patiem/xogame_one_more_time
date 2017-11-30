package utility.validation;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IOValidationTest {

    @Test
    public void ifValuePassedToTestIsCorrectReturnValidResultTest() {

        //given
        IOValidation<String> sv = IOValidation.create(s -> s.equals(s), "Wrong");
        String s = "Anything";

        //when //then
        assertTrue(sv.test(s).isValid());
    }

    @Test
    public void ifValuePassedToTestIsIncorrectReturnInvalidResultTest() {

        //given
        IOValidation<String> sv = IOValidation.create(s -> s.equals("No"), "Wrong");
        String s = "Anything";

        //when //then
        assertFalse(sv.test(s).isValid());
    }

}