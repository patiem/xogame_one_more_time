package gameplay;

public enum CellState {

    EMPTY("e"),
    NAUGHT("O"),
    CROSS("X");

    public String sign;

    CellState(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}