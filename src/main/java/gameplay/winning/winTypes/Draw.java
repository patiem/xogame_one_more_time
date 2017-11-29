package gameplay.winning.winTypes;

import utility.language.Language;

public class Draw implements WinningCondition {

    @Override
    public int getPointsForX() {
        return 1;
    }

    @Override
    public int getPointsForO() {
        return 1;
    }

    @Override
    public String toString() {
        return String.format(Language.MSG_DRAW.toString());
    }
}
