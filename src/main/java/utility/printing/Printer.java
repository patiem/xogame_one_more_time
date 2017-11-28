package utility.printing;

import utility.Polish;

public interface Printer {

    void printMsg(String message);

    void printMsgWithoutNewLine(String msg);

    default void printMsg(Polish msg) {
        printMsg(msg.toString());
    }

}


//TODO: Add methods for printing