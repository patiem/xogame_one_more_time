import gameplay.Game;
import gameplay.ScoreBoard;
import gameplay.ScoreBoardBuilder;
import gameplay.round.RoundManagerBuilder;
import gameplay.round.RoundManager;
import init.Config;
import init.Starter;
import utility.language.LanguageLoader;
import utility.printing.PrintManager;
import utility.scanning.ScannMenager;

import java.util.Map;

public class App {


    public static void main(String[] args) {

        try {
            setupUtilities(args);
            setupGameStart();

        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
        }

    }

    private static void setupGameStart() {
        Starter starter = new Starter(PrintManager.getPrinter(), ScannMenager.getScanner());
        Map<String, Config> config = starter.run();

        int defaultRoundNumber = 3;

        RoundManager roundManager = new RoundManagerBuilder(config.get("board"))
                                    .withPlayers(config.get("users"))
                                    .withMoveManager()
                                    .withBoardPrinter()
                                    .withRoundArbiter()
                                    .build();

        ScoreBoard scoreBoard = new ScoreBoardBuilder().withPlayersFromConfig(config.get("users")).build();

        Game game = new Game(defaultRoundNumber, roundManager, scoreBoard);
        game.run();
        PrintManager.close();
    }

    private static void setupUtilities(String[] args) throws IllegalArgumentException {
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
            ScannMenager.setScanner(args[2]);
        } else {
            throw new IllegalArgumentException("Read Readme before to run app correctly");
        }
    }
}

