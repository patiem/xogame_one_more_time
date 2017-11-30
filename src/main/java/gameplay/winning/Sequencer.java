package gameplay.winning;

import gameplay.board.Board;
import gameplay.board.BoardBuilder;
import gameplay.board.BoardDimension;
import gameplay.move.MoveList;

class Sequencer {

    private final int jump;
    private final BoardDimension bd;
    private final int winLength;
    private StringBuilder builder;
    private Board board;

    public Sequencer(BoardDimension bd) {
        this.bd = bd;
        this.winLength = bd.winningLength();
        this.jump = bd.horizontal();
    }

    public Sequencer(BoardDimension bd, Board board) {
        this(bd);
        this.board = board;

    }

    public Sequence sequencesToCheck(MoveList moves) {
        getUpdatedBoard(moves);
        return getAllSequences(moves.getLastMovePosition());
    }

    private Sequence getAllSequences(int move) {

        Sequence sequences = new Sequence();
        sequences.add(getHorizontal(move));
        sequences.add(getVertical(move));
        sequences.add(getDiagonalRight(move));
        sequences.add(getDiagonalLeft(move));

        return sequences;
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
            if(i > 0 && i <= bd.size()) builder.append(board.getCell(i));
        }
        return builder.toString();
    }

    String getDiagonalRight(int move) {

        builder = new StringBuilder();

        int upRow = (move -1)% jump;
        int downRow = jump - 1 - (move -1)% jump;

        int stRange = (winLength - 1 > upRow) ? move - jump * upRow - upRow : move - jump * (winLength - 1) - winLength + 1;
        int eRange = (winLength - 1 > downRow) ? move + jump * downRow + downRow : move + jump * (winLength - 1) + winLength - 1;

        for (int i = stRange; i <= eRange; i += jump + 1) {
            if(i > 0 && i <= bd.size())
                builder.append(board.getCell(i));
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

        while (move < bd.size()) {
            builder.append(board.getCell(move));
            if (move % jump == 1) break;
            move += jump -1;
        }
        return builder.toString();
    }
}