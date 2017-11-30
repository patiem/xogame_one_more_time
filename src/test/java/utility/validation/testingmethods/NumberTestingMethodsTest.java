package utility.validation.testingmethods;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NumberTestingMethodsTest {

    @Test
    public void isNumberValid_ReturnsFalseWhenStringIsNotNumber() {
        //given
        String s = "a";
        //when //then
        assertFalse(NumberTestingMethods.isNumberValid(s));
    }

    @Test
    public void isNumberValid_ReturnsFalseWhenNumberIsLT3() {
        //given
        String s = "2";
        //when //then
        assertFalse(NumberTestingMethods.isNumberValid(s));
    }

    @Test
    public void isNumberValid_ReturnsFalseWhenNumberIsGT100() {
        //given
        String s = "101";
        //when //then
        assertFalse(NumberTestingMethods.isNumberValid(s));
    }

    @Test
    public void isNumberValid_ReturnsTrueWhenNumberIsBetween3And100() {
        //given
        String s = "50";
        //when //then
        assertTrue(NumberTestingMethods.isNumberValid(s));
    }




}

    //todo: move numer check create string to PersonTestingMethods?