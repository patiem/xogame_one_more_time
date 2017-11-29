package gameplay.winning;

import gameplay.board.BoardDimension;
import gameplay.move.MoveList;
import gameplay.move.Observer;
import gameplay.move.Subject;
import gameplay.signs.XSign;
import gameplay.winning.wintypes.RoundState;

import java.util.ArrayList;
import java.util.List;

public class RoundArbiter implements Observer<MoveList>, Subject{

    private final WinSeeker winSeeker;
    private final Sequencer sequencer;
    private final int maxCountOfMoves;
    private List<Observer> observers;
    private RoundState roundState;

    public RoundArbiter(BoardDimension bd) {
        maxCountOfMoves = bd.size();
        winSeeker = new WinSeeker(bd);
        sequencer = new Sequencer(bd);
        observers = new ArrayList<>();
    }

    @Override
    public void update(MoveList moves) {
        roundState = RoundState.PLAYING;
        if(winSeeker.isWinningMove(sequencer.sequencesToCheck(moves)))
            roundState = (moves.tellWhoMadeLastMove() instanceof XSign) ? RoundState.XWINS : RoundState.OWINS;
        else if(moves.isListFull(maxCountOfMoves)) roundState = RoundState.DRAW;
        notifyObservers();
    }

    @Override
    public void register(Observer obj) {
        if(obj == null) throw new NullPointerException("Null Observer");
        if(!observers.contains(obj)) observers.add(obj);
    }

    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        for (Observer obj : observers) obj.update(roundState);
    }
}