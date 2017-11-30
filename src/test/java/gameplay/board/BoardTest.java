package gameplay.board;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BoardTest {

    private Board board;

    @DataProvider(name = "boardDimension")
    public static Object[][] boardSize() {
        return new Object[][] {{3, 3, 3, 2}, {4, 6, 4, 5}, {19, 20, 7, 50}, {22, 5,  4, 7}, {6, 30, 5, 14}};
    }

    @DataProvider(name = "correctWinningL")
    public static Object[][] correctWinningLength() {
        return new Object[][] {{3}, {4}, {19}, {25}, {6}};
    }

    @Test(dataProvider = "boardDimension")
    public void ifCellIsEmpty_returnTrue(int horizontal, int vertical, int winning, int move) {

        //given
        board = new BoardBuilder(new BoardDimension(horizontal,vertical, winning)).viaArrayList().fillUpArraysListWithNumbers().build();


        //when - then
        String signDoesNotMatterHere = "X";
        assertTrue(board.update(move, signDoesNotMatterHere));
    }

    @Test(dataProvider = "boardDimension")
    public void ifCellIsOccupied_returnFalse(int horizontal, int vertical, int winning, int move) {

        //given
        board = new BoardBuilder(new BoardDimension(horizontal,vertical, winning)).viaArrayList().fillUpArraysListWithNumbers().build();
        board.getBoard().set(move - 1, "X");

        //when - then
        assertFalse(board.update(move, null));
    }

    @Test(dataProvider = "boardDimension")
    public void ifCellIsEmptyAndCrossIsPlaying_cellIsChangedToX(int horizontal, int vertical, int winning, int move) {

        //given
        board = new BoardBuilder(new BoardDimension(horizontal,vertical, winning)).viaArrayList().fillUpArraysListWithNumbers().build();
        String sign = "X";

        //when
        board.update(move, sign);

        //then
        assertTrue(board.getCell(move).equals("X"));
    }

    @Test(dataProvider = "boardDimension")
    public void ifCellIsEmptyAndNoughtIsPlaying_cellIsChangedToO(int horizontal, int vertical, int winning, int move) {

        //given
        board = new BoardBuilder(new BoardDimension(horizontal,vertical, winning)).viaArrayList().fillUpArraysListWithNumbers().build();
        String sign = "O";

        //when
        board.update(move, sign);

        //then
        assertTrue(board.getCell(move).equals("O"));
    }

    @Test(dataProvider = "boardDimension")
    public void ifCellIsOccupiedByCrossAndNoughtChooseIt_isNotChangesToNought(int horizontal, int vertical, int winning, int move) {

        //given
        board = new BoardBuilder(new BoardDimension(horizontal,vertical, winning)).viaArrayList().fillUpArraysListWithNumbers().build();
        String sign = "O";

        //when
        board.getBoard().set(move - 1, "X");
        board.update(move, sign);

        //then
        assertTrue(board.getCell(move).equals("X"));
    }
}