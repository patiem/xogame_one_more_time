package gameplay.round;

import gameplay.board.BoardDimension;
import gameplay.board.BoardPrinter;
import gameplay.move.Move;
import gameplay.move.MoveManager;
import gameplay.player.Player;
import gameplay.player.PlayerSwitcher;
import gameplay.winning.RoundArbiter;
import utility.Polish;
import utility.printing.PrintManager;
import utility.printing.Printer;
import utility.scanning.ScannMenager;
import utility.scanning.Scanning;

public class RoundManager {

    private int roundsNumber;
    private BoardDimension bd;
    private PlayerSwitcher playerSwitcher;
    private MoveManager moveManager;
    private RoundArbiter winSeeker;
    private BoardPrinter boardPrinter;
    private Printer printer;
    private Scanning scanner;

    public RoundManager(int rounds, BoardDimension bd, PlayerSwitcher playerSwitcher, MoveManager moveManager,
                        RoundArbiter winSeeker, BoardPrinter boardPrinter) {

        this.roundsNumber = rounds;
        this.bd = bd;
        this.playerSwitcher = playerSwitcher;
        this.moveManager = moveManager;
        this.winSeeker = winSeeker;
        this.boardPrinter = boardPrinter;
        printer = PrintManager.getPrinter();
        scanner = ScannMenager.getScanner();
    }

    public String actualPlayerName() {
        return playerSwitcher.getNameOfActualUser();
    }


    public void startOneGame() {
        Boolean playing = true;
        boardPrinter.printEmptyBoard();

        while(playing) {
            Player actualPlayer = playerSwitcher.getActualPlayer();

            printer.printMsg(String.format(Polish.MSG_PLAYER.toString(), actualPlayer.getStringSign()));
            printer.printMsg(Polish.MSG_CELL_NUMBER);
            try {

                int move = scanner.getInteger();
                while (move<=0 || move>bd.size()) {
                    printer.printMsg(Polish.ERR_CELL_NUMBER);
                    move = scanner.getInteger();
                }

                try {
                    moveManager.makeMove(Move.build(move, actualPlayer.makeMove()));
                } catch (IllegalArgumentException e) {
                    printer.printMsg(Polish.ERR_CELL_OCCUPIED);
                    playerSwitcher.getActualPlayer();
                }

//                if (winSeeker.isWinningMove(sequencer.getSequencesToValidate())) {
//                    printer.printMsg(String.format("Graczu %s wygrałeś ten mecz!", playerSwitcher.getNameOfActualUser()));
//                    playing = false;
//                }

            } catch ( NumberFormatException e) {
                printer.printMsg(Polish.MSG_EXIT_GAME);
                //TODO: jakiś obserwtor, zeby wyjsc calkiem z gry?
                playing = false;
            }
        }
    }
}
