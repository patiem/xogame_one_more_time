package gameplay.move;

import gameplay.signs.OSign;
import gameplay.signs.XSign;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class MoveTest {

    @Test
    public void ifMovesHasSamePosition_returnsTrue() {

        //given
        Move m1 = new Move(1, new XSign());
        Move m2 = new Move(1, new OSign());
        Move m3 = new Move(1, new XSign());
        //when
        //then
        assertTrue(m1.hasSamePosition(m2));
        assertTrue(m1.hasSamePosition(m3));
    }

    @Test
    public void ifMovesHasDifferentPosition_returnsFalse() {

        //given
        Move m1 = new Move(1, new XSign());
        Move m2 = new Move(2, new OSign());
        Move m3 = new Move(2, new XSign());
        //when
        //then
        assertFalse(m1.hasSamePosition(m2));
        assertFalse(m1.hasSamePosition(m3));
    }

}