package gameplay.winning;

import gameplay.board.BoardDimension;
import gameplay.move.MoveList;
import gameplay.move.Observer;

public class RoundArbiter implements Observer<MoveList> {

    private final WinSeeker winSeeker;
    private final Sequencer sequencer;
    private BoardDimension bd;

    public RoundArbiter(BoardDimension bd) {
        this.bd = bd;
        winSeeker = new WinSeeker(bd);
        sequencer = new Sequencer(bd);
    }

    @Override
    public void update(MoveList moves) {
        Sequence seqs = sequencer.sequencesToCheck(moves);
        winSeeker.isWinningMove(seqs);
    }
}
