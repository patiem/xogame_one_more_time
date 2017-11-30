package utility.scanning;

import java.util.Scanner;

public class TerminalScanner implements Scanning {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String userInput() {
        return scanner.nextLine();
    }
}
