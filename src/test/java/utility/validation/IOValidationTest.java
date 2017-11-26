package utility.validation;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IOValidationTest {

    @Test
    public void ifValuePassedToTestIsCorect_returnValidResultTest() {

        //given
        IOValidation<String> sv = IOValidation.from(s -> s.equals(s), "Wrong");
        String s = "Anything";

        //when //then
        assertTrue(sv.test(s).isvalid());
    }

    @Test
    public void ifValuePassedToTestIsInccorect_returnInvalidResultTest() {

        //given
        IOValidation<String> sv = IOValidation.from(s -> s.equals("No"), "Wrong");
        String s = "Anything";

        //when //then
        assertFalse(sv.test(s).isvalid());
    }

}