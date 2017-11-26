package init;

import utility.Polish;
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

        String name1 = getUserName(Polish.MSG_NAME_ONE, Polish.ERR_NAME);
        String sign1 = getUserSign(Polish.MSG_SIGN, Polish.ERR_SIGN);
        printer.printMsg(String.format(Polish.MSG_PLAYER_COMPLETE.toString(), name1, sign1));

        String name2 = getUserName(Polish.MSG_NAME_TWO, Polish.ERR_NAME);
        String sign2 = (sign1.equals("X")) ? "O" : "X";
        printer.printMsg(String.format(Polish.MSG_PLAYER_COMPLETE.toString(), name2, sign2));

        return new UsersConfig(name1, name2, sign1, sign2);

    }

    private Config takeBoardData() {

        int horizontal = getNumberFromUser(Polish.MSG_VERTICAL, Polish.ERR_BOARD_SIZE, 3);
        int vertical = getNumberFromUser(Polish.MSG_HORIZONTAL, Polish.ERR_BOARD_SIZE, 3);
        printer.printMsgWithoutNewLine(String.format(Polish.MSG_WIN_LENGTH.toString(), Integer.min(horizontal, vertical)));
        int winningLength = getNumberFromUser(Polish.EMPTY, Polish.ERR_BOARD_SIZE, 3);
        printer.printMsg(String.format(Polish.MSG_BOARD_COMPLETE.toString(), horizontal, vertical, winningLength));
        return new BoardConfig(horizontal, vertical, winningLength);
    }


    private int getNumberFromUser(Polish msg, Polish err, int defaultValue) {
        ValidationResult test;
        printer.printMsg(msg);
        String valueTotest = scanner.userInput();

        test = IOValidation.from(NumberTestingMethods::isNumberValid, err.toString()).test(valueTotest);
        if (!test.isvalid()) {
            printer.printMsg(test.getMessage());
            return defaultValue;
        }
        return Integer.valueOf(valueTotest);
    }

    private String getUserSign(Polish msg, Polish err) {
        String sign;
        ValidationResult test;

         printer.printMsg(msg);
         sign = scanner.userInput().toUpperCase();

         test = IOValidation
                 .from(PlayerTestingMethods::isValidSign, err.toString())
                 .test(sign);
            if (!test.isvalid()) {
                printer.printMsg(test.getMessage());
                return "X";
            }
        return sign;
    }

    private String getUserName(Polish msg, Polish err) {
        String name;
        ValidationResult test;

        do {
            printer.printMsg(msg);
            name = scanner.userInput();
            test = IOValidation
                    .from(PlayerTestingMethods::isValidName, err.toString())
                    .test(name);
            if (!test.isvalid()) printer.printMsg(test.getMessage());
        } while (!test.isvalid());

        return name;
    }

    private void welcome() {
        printer.printMsg("Zagraj w kółko i krzyżyk");
    }
}

//TODO: Abstract methods which are getting user input!!!