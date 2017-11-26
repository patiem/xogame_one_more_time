package gameplay.signs;

public class OSign implements Sign {

    @Override
    public CellState getSign() {
        return CellState.NAUGHT;
    }
}
