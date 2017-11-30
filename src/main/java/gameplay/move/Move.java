package gameplay.move;

import gameplay.signs.Sign;

public class Move {

    private final Sign sign;
    private final int position;

    public static Move build(int move, Sign actualSign) {
        return new Move(move, actualSign);
    }

    public Move(int position, Sign sign) {

        this.position = position;
        this.sign = sign;
    }

    public boolean hasSamePosition(Move newMove) {
        return this.position == newMove.position;
    }

    public int getRealPosition() {
        return position - 1;
    }

    public Sign getSign() {
        return sign;
    }

    @Override
    public String toString() {
        return sign.toString();
    }
}
