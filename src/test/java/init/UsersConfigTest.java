package init;

import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UsersConfigTest {

    @Test
    public void getConfigCreatesMap() {

        //given
        Config<String> config = new UsersConfig("One", "Two", "X", "O", "X");

        //when - then
        assertTrue(config.getConfig() instanceof Map);
    }

    @Test
    public void configHasMapWithFourFieldsWithKeys() {

        //given
        Config<String> config = new UsersConfig("One", "Two", "X", "O", "X");

        //when - then
        assertTrue(config.getConfig().containsKey("pl1name"));
        assertTrue(config.getConfig().containsKey("pl2name"));
        assertTrue(config.getConfig().containsKey("pl1sign"));
        assertTrue(config.getConfig().containsKey("pl1sign"));
    }

    @Test
    public void configAssignStringsToKeys() {

        //given
        String name1 = "One";
        String name2 = "Two";
        String sign1 = "X";
        String sign2 = "O";
        String start = "X";

        Config<String> config = new UsersConfig(name1, name2, sign1, sign2, start);

        //when - then
        assertEquals(config.getConfig().get("pl1name"), name1);
        assertEquals(config.getConfig().get("pl2name"), name2);
        assertEquals(config.getConfig().get("pl1sign"), sign1);
        assertEquals(config.getConfig().get("pl2sign"), sign2);
    }
}