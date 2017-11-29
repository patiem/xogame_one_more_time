package utility.printing;

import utility.language.Language;

import java.io.IOException;
import java.util.ResourceBundle;

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
                //printer.printMsg(Language.MSG_PRINT_TR);
                break;
            case "ER":
                printer = new ErrorPrinter();
                //printer.printMsg(Language.MSG_PRINT_ER);
                break;
            case "FL":
                try {
                    printer = FilePrinter.build();
                } catch (IOException e) {
                    System.out.print(e.getMessage());
                    printer = new TerminalPrinter();
                    //printer.printMsg(Language.ERR_PRINT.toString() + Language.MSG_PRINT_TR.toString() );
                }
                //printer.printMsg(Language.MSG_PRINT_FL);

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

    public static void setLanguage(ResourceBundle language) {
        printer.setLanguage(language);
    }
}
