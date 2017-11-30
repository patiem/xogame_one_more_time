package gameplay.round;

import gameplay.board.BoardDimension;
import gameplay.board.BoardPrinter;
import gameplay.move.MoveManager;
import gameplay.player.PlayerSwitcher;
import gameplay.winning.RoundArbiter;
import init.Config;
import utility.printing.PrintManager;
import utility.scanning.ScanManager;

public class RoundManagerBuilder {

    private final BoardDimension bd;
    private PlayerSwitcher playerSwitcher;
    private MoveManager moveManager;
    private RoundArbiter roundArbiter;
    private BoardPrinter boardPrinter;


    public RoundManagerBuilder withPlayers(Config<String> config) {
        playerSwitcher = PlayerSwitcher.build(config);
        return this;
    }

    public RoundManagerBuilder(Config board) {
        bd = BoardDimension.build(board);
    }


    public RoundManagerBuilder withMoveManager() {
        moveManager = new MoveManager();
        return this;
    }

    public RoundManagerBuilder withRoundArbiter() {
        roundArbiter = new RoundArbiter(bd);
        return this;
    }

    public RoundManagerBuilder withBoardPrinter() {
        boardPrinter = new BoardPrinter(bd);
        boardPrinter.setup();
        return this;
    }

    public RoundManager build() {
        moveManager.register(boardPrinter);
        moveManager.register(roundArbiter);
        RoundManager rm = new RoundManager(bd, playerSwitcher, moveManager, boardPrinter);
        roundArbiter.register(rm);
        rm.setPrinter(PrintManager.getPrinter());
        rm.setScanner(ScanManager.getScanner());
        return rm;
    }
}
