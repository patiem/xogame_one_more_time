package utility.validation.testingMethods;

import gameplay.signs.Sign;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PlayerTestingMethodsTest {

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

    @Test
    public void isValidSign_ReturnsTrueWhenXorO() {
        //given
        String s = "X";
        String s2 = "O";
        //when //then
        assertTrue(PlayerTestingMethods.isValidSign(s));
        assertTrue(PlayerTestingMethods.isValidSign(s2));
    }

    @Test
    public void isValidSign_ReturnsFalseWhenNeitherXorO() {
        //given
        String s = "Z";
        String s2 = "4";
        //when //then
        assertFalse(PlayerTestingMethods.isValidSign(s));
        assertFalse(PlayerTestingMethods.isValidSign(s2));
    }

}