//import gameplay.Game;
import gameplay.Game;
import gameplay.round.RoundManagerBuilder;
import gameplay.round.RoundManager;
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

        int defaultRoundNumber = 3;

        RoundManager roundMenager = new RoundManagerBuilder(config.get("board"))
                                    .withPlayers(config.get("users"))
                                    .withDefaultRoundNumber()
                                    .withMoveManager()
                                    .withBoardPrinter()
                                    .withWinSeeker()
                                    .build();

        Game game = new Game(defaultRoundNumber, roundMenager);
        game.run();
    }



}
