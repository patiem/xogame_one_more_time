package gameplay.winning;

import gameplay.board.BoardDimension;
import gameplay.move.MoveList;
import gameplay.move.Observer;
import gameplay.move.Subject;
import gameplay.winning.roundStates.RoundState;
import gameplay.winning.roundStates.WinningCondition;

import java.util.ArrayList;
import java.util.List;

public class RoundArbiter implements Observer<MoveList>, Subject{

    private final WinSeeker winSeeker;
    private final Sequencer sequencer;
    private BoardDimension bd;
    private List<Observer> observers;
    private RoundState roundState = RoundState.PLAYING;

    public RoundArbiter(BoardDimension bd) {
        this.bd = bd;
        winSeeker = new WinSeeker(bd);
        sequencer = new Sequencer(bd);
        observers = new ArrayList<>();
    }

    @Override
    public void update(MoveList moves) {
        Sequence seqs = sequencer.sequencesToCheck(moves);
        if(winSeeker.isWinningMove(seqs)) roundState = RoundState.WIN;
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

