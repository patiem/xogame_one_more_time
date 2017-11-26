package gameplay.winning;

import gameplay.board.BoardDimension;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WinSeekerTest {

    WinSeeker winSeeker;
    BoardDimension bd;

    @BeforeMethod
    public void setup() {
        bd = new BoardDimension(3 , 3, 3);
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
        winSeeker = new WinSeeker(new BoardDimension(10, 10, 4));
        String sequence = "XXXOXXO";
        String sequence2 = "XOXXXXO";
        String sequence3 = "OOOOXXX";

        //when - then
        assertFalse(winSeeker.matcher(sequence));
        assertTrue(winSeeker.matcher(sequence2));
        assertTrue(winSeeker.matcher(sequence3));
    }





}