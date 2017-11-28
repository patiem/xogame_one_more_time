package utility.scanning;

import utility.printing.PrintManager;
import utility.printing.Printer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileScanner implements Scanning {

    private Scanner scanner;
    private Printer printer = PrintManager.getPrinter();

    @Override
    public String userInput() {
        String input = scanner.nextLine();
        printer.printMsg(input);

        return input;
    }

    public FileScanner(String fileName) {

        try {
            scanner = new Scanner(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
