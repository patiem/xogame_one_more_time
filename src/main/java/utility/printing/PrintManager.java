package utility.printing;

import java.io.IOException;

public class PrintManager {

    static Printer printer = new TerminalPrinter();

    public static void setPrinterBuilderToDefault() {
        if(printer == null) {
            setPrinter("TR");
        }
        else printer.printMsg("Drukarka już została wybrana");
    }

    public static void setPrinter(String arg) {

        switch (arg.toUpperCase()) {
            case "TR":
                printer = new TerminalPrinter();
                printer.printMsg("Twoją drukarką jest Terminal");
                break;
            case "ER":
                printer = new ErrorPrinter();
                printer.printMsg("Twoją drukarką jest Strumień Błędów");
                break;
            case "FL":
                try {
                    printer = new FilePrinter();
                } catch (IOException e) {
                    System.out.print(e.getMessage());
                    printer = new TerminalPrinter();
                    printer.printMsg("Coś poszło nie tak, Twoją drukarką jest plik");
                }

                printer.printMsg("Twoją drukarką jest Terminal");
                break;
            default:
                printer = new TerminalPrinter();
        }
    }

    public static Printer getPrinter() {
        if(printer == null) setPrinterBuilderToDefault();
        return printer;
    }

    public static void close() {
        try {
            FilePrinter printer2 = (FilePrinter) printer;
            printer2.close();
        } catch (Exception e) {

        }
    }
}
