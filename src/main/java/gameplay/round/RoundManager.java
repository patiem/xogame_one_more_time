package gameplay.round;

import gameplay.board.BoardDimension;
import gameplay.board.BoardPrinter;
import gameplay.move.Move;
import gameplay.move.MoveManager;
import gameplay.move.Observer;
import gameplay.player.Player;
import gameplay.player.PlayerSwitcher;
import gameplay.winning.RoundArbiter;
import gameplay.winning.roundStates.RoundState;
import gameplay.winning.roundStates.WinFactory;
import gameplay.winning.roundStates.WinningCondition;
import utility.Polish;
import utility.printing.Printer;
import utility.scanning.Scanning;

public class RoundManager implements Observer<RoundState>{

    private int roundsNumber;
    private BoardDimension bd;
    private PlayerSwitcher playerSwitcher;
    private MoveManager moveManager;
    private RoundArbiter roundArbiter;
    private BoardPrinter boardPrinter;
    private RoundState roundState;
    private Printer printer;
    private Scanning scanner;
    private Player actualPlayer;

    public RoundManager(int rounds, BoardDimension bd, PlayerSwitcher playerSwitcher, MoveManager moveManager,
                        RoundArbiter roundArbiter, BoardPrinter boardPrinter) {

        this.roundsNumber = rounds;
        this.bd = bd;
        this.playerSwitcher = playerSwitcher;
        this.moveManager = moveManager;
        this.roundArbiter = roundArbiter;
        this.boardPrinter = boardPrinter;
    }

    public String actualPlayerName() {
        return playerSwitcher.getNameOfActualUser();
    }


    public WinningCondition startOneGame() {

        roundState = RoundState.PLAYING;
        boardPrinter.printEmptyBoard();
        runRound();
        if(roundState == RoundState.WIN) {
            printer.printMsg(String.format(Polish.MSG_WIN.toString(), actualPlayer.getName(), actualPlayer.getStringSign()));
            return WinFactory.getWin(actualPlayer);
        }
        return WinFactory.getWin(roundState);
    }

    private void runRound() {
        while(roundState == RoundState.PLAYING) {
            actualPlayer = playerSwitcher.getActualPlayer();

            printer.printMsg(String.format(Polish.MSG_PLAYER.toString(), actualPlayer.getStringSign()));
            printer.printMsg(Polish.MSG_CELL_NUMBER);
            try {

                int move = takeMoveFromUser();
                tryToMakeMove(actualPlayer, move);

            } catch ( NumberFormatException e) {
                printer.printMsg(Polish.MSG_EXIT_GAME);
                roundState = RoundState.EXIT;
            }
        }
    }

    private void tryToMakeMove(Player actualPlayer, int move) {
        try {
            moveManager.makeMove(Move.build(move, actualPlayer.makeMove()));
        } catch (IllegalArgumentException e) {
            printer.printMsg(Polish.ERR_CELL_OCCUPIED);
            playerSwitcher.getActualPlayer();
        }
    }

    private int takeMoveFromUser() {
        int move = scanner.getInteger();
        while (move<=0 || move>bd.size()) {
            printer.printMsg(Polish.ERR_CELL_NUMBER);
            move = scanner.getInteger();
        }
        return move;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public void setScanner(Scanning scanner) {
        this.scanner = scanner;
    }

    @Override
    public void update(RoundState roundState) {
        this.roundState = roundState;
    }
}


//TODO: jakiś obserwtor, zeby wyjsc calkiem z gry?
