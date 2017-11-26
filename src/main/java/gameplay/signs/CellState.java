package gameplay.signs;

public enum CellState {

    EMPTY("e"),
    NAUGHT("OSign"),
    CROSS("XSign");

    public String sign;

    CellState(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}