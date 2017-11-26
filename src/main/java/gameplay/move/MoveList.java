package gameplay.move;

import interfaces.Observer;
import interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

public class MoveList {

    List<Move> moveList;
    Move lastMove;
    Integer moveCount;

    public MoveList() {
        moveList = new ArrayList<>();
        moveCount = 0;
    }

    void addMoveToList(Move move) {
        //if(moveCount == )
        moveList.add(move);
        lastMove = move;
        moveCount += 1;
    }

    boolean checkIfFieldIsOccupied(Move newMove) {
        for (Move move : moveList)
            if (move.hasSamePosition(newMove)) return true;
        return false;
    }

    public List<Move> getList() {
        return moveList;
    }

    public int getLastMovePosition() {
        return lastMove.getRealPosition() + 1;
    }

}
