package gameplay.signs;

public class O implements Sign {

    @Override
    public CellState getSign() {
        return CellState.NAUGHT;
    }
}
