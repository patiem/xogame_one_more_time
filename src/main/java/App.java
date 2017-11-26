//import gameplay.Game;
import gameplay.GameBuilder;
import init.Config;
import init.Starter;
import utility.printing.PrintManager;
import utility.scanning.ScannMenager;

import java.util.Map;

public class App {


    public static void main(String[] args) {

        if(args.length == 0)
            PrintManager.setPrinterBuilderToDefault();
        else if (args.length == 1) PrintManager.setPrinter(args[0]);

        Starter starter = new Starter(PrintManager.getPrinter(), ScannMenager.getScanner());
        Map<String, Config> config = starter.run();
//        Game game = new GameBuilder().withPlayers(config.get("users"))
//                                     .withBoard(config.get("board"))
//                                     .build();

    }



}
