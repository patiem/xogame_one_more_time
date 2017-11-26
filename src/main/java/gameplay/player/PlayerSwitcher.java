package gameplay.player;

import gameplay.signs.CellState;
import gameplay.signs.SignFabric;
import init.Config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlayerSwitcher {
    private Player one;
    private Player two;
    private List<Player> players;

    public static PlayerSwitcher PlayerSwitcherBuilder(Config<String> users) {

        Player one = new Player(users.getConfig().get("pl1name"), SignFabric.getSign(users.getConfig().get("pl1sign")));
        Player two = new Player(users.getConfig().get("pl2name"), SignFabric.getSign(users.getConfig().get("pl2sign")));
        return new PlayerSwitcher(one, two);
    }

    PlayerSwitcher(Player one, Player two) {
        this.one = one;
        this.two = two;
        players = Arrays.asList(one, two);
    }

    public CellState getActualPlayerSign() {
        CellState actualSign = players.get(0).getSign();
        Collections.reverse(players);
        return actualSign;
    }

    public String getNameOfActualUser() {
        return players.get(0).getName();
    }
}
