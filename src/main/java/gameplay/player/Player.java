package gameplay.player;

import gameplay.signs.Sign;

public class Player {

    private final String name;
    private final Sign sign;
    private Integer points;

    public Player(String name, Sign sign) {

        this.name = name;
        this.sign = sign;
        points = 0;
    }

    public Integer getPoints() {
        return points;
    }

    public Sign makeMove() {
        return sign;
    }

    public String getName() {
        return name;
    }

    public String getStringSign() {
        return sign.toString();
    }

    public Sign getSign() {
        return sign;
    }

    public void increasePoints(int points) {
        this.points += points;
    }
}
