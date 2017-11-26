package utility.validation.testingMethods;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NumberTestingMethodsTest {

    @Test
    public void isValidName_ReturnsFalseWhenStringIsLT3() {
        //given
        String s = "a";
        //when //then
        assertFalse(PlayerTestingMethods.isValidName(s));
    }

    @Test
    public void isValidName_ReturnsFalseWhenStringIsGT20() {
        //given
        String s = "a01234567890123456789";
        //when //then
        assertFalse(PlayerTestingMethods.isValidName(s));
    }

    @Test
    public void isValidName_ReturnsFalseWhenStringDoesntStartWithLetter() {
        //given
        String s = "1a3";
        //when //then
        assertFalse(PlayerTestingMethods.isValidName(s));
    }
    @Test
    public void isValidName_ReturnsFalseWhenStringContainsSpecialCharaters() {
        //given
        String s = "aaaa:aaa";
        //when //then
        assertFalse(PlayerTestingMethods.isValidName(s));
    }

    @Test
    public void isValidName_ReturnsTrueWhenNameIsProper() {
        //given
        String s = "abcd";
        //when //then
        assertTrue(PlayerTestingMethods.isValidName(s));
    }



}

    //todo: move numer check from string to PersonTestingMethods?