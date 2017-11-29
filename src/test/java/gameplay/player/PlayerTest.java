package gameplay.player;

import gameplay.signs.CellState;
import gameplay.signs.OSign;
import gameplay.signs.Sign;
import gameplay.signs.XSign;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PlayerTest {

    @Test
    public void newPlayerHasZeroPoints() {

        //given
        Sign x = new XSign();
        Player player = new Player("One", x);
        Integer startPoints = 0;

        //when - then
        assertEquals(player.getPoints(), startPoints);
    }

    @Test
    public void playerHasName() {

        //given
        Sign o = new OSign();
        Player player = new Player("One", o);

        //when - then
        assertEquals(player.getName(), "One");
    }

    @Test
    public void playerHasSign() {

        //given
        Sign o = new OSign();
        Player player = new Player("One", o);

        //when - then
        assertEquals(player.getSign().getClass(), OSign.class);
    }

}