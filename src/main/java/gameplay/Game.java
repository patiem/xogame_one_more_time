package gameplay;

import gameplay.round.RoundManager;
import utility.language.Language;
import utility.printing.PrintManager;
import utility.printing.Printer;

public class Game {

    private final Printer printer;
    private int roundNumber;
    private RoundManager roundMenager;
    private ScoreBoard scoreBoard;


    public Game(int defaultRoundNumber, RoundManager roundMenager, ScoreBoard scoreBoard) {

        this.roundNumber = defaultRoundNumber;
        this.roundMenager = roundMenager;
        this.scoreBoard = scoreBoard;
        printer = PrintManager.getPrinter();
    }


    public void run() {
        try {
            Integer roundCount;
            for (roundCount = 1; roundCount <= roundNumber; roundCount++) {
                printer.printMsg(Language.MSG_RND_COUNT, roundCount.toString());
                printer.printMsg(Language.MSG_RND_PLAYER, roundMenager.actualPlayerName());
                scoreBoard.addWin(roundMenager.startOneGame());
                printer.printMsg(Language.MSG_SCORE, scoreBoard.gameResult());
            }
            printer.printMsg(scoreBoard.getWinner());
        } catch (NumberFormatException e) {
            printer.printMsg(Language.MSG_EXIT_GAME);
        }
    }
}

