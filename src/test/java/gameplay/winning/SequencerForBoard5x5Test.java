package gameplay.winning;

import gameplay.board.Board;
import gameplay.board.BoardBuilder;
import gameplay.board.BoardDimension;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.intValues.Horizontal;
import utility.intValues.IntValue;
import utility.intValues.Size;
import utility.intValues.WinLength;

import static org.testng.Assert.assertEquals;

public class SequencerForBoard5x5Test {

    private Sequencer sequencer;
    private BoardDimension bd;
    private Board board;

    @BeforeMethod
    public void setup() {
        IntValue value = new Horizontal(5);
        IntValue size = new Size(5 * 5);
        IntValue win = new WinLength(3);
        bd = new BoardDimension(value, size, win);
        board = new BoardBuilder(bd).viaArrayList().fillUpArraysListWithNumbers().build();
        board.update(1, "O");
        board.update(3, "X");
        board.update(4, "O");
        board.update(5, "O");
        board.update(7, "O");
        board.update(8, "X");
        board.update(9, "X");
        board.update(11, "X");
        board.update(12, "O");
        board.update(13, "X");
        board.update(14, "O");
        board.update(15, "X");
        board.update(16, "O");
        board.update(17, "X");
        board.update(18, "O");
        board.update(19, "X");
        board.update(20, "O");
        board.update(21, "O");
        board.update(23, "O");
        board.update(24, "X");
        board.update(25, "O");
        sequencer = new Sequencer(bd, board);
    }

    @Test
    public void returnsStringWithHorizontalLineForGivenMovePositionWhenPositionInCenterOfRow() {

        //given
        int move = 13;
        String sequence = "XOXOX";
        int move2 = 18;
        String sequence2 = "OXOXO";

        //when - then
        assertEquals(sequencer.getHorizontal(move), sequence);
        assertEquals(sequencer.getHorizontal(move2), sequence2);
    }

    @Test
    public void returnsStringWithVerticalLineForGivenMovePositionWhenPositionInCenterOfColumn() {

        //given
        int move = 13;
        String sequence = "XXXOO";
        int move2 = 14;
        String sequence2 = "OXOXX";

        //when - then
        assertEquals(sequencer.getVertical(move), sequence);
        assertEquals(sequencer.getVertical(move2), sequence2);
    }

    @Test
    public void returnsStringWithDiagonalRightLineForGivenMovePositionWhenPositionInCenterOfTable() {

        //given
        int move = 13;
        String sequence = "OOXXO";

        //when - then
        assertEquals(sequencer.getDiagonalRight(move), sequence);
    }

    @Test
    public void returnsStringWithDiagonalLeftLineForGivenMovePositionWhenPositionInCenterOfTable() {

        //given
        int move = 13;
        String sequence = "OXXXO";

        //when - then
        assertEquals(sequencer.getDiagonalLeft(move), sequence);
    }

    @Test
    public void returnsStringWithHorizontalLineForGivenMovePositionWhenPositionInLeftSideOfRow() {

        //given
        int move = 11;
        String sequence = "XOX";

        //when - then
        assertEquals(sequencer.getHorizontal(move), sequence);
    }

    @Test
    public void returnsStringWithHorizontalLineForGivenMovePositionWhenPositionInRightSideOfRow() {

        //given
        int move = 15;
        String sequence = "XOX";

        //when - then
        assertEquals(sequencer.getHorizontal(move), sequence);
    }

    @Test
    public void returnsStringWithVerticalLineForGivenMovePositionWhenPositionInTopOfColumn() {

        //given
        int move = 3;
        String sequence = "XXX";

        //when - then
        assertEquals(sequencer.getVertical(move), sequence);
    }

    @Test
    public void returnsStringWithVerticalLineForGivenMovePositionWhenPositionInBottomOfColumn() {

        //given
        int move = 24;
        String sequence = "OXX";

        //when - then
        assertEquals(sequencer.getVertical(move), sequence);
    }

    @Test
    public void returnsStringWithDiagonalRightLineForGivenMovePositionWhenPositionOnBorderLeft() {

        //given
        int move = 11;
        String sequence = "XXO";

        //when - then
        assertEquals(sequencer.getDiagonalRight(move), sequence);
    }

    @Test
    public void returnsStringWithDiagonalRightLineForGivenMovePositionWhenPositionOnBorderDown() {

        //given
        int move = 23;
        String sequence = "XXO";

        //when - then
        assertEquals(sequencer.getDiagonalRight(move), sequence);
    }

    @Test
    public void returnsStringWithDiagonalRightLineForGivenMovePositionWhenPositionOnBorderRight() {

        //given
        int move = 20;
        String sequence = "XOO";

        //when - then
        assertEquals(sequencer.getDiagonalRight(move), sequence);
    }

    @Test
    public void returnsStringWithDiagonalRightLineForGivenMovePositionWhenPositionOnBorderBottom() {

        //given
        int move = 3;
        String sequence = "XXX";

        //when - then
        assertEquals(sequencer.getDiagonalRight(move), sequence);
    }

    @Test
    public void returnsStringWithDiagonalLeftLineForGivenMovePositionWhenPositionInBottomOfTable() {

        //given
        int move = 23;
        String sequence = "XXO";

        //when - then
        assertEquals(sequencer.getDiagonalRight(move), sequence);
    }

    @Test
    public void returnsStringWithDiagonalLeftLineForGivenMovePositionWhenPositionOnTopOfTable() {

        //given
        int move = 3;
        String sequence = "XOX";

        //when - then
        assertEquals(sequencer.getDiagonalLeft(move), sequence);
    }

    @Test
    public void returnsStringWithDiagonalLeftLineForGivenMovePositionWhenPositionOnLeftOfTable() {

        //given
        int move = 16;
        String sequence = "OXOO";

        //when - then
        assertEquals(sequencer.getDiagonalLeft(move), sequence);
    }

    @Test
    public void returnsStringWithDiagonalLeftLineForGivenMovePositionWhenPositionOnRightOfTable() {

        //given
        int move = 15;
        String sequence = "XXO";

        //when - then
        assertEquals(sequencer.getDiagonalLeft(move), sequence);
    }
}