package gameplay.winning.wintypes;

import gameplay.player.Player;
import utility.language.Language;

public class OWins implements WinningCondition {

    private Player player;
    static final int xScore = 0;
    static final int oScore = 3;

    public OWins(Player player) {
        this.player = player;
    }

    @Override
    public int getPointsForX() {
        return xScore;
    }

    @Override
    public int getPointsForO() {
        return oScore;
    }

    @Override
    public String toString() {
        return String.format(Language.MSG_WIN.toString(), player.getName());
    }
}
