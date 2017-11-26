package gameplay.board;

import java.util.List;

public class Board {

    private final BoardDimension boardDimension;
    private List<String> cellList;

    public Board(List<String> al, BoardDimension bd) {
        cellList = al;
        boardDimension = bd;
    }

    public boolean update(int move, String sign) {
        if (checkIfCellIsEmpty(move)) {
            setSign(move, sign);
            return true;
        }
        return false;
    }

    private void setSign(int move, String sign) {
        cellList.set(move - 1, sign);
    }

    private boolean checkIfCellIsEmpty(int move) {
        return !(cellList.get(move - 1).equals("X") || cellList.get(move - 1).equals("O"));
    }

    public List<String> getBoard() {
        return cellList;
    }

    public String getCell(int position) {
        return cellList.get(position - 1);
    }

}

//TODO: do I need getBoard method?