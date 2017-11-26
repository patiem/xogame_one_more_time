package gameplay.winning;

public class Draw implements WinningCondition {

    @Override
    public int getPointsForX() {
        return 1;
    }

    @Override
    public int getPointsForO() {
        return 1;
    }
}
