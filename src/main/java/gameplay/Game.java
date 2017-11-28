package gameplay;

import gameplay.board.BoardDimension;
import gameplay.round.RoundManager;
import gameplay.winning.winTypes.WinningCondition;
import utility.Polish;
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


    public Game(int defaultRoundNumber, RoundManager roundMenager) {

        this.roundNumber = defaultRoundNumber;
        this.roundMenager = roundMenager;
        scanner = ScannMenager.getScanner();
        printer = PrintManager.getPrinter();
    }


    public void run() {
        int roundCount;
        for (roundCount = 1; roundCount <= roundNumber; roundCount++) {
            printer.printMsg(String.format(Polish.MSG_RND_COUNT.toString(), roundCount));
            printer.printMsg(String.format(Polish.MSG_RND_PLAYER.toString(), roundMenager.actualPlayerName()));
            WinningCondition win = roundMenager.startOneGame();
            printer.printMsg(win.toString());
            //TODO przyda sie klaska trzymajaca wyniki i gracza:

        }
    }
}

