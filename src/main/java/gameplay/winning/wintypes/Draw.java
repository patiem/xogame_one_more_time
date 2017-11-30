package gameplay.winning.wintypes;

import utility.language.Language;

public class Draw implements WinningCondition {

    private static final int X_SCORE = 1;
    private static final int O_SCORE = 1;

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
        return Language.MSG_DRAW.toString();
    }
}
