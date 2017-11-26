package gameplay.move;


import java.util.ArrayList;
import java.util.List;

public class MoveManager implements Subject{

    List<Observer> observers;
    MoveList moves;

    public MoveManager() {
        observers = new ArrayList<>();
        moves = new MoveList();
    }

    public boolean makeMove(Move move) {
        if (moves.checkIfFieldIsOccupied(move)) throw new IllegalArgumentException();
        moves.addMoveToList(move);
        notifyObservers();
        return true;
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
        for (Observer obj : observers) obj.update(moves);
    }
}
