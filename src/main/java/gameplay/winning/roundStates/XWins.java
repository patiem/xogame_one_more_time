package gameplay.winning.roundStates;

public class XWins implements WinningCondition {

    @Override
    public int getPointsForX() {
        return 3;
    }

    @Override
    public int getPointsForO() {
        return 0;
    }
}
