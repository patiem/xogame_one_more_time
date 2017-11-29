package gameplay.board;

import gameplay.move.MoveList;
import gameplay.move.Observer;
import utility.printing.PrintManager;
import utility.printing.Printer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoardPrinter implements Observer<MoveList> {


    private String inline;
    private String pipes;
    private String line;
    private BoardDimension bd;
    private Printer printer;
    private StringBuilder sb;



    public BoardPrinter(BoardDimension bd) {
        this.bd = bd;
        printer = PrintManager.getPrinter();
    }

    String makePrettyBoard(Board board) {
        sb = new StringBuilder();
        sb.append(line);
        sb.append(pipes);
        sb.append("|");
        Integer n = 1;
        String sign;
        for (String cell : board.getBoard()) {

            if (cell.equals("X")) sign = "X";
            else if (cell.equals("O")) sign = "O";
            else sign = n.toString();

            sb.append(String.format("%3s |", sign));


            if (n % bd.horizontal() == 0) {
                sb.append("\n");
                sb.append(inline);
                if(n < bd.size() - bd.horizontal() + 1) {
                    sb.append(pipes);
                    sb.append("|");
                }
            }
            n += 1;
        }
        return sb.toString();
    }

    public void setup() {
        inline = makeInline();
        line = makeLine();
        pipes = makePipes();
    }

    private String makePipes() {
        sb = new StringBuilder();
        List<String> downLineList2 = IntStream.range(0, bd.horizontal()).mapToObj(a -> "|").collect(Collectors.toList());
        sb.append(String.join("    ", downLineList2));
        sb.append("    |\n");
        return sb.toString();
    }

    private String makeLine() {
        sb = new StringBuilder(" ");
        List<String> lineList = IntStream.range(0, bd.horizontal()).mapToObj(a -> "____").collect(Collectors.toList());
        sb.append(String.join(" ", lineList));
        sb.append(" \n");
        return sb.toString();
    }

    private String makeInline() {
        sb = new StringBuilder();
        List<String> downLineList = IntStream.range(0, bd.horizontal()).mapToObj(a -> "|____").collect(Collectors.toList());
        sb.append(String.join("", downLineList));
        sb.append("|\n");
        return sb.toString();
    }

    @Override
    public void update(MoveList moves) {
        BoardBuilder boardBuilder = new BoardBuilder(bd);
        Board board = boardBuilder.viaArrayList().fillUpArraysListWithNumbers().fillBoardWithMoves(moves).build();
        printer.printMsg(makePrettyBoard(board));
    }

    public void printEmptyBoard() {
        BoardBuilder boardBuilder = new BoardBuilder(bd);
        Board board = boardBuilder.viaArrayList().fillUpArraysListWithNumbers().build();
        printer.printMsg(makePrettyBoard(board));
    }
}
