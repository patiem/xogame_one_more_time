package gameplay.winning.roundStates;

public class OWins implements WinningCondition {

    @Override
    public int getPointsForX() {
        return 0;
    }

    @Override
    public int getPointsForO() {
        return 3;
    }
}
