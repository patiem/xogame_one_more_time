package gameplay.winning;

import gameplay.board.BoardDimension;
import gameplay.move.MoveList;
import gameplay.move.Observer;

public class WinSeeker implements Observer<MoveList> {
    private BoardDimension bd;

    public WinSeeker(BoardDimension bd) {
        this.bd = bd;
    }

    @Override
    public void update(MoveList cos) {

    }
}
