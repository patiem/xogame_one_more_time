package gameplay.signs;

public class OSign implements Sign {

    @Override
    public CellState show() {
        return CellState.NAUGHT;
    }

    @Override
    public String toString() {
        return "O";
    }
}
