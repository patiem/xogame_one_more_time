package utility.validation.testingMethods;


public class PlayerTestingMethods {

    public static boolean isValidName(String s) {
        return !(s.length() < 3|| s.length() >20 || !s.matches("^[A-Za-z][A-Za-z0-9]*$"));
    }

    public static boolean isValisSign(String s) {
        return s.equals("X") || s.equals("O");
    }
}