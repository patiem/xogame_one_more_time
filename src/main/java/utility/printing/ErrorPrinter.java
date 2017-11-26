package utility.printing;

class ErrorPrinter implements Printer {
    @Override
    public void printMsg(String message) {
        System.err.println(message);
    }

    @Override
    public void printMsgWithFormat(String message, String... fields) {

    }
}
