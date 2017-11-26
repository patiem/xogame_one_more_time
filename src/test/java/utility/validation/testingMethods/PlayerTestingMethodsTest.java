package utility.validation.testingMethods;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PlayerTestingMethodsTest {

    @Test
    public void isNumberValid_ReturnsFalseWhenStringIsNotNumber() {
        //given
        String s = "a";
        //when //then
        assertFalse(NumberTestingMethods.isNumberValid(s));
    }

}