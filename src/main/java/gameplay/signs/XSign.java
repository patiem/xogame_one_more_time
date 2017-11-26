package gameplay.signs;

public class XSign implements Sign {

    @Override
    public CellState show() {
        return CellState.CROSS;
    }

    @Override
    public String toString() {
        return "X";
    }
}
