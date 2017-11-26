package init;

import utility.printing.Printer;
import utility.scanning.Scanning;
import utility.validation.IOValidation;
import utility.validation.ValidationResult;
import utility.validation.testingMethods.NumberTestingMethods;
import utility.validation.testingMethods.PlayerTestingMethods;

import java.util.HashMap;
import java.util.Map;

public class Starter {

    private Scanning scanner;
    private Printer printer;
    private Map<String, Config> configurations;

    public Starter(Printer printer, Scanning scanner) {
        this.scanner = scanner;
        this.printer = printer;
        configurations = new HashMap<>();
    }

    public Map<String, Config> run() {
        welcome();
        configurations.put("users", takeUserData());
        configurations.put("board", takeBoardData());

        return configurations;
    }

    private Config takeUserData() {

        String name1 = getUserName("Podaj imie pierwszego gracza", "Imie musi byc 3-21 znakow, spróbuj jeszcze raz");
        String sign1 = getUserSign("Podaj X czy O", "Imie musi byc 3-21 znakow, spróbuj jeszcze raz");
        printer.printMsg(String.format("Graczu %s - grasz jako %s", name1, sign1));

        String name2 = getUserName("Podaj imie drugiego gracza", "Twój znak nie był ani O ani X, więc przydzielamy Ci X");
        String sign2 = (sign1.equals("X")) ? "O" : "X";
        printer.printMsg(String.format("Graczu %s - grasz jako %s", name2, sign2));

        return new UsersConfig(name1, name2, sign1, sign2);

    }

    private Config takeBoardData() {

        int horizontal = getNumberFromUser("Podaj szerokość większą lub równą 3 i mniejsza niz 100", "To nie jest >= 3 w związku z tym zdecyduję za Ciebie, że będzie 3", 3);
        int vertical = getNumberFromUser("Podaj wysokość większą lub równą 3 I mniejsza niz 100", "To nie jest >= 3 w związku z tym zdecyduję za Ciebie, że będzie 3", 3);
        int winningLength = getNumberFromUser(String.format("Podaj ile znakow do wygranej (minimum 3 ale nie wiecej niz %d", horizontal),
                                            "To nie spelnia podanych wymagan, wiec zdecyduję za Ciebie, że będzie 3",
                                            3);

        printer.printMsg(String.format("Twoja tablica ma rozmiar %d x %d - aby wygrać potrzeba %d znaków", horizontal, vertical, winningLength));
        return new BoardConfig(horizontal, vertical, winningLength);
    }


    private int getNumberFromUser(String msg, String err, int defaultValue) {
        ValidationResult test;
        printer.printMsg(msg);
        String valueTotest = scanner.userInput();

        test = IOValidation.from(NumberTestingMethods::isNumberValid, err).test(valueTotest);
        if (!test.isvalid()) {
            printer.printMsg(test.getMessage());
            return defaultValue;
        }
        return Integer.valueOf(valueTotest);
    }

    private String getUserSign(String msg, String err) {
        String sign;
        ValidationResult test;

         printer.printMsg(msg);
         sign = scanner.userInput().toUpperCase();

         test = IOValidation
                 .from(PlayerTestingMethods::isValidSign, err)
                 .test(sign);
            if (!test.isvalid()) {
                printer.printMsg(test.getMessage());
                return "X";
            }
        return sign;
    }

    private String getUserName(String msg, String err) {
        String name;
        ValidationResult test;

        do {
            printer.printMsg(msg);
            name = scanner.userInput();
            test = IOValidation
                    .from(PlayerTestingMethods::isValidName, err)
                    .test(name);
            if (!test.isvalid()) printer.printMsg(test.getMessage());
        } while (!test.isvalid());

        return name;
    }

    private void welcome() {
        printer.printMsg("Zagraj w kółko i krzyżyk");
    }
}
