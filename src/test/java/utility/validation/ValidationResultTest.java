package utility.validation;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidationResultTest {

    @Test
    public void makingOkResult_returnValidResult() {

        //given
        ValidationResult vr = ValidationResult.ok();
        //when //then
        assertTrue(vr.isvalid());
    }

    @Test
    public void makingOkResult_returnInvalidResult() {

        //given
        String err = "Wrong";
        ValidationResult vr = ValidationResult.fail(err);
        //when //then
        assertFalse(vr.isvalid());
    }

    @Test
    public void invalidResultMustHaveMessage() {

        //given
        String err = "Wrong";
        ValidationResult vr = ValidationResult.fail(err);
        //when //then
        assertEquals(vr.getMessage(), err);
        }

}