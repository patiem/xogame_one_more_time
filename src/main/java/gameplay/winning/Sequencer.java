package gameplay.winning;

import gameplay.board.Board;
import gameplay.board.BoardBuilder;
import gameplay.board.BoardDimension;
import gameplay.move.Move;
import gameplay.move.MoveList;
import interfaces.Observer;

import java.util.List;

public class Sequencer implements Observer<MoveList> {

    private final int jump;
    private BoardDimension bd;
    private int winLength;
    private StringBuilder builder;
    private Board board;
    private String[] sequences;

    public Sequencer(BoardDimension bd) {
        this.bd = bd;
        this.winLength = bd.getWinningLength();
        this.jump = bd.getVertical();
    }

    public Sequencer(BoardDimension bd, Board board) {
        this.bd = bd;
        this.winLength = bd.getWinningLength();
        this.jump = bd.getVertical();
        this.board = board;
    }

    private void getAllSequences(int move) {

        sequences = new String[4];
        sequences[0] = getHorizontal(move);
        sequences[1] = getVertical(move);
        sequences[2] = getDiagonalRight(move);
        sequences[3] = getDiagonalLeft(move);
    }

    public String[] getSequencesToValidate() {
        return sequences;
    }

    @Override
    public void update(MoveList moves) {
        getUpdatedBoard(moves);
        getAllSequences(moves.getLastMovePosition());
    }

    private void getUpdatedBoard(MoveList moves) {
        board = new BoardBuilder(bd)
                .viaArrayList()
                .fillUpArraysListWithNumbers()
                .fillBoardWithMoves(moves)
                .build();
    }

    String getHorizontal(int move) {

        builder = new StringBuilder();

        int startRow = ((move - 1) / jump) * jump + 1;
        int endRow = startRow + jump - 1;
        int startRange = move - winLength + 1;
        int endRange = move + winLength -1;

        startRange = (startRange < startRow) ? startRow : startRange;
        endRange = (endRange > endRow) ? endRow : endRange;

        for (int i = startRange; i <= endRange; i++) builder.append(board.getCell(i));
        return builder.toString();
    }


    String getVertical(int move) {

        builder = new StringBuilder();
        int startRange = (move - jump * (winLength - 1));
        int endRange = move + jump * (winLength - 1);

        for (int i = startRange; i <= endRange; i += jump) {
            if(i > 0 && i <= bd.getSize()) builder.append(board.getCell(i));
        }
        return builder.toString();
    }

    String getDiagonalRigh2t(int move) {

        builder = new StringBuilder();

        int upRow = (move -1)% jump;
        int downRow = jump - 1 - (move -1)% jump;

        int stRange = (winLength - 1 > upRow) ? move - jump * upRow - upRow : move - jump * (winLength - 1) - winLength + 1;
        int eRange = (winLength - 1 > downRow) ? move + jump * downRow + downRow : move + jump * (winLength - 1) + winLength - 1;

        for (int i = stRange; i <= eRange; i += jump + 1) {
            if(i > 0 && i <= bd.getSize())
                builder.append(board.getCell(i));
        }

        return builder.toString();
    }

    String getDiagonalRight(int move) {

        builder = new StringBuilder();

        while (move - jump - 1 > 0) {
            move = move - jump - 1;
            if (move % jump == 0) {
                move = move + jump + 1;
                break;
            }
        }

        while (move <= bd.getSize()) {
            builder.append(board.getCell(move ));
            move += (jump + 1);
        }
        return builder.toString();
    }


    String getDiagonalLeft(int move) {

        builder = new StringBuilder();

        while(move - jump > 0) {
            move = move - jump + 1;
            if ((move - 1) % jump == 0) {
                move += jump -1;
                break;
            }
        }

        while (move < bd.getSize()) {
            builder.append(board.getCell(move));
            if (move % jump == 1) break;
            move += jump -1;
        }
        return builder.toString();
    }
}
 //TODO: Zmienić pierwszą diagonalkę