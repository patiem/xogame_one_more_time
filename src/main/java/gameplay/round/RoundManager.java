package gameplay.round;

import gameplay.board.BoardDimension;
import gameplay.board.BoardPrinter;
import gameplay.move.Move;
import gameplay.move.MoveManager;
import gameplay.move.Observer;
import gameplay.player.Player;
import gameplay.player.PlayerSwitcher;
import gameplay.winning.winTypes.RoundState;
import gameplay.winning.winTypes.WinFactory;
import gameplay.winning.winTypes.WinningCondition;
import utility.Polish;
import utility.printing.Printer;
import utility.scanning.Scanning;

public class RoundManager implements Observer<RoundState>{

    private BoardDimension bd;
    private PlayerSwitcher playerSwitcher;
    private MoveManager moveManager;

    private BoardPrinter boardPrinter;
    private RoundState roundState;
    private Printer printer;
    private Scanning scanner;
    private Player actualPlayer;

    public RoundManager(BoardDimension bd, PlayerSwitcher playerSwitcher, MoveManager moveManager, BoardPrinter boardPrinter) {

        this.bd = bd;
        this.playerSwitcher = playerSwitcher;
        this.moveManager = moveManager;
        this.boardPrinter = boardPrinter;
    }

    public String actualPlayerName() {
        return playerSwitcher.getNameOfActualUser();
    }


    public WinningCondition startOneGame() {

        roundState = RoundState.PLAYING;
        boardPrinter.printEmptyBoard();
        moveManager.clean();

        runRound();
        if(roundState == RoundState.DRAW) printer.printMsg(Polish.MSG_DRAW);
        else printer.printMsg(String.format(Polish.MSG_WIN.toString(), actualPlayer.getName()));
        return WinFactory.getWin(roundState, actualPlayer);
    }

    private void runRound() {
        while(roundState == RoundState.PLAYING) {
            actualPlayer = playerSwitcher.getActualPlayer();

            printer.printMsg(String.format(Polish.MSG_PLAYER.toString(), actualPlayer.getStringSign()));
            printer.printMsg(Polish.MSG_CELL_NUMBER);

            int move = takeMoveFromUser();
            tryToMakeMove(actualPlayer, move);
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
