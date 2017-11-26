package gameplay.board;

import init.Config;
import utility.intValues.Horizontal;
import utility.intValues.IntValue;
import utility.intValues.Size;
import utility.intValues.WinLength;

import java.util.Map;

public class BoardDimension {

    private final IntValue horizontal;
    private final IntValue size;
    private final IntValue winningLength;


    public static BoardDimension build(Config board) {
        Map<String, Integer> configs = board.getConfig();
        IntValue w = new Horizontal(configs.get("horizontal"));
        IntValue s = new Size(configs.get("vertical") * w.intValue());
        IntValue win = new WinLength(configs.get("winning"));
        return new BoardDimension(w,s,win);
    }


    public BoardDimension(IntValue w, IntValue s, IntValue win) {
        horizontal = w;
        size = s;
        winningLength = win;
    }

    public BoardDimension(int horizontal, int vertical, int winning) {
        this(new Horizontal(horizontal), new Size(horizontal * vertical), new WinLength(winning));
    }


    public int horizontal() {
        return horizontal.intValue();
    }

    public int size() {
        return size.intValue();
    }

    public int winningLength() {
        return winningLength.intValue();
    }
}

