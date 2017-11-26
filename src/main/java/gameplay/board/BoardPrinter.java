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

//    public String getPrettyBoard() {
//        setup();
//        return makePrettyBoard();
//    }

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
        StringBuilder pipes = new StringBuilder();
        List<String> downLineList2 = IntStream.range(0, bd.horizontal()).mapToObj(a -> "|").collect(Collectors.toList());
        pipes.append(String.join("    ", downLineList2));
        pipes.append("    |\n");
        return pipes.toString();
    }

    private String makeLine() {
        StringBuilder line = new StringBuilder(" ");
        List<String> LineList = IntStream.range(0, bd.horizontal()).mapToObj(a -> "____").collect(Collectors.toList());
        line.append(String.join(" ", LineList));
        line.append(" \n");
        return line.toString();
    }

    private String makeInline() {
        StringBuilder line = new StringBuilder();
        List<String> downLineList = IntStream.range(0, bd.horizontal()).mapToObj(a -> "|____").collect(Collectors.toList());
        line.append(String.join("", downLineList));
        line.append("|\n");
        return line.toString();
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

//TODO: Abstarct setup methods!!!
//todo: print empty and update to simillar!!