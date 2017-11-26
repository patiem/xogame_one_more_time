package gameplay.player;

import gameplay.signs.SignFabric;
import init.Config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlayerSwitcher {
    private Player one;
    private Player two;
    private List<Player> players;

    public static PlayerSwitcher build(Config<String> users) {

        Player one = new Player(users.getConfig().get("pl1name"), SignFabric.getSign(users.getConfig().get("pl1sign")));
        Player two = new Player(users.getConfig().get("pl2name"), SignFabric.getSign(users.getConfig().get("pl2sign")));
        return new PlayerSwitcher(one, two);
    }

    PlayerSwitcher(Player one, Player two) {
        this.one = one;
        this.two = two;
        players = Arrays.asList(one, two);
    }

    public String getNameOfActualUser() {
        return players.get(0).getName();
    }

    public Player getActualPlayer() {
        Player player = players.get(0);
        Collections.reverse(players);
        return player;
    }
}
