package utility.scanning;

public interface Scanning {
    String userInput();

    default int getInteger() {
        String value = userInput();
        value = value.replaceAll("\\s","");
        return Integer.valueOf(value);
    }
}
