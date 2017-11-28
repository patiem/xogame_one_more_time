package gameplay.winning.roundStates;

import utility.Polish;

public class XWins implements WinningCondition {

    private String playerName;

    public XWins(String playerName) {
        this.playerName = playerName;
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
        return String.format(Polish.MSG_WIN.toString(), playerName);
    }
}
