package init;

import utility.language.Language;
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

        String name1 = getUserName(Language.MSG_NAME_ONE, Language.ERR_NAME);
        String sign1 = getUserSign(Language.MSG_SIGN, Language.ERR_SIGN);
        printer.printMsg(Language.MSG_PLAYER_COMPLETE, name1, sign1);

        String name2 = getUserName(Language.MSG_NAME_TWO, Language.ERR_NAME);
        String sign2 = (sign1.equals("X")) ? "O" : "X";
        printer.printMsg(Language.MSG_PLAYER_COMPLETE, name2, sign2);

        return new UsersConfig(name1, name2, sign1, sign2);

    }

    private Config takeBoardData() {

        Integer horizontal = getNumberFromUser(Language.MSG_VERTICAL, Language.ERR_BOARD_SIZE, 3);
        Integer vertical = getNumberFromUser(Language.MSG_HORIZONTAL, Language.ERR_BOARD_SIZE, 3);
        Integer min = Integer.min(horizontal, vertical);
        printer.printMsg(Language.MSG_WIN_LENGTH, min.toString());
        Integer winningLength = getNumberFromUser(Language.EMPTY, Language.ERR_BOARD_SIZE, 3);
        printer.printMsg(Language.MSG_BOARD_COMPLETE, horizontal.toString(), vertical.toString(), winningLength.toString());
        return new BoardConfig(horizontal, vertical, winningLength);
    }


    private int getNumberFromUser(Language msg, Language err, int defaultValue) {
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

    private String getUserSign(Language msg, Language err) {
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

    private String getUserName(Language msg, Language err) {
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
        printer.printMsg(Language.MSG_START);
    }
}

//TODO: Abstract methods which are getting user input!!!