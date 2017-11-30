package utility.printing;

import utility.language.Language;

import java.io.IOException;
import java.util.ResourceBundle;

public class PrintManager {

    private static Printer printer = new TerminalPrinter();

    private PrintManager(){}

    public static void setPrinterBuilderToDefault() {
            setPrinter("TR");
    }

    public static void setPrinter(String arg) {

        switch (arg.toUpperCase()) {
            case "TR":
                printer = new TerminalPrinter();
                break;
            case "ER":
                printer = new ErrorPrinter();
                break;
            case "FL":
                try {
                    printer = FilePrinter.build();
                } catch (IOException e) {
                    printer = new TerminalPrinter();
                    printer.printMsg(Language.ERR_PRINTER);
                }

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
        FilePrinter printer2 = (FilePrinter) printer;
        printer2.close();
    }

    public static void setLanguage(ResourceBundle language) {
        printer.setLanguage(language);
    }
}
