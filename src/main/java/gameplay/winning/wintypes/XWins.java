package gameplay.winning.wintypes;

import gameplay.player.Player;
import utility.language.Language;

public class XWins implements WinningCondition {

    private Player player;
    private final int xScores = 3;
    private final int oScores = 0;

    public XWins(Player player) {
        this.player = player;
    }

    @Override
    public int getPointsForX() {
        return xScores;
    }

    @Override
    public int getPointsForO() {
        return oScores;
    }

    @Override
    public String toString() {
        return String.format(Language.MSG_WIN.toString(), player.getName());
    }
}
