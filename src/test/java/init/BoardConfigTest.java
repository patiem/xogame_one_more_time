package init;

import init.BoardConfig;
import init.Config;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BoardConfigTest {

    @Test
    public void getConfigCreatesMap() {

        //given
        Config<Integer> config = new BoardConfig(5,5,5);

        //when - then
        assertTrue(config.getConfig() instanceof Map);
    }

    @Test
    public void configHasMapWithFourFieldsWithKeys() {

        //given
        Config<Integer> config = new BoardConfig(5,5,5);

        //when - then
        assertTrue(config.getConfig().containsKey("horizontal"));
        assertTrue(config.getConfig().containsKey("vertical"));
        assertTrue(config.getConfig().containsKey("winning"));
    }

    @Test
    public void configAssignStringsToKeys() {

        //given
        Integer vertical = 5;
        Integer horizontal = 5;
        Integer winning = 5;
        Config<Integer> config = new BoardConfig(horizontal, vertical, winning);

        //when - then
        assertEquals(config.getConfig().get("horizontal"), horizontal);
        assertEquals(config.getConfig().get("vertical"), vertical);
        assertEquals(config.getConfig().get("winning"), winning);
    }

}