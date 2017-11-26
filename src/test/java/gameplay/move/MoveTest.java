package gameplay.move;

import enums.CellState;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MoveTest {

    @Test
    public void ifMovesHasSamePosition_returnsTrue() {

        //given
        Move m1 = new Move(1, CellState.CROSS);
        Move m2 = new Move(1, CellState.NAUGHT);
        Move m3 = new Move(1, CellState.CROSS);
        //when
        //then
        assertTrue(m1.hasSamePosition(m2));
        assertTrue(m1.hasSamePosition(m3));
    }

    @Test
    public void ifMovesHasDifferentPosition_returnsFalse() {

        //given
        Move m1 = new Move(1, CellState.CROSS);
        Move m2 = new Move(2, CellState.NAUGHT);
        Move m3 = new Move(2, CellState.CROSS);
        //when
        //then
        assertFalse(m1.hasSamePosition(m2));
        assertFalse(m1.hasSamePosition(m3));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void ifMoveHasEmptyState_throwsException() {
        Move m1 = new Move(1, CellState.EMPTY);
    }

}