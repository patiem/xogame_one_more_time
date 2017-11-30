package utility.validation.testingmethods;

public class NumberTestingMethods {

    private NumberTestingMethods(){}

    private static boolean isNumber(String s) {
        try {
            Integer.valueOf(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isBetween(int value, int min, int max) {
        return value >= min && value <= max;
    }

    public static boolean isNumberValid(String value) {
        return isNumber(value) && isBetween(Integer.valueOf(value), 3, 100);
    }

}
