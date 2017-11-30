package gameplay.winning;

import gameplay.board.Board;
import gameplay.board.BoardBuilder;
import gameplay.board.BoardDimension;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.intvalues.Horizontal;
import utility.intvalues.IntValue;
import utility.intvalues.Size;
import utility.intvalues.WinLength;

import static org.testng.Assert.assertEquals;

public class SequencerForBoard3x3Test {

    private Sequencer sequencer;

    @BeforeMethod
    public void setup() {
        IntValue value = new Horizontal(3);
        IntValue size = new Size(3 * 3);
        IntValue win = new WinLength(3);
        BoardDimension bd = new BoardDimension(value, size, win);
        Board board = new BoardBuilder(bd).viaArrayList().fillUpArraysListWithNumbers().build();
        board.update(1, "O");
        board.update(3, "X");
        board.update(4, "O");
        board.update(5, "O");
        board.update(6, "O");
        board.update(7, "O");
        board.update(8, "X");
        board.update(9, "X");
        sequencer = new Sequencer(bd, board);
    }

    @Test
    public void returnsStringWithHorizontalLineForGivenMovePositionWhenPositionInCenterOfRow() {

        //given
        int move = 5;
        String sequence = "OOO";

        //when - then
        assertEquals(sequencer.getHorizontal(move), sequence);
    }

    @Test
    public void returnsStringWithVerticalLineForGivenMovePositionWhenPositionInCenterOfColumn() {

        //given
        int move = 5;
        String sequence = "2OX";

        //when - then
        assertEquals(sequencer.getVertical(move), sequence);
    }

    @Test
    public void returnsStringWithDiagonalRightLineForGivenMovePositionWhenPositionInCenterOfTable() {

        //given
        int move = 5;
        String sequence = "OOX";

        //when - then
        assertEquals(sequencer.getDiagonalRight(move), sequence);
    }

    @Test
    public void returnsStringWithDiagonalLeftLineForGivenMovePositionWhenPositionInCenterOfTable() {

        //given
        int move = 5;
        String sequence = "XOO";

        //when - then
        assertEquals(sequencer.getDiagonalLeft(move), sequence);
    }

    @Test
    public void returnsStringWithHorizontalLineForGivenMovePositionWhenPositionInLeftSideOfRow() {

        //given
        int move = 1;
        String sequence = "O2X";

        //when - then
        assertEquals(sequencer.getHorizontal(move), sequence);
    }

    @Test
    public void returnsStringWithHorizontalLineForGivenMovePositionWhenPositionInRightSideOfRow() {

        //given
        int move = 6;
        String sequence = "OOO";

        //when - then
        assertEquals(sequencer.getHorizontal(move), sequence);
    }

    @Test
    public void returnsStringWithVerticalLineForGivenMovePositionWhenPositionInTopOfColumn() {

        //given
        int move = 3;
        String sequence = "XOX";

        //when - then
        assertEquals(sequencer.getVertical(move), sequence);
    }

    @Test
    public void returnsStringWithVerticalLineForGivenMovePositionWhenPositionInBottomOfColumn() {

        //given
        int move = 7;
        String sequence = "OOO";

        //when - then
        assertEquals(sequencer.getVertical(move), sequence);
    }

    @Test
    public void returnsStringWithDiagonalRightLineForGivenMovePositionWhenPositionOnBorderLeft() {

        //given
        int move = 4;
        String sequence = "OX";

        //when - then
        assertEquals(sequencer.getDiagonalRight(move), sequence);
    }

    @Test
    public void returnsStringWithDiagonalRightLineForGivenMovePositionWhenPositionOnBorderDown() {

        //given
        int move = 8;
        String sequence = "OX";

        //when - then
        assertEquals(sequencer.getDiagonalRight(move), sequence);
    }

    @Test
    public void returnsStringWithDiagonalRightLineForGivenMovePositionWhenPositionOnBorderRight() {

        //given
        int move = 6;
        String sequence = "2O";

        //when - then
        assertEquals(sequencer.getDiagonalRight(move), sequence);
    }

    @Test
    public void returnsStringWithDiagonalRightLineForGivenMovePositionWhenPositionOnBorderBottom() {

        //given
        int move = 9;
        String sequence = "OOX";

        //when - then
        assertEquals(sequencer.getDiagonalRight(move), sequence);
    }

    @Test
    public void returnsStringWithDiagonalLeftLineForGivenMovePositionWhenPositionInBottomOfTable() {

        //given
        int move = 8;
        String sequence = "OX";

        //when - then
        assertEquals(sequencer.getDiagonalRight(move), sequence);
    }

    @Test
    public void returnsStringWithDiagonalLeftLineForGivenMovePositionWhenPositionOnTopOfTable() {

        //given
        int move = 3;
        String sequence = "XOO";

        //when - then
        assertEquals(sequencer.getDiagonalLeft(move), sequence);
    }

    @Test
    public void returnsStringWithDiagonalLeftLineForGivenMovePositionWhenPositionOnLeftOfTable() {

        //given
        int move = 7;
        String sequence = "XOO";

        //when - then
        assertEquals(sequencer.getDiagonalLeft(move), sequence);
    }

    @Test
    public void returnsStringWithDiagonalLeftLineForGivenMovePositionWhenPositionOnRightOfTable() {

        //given
        int move = 6;
        String sequence = "OX";

        //when - then
        assertEquals(sequencer.getDiagonalLeft(move), sequence);
    }
}