package gameplay.board;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.intvalues.Horizontal;
import utility.intvalues.IntValue;
import utility.intvalues.Size;
import utility.intvalues.WinLength;

import static org.testng.Assert.assertEquals;

public class BoardPrinterTest {


    private Board board;
    private BoardPrinter boardPrinter;

    @BeforeMethod
    public void setup() {
        IntValue value = new Horizontal(3);
        IntValue size = new Size(3 * 3);
        IntValue win = new WinLength(3);
        BoardDimension boardDimension = new BoardDimension(value, size, win);
        board = new BoardBuilder(boardDimension).viaArrayList().fillUpArraysListWithNumbers().build();
        boardPrinter = new BoardPrinter(boardDimension);
        boardPrinter.setup();
    }

    @Test
    public void returnsPrettyBoardStringWIthNumbersIfBoardEmpty() {

        //given
        String boardString =
                " ____ ____ ____ \n" +
                "|    |    |    |\n" +
                "|  1 |  2 |  3 |\n" +
                "|____|____|____|\n" +
                "|    |    |    |\n" +
                "|  4 |  5 |  6 |\n" +
                "|____|____|____|\n" +
                "|    |    |    |\n" +
                "|  7 |  8 |  9 |\n" +
                "|____|____|____|\n";

        //when - then
        assertEquals(boardPrinter.makePrettyBoard(board), boardString);
    }

    @Test
    public void returnsPrettyBoardStringWithXandOIfCellsOccupied() {

        //given
        board.update(2, "X");
        board.update(5, "O");
        String boardString =
                " ____ ____ ____ \n" +
                "|    |    |    |\n" +
                "|  1 |  X |  3 |\n" +
                "|____|____|____|\n" +
                "|    |    |    |\n" +
                "|  4 |  O |  6 |\n" +
                "|____|____|____|\n" +
                "|    |    |    |\n" +
                "|  7 |  8 |  9 |\n" +
                "|____|____|____|\n";

        //when - then
        assertEquals(boardPrinter.makePrettyBoard(board), boardString);
    }

}