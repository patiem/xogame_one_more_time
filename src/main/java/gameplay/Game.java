package gameplay;

import gameplay.board.BoardDimension;
import gameplay.round.RoundManager;
import utility.language.Language;
import utility.printing.PrintManager;
import utility.printing.Printer;
import utility.scanning.ScannMenager;
import utility.scanning.Scanning;

public class Game {

    private final Scanning scanner;
    private final Printer printer;
    private BoardDimension bd;

    private int roundNumber;
    private RoundManager roundMenager;
    private ScoreBoard scoreBoard;


    public Game(int defaultRoundNumber, RoundManager roundMenager, ScoreBoard scoreBoard) {

        this.roundNumber = defaultRoundNumber;
        this.roundMenager = roundMenager;
        this.scoreBoard = scoreBoard;
        scanner = ScannMenager.getScanner();
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

