package gameplay.signs;

public class XSign implements Sign {

    @Override
    public CellState getSign() {
        return CellState.CROSS;
    }
}
