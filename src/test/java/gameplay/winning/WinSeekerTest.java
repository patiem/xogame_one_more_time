package gameplay.winning;

import gameplay.board.BoardDimension;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.intvalues.Horizontal;
import utility.intvalues.IntValue;
import utility.intvalues.Size;
import utility.intvalues.WinLength;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class WinSeekerTest {

    private WinSeeker winSeeker;
    private BoardDimension bd;

    @BeforeMethod
    public void setup() {
        IntValue value = new Horizontal(5);
        IntValue size = new Size(5 * 5);
        IntValue win = new WinLength(3);
        bd = new BoardDimension(value, size, win);
    }

    @Test
    public void sequenceOfThreeNaughts_NaughtWins() {

        //given
        winSeeker = new WinSeeker(bd);
        String sequence = "OOO";

        //when - then
        assertTrue(winSeeker.matcher(sequence));
    }

    @Test
    public void sequenceOfThreeCrosses_CrossWin() {

        //given
        winSeeker = new WinSeeker(bd);
        String sequence = "XXX";

        //when - then
        assertTrue(winSeeker.matcher(sequence));
    }

    @Test
    public void sequenceOfDifferentSigns_NoWin() {

        //given
        winSeeker = new WinSeeker(bd);
        String sequence = "OXO";

        //when - then
        assertFalse(winSeeker.matcher(sequence));
    }

    @Test
    public void sequenceWithEmptyCellAndFullBoard_NoWin() {

        //given
        winSeeker = new WinSeeker(bd);
        String sequence = "OeO";

        //when - then
        assertFalse(winSeeker.matcher(sequence));
    }

    @Test
    public void sequenceOfThreeCrossesAndBoardBiggerThanWiningLength_Win() {

        //given
        winSeeker = new WinSeeker(bd);
        String sequence = "OXXXO";
        String sequence2 = "XXXOO";

        //when - then
        assertTrue(winSeeker.matcher(sequence));
        assertTrue(winSeeker.matcher(sequence2));
    }

    @Test
    public void sequenceOn7LengthBoardFor4WinningLength() {

        //given
        IntValue value = new Horizontal(10);
        IntValue size = new Size(10 * 10);
        IntValue win = new WinLength(4);
        bd = new BoardDimension(value, size, win);
        winSeeker = new WinSeeker(new BoardDimension(value, size, win));
        String sequence = "XXXOXXO";
        String sequence2 = "XOXXXXO";
        String sequence3 = "OOOOXXX";

        //when - then
        assertFalse(winSeeker.matcher(sequence));
        assertTrue(winSeeker.matcher(sequence2));
        assertTrue(winSeeker.matcher(sequence3));
    }





}