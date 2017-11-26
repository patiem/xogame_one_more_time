package utility;

public class PrintManager {

    static Printer printer;

    public static void setPrinterBuilderToDefault() {
        if(printer == null) {
            setPrinter("TR");
        }
        else printer.printMsg("Drukarka już została wybrana");
    }

    public static void setPrinter(String arg) {
        if(printer != null) {
            printer.printMsg("Drukarka już została wybrana");
            return;
        }

        switch (arg.toUpperCase()) {
            case "TR":
                printer = new TerminalPrinter();
                printer.printMsg("Twoją drukarką jest Terminal");
                break;
            case "ER":
                printer = new ErrorPrinter();
                printer.printMsg("Twoją drukarką jest Strumień Błędów");
                break;
            default:
                printer = new TerminalPrinter();
        }
    }

    public static Printer getPrinter() {
        return printer;
    }
}
