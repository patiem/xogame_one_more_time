package app;

import gameplay.Game;
import gameplay.ScoreBoard;
import gameplay.ScoreBoardBuilder;
import gameplay.round.RoundManagerBuilder;
import gameplay.round.RoundManager;
import init.Config;
import init.Starter;
import utility.language.LanguageLoader;
import utility.printing.PrintManager;
import utility.scanning.ScanManager;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger LOGGER = Logger.getLogger( App.class.getName() );

    public static void main(String[] args) {

        try {
            setupUtilities(args);
            setupGame().run();
            PrintManager.close();

        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.FINE, e.getMessage());
        }
    }

    private static Game setupGame() {
        Starter starter = new Starter(PrintManager.getPrinter(), ScanManager.getScanner());
        Map<String, Config<String>> config = starter.run();

        int defaultRoundNumber = 3;

        RoundManager roundManager = new RoundManagerBuilder(config.get("board"))
                                    .withPlayers(config.get("users"))
                                    .withMoveManager()
                                    .withBoardPrinter()
                                    .withRoundArbiter()
                                    .build();

        ScoreBoard scoreBoard = new ScoreBoardBuilder().withPlayersFromConfig(config.get("users")).build();

        return new Game(defaultRoundNumber, roundManager, scoreBoard);

    }

    private static void setupUtilities(String[] args) {
        if(args.length == 0) {
            PrintManager.setPrinterBuilderToDefault();
            PrintManager.setLanguage(LanguageLoader.loadLanguage("PL"));
        }
        else if (args.length == 2) {
            PrintManager.setPrinter(args[0]);
            PrintManager.setLanguage(LanguageLoader.loadLanguage(args[1]));
        }
        else if (args.length == 3) {
            PrintManager.setPrinter(args[0]);
            PrintManager.setLanguage(LanguageLoader.loadLanguage(args[1]));
            ScanManager.setScanner(args[2]);
        } else {
            throw new IllegalArgumentException("Read Readme before running this app");
        }
    }
}

