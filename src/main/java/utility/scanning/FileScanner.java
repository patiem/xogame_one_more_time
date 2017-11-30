package utility.scanning;

import utility.printing.PrintManager;
import utility.printing.Printer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileScanner implements Scanning {

    private Scanner scanner;
    static final Printer printer = PrintManager.getPrinter();

    @Override
    public String userInput() {
        String input = scanner.nextLine();
        printer.printMsg(input);
        return input;
    }

    public static FileScanner createFileScanner(String fileName) {
        try {
            Scanner scanner = new Scanner(new FileReader(fileName));
            return new FileScanner(scanner);

        } catch (FileNotFoundException e) {
            printer.printMsg("Your file with scenario was not found, game will terminated");
            throw new IllegalArgumentException();
        }
    }

    private FileScanner(Scanner scanner) {
        this.scanner = scanner;

    }


}
