package gameplay.player;


import gameplay.signs.CellState;
import gameplay.signs.Sign;

public class Player {

    private final String name;
    private final Sign sign;
    private int points;

    public Player(String name, Sign sign) {

        this.name = name;
        this.sign = sign;
        points = 0;

    }

    public int getPoints() {
        return points;
    }

    public CellState getSign() {
        return sign.getSign();
    }

    public String getName() {
        return name;
    }


}
