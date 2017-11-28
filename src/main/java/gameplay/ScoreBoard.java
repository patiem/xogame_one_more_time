package gameplay;

import gameplay.signs.Sign;
import gameplay.winning.winTypes.WinningCondition;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {

    private List<WinningCondition> winList = new ArrayList<>();

    public void addWin(WinningCondition wc) {
        winList.add(wc);
    }

    public int countPointsForPlayer(Sign sign) {
        return 0;
    }


    @Override
    public String toString() {
        return "ScoreBoard{" +
                "winList=" + winList +
                '}';
    }
}
