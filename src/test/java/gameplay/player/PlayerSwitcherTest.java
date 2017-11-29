package gameplay.player;

import gameplay.signs.OSign;
import gameplay.signs.SignFabric;
import gameplay.signs.XSign;
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
        assertEquals(playerSwitcher.getActualPlayer().getSign().getClass(), XSign.class);
        assertEquals(playerSwitcher.getActualPlayer().getSign().getClass(), OSign.class);
        assertEquals(playerSwitcher.getActualPlayer().getSign().getClass(), XSign.class);
    }

}