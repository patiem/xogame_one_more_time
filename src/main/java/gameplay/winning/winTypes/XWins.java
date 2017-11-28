package gameplay.winning.winTypes;

import gameplay.player.Player;
import utility.Polish;

public class XWins implements WinningCondition {

    private Player player;

    public XWins(Player player) {
        this.player = player;
    }

    @Override
    public int getPointsForX() {
        return 3;
    }

    @Override
    public int getPointsForO() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format(Polish.MSG_WIN.toString(), player.getName());
    }
}
