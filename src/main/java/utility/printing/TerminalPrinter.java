package utility.printing;

class TerminalPrinter implements Printer {
    @Override
    public void printMsg(String message) {
        System.out.println(message);
    }

    @Override
    public void printMsgWithFormat(String message, String... fields) {

    }

    @Override
    public void printMsgWithoutNewLine(String message) {
        System.out.print(message);

    }
}
