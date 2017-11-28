package gameplay.winning.winTypes;

import gameplay.player.Player;
import utility.Polish;

public class OWins implements WinningCondition {

    private Player player;

    public OWins(Player player) {
        this.player = player;
    }

    @Override
    public int getPointsForX() {
        return 0;
    }

    @Override
    public int getPointsForO() {
        return 3;
    }

    @Override
    public String toString() {
        return String.format(Polish.MSG_WIN.toString(), player.getName());
    }
}
