package gameplay.move;

import gameplay.signs.Sign;

import java.util.ArrayList;
import java.util.List;

public class MoveList {

    private final List<Move> movesHistory;
    private Move lastMove;
    private Integer moveCount;

    public MoveList() {
        movesHistory = new ArrayList<>();
        moveCount = 0;
    }

    void addMoveToList(Move move) {
        movesHistory.add(move);
        lastMove = move;
        moveCount += 1;
    }

    boolean checkIfFieldIsOccupied(Move newMove) {
        for (Move move : movesHistory)
            if (move.hasSamePosition(newMove)) return true;
        return false;
    }

    public boolean isListFull(int maxMoveCount) {
        return maxMoveCount == moveCount;
    }

    public List<Move> getList() {
        return movesHistory;
    }

    public int getLastMovePosition() {
        return lastMove.getRealPosition() + 1;
    }

    public Sign tellWhoMadeLastMove() {
        return lastMove.getSign();
    }

}
