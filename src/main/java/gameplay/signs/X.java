package gameplay.signs;

public class X implements Sign {

    @Override
    public CellState getSign() {
        return CellState.CROSS;
    }
}
