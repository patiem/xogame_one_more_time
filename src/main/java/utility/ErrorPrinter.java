package utility;

class ErrorPrinter implements Printer {
    @Override
    public void printMsg(String message) {
        System.err.println(message);
    }
}
