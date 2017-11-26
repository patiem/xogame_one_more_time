package gameplay.move;

import enums.CellState;

public class Move {

    private int position;
    private CellState cellState;

    public Move(int position, CellState cellState) {

        this.position = position;
        if (cellState == CellState.EMPTY) throw new IllegalArgumentException();
        this.cellState = cellState;
    }

    public boolean hasSamePosition(Move newMove) {

        return this.position == newMove.position;
    }

    public static Move build(int move, CellState actualSign) {
        return new Move(move, actualSign);
    }

    public int getRealPosition() {
        return position - 1;
    }

    public CellState getState() {
        return cellState;
    }
}
