import init.Starter;
import utility.printing.PrintManager;
import utility.scanning.ScannMenager;

public class App {


    public static void main(String[] args) {

        if(args.length == 0)
            PrintManager.setPrinterBuilderToDefault();
        else if (args.length == 1) PrintManager.setPrinter(args[0]);

        Starter starter = new Starter(PrintManager.getPrinter(), ScannMenager.getScanner());
        starter.run();

    }



}
