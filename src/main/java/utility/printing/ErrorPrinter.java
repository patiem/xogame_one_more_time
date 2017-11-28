package utility.printing;

class ErrorPrinter implements Printer {

    @Override
    public void printMsg(String message) {
        System.err.println(message);
    }

    @Override
    public void printMsgWithoutNewLine(String msg) {

    }
}
