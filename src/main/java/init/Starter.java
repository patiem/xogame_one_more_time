package init;

import utility.printing.Printer;
import utility.scanning.Scanning;
import utility.validation.IOValidation;
import utility.validation.ValidationResult;
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
        //configurations.put("board", takeBoardData());

        return configurations;
    }

//    private Config takeBoardData() {
//
//        int horizontal;
//        try {
//            printer.printMsg("Podaj szerokość większą lub równą 3");
//            horizontal = scanner.nextInt();
//            if ( horizontal < 3) throw new InputMismatchException();
//
//        } catch (InputMismatchException e) {
//            printer.printMsg("To nie jest >= 3 w związku z tym zdecyduję za Ciebie, że będzie 3");
//            horizontal = 3;
//            scanner.nextLine();
//        }
//
//        int vertical;
//        try {
//            printer.printMsg("Podaj wysokość większą lub równą 3");
//            vertical = scanner.nextInt();
//            if ( vertical < 3) throw new InputMismatchException();
//        } catch (InputMismatchException e) {
//            printer.printMsg("To nie jest >= 3 w związku z tym zdecyduję za Ciebie, że będzie 3");
//            vertical = 3;
//            scanner.nextLine();
//        }
//
//        int winningLength;
//        try {
//            printer.printMsg(String.format("Podaj ile znakow do wygranej (minimum 3 ale nie wiecej niz %d", horizontal));
//            winningLength = scanner.nextInt();
//            if ( winningLength < 3 || winningLength > horizontal) throw new InputMismatchException();
//        } catch (InputMismatchException e) {
//            printer.printMsg("To nie spelnia podanych wymagan, wiec zdecyduję za Ciebie, że będzie 3");
//            winningLength = 3;
//            scanner.nextLine();
//        }
//        printer.printMsg(String.format("Twoja tablica ma rozmiar %d x %d - aby wygrać potrzeba %d znaków", horizontal, vertical, winningLength));
//
//        return new BoardConfig(horizontal, vertical, winningLength);
//    }

    private Config takeUserData() {

        String name1 = getUserName("Podaj imie pierwszego gracza");
        String sign1 = getUserSign("Podaj X czy O");
        printer.printMsg(String.format("Graczu %s - grasz jako %s", name1, sign1));

        String name2 = getUserName("Podaj imie drugiego gracza");
        String sign2 = (sign1.equals("X")) ? "O" : "X";
        printer.printMsg(String.format("Graczu %s - grasz jako %s", name2, sign2));

        return new UsersConfig(name1, name2, sign1, sign2);

    }

    private String getUserSign(String msg) {
        String sign;
        ValidationResult test;

         printer.printMsg(msg);
         sign = scanner.userInput().toUpperCase();

         test = IOValidation
                 .from(PlayerTestingMethods::isValisSign, "Twój znak nie był ani O ani X, więc przydzielamy Ci X")
                 .test(sign);
            if (!test.isvalid()) {
                printer.printMsg(test.getMessage());
                return "X";
            }
        return sign;
    }

    private String getUserName(String msg) {
        String name;
        ValidationResult test;

        do {
            printer.printMsg(msg);
            name = scanner.userInput();
            test = IOValidation
                    .from(PlayerTestingMethods::isValidName, "Imie musi byc 3-21 znakow, spróbuj jeszcze raz")
                    .test(name);
            if (!test.isvalid()) printer.printMsg(test.getMessage());
        } while (!test.isvalid());

        return name;
    }

    private void welcome() {
        printer.printMsg("Zagraj w kółko i krzyżyk");
    }
}
