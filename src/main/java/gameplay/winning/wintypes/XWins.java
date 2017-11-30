package gameplay.winning.wintypes;

import gameplay.player.Player;
import utility.language.Language;

public class XWins implements WinningCondition {

    private final Player player;
    private static final int X_SCORES = 3;
    private static final int O_SCORES = 0;

    public XWins(Player player) {
        this.player = player;
    }

    @Override
    public int getPointsForX() {
        return X_SCORES;
    }

    @Override
    public int getPointsForO() {
        return O_SCORES;
    }

    @Override
    public String toString() {
        return String.format(Language.MSG_WIN.toString(), player.getName());
    }
}
