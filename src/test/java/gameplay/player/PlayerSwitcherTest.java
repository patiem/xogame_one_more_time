package gameplay.player;

import gameplay.signs.CellState;
import gameplay.signs.SignFabric;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PlayerSwitcherTest {

    @Test
    public void ifFirstIsAddedXThenReturnsXAndNextRetunsO() {

        //given
        Player player = new Player("One", SignFabric.getSign("X"));
        Player player1 = new Player("Two", SignFabric.getSign("O"));
        PlayerSwitcher playerSwitcher = new PlayerSwitcher(player, player1);

        //when - then
        assertEquals(playerSwitcher.getActualPlayerSign(), CellState.CROSS);
        assertEquals(playerSwitcher.getActualPlayerSign(), CellState.NAUGHT);
        assertEquals(playerSwitcher.getActualPlayerSign(), CellState.CROSS);
    }

}