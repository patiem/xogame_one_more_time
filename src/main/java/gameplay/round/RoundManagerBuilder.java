package gameplay.round;

import gameplay.board.BoardDimension;
import gameplay.board.BoardPrinter;
import gameplay.move.MoveManager;
import gameplay.player.PlayerSwitcher;
import gameplay.winning.RoundArbiter;
import init.Config;

public class RoundManagerBuilder {

    BoardDimension bd;
    PlayerSwitcher playerSwitcher;
    MoveManager moveManager;
    RoundArbiter winSeeker;
    BoardPrinter boardPrinter;
    private int roundNumber;


    public RoundManagerBuilder withPlayers(Config config) {
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

    public RoundManagerBuilder withWinSeeker() {
        winSeeker = new RoundArbiter(bd);
        return this;
    }

    public RoundManagerBuilder withBoardPrinter() {
        boardPrinter = new BoardPrinter(bd);
        boardPrinter.setup();
        return this;
    }

    public RoundManagerBuilder withRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
        return this;
    }

    public RoundManagerBuilder withDefaultRoundNumber() {
        this.roundNumber = 3;
        return this;
    }

    public RoundManager build() {
        moveManager.register(boardPrinter);
        moveManager.register(winSeeker);

        return new RoundManager(roundNumber, bd, playerSwitcher, moveManager, winSeeker, boardPrinter);
    }
}
