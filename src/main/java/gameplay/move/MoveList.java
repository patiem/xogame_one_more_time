package gameplay.move;

import gameplay.signs.Sign;

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
        moveList.add(move);
        lastMove = move;
        moveCount += 1;
    }

    boolean checkIfFieldIsOccupied(Move newMove) {
        for (Move move : moveList)
            if (move.hasSamePosition(newMove)) return true;
        return false;
    }

    public boolean isListFull(int maxMoveCount) {
        return maxMoveCount == moveCount;
    }

    public List<Move> getList() {
        return moveList;
    }

    public int getLastMovePosition() {
        return lastMove.getRealPosition() + 1;
    }

    public Sign tellWhoMadeLastMove() {
        return lastMove.getSign();
    }

}
