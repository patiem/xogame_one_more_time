package gameplay.board;

import gameplay.move.Move;
import gameplay.move.MoveList;
import gameplay.move.Observer;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoardBuilder {


    private final BoardDimension boardDimension;
    private int initialCapacity;
    private List<String> al;

    public BoardBuilder(BoardDimension bd) {
        this.boardDimension = bd;
        initialCapacity = boardDimension.size();
    }

    public BoardBuilder viaArrayList() {
        al = new ArrayList(initialCapacity);
        return this;
    }

    public BoardBuilder fillUpArraysListWithNumbers() {
        al = IntStream.range(0, initialCapacity).mapToObj(a -> Integer.toString(a + 1)).collect(Collectors.toList());
        return this;
    }

    public BoardBuilder fillBoardWithMoves(MoveList moves) {
        for (Move move : moves.getList()) {
            System.out.println(move.toString());
            al.set(move.getRealPosition(), move.toString());
        }
        return this;
    }

    public Board build() {
        return new Board(al, boardDimension);
    }

}