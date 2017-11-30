package gameplay;

import gameplay.player.Player;
import gameplay.winning.wintypes.WinningCondition;
import utility.language.Language;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ScoreBoard {

    private final List<WinningCondition> winList = new ArrayList<>();
    private final Player playerX;
    private final Player playerO;

    public ScoreBoard(Player playerX, Player playerO) {
        this.playerX = playerX;
        this.playerO = playerO;
    }

    public void addWin(WinningCondition wc) {
        winList.add(wc);
        recountPointsForPlayer(wc);
    }

    private void recountPointsForPlayer(WinningCondition wc) {
        playerX.increasePoints(wc.getPointsForX());
        playerO.increasePoints(wc.getPointsForO());

    }

    public String[] gameResult() {
        return new String[] {playerX.getName(), playerX.getPoints().toString(), playerO.getName(), playerO.getPoints().toString()};
    }

    public Language getWinner() {
        if (Objects.equals(playerX.getPoints(), playerO.getPoints())) return Language.DRAW;
        return (playerX.getPoints() > playerO.getPoints()) ? Language.WIN_X : Language.WIN_O;
    }
}
