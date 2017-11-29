package utility.validation.testingmethods;

public class NumberTestingMethods {

    public static boolean isNumber(String s) {
        try {
            Integer.valueOf(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isBetween(int value, int min, int max) {
        return value >= min && value <= max;
    }

    public static boolean isNumberValid(String value) {
        return isNumber(value) && isBetween(Integer.valueOf(value), 3, 100);
    }

}
