package utility.scanning;

public interface Scanning {
    String userInput();

    default int getInteger() {
        return Integer.valueOf(userInput());
    }
}
