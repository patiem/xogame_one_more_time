package gameplay.winning.roundStates;

import utility.Polish;

public class OWins implements WinningCondition {

    private String playerName;

    public OWins(String playerName) {
        this.playerName = playerName;
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
        return String.format(Polish.MSG_WIN.toString(), playerName);
    }
}
