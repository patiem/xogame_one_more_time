package gameplay.winning.wintypes;

import gameplay.player.Player;
import utility.language.Language;

public class OWins implements WinningCondition {

    private final Player player;
    private static final int X_SCORE = 0;
    private static final int O_SCORE = 3;

    public OWins(Player player) {
        this.player = player;
    }

    @Override
    public int getPointsForX() {
        return X_SCORE;
    }

    @Override
    public int getPointsForO() {
        return O_SCORE;
    }

    @Override
    public String toString() {
        return String.format(Language.MSG_WIN.toString(), player.getName());
    }
}
