package utility;

class TerminalPrinter implements Printer {
    @Override
    public void printMsg(String message) {
        System.out.println(message);
    }
}
