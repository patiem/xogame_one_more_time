package utility.printing;

import utility.Polish;

public interface Printer {
    void printMsg(String message);
    void printMsgWithFormat(String message, String... fields);

    void printMsgWithoutNewLine(String msg);

    default void printMsg(Polish msg) {
        printMsg(msg.toString());
    }

    default void printMsgWithoutNewLine(Polish msg) {
        printMsgWithoutNewLine(msg.toString());
    };

}


//TODO: Add methods for printing