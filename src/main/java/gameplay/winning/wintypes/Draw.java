package gameplay.winning.wintypes;

import utility.language.Language;

public class Draw implements WinningCondition {

    static final int xScore = 1;
    static final int oScore = 1;

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
        return String.format(Language.MSG_DRAW.toString());
    }
}
